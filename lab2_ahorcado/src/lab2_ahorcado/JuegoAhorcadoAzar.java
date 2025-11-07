/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_ahorcado;

/**
 *
 * @author David
 */
public class JuegoAhorcadoAzar extends JuegoAhorcadoBase{
    
    
    private String secretWord="";
    
    public JuegoAhorcadoAzar(){
        super(6);
        
        //ejecuta comando para elegir palabra del gestor
    }
    
    @Override
    public void actualizarPalabraActual(char letra) {
        String tempWord=super.palabraActual;//obtencion de version anterior
        String comparison =String.valueOf(letra);
        //Esto para considerar los espacios...los espacios se manejaran como un _
        if(comparison.equals("_")){
            tempWord+="_";
        }else{
            tempWord+=letra;//agruegado
        }
        super.palabraActual=tempWord;//Actualiza la palabra actual a la creada mediante la iteracion
    }

    @Override
    public boolean verificarLetra(char letra) throws ExcepcionLetras {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean hasGanado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void inicializarPalabraSecreta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //aqui iria
    }

    @Override
    public void jugar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
