package com.tp1;

public class ErrorListener {
    private static ErrorListener instance = null;
    private boolean codigo_error = false;

    public static ErrorListener getInstance() {
        if (instance == null) {
            instance = new ErrorListener();
        }
        return instance;
    }

    public static void printError(int line, String error) {
        System.out.println("SE ENCONTRO EL SIGUIENTE ERROR EN LA LINEA " + line + " " +error);
    }

    public Boolean thereIsError() {
        return this.codigo_error;
    }
    
}
