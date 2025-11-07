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
import java.net.URL;

public class VentanaAhorcado extends JFrame {
    
    private JuegoAhorcadoBase JuegoActual;
    
    private JTextField TxtPalabraFija;
    private JButton BtnIniciarFijo;
    
    private JLabel LblPalabra;
    private JLabel LblIntentos;
    
    private JPanel PanelImagen;
    private JLabel LblBase;
    private ArrayList<JLabel> Capas;
    
    private JLabel LblMensaje;
    
    private JPanel PanelLetras;
    private ArrayList<JButton> BtnLetras;
    private JLabel LblImagenAhorcado;
    
    
    public VentanaAhorcado() {
        super("Juego Ahorcado");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setMinimumSize(new Dimension(800, 500));
        
        JPanel PanelTop = new JPanel();
        PanelTop.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        TxtPalabraFija = new JTextField(14);
        TxtPalabraFija.setToolTipText("Ej: PROGRAMACION");
        
        BtnIniciarFijo = new JButton("Iniciar (Fijo)");
        
                
        PanelTop.add(TxtPalabraFija);
        PanelTop.add(BtnIniciarFijo);
        
        
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
        
        PanelImagen = new JPanel(null);
        PanelImagen.setPreferredSize(new Dimension(360, 240));
        PanelImagen.setBackground(Color.WHITE);
        
        LblBase = new JLabel();
        LblBase.setBounds(0, 0, 360, 240);
        PanelImagen.add(LblBase);
        
        Capas = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            JLabel capa = new JLabel();
            capa.setBounds(0, 0, 360, 240);
            capa.setVisible(false);
            Capas.add(capa);
            
            PanelImagen.add(capa);
        }
        
        CargarImagenes();
        
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(1, 2, 10, 10));
        centro.add(PanelImagen);
        
        PanelCentro.add(PanelArriba, BorderLayout.NORTH);
        PanelCentro.add(centro, BorderLayout.CENTER);
        
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
        add(PanelCentro, BorderLayout.CENTER);
        add(PanelAbajo, BorderLayout.SOUTH);
        
        ConfigurarEventos();
        pack();
    }
    
    private void ConfigurarEventos() {
        BtnIniciarFijo.addActionListener(e -> {
            String fija = TxtPalabraFija.getText().trim();
            
            if (fija.isEmpty()) {
                fija = "PROGRAMACION";
            }
            
            JuegoActual = new JuegoAhorcadoFijo(fija);
            JuegoActual.inicializarPalabraSecreta();
            ActualizarStick();
            
            LblPalabra.setText(Espaciada(JuegoActual.getPalabraActual()));
            LblIntentos.setText("Intentos: " + JuegoActual.getIntentos());
            LblMensaje.setText("Ingresa un numero");
            
            ActualizarPantallaInicio();
            
            for (JButton boton : BtnLetras) {
               boton.setEnabled(true);
            }       
        }); 
    }
     
    private void ActualizarPantallaInicio() {
        LblPalabra.setText(Espaciada(JuegoActual.getPalabraActual()));
        LblIntentos.setText("Intentos: " + JuegoActual.getIntentos());
                
        LblMensaje.setText("Ingrese una letra");
        
        for (JButton boton : BtnLetras) {
            boton.setEnabled(true);
        }
    }
    
    private void onLetra(ActionEvent e) {
        if (JuegoActual == null) {
            LblMensaje.setText("Primero inicial el juego");
            return;
        }
        
        JButton src = (JButton) e.getSource();
        char letra = src.getText().charAt(0);
        
        //Evitar repetidos
        if (JuegoActual.getLetrasUsadas().contains(letra)) {
            LblMensaje.setText("Letra repetida: " + letra);
            src.setEnabled(false);
            
            return;
        }
        
        int antes = JuegoActual.getIntentos();
        JuegoActual.jugar(letra);
        ActualizarStick();
        
        LblPalabra.setText(Espaciada(JuegoActual.getPalabraActual()));
        LblIntentos.setText("Intentos: " + JuegoActual.getIntentos());
        
        src.setEnabled(false);
        
        if (JuegoActual.getIntentos() < antes) {
            LblMensaje.setText("Letra incorreca: " + letra + " | Intentos restantes: " + JuegoActual.getIntentos());
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
            if (pa.charAt(i) != ' ' && pa.charAt(i) == '_') {
                return false;
            }
        }
        
        return true;
    }
    
    private void DeshabilitarTodas() {
        for (int i = 0; i < BtnLetras.size(); i++) {
            BtnLetras.get(i).setEnabled(false);
        }
    }
    
    private String Espaciada(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append(' ');
        }
        
        return sb.toString();
    }
    
    private void CargarImagenes() {
        for (int i = 0; i < 6; i++) {
            URL url = getClass().getResource("imagenes/parte" + (i + 1) + ".PNG");
            if (url != null) {
                Capas.get(i).setIcon(new ImageIcon(url));
            }
        }
    }
    
    private void ActualizarStick() {
        if (JuegoActual == null) {
            return;
        }
        
        int errores = JuegoActual.getLimiteIntentos() - JuegoActual.getIntentos();
        
        for (int i = 0; i < 6; i++) {
            Capas.get(i).setVisible(i < errores);
        }
        
        PanelImagen.repaint();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaAhorcado().setVisible(true);
        });
    }
}
