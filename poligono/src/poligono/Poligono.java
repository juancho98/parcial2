/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligono;

/**
 *
 * @author jdani
 */
public class Poligono {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Linea l1 = new Linea (5,2,7,9);
      Linea l2 = new Linea (-15,6,2,1);
      System.out.println(l1);
      System.out.println(l2);

      
      System.out.println("SE INTERSECTAN ?? : "+l1.Interseccion(l2));
        // TODO code application logic here
    }
    
}
