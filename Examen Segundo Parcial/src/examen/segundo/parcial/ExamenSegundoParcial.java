/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.segundo.parcial;

import GUI.PrincipalFrame;
import OBJECTS.Tablero;
import java.util.Scanner;

/**
 *
 * @author jdani
 */
public class ExamenSegundoParcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PrincipalFrame pf = new PrincipalFrame();
        // TODO code application logic here
                
    }    
    public void consola(){
        Scanner datos = new Scanner (System.in);
        Tablero tab = new Tablero(3);
        boolean ban;
        while(ban=true){
            System.out.println("\n***************************************************\n");
            for (int i = 0; i < tab.getDimx(); i++) {
                for (int j = 0; j < tab.getDimx(); j++) {
                    System.out.print(tab.toString(i, j));
                }
                System.out.println("");   
            }
            
            System.out.println("numero: ");
            for (int i = 0; i < tab.getDimx(); i++) {
                for (int j = 0; j < tab.getDimx(); j++) {
                    Integer dato = datos.nextInt();
                    tab.ingresar(i, j, dato);
                }  
            }
            
            System.out.println("\n***************************************************\n");
            for (int i = 0; i < tab.getDimx(); i++) {
                for (int j = 0; j < tab.getDimx(); j++) {
                    System.out.print(tab.toString(i, j));
                }
                System.out.println("");   
            }  
        }
    }
}
