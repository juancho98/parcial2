/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controlador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author jdani
 */
public class PrincipalFrame extends JFrame {

    private PanelDet determinante;
    private Controlador controlador;

    public PrincipalFrame() {
        super("Determinantes");
        super.setSize(500, 500);
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.controlador = new Controlador();
        this.determinante = new PanelDet(1);
        super.add(this.crearMatriz(), BorderLayout.NORTH);
        super.add(this.determinante);
        //super.add(this.crearPnlBotones(), BorderLayout.SOUTH);
        super.setVisible(true);
    }

    private JPanel crearMatriz() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        String dim = JOptionPane.showInputDialog(null, "dimencion de la matriz:");
        int dimencion = parseInt(dim);
        System.out.println(dim);
        NumberFormat formato = NumberFormat.getInstance();
        formato.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(formato);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(Integer.MIN_VALUE);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        JFormattedTextField tamano = new JFormattedTextField(formatter);
        tamano.setColumns(4);
        PrincipalFrame.super.remove(determinante);
        determinante = null;
        determinante = new PanelDet(dimencion);
        PrincipalFrame.super.add(determinante);
        PrincipalFrame.super.repaint();
        panel.add(crearPnlBotones());

        return panel;
    }

    private JPanel crearPnlBotones() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton btnCalcular = new JButton("Calcular determinante");
        btnCalcular.addActionListener((ActionEvent ae) -> {
            int[][] matriz = determinante.getValores();
            controlador.setArray(matriz);
            int det = controlador.calcularDeterminante();
            JOptionPane.showMessageDialog(PrincipalFrame.this, String.format("El determinante es: %d", det));
        });
        panel.add(btnCalcular);
        return panel;
    }
}

