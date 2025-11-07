/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_ahorcado;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author David
 */
public class menuInicial {
    
    public menuInicial(){
        JFrame screen = new JFrame();
        screen.setSize(800, 600);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        
        JLabel titulo = new JLabel("¡AHORCADOS, EL JUEGO!");
        titulo.setBounds(100, 50, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 50));
        
        JButton btPlay = new JButton("JUGAR");
        btPlay.setBounds(300, 180, 200, 50);
        btPlay.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              screen.dispose();
              menuSeleccion ventana = new menuSeleccion();
              
             
          }
                    
        });
        
        screen.add(btPlay);
        screen.add(titulo);
        screen.setVisible(true);
        
    }
    
    
    public static void main(String[] args) {
        menuInicial ventana = new menuInicial();
    }
    
   
        
}
