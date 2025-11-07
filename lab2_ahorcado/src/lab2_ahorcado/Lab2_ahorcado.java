/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2_ahorcado;
/**
 *
 * @author HP
 */

import javax.swing.*;
import java.awt.*;

public class Lab2_ahorcado extends JFrame {

    static boolean primera = true;
    
    private JLabel titulo = new JLabel();
    private JButton btnJugar = new JButton();
    private JButton btnPalabra = new JButton();
    private JButton btnSalir = new JButton();
    private JButton btnPalabrasSecretas = new JButton();
    private JComboBox<String> juegos = new JComboBox<>(new String[]{"Al Azar", "Fijo"});
    private JComboBox<String> palab = new JComboBox<>();

    public Lab2_ahorcado(){
        initVentana();
        initComponentes();
        primera();
    }
    
    private void initVentana(){
        setSize(800, 700);
        setTitle("AHORCADO");
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void initComponentes(){
        titulo.setBounds(145, 60, 500, 147);
        // agg la img - titulo.setIcon(new ImageIcon(getClass().getResource
        
        btnJugar.setBounds(260, 270, 260, 70);
        btnJugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnJugar.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btnJugar.addActionListener(e -> jugarAction());
        
        btnPalabrasSecretas.setBounds(260, 350, 260, 70 );
        btnPalabrasSecretas.setCursor(new Cursor);
    }

    public static void main(String[] args) {
        
    }

}
