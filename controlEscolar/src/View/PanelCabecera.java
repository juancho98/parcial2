/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Utilidades.AgregarListener;
import Utilidades.EliminarListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCabecera extends JPanel{
    JLabel universidad;
    JLabel instrucciones;
    JPanel opciones;
    
    AgregarListener agregarListener;
    EliminarListener eliminarListener;
    
    public PanelCabecera(){
        super();
        super.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        universidad   = new JLabel("Universidad Complutense de Madrid");
        instrucciones = new JLabel("Operaciones con los estudiantes:");
        
        opciones = new JPanel();
        opciones.setLayout(new FlowLayout());
        
        JButton agregar = new JButton("Agregar");
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se agregara un estudiante");
                agregarListener.onBtnClick(); //en Main se puede hacer 
            }
        });
        
        
        JButton buscar = new JButton("Buscar");        
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarListener.onBtnClick();
            }
        });
        
        opciones.add(agregar);
        opciones.add(buscar);
        
        super.add(universidad);
        super.add(instrucciones);
        super.add(opciones);
//        super.setLayout(null);
    }

    public void setAgregarListener(AgregarListener agregarListener) {
        this.agregarListener = agregarListener;
    }

    public void setEliminarListener(EliminarListener eliminarListener) {
        this.eliminarListener = eliminarListener;
    }
    
    
}
