package com.tp1.TablaSimbolos;

import java.util.HashMap;
import java.util.LinkedList;



public class TablaSimbolos {

    private LinkedList<HashMap<String, ID>> tablaSimbolos;
    private LinkedList<HashMap<String, ID>> historialTablaSimbolos;
    private static TablaSimbolos instance;
    

    public static TablaSimbolos getInstance() {
        if(instance == null)
            instance = new TablaSimbolos();

        return instance;
    }

    public TablaSimbolos() {
        this.tablaSimbolos = new LinkedList<HashMap<String, ID>>();
        this.historialTablaSimbolos = new LinkedList<HashMap<String, ID>>(); 
        this.addContext();
    }

    public void addContext() {
        HashMap<String, ID> context = new HashMap<String,ID>();       
        this.tablaSimbolos.add(context);
        this.historialTablaSimbolos.add(context);
    }

    public void addParamForContext() {
        this.tablaSimbolos.add(new HashMap<String, ID>());
    }

    public int getContext() {
        return this.tablaSimbolos.size();
    }

    public void removeContext() {
        this.tablaSimbolos.removeLast();
    }

    public ID searchId(final ID id) {
        for(int i = 0; i < this.tablaSimbolos.size(); i++) {
            if(this.tablaSimbolos.get(i).containsKey(id.getNombre()))
                return this.tablaSimbolos.get(i).get(id.getNombre());
        }

        return null;
    }
    
    public ID searchVariable(final String nombre) {
        for(int i = 0; i < this.tablaSimbolos.size(); i++) {
            if(this.tablaSimbolos.get(i).containsKey(nombre))
                return this.tablaSimbolos.get(i).get(nombre);
        }
        return null;
    }

    public void addId(final ID id) {
        this.tablaSimbolos.getLast().put(id.getNombre(), id);
        this.historialTablaSimbolos.get(this.historialTablaSimbolos.size() - 1).put(id.getNombre(), id);
    }
    
    public Boolean asignacionId(final ID id) {
        for(int i = this.tablaSimbolos.size() - 1; i >= 0; i--) {
            if(this.tablaSimbolos.get(i).containsKey(id.getNombre())) {
                this.tablaSimbolos.get(i).replace(id.getNombre(), id);
                this.historialTablaSimbolos.get(i).replace(id.getNombre(), id);
                return true;
            }
        }
        return false;
    }

    public void addFuncion(final Funcion funcion) {
        this.tablaSimbolos.getLast().put(funcion.getNombre(), funcion);
        if (this.tablaSimbolos.size() == 0){
            if (this.historialTablaSimbolos.size() > 1){
                this.historialTablaSimbolos.get(this.historialTablaSimbolos.size() - 2).put(funcion.getNombre(), funcion);
            }
            else {
                this.historialTablaSimbolos.get(this.historialTablaSimbolos.size() - 1).put(funcion.getNombre(), funcion);
            }
        }
    }

    public void addParamFuncion(final ID id) {
        this.tablaSimbolos.getLast().put(id.getNombre(), id);
    }

    public boolean isVariableDeclared(final ID id) {
        for(int i = this.tablaSimbolos.size() - 1; i >= 0; i--) {
            if (this.tablaSimbolos.get(i).containsKey(id.getNombre())) {
                return true;
            }
        }
        return false;
    }

    public boolean isVariableDeclared(final String nombre) {
        for(int i = this.tablaSimbolos.size() - 1; i >= 0; i--) {
            if (this.tablaSimbolos.get(i).containsKey(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void setUsedId(final String nombre) {
        for (HashMap<String, ID> contexto : this.tablaSimbolos) {
            for (ID id : contexto.values()) {
                if (id.getNombre().equals(nombre))
                    id.setUsado(true);
            }
        }
    }
    
    public Funcion getDefFuncion(final Funcion function) {
        ID id = this.tablaSimbolos.getFirst().get(function.getNombre());
        
        if (id instanceof Funcion)
            return (Funcion) id;
        else
            return null; 
    }

    public void printTable() {
        int ctx = 1;
        System.out.println("\n------TABLA DE SIMBOLOS------");
        for (HashMap<String, ID> contexto : this.tablaSimbolos) {
            System.out.println("Contexto: " + ctx++ + " {");
            for (ID id : contexto.values()) {
                System.out.println("    " + id.toString());
            }
            System.out.println("}");
        }
      
        ctx = 1;
        System.out.println("\n------HISTORIAL------");
        for (HashMap<String, ID> contexto : this.historialTablaSimbolos) {
            System.out.println("Contexto: " + ctx++ + " {");
            for (ID id : contexto.values()) {
                System.out.println("    " + id.toString());
            }
            System.out.println("}");
        }       
    }
    
}
