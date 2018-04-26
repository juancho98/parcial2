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
import controller.Controlador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class PrincipalFrame extends JFrame {
    
    private JButton btnElegir;
    private JButton btnEncriptar;
    private Controlador controlador;   
    private JButton btnDesencriptar;
    private JPasswordField contraseña;
    private JButton btnAceptar;
    private JLabel Archivolabel;
    
    public PrincipalFrame() {
        super("Encriptador");
        this.controlador = new Controlador();
        super.setSize(480, 150);
        
       
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        
        //super.add(this.PanelButtons(),BorderLayout.CENTER);
        super.add(this.crearPanelTrabajo(),BorderLayout.CENTER);
        super.setVisible(true);
    }
    
    private JPanel crearPanelTrabajo() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout());
        this.contraseña = new JPasswordField(20);
        this.btnAceptar = new JButton("GUARDAR CONTRASEÑA");
        this.Archivolabel = new JLabel("SELECCIONAR ARCHIVO");
        
        this.btnAceptar.addActionListener((ActionEvent ae) -> {
            new Thread(() -> {
                String contrasena = new String(PrincipalFrame.this.contraseña.getPassword());
                PrincipalFrame.this.controlador.setLlave(contrasena);
                PrincipalFrame.this.btnElegir.setVisible(true);
            }).start();
        });
        panel.add(new JLabel("CONTRASEÑA: "));
        panel.add(this.contraseña);
        panel.add(this.btnAceptar);
        panel.add(this.Archivolabel);
        panel.add(this.PanelButtons(), BorderLayout.CENTER);
        return panel;
    }
    
    private JPanel PanelButtons() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        
        //panel.setBackground(Color.yellow);
        this.btnElegir = new JButton("Seleccionar archivo");
        this.btnElegir.setSize(500, 60);
        this.btnEncriptar = new JButton("Encriptar Archivo");
        this.btnDesencriptar = new JButton("Desencriptar Archivo");
        JFileChooser fileChooser = new JFileChooser();
        panel.setLayout(new FlowLayout());
        btnElegir.setVisible(false);
        btnEncriptar.setVisible(false);
        btnDesencriptar.setVisible(false);
        btnElegir.addActionListener((ActionEvent ae) -> {
            int returnVal = fileChooser.showOpenDialog(panel);
            
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                controlador.seleccionarArchivo(fileChooser.getSelectedFile().getAbsolutePath());
                Archivolabel.setText("Archivo: "+fileChooser.getSelectedFile().getAbsolutePath());
                btnEncriptar.setVisible(true);
                btnDesencriptar.setVisible(true);
            }
        });
        btnEncriptar.addActionListener((ActionEvent ae) -> {
            try {
                controlador.encriptar();
            } catch (IOException ex) {
                Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(PrincipalFrame.this,String.format("Archivo Encriptado"));
        });
        
        btnDesencriptar.addActionListener((ActionEvent ae) -> {
            try {
                controlador.desencriptar();
            } catch (IOException ex) {
                Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(PrincipalFrame.this,String.format("Archivo Desencriptado"));
        });
        
        panel.add(btnElegir);
        panel.add(btnEncriptar);
        panel.add(btnDesencriptar);
        
        return panel;
    }
}

class Test {
    public static void main(String[] args) {
        new PrincipalFrame();
    }      
}
