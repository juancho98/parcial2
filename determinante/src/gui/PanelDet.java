/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author jdani
 */
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
    

    public PanelDet(int size) {
        super();
        this.tamano = size;
        this.matriz = new GridLayout(this.tamano, this.tamano);
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

    public int[][] getValores() {
        int [][] resultado = new int[campo.length] [campo.length];
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo.length; j++) {
                resultado[i][j] = Integer.valueOf(campo[i][j].getText());
            }
        }
        return resultado;
    }
}
