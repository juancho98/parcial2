/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OBJECTS;

/**
 *
 * @author jdani
 */
public class Celda {
    private Integer x;
    private Integer y;
    private Integer dato;

    public Celda(Integer x, Integer y, Integer dato) {
        this.x = x;
        this.y = y;
        this.dato = dato;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getDato() {
        return dato;
    }

    public void setDato(Integer dato) {
        this.dato = dato;
    }

    public String toString() {
        return "["+this.dato+"] ";
    }
    
    
}
