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
public class Tablero {

    
    private Integer dimx;
    private Celda [][] tablero;
    private Integer[] numeros;
    private Integer suma;
    
    public Tablero(int dimx){
        this.dimx = dimx;
        this.tablero = new Celda[dimx][dimx];
        Integer num = 1;
        for (int i = 0; i < dimx; i++) {
            for (int j = 0; j < dimx; j++) {
                tablero[i][j] = new Celda(i,j,num++);
            }
        }
        numeros = new Integer[dimx*dimx];
        for (int i = 0; i < dimx*dimx; i++) {
            numeros[i]= i+1;
            System.out.println(numeros[i]);
        }
    }    
    public boolean VerificarNumeros(){
        boolean ban = true;
        
        return ban;
    }
    
    public boolean rango(){
        boolean ban = true;
        int max = dimx*dimx;
        for (int i = 0; i < dimx; i++) {
            for (int j = 0; j < dimx; j++) {
                if (tablero[i][j].getDato()>0 && tablero[i][j].getDato()<= max) {
                }else{
                    ban = false;
                }
            }
        }
        return ban;
    }
    public boolean repetidos(){
        boolean ban = true;
        
        int[][] aux = new int[dimx*dimx][2];
        for (int i = 0; i < dimx*dimx; i++) {
            aux[i][0]=i+1;
            aux[i][1]=0;
        }
        for (int i = 0; i < dimx; i++) {
            for (int j = 0; j < dimx; j++) {
                for (int k = 0; k < dimx*dimx; k++) {
                    if(tablero[i][j].getDato()==aux[k][0]){
                        aux[k][1]++;
                    }
                }
            }
        }
        
        for (int i = 0; i < dimx*dimx; i++) {
            if(aux[i][1]!=1){
                ban = false;
            }
        }
        return ban;
    }
    
    public boolean sumaDiagonales(){
        Integer diag1=0;
        Integer diag2=0;
        for (int i = 0; i < dimx; i++) {
            diag1 = tablero[i][i].getDato()+diag1;
        }
        //System.out.println("sumas diagonales: "+diag1);
        Integer aux=0;
        for (int i = dimx-1; i >= 0; i--) {
            diag2 = tablero[i][aux].getDato()+diag2;
            aux++;
        }
        //System.out.println("sumas diagonales: "+diag2);
        if(diag1==diag2){
            this.suma = diag1;
            return true;
        }
        else{
            //System.out.println("error");
            return false;
        }
    }
    
    public boolean sumaHorizontales(){
        Integer hori=0;
        boolean ban = true;
        for (int i = 0; i < dimx; i++) {
            hori = 0;
            for (int j = 0; j < dimx; j++) {
                hori = hori+tablero[i][j].getDato();
            }
            if(hori != suma){
                ban =false;
            }
            //System.out.println("suma horizontal= "+hori);
        }
        return ban;
    }
    
    public boolean sumaVerticales(){
        Integer ver=0;
        boolean ban = true;
        for (int i = 0; i < dimx; i++) {
            ver =0;
            for (int j = 0; j< dimx; j++) {
                ver = ver+tablero[j][i].getDato();
            }
            if(ver != suma){
                    ban =false;
               }
            //System.out.println("suma verticales= "+ver); 
        }
        return ban;
    }
    
    public int verificarSumas(){
        System.out.println("repetidos:"+repetidos());
        System.out.println("fuera de rango: "+rango());
        if(rango() == true){
            if (repetidos() == true) {
                if((sumaDiagonales()== true) && (sumaVerticales()==true) && (sumaHorizontales()==true) ){
                    return 1;
                }
                else{
                    return 2;
                }
            }
            else{
                return 3;
            }
        }
        return 4;
    }
    
    public void ingresar(Integer x, Integer y,Integer dato){
        tablero[x][y].setDato(dato);
    }
    
    public String toString(Integer x, Integer y) {
        return tablero[x][y].toString();
    }

    public Integer getDimx() {
        return dimx;
    }

    public void setDimx(Integer dimx) {
        this.dimx = dimx;
    }

    public Celda[][] getTablero() {
        return tablero;
    }

    public void setTablero(Celda[][] tablero) {
        this.tablero = tablero;
    }
}
