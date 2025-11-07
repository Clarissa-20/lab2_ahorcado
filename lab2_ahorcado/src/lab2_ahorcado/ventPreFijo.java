/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_ahorcado;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author David
 */
public class ventPreFijo {
    public ventPreFijo(){
        JFrame screen = new JFrame();
        screen.setSize(500, 500);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        JLabel titulo = new JLabel("Elegir Palabra Secreta");
        titulo.setBounds(120, 30, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 30));
        
        
        
        JComboBox<String> wordBank = new JComboBox<String>();
        wordBank.setBounds(130, 150, 200, 25);
        for(String word: AdminPalabrasSecretas.getListaPalabras()){
            wordBank.addItem(word);
        }
        
        
        
        JButton btPlay = new JButton("JUGAR ");
        btPlay.setBounds(130, 200, 200, 50);
        
        btPlay.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              String secretWord = (String) wordBank.getSelectedItem();
              JuegoAhorcadoFijo game = new JuegoAhorcadoFijo(secretWord);
              System.out.println("LETS GO GAMMING");
          }
                    
        });
        
        
        JButton btVOLVER = new JButton("VOLVER");
        btVOLVER.setBounds(130, 300, 200, 50);
        
        btVOLVER.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              screen.dispose();
              menuSeleccion ventana = new menuSeleccion();
             
             
          }
                    
        });
        
        
        
        screen.add(wordBank);
        screen.add(btPlay);
        screen.add(btVOLVER);
        screen.add(titulo);
        screen.setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        ventPreFijo ventan = new ventPreFijo();
    }
    
}
