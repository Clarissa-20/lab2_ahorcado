/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_ahorcado;
/**
 *
 * @author HP
 */

import java.util.ArrayList;
import javax.swing.*;

public class AdminPalabrasSecretas extends JFrame {

    public static ArrayList<String> palabras = new ArrayList<>();

    public static boolean primeraVez = true;
    public static String palabraFija = null;

    private JTextField ingreso;
    private JButton agregar, reiniciar, finalizar;
    private JLabel info;
    private int contador = 0;
    private final int maxPalabras = 6;

    public AdminPalabrasSecretas() {
        setTitle("Administrador de Palabras");
        palabras.clear();
        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ingreso = new JTextField();
        ingreso.setBounds(50, 50, 200, 30);
        add(ingreso);

        agregar = new JButton("AGREGAR");
        agregar.setBounds(260, 50, 100, 30);
        add(agregar);

        reiniciar = new JButton("REINICIAR");
        reiniciar.setBounds(50, 100, 100, 30);
        add(reiniciar);

        finalizar = new JButton("FINALIZAR");
        finalizar.setBounds(160, 100, 100, 30);
        finalizar.setEnabled(false);
        add(finalizar);

        info = new JLabel("PALABRAS AGREGADAS: 0/6");
        info.setBounds(50, 150, 300, 30);
        add(info);

        agregar.addActionListener(e -> {
            String palabra = ingreso.getText().trim();
            if (!palabra.isEmpty()) {
                if (!palabras.contains(palabra)) {
                    palabras.add(palabra);
                    contador++;
                    info.setText("PALABRAS AGREDADAS: " + contador + "/" + maxPalabras);
                    ingreso.setText("");
                    if (contador >= maxPalabras) {
                        agregar.setEnabled(false);
                        finalizar.setEnabled(true);
                        JOptionPane.showMessageDialog(this, "Has alcanzado 6 palabras, puedes finalizar.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "La palabra ya existe.");
                }
            }
        });
        reiniciar.addActionListener(e -> {
            palabras.clear();
            contador = 0;
            info.setText("PALABRAS AGREGADAS: 0/6");
            agregar.setEnabled(true);
            finalizar.setEnabled(false);
        });

        finalizar.addActionListener(e -> {
            if (contador < maxPalabras) {
                JOptionPane.showMessageDialog(this, "Debes agregar exactamente 6 palabras antes de finalizar.");
                return;
            }
            primeraVez = true;
            JOptionPane.showMessageDialog(this, "Palabras guardadas con exito.");
//            new Lab2_ahorcado().setVisible(true); 
            menuSeleccion ventana = new menuSeleccion();//se realizo el cambio ya que debe que llevar a la ventana de seleccion
            dispose();
        });
        setVisible(true);
    }

    public static String getPalbras() {
        if (palabras.isEmpty()) {
            return "DEFAULT";
        }
        int random = (int) (Math.random() * palabras.size());
        return palabras.get(random);
    }

    public static ArrayList<String> getListaPalabras() {
        return palabras;
    }

    public static String palabraFija() {
        return palabraFija;
    }

    public static void main(String[] args) {
        AdminPalabrasSecretas view = new AdminPalabrasSecretas();
    }
}
