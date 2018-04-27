/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class ListaAlumnos {
    Alumno inicio;
    Alumno fin;
    
    public void append(Alumno nuevo){
        if(inicio == null){
            inicio = nuevo;
            fin = nuevo;
        }else{
            fin.setNext(nuevo);
            fin = nuevo;
        }
        System.out.println("Se ha agregado al alumno: "+ nuevo.getNombre());
    }
    
    public Integer getNumeroAlumnos(){
        Integer n=0;
        
        Alumno current = inicio;
        
        while(current!=null){
            n++;
            current = current.getNext();
        }
        
        return n;
    }

    public void printList(){
        Alumno current = inicio;
        System.out.println("Funcion print list");
        while(current != null){
            System.out.println(current.getNombre());
            current = current.getNext();
        }
    }
    
    public Alumno getHead() {
        return inicio;
    }
    
    
}
