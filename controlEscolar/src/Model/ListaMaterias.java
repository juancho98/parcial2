/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class ListaMaterias {
    Materia inicio;
    Materia fin;
    
    public void append(Materia nuevo){
        if(inicio == null){
            inicio = nuevo;
            fin = nuevo;
        }else{
            fin.setSig(nuevo);
            fin = nuevo;
        }
    }
}
