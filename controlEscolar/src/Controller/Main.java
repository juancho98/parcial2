/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Alumno;
import Model.ListaAlumnos;
import Model.Fecha;
import exceptions.FechaInvalidaException;
import View.PrincipalFrame;

public class Main {
    
    public static void main(String[] args) throws FechaInvalidaException {
        ListaAlumnos listaAlumnos = new ListaAlumnos();
        
        Integer[] ID = {1,2,3,4,5};
        String[] Nombre  = {"Kathy", "John", "Sue", "Jane", "Joe"};
        String[] Paterno = {"Smith", "Doe", "Black", "White", "Brown"};
        String[] Materno = {"Smith", "Doe", "Black", "White", "Brown"};
        Fecha[] FechaNac = {new Fecha(16,9,1998),
                            new Fecha(6,4,1999),
                            new Fecha(1,3,1996),
                            new Fecha(12,5,1998),
                            new Fecha(11,12,1997)};
        String[] Carrera = {"ISSC", "IC", "IA", "IETC", "ISSC"};
        Double[] Promedio = {9.5, 6.5, 8.9, 9.3, 8.3};
        
        Alumno nuevo;
        
        for(int i=0; i<5;i++){
            nuevo = new Alumno(ID[i], Nombre[i], Paterno[i], Materno[i], FechaNac[i], Carrera[i], Promedio[i]);
            listaAlumnos.append(nuevo);
        }
       
        listaAlumnos.printList();
        
        new PrincipalFrame(listaAlumnos);
        
    }
}
