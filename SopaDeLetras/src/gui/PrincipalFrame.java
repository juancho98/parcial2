/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controlador.ControladorArchivo;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author jdani
 */
public class PrincipalFrame extends JFrame {
    private ControladorArchivo controlador;
    
    public PrincipalFrame() {
        super("Sopa de letras");
        this.controlador = new ControladorArchivo();
        super.setSize(300, 600);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        
        JPanel pnlBoton = new JPanel();
        pnlBoton.add(this.creaBotones());
        
        Imagen pnlImagen = new Imagen("/images/icon.jpg");
        pnlBoton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
        BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
        super.add(pnlBoton,BorderLayout.EAST);
        
        super.add(pnlImagen, BorderLayout.WEST);
        super.pack();
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }
    private JPanel creaBotones() {
        
        JPanel pnl = new JPanel();
        JButton btnElegir = new JButton("Selecciona archivo");
        JButton btnResultado = new JButton("Obtener Resultado");
        JLabel label = new JLabel("");
     
        JFileChooser fileChooser = new JFileChooser();
        pnl.setLayout(new FlowLayout());
        btnResultado.setEnabled(false);
        
        btnElegir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int returnVal = fileChooser.showOpenDialog(pnl);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        controlador.abrirArchivo(fileChooser.getSelectedFile());
                        btnResultado.setEnabled(true);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(PrincipalFrame.this,"Ocurrio un error al abrir el archivo");
                    }
                }
            }
        });
       
        btnResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    controlador.generarSalida();
                    JOptionPane.showMessageDialog(PrincipalFrame.this,String.format("El archivo se generó con éxito"));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this,"Error");
                }
            }
        });
        
        pnl.add(btnElegir);
        pnl.add(btnResultado);
        
        return pnl;
    }
}
