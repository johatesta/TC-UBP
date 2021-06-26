package tp1;

import tp1.TablaSimbolos.*;

import java.util.LinkedList;


public class miListener extends programaBaseListener {

    private TablaSimbolos simbolTable = TablaSimbolos.getInstance();
   
    programaParser parser;

    public miListener() {
    }

    @Override 
    public void enterBloque( programaParser.BloqueContext ctx) { 
        if (ctx.getParent().getClass().equals( programaParser.Definicion_funcionContext.class)) {
             programaParser.Definicion_funcionContext fnctx = ( programaParser.Definicion_funcionContext) ctx.getParent();
            Funcion funcion = DataFuncion.getDataFuncion(fnctx);

            if (!this.simbolTable.isVariableDeclared(funcion)){
                this.simbolTable.addFuncion(funcion);
            }
            this.simbolTable.addContext();
            
            if (fnctx.param_definicion().getChildCount() != 0) {
                for (ID param : funcion.getParametros()) {
                    this.simbolTable.addId(param);
                }
            }
        }
        else {
            this.simbolTable.addContext();
        }
    }

    
    @Override 
    public void exitBloque( programaParser.BloqueContext ctx) {
        this.simbolTable.removeContext();
    }

    @Override 
    public void exitDeclaracion(programaParser.DeclaracionContext ctx) {
       programaParser.Asignacion_simpleContext lista = ctx.asignacion_simple();
       while (lista != null) {
           if (lista.asignacion_simple() == null) {
               ID id = new Variable(lista.ID().getText(), ctx.tipo_de_datos().getText());
               if (!this.simbolTable.isVariableDeclared(id)) {
                   this.simbolTable.addId(id);
               }
               else {
                   ErrorListener.printError(ctx.getStop().getLine(), "Variable duplicada");
               }
           }
           lista = lista.asignacion_simple();
       }
    }


    @Override
         public void exitAsignacion( programaParser.AsignacionContext ctx){
        ID variable = this.simbolTable.searchVariable(ctx.ID().getText());
        int linea = ctx.getStart().getLine(); // el numero de linea es para el parser error

        if (ctx.getParent().getClass().equals( programaParser.AsignacionContext.class)) {
             programaParser.AsignacionContext lista = ( programaParser.AsignacionContext) ctx.getParent();
            
            while(lista.getParent().getClass().equals( programaParser.AsignacionContext.class)) {
                lista = ( programaParser.AsignacionContext) lista.getParent();
            }

            if (lista.getParent().getClass().equals( programaParser.DeclaracionContext.class)) {
                String nombreVariable = ctx.ID().getText();
                String tipoVariable = (( programaParser.DeclaracionContext) lista.getParent()).tipo_de_datos().getText();
                variable = new Variable(nombreVariable, tipoVariable);
                
                if (!this.simbolTable.isVariableDeclared(variable)) {
                    this.simbolTable.addId(variable);
                }
                else {
                    //Variable duplicada
                    ErrorListener.printError(linea, "Se encontro una variable duplicada "+ variable.getNombre());
                }
            }    
        }
        else if (this.simbolTable.isVariableDeclared(ctx.ID().getText())) {
            this.simbolTable.setUsedId(ctx.ID().getText());
            
        }
        else {
            //Variable no declarada
            ErrorListener.printError(ctx.getStop().getLine(), " La variables --> "+ ctx.ID().getText() +" no esta declarado");
        }
    }
  
    @Override 
    public void exitDeclaracion_funcion(programaParser.Declaracion_funcionContext ctx) {
        Funcion funcion = null;

        if (ctx.tipo_de_datos() != null)
            funcion = new Funcion(ctx.tipo_de_datos().getText(), ctx.ID().getText());
    

        LinkedList<ID> paramFuncion = new LinkedList<ID>();

        if (DataFuncion.validarFuncion(funcion, ctx)) {
            if(!ctx.param_declaracion().isEmpty()) {
                this.simbolTable.addParamForContext();
                paramFuncion = DataFuncion.getParametros(ctx.param_declaracion(), paramFuncion);
                
                for (ID id : paramFuncion) {
                    if (id.getNombre() != "") {
                        if (this.simbolTable.isVariableDeclared(id)) {
                            //parser de error --> variable ya declarada
                            ErrorListener.printError(ctx.getStop().getLine(), "La variable "+ id.getNombre() +" ya ha sido declarada");
                        }
                        this.simbolTable.addParamFuncion(id);
                    }
                }
                this.simbolTable.removeContext();
            }
            funcion.setParametros(paramFuncion);
            this.simbolTable.addFuncion(funcion);
        }
    }

    @Override 
    public void exitDefinicion_funcion(programaParser.Definicion_funcionContext ctx) { 
        if (!ctx.ID().getText().equals("main")){
            if (ctx.bloque().instrucciones() != null) {
                programaParser.InstruccionesContext inst = ctx.bloque().instrucciones();
                while(inst != null) {
                    if (inst.instruccion() != null){
                        if(inst.instruccion().finalizar_con_return() != null) {
                            // encontre retorno
                            if (ctx.tipo_de_datos() != null) {
                                if(inst.instruccion().finalizar_con_return().term() == null ) {
                                    // parser de error --> falta valor de return
                                    ErrorListener.printError(ctx.getStop().getLine(), " Debe retornar un valor");
                                    return;
                                }
                            }
                            else if(inst.instruccion().finalizar_con_return().term() != null) {
                                // parser de error --> return con operacion en funcion void
                                ErrorListener.printError(ctx.getStop().getLine(), "la función void no debe devolver un valor!");
                            }
                            return;
                        }
                    }
                    inst = inst.instrucciones();
                }
                // si no tiene return valido que tipo funcion sea void
                if (!ctx.tipo_de_datos().getText().equals("void")){
                    //parser de error
                    ErrorListener.printError(ctx.getStop().getLine(), "Debe retornar un valor");
                    return ;   
                }
            }
        }
    }


    @Override
    public void exitPuntocoma(programaParser.PuntocomaContext ctx) {
        if (ctx.PYQ() != null) {
            if (!ctx.PYQ().getText().equals(";")) {
                ErrorListener.printError(ctx.getStop().getLine(),"Falta punto y coma");
            }
        }
    }

   @Override
   public void exitPrograma(programaParser.ProgramaContext ctx){
       this.simbolTable.removeContext();
       this.simbolTable.printTable();
       this.toString();
   }


}
