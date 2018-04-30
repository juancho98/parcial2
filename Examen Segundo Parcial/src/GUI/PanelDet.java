/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author jdani
 */
import OBJECTS.Tablero;
import java.awt.GridLayout;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author jdani
 */
public class PanelDet extends JPanel {

    private int tamano;
    private GridLayout matriz;
    private JFormattedTextField[][] campo;
    private Tablero tablero;
    

    public PanelDet(int size) {
        super();
        this.tamano = size;
        this.matriz = new GridLayout(this.tamano, this.tamano);
        tablero = new Tablero(tamano);
        this.setLayout(matriz);
        this.campo = new JFormattedTextField[size][size];
        NumberFormat formato = NumberFormat.getInstance();
        formato.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(formato);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(Integer.MIN_VALUE);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo.length; j++) {
                this.campo[i][j] = new JFormattedTextField(formatter);
                this.campo[i][j].setColumns(4);
                super.add(campo[i][j]);
            }
        }
        super.repaint();
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
    public void limpiar(){
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo.length; j++) {
                campo[i][j].setText("");
            }
        }
    }
   
    public void verificar(){
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo.length; j++) {
                tablero.ingresar(i, j, Integer.valueOf(campo[i][j].getText()));
            }
        }
        
        switch(tablero.verificarSumas()){
            case 1:
                JOptionPane.showMessageDialog(null, "FELICIDADES!!");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "ORDEN INCORRECTO DE LOS NUMEROS");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "TIENES NUMEROS REPETIDOS");
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "LOS NUMEROS ESTAN FUERA DE RANGO");
                break;
        }
    }   
}
