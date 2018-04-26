/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author jdani
 */
public class Nodo<T> {
    private T dato;
    private Nodo<T> sig;
    
    public Nodo(T dato, boolean circular){
        this.dato = dato;
        if(circular) {
            this.sig = this;
        } else {
            this.sig = null;
        }
    }
    public void setDato(T data) {
        this.dato = data;
    }

    public Nodo<T> getSig() {
        return sig;
    }


    public T getDato() {
        return dato;
    }

    public void setSig(Nodo<T> sig) {
        this.sig = sig;
    }
    
    
}
