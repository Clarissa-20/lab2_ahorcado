/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_ahorcado;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public abstract class JuegoAhorcadoBase implements JuegoAhorcado{
    
    protected String palabraSecreta;
    protected String palabraActual;
    protected int intentos;
    protected int limiteIntentos;
    protected ArrayList<Character> letrasUsadas = new ArrayList<>();
    protected ArrayList<ImageIcon> figuraAhorcado = new ArrayList<>();
    
    
    public JuegoAhorcadoBase(int limiteIntentos){ //Cada juego por lo minmo ha de empezar con una idea de la palabra secreta y el limite de intentos
        this.limiteIntentos=limiteIntentos;
        

        palabraSecreta = "";
        palabraActual="";
        
        intentos = limiteIntentos;
        
        
        figuraAhorcado.add("imagenes/parte1.png");
        figuraAhorcado.add("imagenes/parte2.png");
        figuraAhorcado.add("imagenes/parte3.png");
        figuraAhorcado.add("imagenes/parte4.png");
        figuraAhorcado.add("imagenes/parte5.png");
        figuraAhorcado.add("imagenes/parte6.png");
        
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    public String getPalabraActual() {
        return palabraActual;
    }

    public int getIntentos() {
        return intentos;
    }

    public int getLimiteIntentos() {
        return limiteIntentos;
    }
    
    

    public ArrayList<Character> getLetrasUsadas() {
        return letrasUsadas;
    }

    public ArrayList<ImageIcon> getFiguraAhorcado() {
        return figuraAhorcado;
    }
    
    protected void reiniciarEstado() {
        this.intentos = limiteIntentos;
        this.letrasUsadas.clear();
        
        construirPalabraActual();
    }
    
    protected void construirPalabraActual() {
        if (palabraSecreta == null) {
            palabraSecreta = "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < palabraSecreta.length(); i++) {
            char a = Character.toUpperCase(palabraSecreta.charAt(i));
            sb.append(a == ' ' ? ' ' : '_');
        }
        
        this.palabraActual = sb.toString();
    }
    
    public void setPalabraSecreta(String s) {
        palabraSecreta = (s == null ? "" : s.trim().toUpperCase());
    }
    
    public abstract void actualizarPalabraActual(char letra);
    
    public abstract boolean verificarLetra(char letra);
    public abstract boolean hasGanado();

    @Override
    public void jugar(char letra) {
        if (intentos <= 0 || hasGanado()) {
            return;
        }
        
        letra = Character.toUpperCase(letra);
        
        if (!Character.isLetter(letra)) {
            return;
        }
        
        for (int i = 0; i < letrasUsadas.size(); i++) {
            if (letrasUsadas.get(i) == letra) {
                return;
            }
            
            letrasUsadas.add(letra);
            boolean acierto = verificarLetra(letra);
            
            if (acierto) {
                actualizarPalabraActual(letra);
            } else {
                intentos = Math.max(0, intentos - 1);
            }
        }
    }
    
    public ImageIcon estadoFigura() {
        int errores = limiteIntentos - intentos;

        if (errores < 0) {
            errores = 0;
        }
        if (errores < 6) {
            errores = 6;
        }

        return figuraAhorcado.get(errores);
    }
    
    protected void cargarFiguras() {
        figuraAhorcado = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            try {
                URL url = getClass().getResource("imagenes/parte" + (i + 1) + ".PNG");
                
                if (url != null) {
                    figuraAhorcado.add(new ImageIcon(url));
                } else {
                    //si no encuentra imagen, mete alguna babosada vacia
                    figuraAhorcado.add(new ImageIcon(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB)));
                }
            } catch (Exception e) {
                figuraAhorcado.add(new ImageIcon(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB)));
            }
        }
    }
}
