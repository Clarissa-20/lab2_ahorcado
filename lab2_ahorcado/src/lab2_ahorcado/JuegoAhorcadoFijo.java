/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_ahorcado;

/**
 *
 * @author David
 */
public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {
    
    String palabraHolder;
    
    public JuegoAhorcadoFijo(String palabraSecreta){//palabraSecreta a ser indicada en la ventana previa
        super(6);
        inicializarPalabraSecreta();//Someter a revision
    }
    
    
    @Override
    public void actualizarPalabraActual(char letra) {//agruegamos letra a palabra formante....este se ejecuta despues de la verificacion de letra
        String tempWord="";
        String comparison =String.valueOf(letra);
        //Esto para considerar los espacios...los espacios se manejaran como un _
        if(comparison.equals("_")){
            tempWord+="_";
        }else{
            tempWord+=letra;
        }
        super.palabraActual=tempWord;//Actualiza la palabra actual a la creada mediante la iteracion
    }

    @Override
    public boolean verificarLetra(char letra){//metodo de verificacion si es una letra valida o si no existe ya 
        
        //verificacion 1: que sea una letra
        if(Character.isLetter(letra)){
            //verificacion 2: que no exista ya
            boolean verificacion=false;
            for(char let: super.letrasUsadas){
                if(let==letra){
                    verificacion=true;
                }
            }
            if(verificacion==false){
                super.letrasUsadas.add(letra);
                return true;
            }
        }
        return false;
        
    }

    @Override
    public boolean hasGanado() {//verificamos si la palabra que ya llevamos es igual a la palabra ingresada secreta
        if(super.palabraActual.equalsIgnoreCase(palabraSecreta)){
            return true;
        }
        return false;
    }

    @Override
    public void inicializarPalabraSecreta() {
        super.setPalabraSecreta(palabraHolder);
    }

    @Override
    public void jugar() {
        //futura logica aqui
    }
    
}
