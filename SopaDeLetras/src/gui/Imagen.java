/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author jdani
 */
public class Imagen extends JLabel{
    public Imagen(String path){
       super();
       this.cagarIcono(path);
    }
    private void cagarIcono(String Path){
        URL url = System.class.getResource(Path);
        ImageIcon im = new ImageIcon(url);
        super.setIcon(im);
    }
}
