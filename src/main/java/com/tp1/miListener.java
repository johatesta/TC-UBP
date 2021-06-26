package com.tp1;

//import com.tp1.TablaSimbolos.*;
import com.tp1.TablaSimbolos.*;

import java.util.LinkedList;


package com.tp2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import com.tp2.clasesAux.Funcion;
import com.tp2.clasesAux.Simbolo;
import com.tp2.clasesAux.Variable;


/**
 *
 * 
 */
public class TP2CustomListener extends TP2BaseListener {
    
    ArrayList mapas = new ArrayList<>();

    int contextoActual;

    TP2CustomListener()
    {
        contextoActual=0;
        HashMap<String, Simbolo> mapa = new HashMap<String, Simbolo>();
        mapas.add(mapa);
    }
        
     
    @Override public void exitSemi(TP2Parser.SemiContext ctx) { 
        if(ctx.PUNTOYCOMA()!=null){
            if(!ctx.PUNTOYCOMA().getText().equals(";")){ //Si esta, devuelve ";", sino "<missing ';'>"... Comparamos negativamente
             System.out.println("Error sintáctico: Falta punto y coma.[Linea "+ctx.getParent().start.getLine()+"]");
            }
        }
    }
    
    @Override public void exitParentesisAp(TP2Parser.ParentesisApContext ctx) { 

        if(ctx.PA()==null){
            ParserRuleContext ctParent= ctx.getParent();
            System.out.println("Error sintáctico: Falta de paréntesis de apertura. [Linea <"+ctx.start.getLine()+";"+ctx.start.getCharPositionInLine()+">]");
        }
    }
    
    @Override public void enterBloque(@NotNull TP2Parser.BloqueContext ctx) {         
        contextoActual++;
        HashMap<String, Simbolo>  mapa = new HashMap<String, Simbolo>();
        mapas.add(mapa);

        ParserRuleContext cParent = ctx.getParent();
        if(cParent instanceof TP2Parser.DefinicionContext){
           ParserRuleContext defFunc = cParent.getParent();
           if(defFunc instanceof TP2Parser.DeffuncContext){
               TP2Parser.DeclaracionfuncContext cDeclaracionArgs = ((TP2Parser.DeffuncContext) defFunc).declaracionfunc();
                        
                while(cDeclaracionArgs!=null && cDeclaracionArgs.tipovar()!=null){
                    Variable var = new Variable();
                    var.setTipoDato(cDeclaracionArgs.tipovar().getText());
                    var.setNombre(cDeclaracionArgs.ID().getText());
                    var.setUsada(Boolean.FALSE);
                    var.setInicializada(Boolean.FALSE);
                    mapa.put(cDeclaracionArgs.ID().getText(), var);
                    cDeclaracionArgs = cDeclaracionArgs.declaracionfunc();
                }
           }
        }
    }
     
    @Override public void exitBloque(@NotNull TP2Parser.BloqueContext ctx) { 
        sinUsarEnContexto((HashMap<String, Simbolo>) mapas.get(contextoActual));
        mapas.remove(mapas.get(contextoActual));
        contextoActual--;
    }
    
    private Simbolo buscarEnContextosPosibles(String ID, Integer ctx){
        Simbolo aux = null;
        for(Integer i = ctx; i >= 0; i--){
            HashMap<String, Simbolo>  mapa = (HashMap<String, Simbolo>)mapas.get(i);
            if(mapa.containsKey(ID)){
                aux = mapa.get(ID);
            }
        }
        
        return aux;
    }
    
    private Simbolo buscarEnContexto(String ID, HashMap<String, Simbolo>  mapa){
        return (mapa.containsKey(ID)? mapa.get(ID) : null);
    }
    
    private void sinUsarEnContexto(HashMap<String, Simbolo>  mapa){
        for(Map.Entry<String, Simbolo> entry : mapa.entrySet()){
            String key = entry.getKey();
            Simbolo sym = entry.getValue();
            String tipoSym;
            if(sym instanceof Variable){
                tipoSym = "variable";
            }else{
                tipoSym = "función";
            }
            if(!sym.getUsada()){
                System.out.println("Error semántico: La "+tipoSym+" "+sym.getNombre()+" fue declarada pero no fue usada.");
            }
        }
    }
    private void sinInicializar(HashMap<String, Simbolo>  mapa){
        for(Map.Entry<String, Simbolo> entry : mapa.entrySet()){
            String key = entry.getKey();
            Simbolo sym = entry.getValue();
            String tipoSym;
            if(sym instanceof Variable){
                tipoSym = "variable";
            }else{
                tipoSym = "función";
            }
            if(!sym.getInicializada()){
                System.out.println("Error semántico: La "+tipoSym+" "+sym.getNombre()+" fue declarada pero no fue inicializada.");
            }
        }
    }
    
    @Override public void exitDeclaracionv(TP2Parser.DeclaracionvContext ctx) { 
        String tipoVar = ctx.tipovar().getText();
        TP2Parser.ListaContext cLista = ctx.lista();
        while(cLista!=null){            
            
            //Controlamos que no sea error
            if(cLista.tipovar()!=null){
                System.out.println("Error sintáctico: Formato incorrecto en lista de declaración de variables.");
            }
            String idVar;
            if(cLista.ID() != null){                 
                idVar = cLista.ID().getText();
                if(idVar.equals("<missing ID>")){
                   System.out.println("Error sintáctico: Formato incorrecto en lista de declaración de variables.");
                }else{
                    HashMap<String, Simbolo>  mapa = (HashMap<String, Simbolo>)mapas.get(contextoActual);

                   //Comprobar que no se repita en el contexto actual --> doble declaracion
                   Variable var = (Variable) buscarEnContexto(idVar, mapa);
                  
                    if(var==null){
                        var = new Variable();
                        var.setTipoDato(tipoVar);
                        var.setNombre(idVar);
                        var.setUsada(Boolean.FALSE);
                        TP2Parser.AsignacionContext cAsignacion = cLista.asignacion();
                        TP2Parser.AssignModeContext cAssingMode = cAsignacion.assignMode();
         
                        if(cAssingMode != null){
                            if(cAssingMode.IGUAL() != null){
                                var.setInicializada(Boolean.TRUE);
                            } 
                        }
                       
                        mapa.put(idVar, var);

                     }else{
                         System.out.println("Error semántico: El identificador ya fue declarado. [Linea <"+ctx.start.getLine()+";"+cLista.ID().getSymbol().getCharPositionInLine()+">]");
                     }
                }
            }
            cLista = cLista.lista();
        }
    }
    
    @Override public void exitFactor(TP2Parser.FactorContext ctx) { 
        if(ctx.ID() != null){
            String ID = ctx.ID().getText();
            HashMap<String, Simbolo>  mapa = (HashMap<String, Simbolo>)mapas.get(contextoActual);
            Variable var = (Variable) buscarEnContextosPosibles(ID, contextoActual);
            
            if(var != null){
                var.setUsada(Boolean.TRUE);
                var.setInicializada(Boolean.TRUE);
                mapa.put(var.getNombre(), var);
            }else{
                System.out.println("Error semántico: Se usó un identificador (\""+ID+"\") sin declarar. [Linea <"+ctx.start.getLine()+";"+ctx.ID().getSymbol().getCharPositionInLine()+">]");
            }
        }
    }
    
    @Override public void exitAsignacion(TP2Parser.AsignacionContext ctx) {
        //Por la estructura de la regla, compruebo que la asignacion  no sea en una declaracion de variable
        ParserRuleContext cParent = ctx.getParent();
        while(!(cParent instanceof TP2Parser.VariablesContext) && !(cParent instanceof TP2Parser.DeclaracionvContext)){
            cParent = cParent.getParent();
        }
        
        //Si es una variable y no fue una declaracion de variable, entonces sigo
        if(cParent instanceof TP2Parser.VariablesContext){
            HashMap<String, Simbolo>  mapa = (HashMap<String, Simbolo>)mapas.get(contextoActual);
            TP2Parser.ListaContext cLista = (TP2Parser.ListaContext) ctx.getParent();
            String varID = cLista.ID().getText();
            Variable var = (Variable) buscarEnContextosPosibles(varID, contextoActual);
            
            if(var != null){
                var.setUsada(Boolean.TRUE);
                var.setInicializada(Boolean.TRUE);
                mapa.put(var.getNombre(), var);
                
                
            }else{
                System.out.println("Error semántico: Se usó un identificador (\""+varID+"\") sin declarar. [Linea <"+ctx.start.getLine()+";"+cLista.ID().getSymbol().getCharPositionInLine()+">]");
            }


        }

    }   
    
    @Override public void exitDeffunc(TP2Parser.DeffuncContext ctx) {
        HashMap<String, Simbolo>  mapa = (HashMap<String, Simbolo>)mapas.get(0); // Todas las funciones forman parte del contexto 0 porque no se pueden hacer funciones dentro de funciones
        String idFunc = ctx.ID().getText();
        Funcion func = new Funcion();
        
        
        if(ctx.tipofunc()!=null){
            String tipoFunc = ctx.tipofunc().getText();
            
            if(ctx.definicion().expresionDef()!=null){
                if(ctx.definicion().expresionDef().semi()!=null){
                    if(ctx.definicion().expresionDef().semi().PUNTOYCOMA().getText().equals(";")){ 
                        func.setTipoDato(tipoFunc);
                        func.setNombre(idFunc);
                        func.setUsada(Boolean.FALSE);
                        func.setInicializada(Boolean.FALSE);
                        
                        
                        TP2Parser.DeclaracionfuncContext cDeclaracionArgs = ctx.declaracionfunc();
                        
                        ArrayList<Variable> argumentos = new ArrayList<Variable>();
                        
                        while(cDeclaracionArgs!=null && cDeclaracionArgs.tipovar()!=null){
                            Variable var = new Variable();
                            var.setTipoDato(cDeclaracionArgs.tipovar().getText());
                            var.setNombre(cDeclaracionArgs.ID().getText());
                            var.setUsada(Boolean.FALSE);
                            var.setInicializada(Boolean.FALSE);
                            argumentos.add(var);
                            cDeclaracionArgs = cDeclaracionArgs.declaracionfunc();
                        }
                        
                        func.setArgumentos(argumentos);
                        
                        
                    }
                }
            }else{
                Funcion funcAux = (Funcion) buscarEnContexto(idFunc, mapa);
                //Comprobar que no se repita en el contexto actual --> doble declaracion
                if(funcAux==null){
                    
                    func = new Funcion();
                    func.setTipoDato(tipoFunc);
                    func.setNombre(idFunc);
                   
                    if(idFunc.toLowerCase().equals("main")){ //Main es un caso especial
                        func.setUsada(Boolean.TRUE);
                    }else{
                        func.setUsada(Boolean.FALSE);
                    }

                    
                    TP2Parser.DeclaracionfuncContext cDeclaracionArgs = ctx.declaracionfunc();
                        
                    ArrayList<Variable> argumentos = new ArrayList<Variable>();

                    while(cDeclaracionArgs!=null && cDeclaracionArgs.tipovar()!=null){
                        Variable var = new Variable();
                        var.setTipoDato(cDeclaracionArgs.tipovar().getText());
                        var.setNombre(cDeclaracionArgs.ID().getText());
                        var.setUsada(Boolean.FALSE);
                        var.setInicializada(Boolean.FALSE);
                        System.out.println(cDeclaracionArgs.tipovar().getText());
                        argumentos.add(var);
                        cDeclaracionArgs = cDeclaracionArgs.declaracionfunc();
                    }

                    func.setArgumentos(argumentos);

                    func.setInicializada(Boolean.TRUE);

                }else{
                    func = funcAux;
                    TP2Parser.DeclaracionfuncContext cDeclaracionArgs = ctx.declaracionfunc();
                        
                    ArrayList<Variable> argumentos = new ArrayList<Variable>();

                    while(cDeclaracionArgs!=null && cDeclaracionArgs.tipovar()!=null){
                        Variable var = new Variable();
                        var.setTipoDato(cDeclaracionArgs.tipovar().getText());
                        var.setNombre(cDeclaracionArgs.ID().getText());
                        var.setUsada(Boolean.FALSE);
                        var.setInicializada(Boolean.FALSE);
                        argumentos.add(var);
                        cDeclaracionArgs = cDeclaracionArgs.declaracionfunc();
                    }


                    if(func.getArgumentos().size() == argumentos.size() && func.getTipoDato().equals(tipoFunc)){
                        for(int i =0; i< func.getArgumentos().size(); i++){
                            Variable v1 = (Variable)func.getArgumentos().get(i);
                            Variable v2 = (Variable)argumentos.get(i);
                            if(!v1.getTipoDato().equals(v2.getTipoDato())){
                                System.out.println("Error semántico: Definiciones conflictivas de la función \""+idFunc+"\". [Linea <"+ctx.start.getLine()+";"+ctx.ID().getSymbol().getCharPositionInLine()+">]");
                                break;
                            }
                        }
                    }else{
                        System.out.println("Error semántico: Definiciones conflictivas de la función "+idFunc+". [Linea <"+ctx.start.getLine()+";"+ctx.ID().getSymbol().getCharPositionInLine()+">]");
                    }

                    if(func.getInicializada()){
                        System.out.println("Error semántico: La función "+idFunc+" ya fue definida. [Linea <"+ctx.start.getLine()+";"+ctx.ID().getSymbol().getCharPositionInLine()+">]");
                    }else{
                       func.setInicializada(Boolean.TRUE);
                       if(idFunc.toLowerCase().equals("main")){
                        func.setUsada(Boolean.TRUE);
                       }
                    }
                }
            }

        mapa.put(idFunc, func);
        } 
    }
    
    // En asignacion controlar tipos incompatibles
    
    @Override public void exitLlamadafunc(TP2Parser.LlamadafuncContext ctx) { 
        String idFunc = ctx.ID().getText();
        HashMap<String, Simbolo>  mapa = (HashMap<String, Simbolo>)mapas.get(0); // Todas las funciones forman parte del contexto 0 porque no se pueden hacer funciones dentro de funciones

        Funcion func = (Funcion) buscarEnContexto(idFunc, mapa);
        if(func==null){
            System.out.println("Error semántico: Se usó un identificador de función \""+idFunc+"\" sin declarar. [Linea <"+ctx.start.getLine()+";"+ctx.ID().getSymbol().getCharPositionInLine()+">]");
        }else{
            func.setUsada(Boolean.TRUE);
            mapa.put(func.getNombre(), func);
        }
    }
    
    //Al terminar el programa controlar que no existan funciones ni variables con Usado en false
    @Override public void exitProg(TP2Parser.ProgContext ctx) { 
        sinUsarEnContexto((HashMap<String, Simbolo>) mapas.get(contextoActual));
        sinInicializar((HashMap<String, Simbolo>) mapas.get(contextoActual));
    }

}
