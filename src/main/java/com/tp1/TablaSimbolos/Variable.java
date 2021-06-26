package com.tp1.TablaSimbolos;

public class Variable extends ID {

    public Variable() {}

    public Variable(String nombre, String tipo) {
        super(nombre, tipo);
    }

    @Override
    public String toString() {
        String variable = this.getTipo() + " " + this.getNombre();

        if (this.isUsado())
            variable += " [Variable usada]";
        else
            variable += " [Variable sin usar]";
            
        return variable;
    }
    
}
