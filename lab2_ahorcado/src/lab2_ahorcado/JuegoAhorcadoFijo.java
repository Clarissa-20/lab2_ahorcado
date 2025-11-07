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
    
    private final String palabraFija;
    
    public JuegoAhorcadoFijo(String palabraFija){//palabraSecreta a ser indicada en la ventana previa
        super(6);
        this.palabraFija = (palabraFija == null ? "" : palabraFija.trim().toUpperCase());
    }
    
    
    @Override
    public void actualizarPalabraActual(char letra) {//agruegamos letra a palabra formante....este se ejecuta despues de la verificacion de letra
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
    public boolean verificarLetra(char letra){ //verificar que la letra ingresada sea parte de la palabra secreta //Manejar por medio de apartado distinto para ingresado de letra
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasGanado() {//verificamos si la palabra que ya llevamos es igual a la palabra ingresada secreta
        return palabraSecreta.length() < 0 && palabraActual.indexOf('_') == -1;
    }

    @Override
    public void inicializarPalabraSecreta() {
        setPalabraSecreta(palabraFija);
        reiniciarEstado();
    }

    @Override
    public void jugar(char letra) {
        //futura logica aqui
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
        }
        
        letrasUsadas.add(letra);
        
        boolean acierto = verificarLetra(letra);
        
        if (acierto) {
            actualizarPalabraActual(letra);
        } else {
            intentos = Math.max(0, intentos - 1);
        }
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
