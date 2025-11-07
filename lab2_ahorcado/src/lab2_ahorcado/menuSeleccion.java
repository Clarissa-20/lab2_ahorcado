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
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class menuSeleccion {
    public menuSeleccion(){
        JFrame screen = new JFrame();
        screen.setSize(800, 600);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        
        JLabel titulo = new JLabel("MENU PRINCIPAL");
        titulo.setBounds(150, 50, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 50));
        
        
        
        JButton btFIJO = new JButton("JUGAR MODO FIJO");
        btFIJO.setBounds(80, 180, 200, 50);
        
        btFIJO.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              
              if(AdminPalabrasSecretas.getListaPalabras().size()<1){
                  JOptionPane.showMessageDialog(screen, "No tiene palabras secretas registradas");
              }else{
                 screen.dispose();
                ventPreFijo ventana = new ventPreFijo(); 
              }
              
              
              
             
             
          }
                    
        });
        
        JButton btAZAR = new JButton("JUGAR MODO AZAR");
        btAZAR.setBounds(80, 280, 200, 50);
        
        btAZAR.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              int sizeLista = AdminPalabrasSecretas.getListaPalabras().size();
              if(sizeLista<1){
                  JOptionPane.showMessageDialog(screen, "No tiene palabras secretas registradas");
              }else{
                 
                 JuegoAhorcadoAzar game = new JuegoAhorcadoAzar();
                  System.out.println("LETS GO GAMMING");
                  screen.dispose();
              }
             
             
          }
                    
        });
        
        JButton btPALABRAS = new JButton("ADMINISTRAR PALABRAS");
        btPALABRAS.setBounds(300, 180, 200, 50);
        
        btPALABRAS.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
             screen.dispose();
             AdminPalabrasSecretas ventana = new AdminPalabrasSecretas();
          }
                    
        });
        
        
        JButton btVOLVER = new JButton("VOLVER");
        btVOLVER.setBounds(300, 280, 200, 50);
        
        btVOLVER.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
             screen.dispose();
             menuInicial ventana = new menuInicial();
          }
                    
        });
        
        
        
        
        
     
        
        
        
        screen.add(btFIJO);
        screen.add(btAZAR);
        screen.add(btPALABRAS);
        screen.add(btVOLVER);
        screen.add(titulo);
        
        screen.setVisible(true);
    }
    
    public static void main(String[] args) {
        menuSeleccion ventana = new menuSeleccion();
    }
  }
