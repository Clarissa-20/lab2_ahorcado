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
    protected ArrayList<Character> letrasUsadas;
    protected ArrayList<String> figuraAhorcado;
    
    
    public JuegoAhorcadoBase(int limiteIntentos){ //Cada juego por lo minmo ha de empezar con una idea de la palabra secreta y el limite de intentos
        this.palabraSecreta=palabraSecreta;
        this.limiteIntentos=limiteIntentos;
        
        this.letrasUsadas = new ArrayList<>();
        this.figuraAhorcado = new ArrayList<>();
        
        palabraActual="";
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
    
    public abstract void actualizarPalabraActual(char letra);
    
    public abstract boolean verificarLetra(char letra);
    public abstract boolean hasGanado();
    
    public void setPalabraSecreta(String secretWord){
        this.palabraSecreta=secretWord;
    }
    
    
    
}
