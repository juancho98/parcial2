/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import objects.Archivo;
import objects.Lista;
import objects.Llave;
import objects.Nodo;

/**
 *
 * @author jdani
 */
public class Controlador {
    private Archivo gestor;
    private Llave<Character> llave;
    int valor;
    
    public Controlador() {
        this.llave = new Llave<Character>();
    }
    
    public void seleccionarArchivo(String ruta) {
        this.gestor = new Archivo(ruta);
    }
    public void setLlave(String llave) {
        for (int i = 0; i < llave.length(); i++) {
            this.llave.insertar(llave.charAt(i));
        }
    }
    public void setLlave(Llave<Character> llave) {
        this.llave = llave;
    }
    
    

    public Archivo getGestor() {
        return gestor;
    }

    public Llave<Character> getLlave() {
        return llave;
    }
    
    

    public void encriptar() throws IOException {
        this.gestor.leer();
        
        Lista<Integer> archivo = this.gestor.getFile();
        Nodo<Character> aux = llave.getIni();
        valor = 0;
        Nodo<Integer> nAux = archivo.getInicio();
        while (nAux != null) {
            valor = nAux.getDato()+(int)aux.getDato();
            if(valor>255){
                valor -= 255;
            }
            nAux.setDato(valor);
            aux = aux.getSig();
            nAux = nAux.getSig();
        }
       
        this.gestor.escribir();
        System.out.println("encriptado");
    }
    
    public void desencriptar() throws IOException {
        this.gestor.leer();
        Lista<Integer> archivo = this.gestor.getFile();
        Nodo<Character> aux = llave.getIni();
        valor = 0;
        Nodo<Integer> nAux = archivo.getInicio();
        while (nAux != null) {
            valor = nAux.getDato()-(int)aux.getDato();
            if(valor<0){
                valor += 255;
            }
            nAux.setDato(valor);
            aux = aux.getSig();
            nAux = nAux.getSig();
        }
        this.gestor.escribir();
        System.out.println("desencriptado");
    }
}

