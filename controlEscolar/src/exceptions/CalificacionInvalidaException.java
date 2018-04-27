/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

public class CalificacionInvalidaException extends Exception {

    /**
     * Creates a new instance of <code>CalificacionInvalidaException</code>
     * without detail message.
     */
    public CalificacionInvalidaException() {
    }

    /**
     * Constructs an instance of <code>CalificacionInvalidaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public CalificacionInvalidaException(String msg) {
        super(msg);
    }
}
