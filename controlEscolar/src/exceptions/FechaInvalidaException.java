package exceptions;

public class FechaInvalidaException extends Exception {

    /**
     * Creates a new instance of <code>FechaInvalidaException</code> without
     * detail message.
     */
    public FechaInvalidaException() {
    }

    /**
     * Constructs an instance of <code>FechaInvalidaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FechaInvalidaException(String msg) {
        super(msg);
    }

    FechaInvalidaException(String el_mes_d_no_existe, Integer mes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    FechaInvalidaException(String el_mes_d_tiene__dias, Integer mes, Integer diasMes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
