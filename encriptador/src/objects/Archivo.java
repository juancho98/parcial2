/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template archivo, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.*;
import java.util.List;

/**
 *
 * @author jdani
 */
public class Archivo {
    
    private FileInputStream entrada;
    private FileOutputStream salida;
    private Lista<Integer> archivo;
    private File entradaArchivo;
    char c = 0;
    int d = 0;
    int e = 0;
    int f =0;
    int a = 0;
    int b = 0;
    
    public Archivo(String path) {
        this.entradaArchivo = new File(path);
        this.archivo = new Lista();
    }
    
    
    public void escribir() throws FileNotFoundException, IOException {
        String nombre = this.entradaArchivo.getAbsolutePath();
        this.entradaArchivo.delete();
        this.entradaArchivo = new File(nombre);
        this.salida = new FileOutputStream(entradaArchivo);
        Nodo<Integer> aux = this.archivo.getInicio();
        while(aux != null){
            Integer b = aux.getDato();
            this.salida.write(b);
            aux = aux.getSig();
        }
        this.salida.close();
    }
    
    public void leer() throws FileNotFoundException, IOException{
        this.entrada = new FileInputStream(entradaArchivo);
        while(entrada.available()>0) {
            this.archivo.insertarFinal(entrada.read());
        }
        this.entrada.close();
    }
    
    public boolean Comparar(File file) throws IOException {
        
        boolean bandera = true;
        Llave<Character> llave = new Llave();
        llave.insertar('K');
        llave.insertar('E');
        llave.insertar('Y');
        Nodo<Character> aux = llave.getIni();
        try (FileInputStream nStream = new FileInputStream(file)) {
            this.entrada = new FileInputStream(entradaArchivo);
            
            while(entrada.available()>0 && nStream.available()>0) {
                a = this.entrada.read();
                b = nStream.read();
                c = aux.getDato();
                d = (int)aux.getDato();
                e = b+d;
                f = e-d;
                
                System.out.println(String.format("%d   %d   %s   %d   %d   %d", a,b,c,d,e,f));
                if( a == b) {
                    bandera = true;
                } else {
                    bandera = false;
                }
                aux = aux.getSig();
            }
            entrada.close();
        }
        return bandera;
    }

    public Lista<Integer> getFile() {
        return archivo;
    }

    public File getInputFile() {
        return entradaArchivo;
    }
    
    
}
