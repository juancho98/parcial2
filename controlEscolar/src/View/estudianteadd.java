/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Utilidades.CancelarListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Utilidades.AceptarEstudianteListener;

public class estudianteadd extends JDialog{
    private JButton btnAceptar;
    private JButton btnCancelar;

    private JLabel noControl;
    private JLabel nombre;
    private JLabel paterno;
    private JLabel materno;
    private JLabel fechaNac;
    private JLabel carrera;
    private JLabel promedio;
    
    private JTextField noControlInput;
    private JTextField nombreInput;
    private JTextField paternoInput;
    private JTextField maternoInput;
    private JTextField fechaNacInput;
    private JTextField carreraInput;
    private JTextField promedioInput;
    
    private AceptarEstudianteListener aceptarListener;
    
    public estudianteadd(JFrame parent){
        super(parent, "Agregar estudiante", true);
        super.setSize(100,100);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        
        super.setLayout(new FlowLayout());
        
        noControl = new JLabel("No. de control: ");
        nombre = new JLabel("Nombre: ");
        paterno = new JLabel("Paterno: ");
        materno = new JLabel("Materno: ");
        fechaNac = new JLabel("Fecha de nacimiento (1/1/2000)");
        carrera = new JLabel("Carrera: ");
        promedio = new JLabel("Promedio: ");
        
        noControlInput = new JTextField();
        nombreInput = new JTextField();
        paternoInput = new JTextField();
        maternoInput = new JTextField();
        fechaNacInput = new JTextField();
        carreraInput = new JTextField();
        promedioInput = new JTextField();
        
        btnAceptar = new JButton("Aceptar");
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //listener.aceptarClickButton(edtTexto.getText());
                aceptarListener.onBtnClick(noControlInput.getText(),
                                            nombreInput.getText(),
                                            paternoInput.getText(),
                                            maternoInput.getText(),
                                            fechaNacInput.getText(),
                                            carreraInput.getText(),
                                            promedioInput.getText());
                
                estudianteadd.this.setVisible(false);
                
            }
        });
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estudianteadd.this.setVisible(false);
            }
        });
        
        super.add(noControl);
        super.add(noControlInput);
        
        super.add(btnAceptar);
        super.add(btnCancelar);
    }
    
    public void mostrar(){
        noControlInput.setText("0");
        super.setVisible(true);
    }
    
    public void Modificar(String textito){
        noControlInput.setText("");
        super.setVisible(true);
    }

    public void setAceptarListener(AceptarEstudianteListener aceptarListener) {
        this.aceptarListener = aceptarListener;
    }

    
}
