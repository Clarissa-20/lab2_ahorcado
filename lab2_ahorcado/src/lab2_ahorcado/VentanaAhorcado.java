/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_ahorcado;

/**
 *
 * @author Hp
 */

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaAhorcado extends JFrame {
    
    private JuegoAhorcadoBase JuegoActual;
    
    private JLabel LblPalabra;
    private JLabel LblIntentos;
    
    private JTextArea TxtAscii;
    private JLabel LblMensaje;
    
    private JPanel PanelLetras;
    private ArrayList<JButton> BtnLetras;
    
    private JButton BtnIniciar;
    
    public VentanaAhorcado() {
        super("Juego Ahorcado");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setMinimumSize(new Dimension(800, 500));
        
        JPanel PanelTop = new JPanel();
        PanelTop.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        BtnIniciar = new JButton("Iniciar");
        
        ConfigurarEventos();
        
        PanelTop.add(BtnIniciar);
        
        
        JPanel PanelCentro = new JPanel();
        PanelCentro.setLayout(new BorderLayout(10, 10));
        
        LblPalabra = new JLabel("", SwingConstants.CENTER);
        LblPalabra.setFont(new Font("Consolas", Font.BOLD, 32));
        
        LblIntentos = new JLabel("Intentos: 6", SwingConstants.CENTER);
        LblIntentos.setFont(new Font("SansSerif", Font.PLAIN, 16));
        
        
        JPanel PanelArriba = new JPanel();
        PanelArriba.setLayout(new GridLayout(2, 1));
        PanelArriba.add(LblPalabra);
        PanelArriba.add(LblIntentos);
        
        
        TxtAscii = new JTextArea(8, 20);
        TxtAscii.setEnabled(false);
        TxtAscii.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        JScrollPane ScrollAscii = new JScrollPane(TxtAscii);
        
        JPanel PanelMid = new JPanel();
        PanelMid.setLayout(new GridLayout(1, 2, 10, 10));
        PanelMid.add(ScrollAscii);
        
        PanelCentro.add(PanelArriba, BorderLayout.NORTH);
        PanelCentro.add(PanelMid, BorderLayout.CENTER);
        
        PanelLetras = new JPanel();
        PanelLetras.setLayout(new GridLayout(2, 13, 4, 4));
        
        BtnLetras = new ArrayList<>();
        
        for (char c = 'A'; c <= 'Z'; c++) {
            JButton boton = new JButton(String.valueOf(c));
            
            boton.addActionListener(this::onLetra);
            boton.setEnabled(false);
            
            BtnLetras.add(boton);
            PanelLetras.add(boton);
        }
        
        LblMensaje = new JLabel("Presiona 'iniciar' para comenzar", SwingConstants.CENTER);
        
        JPanel PanelAbajo = new JPanel();
        PanelAbajo.setLayout(new BorderLayout(8, 8));
        
        PanelAbajo.add(PanelLetras, BorderLayout.CENTER);
        PanelAbajo.add(LblMensaje, BorderLayout.SOUTH);
        
        add(PanelTop, BorderLayout.NORTH);
        add(PanelMid, BorderLayout.CENTER);
        add(PanelAbajo, BorderLayout.SOUTH);
    }
    
    private void ConfigurarEventos() {
        BtnIniciar.addActionListener(e -> {
            if (JuegoActual == null) {
                LblMensaje.setText("No hay juego configurado");
                return;
            }
            
            JuegoActual.inicializarPalabraSecreta();
            ActualizarPantallaInicio();
        });
    }
    
    private void ActualizarPantallaInicio() {
        LblPalabra.setText(Espaciada(JuegoActual.getPalabraActual()));
        LblIntentos.setText("Intentos: " + JuegoActual.getIntentos());
        
        TxtAscii.setText(JuegoActual.getFiguraAhorcado().toString());
        
        LblMensaje.setText("Ingrese una letra");
        
        for (JButton boton : BtnLetras) {
            boton.setEnabled(true);
        }
    }
    
    private void onLetra(ActionEvent e) {
        if (JuegoActual == null) {
            return;
        }
        
        JButton src = (JButton) e.getSource();
        char letra = src.getText().charAt(0);
        
        if (JuegoActual.getLetrasUsadas().contains(letra)) {
            LblMensaje.setText("Letra repetida: " + letra);
            src.setEnabled(false);
            
            return;
        }
        
        int antes = JuegoActual.getIntentos();
        JuegoActual.jugar();
        
        LblPalabra.setText(JuegoActual.getFiguraAhorcado().toString());
        
        src.setEnabled(false);
        
        if (JuegoActual.getIntentos() < antes) {
            LblMensaje.setText("Letra incorreca: " + letra);
        } else {
            LblMensaje.setText("Letra correcta: " + letra);
        }
        
        if (VerificarGanador()) {
            LblMensaje.setText("Ganaste! Palabra: " + JuegoActual.getPalabraSecreta());
            DeshabilitarTodas();
        } else if (JuegoActual.getIntentos() <= 0) {
            LblMensaje.setText("Perdiste, la palabra era: " + JuegoActual.getPalabraSecreta());
            DeshabilitarTodas();
        }
    }
    
    private boolean VerificarGanador() {
        String pa = JuegoActual.getPalabraActual();
        
        for (int i = 0; i < pa.length(); i++) {
            if (pa.charAt(i) != ' ' && pa.charAt(i) == ' ') {
                return false;
            }
        }
        
        return true;
    }
    
    private void DeshabilitarTodas() {
        for (JButton boton : BtnLetras) {
            boton.setEnabled(false);
        }
    }
    
    private String Espaciada(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append(' ');
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaAhorcado().setVisible(true);
        });
    }
}
