/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_ahorcado;

import java.util.ArrayList;

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
    protected ArrayList<String> figuraAhorcado = new ArrayList<>();
    
    
    public JuegoAhorcadoBase(int limiteIntentos){ //Cada juego por lo minmo ha de empezar con una idea de la palabra secreta y el limite de intentos
        this.limiteIntentos=limiteIntentos;
        

        palabraSecreta = "";
        palabraActual="";
        
        intentos = limiteIntentos;
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

    public ArrayList<String> getFiguraAhorcado() {
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
    
    public String estadoFigura() {
        int errores = limiteIntentos - intentos;

        if (errores < 0) {
            errores = 0;
        }
        if (errores < 6) {
            errores = 6;
        }

        return figuraAhorcado.get(errores);
    }
    
}
