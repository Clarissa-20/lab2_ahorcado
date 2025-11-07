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
        inicializarPalabraSecreta();
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
    public boolean verificarLetra(char letra){
        for(char comparison: super.palabraSecreta.toCharArray()){
            if(letra==comparison){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasGanado() {
        if(super.palabraActual.equalsIgnoreCase(palabraSecreta)){
            return true;
        }
        return false;
    }

    @Override
    public void inicializarPalabraSecreta() {
        String palabraAzar = AdminPalabrasSecretas.getPalbras();
        super.setPalabraSecreta(palabraAzar);
        //aqui iria
    }

    @Override
    public void jugar(char letra) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public boolean isLetra(char letra) throws ExcepcionLetras{ //metodo de verificacion si es una letra valida o si no existe ya //Metodo auxiliar
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
        throw new ExcepcionLetras("El dato ingresado no es una letra");
    }
    
    
}
