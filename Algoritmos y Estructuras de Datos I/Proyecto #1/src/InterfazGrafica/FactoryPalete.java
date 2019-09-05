package InterfazGrafica;

import ComponentesLogicos.*;
import javafx.scene.image.Image;

/**
 * Esta clase es un factory de las clases componente.
 */
public class FactoryPalete {

    /**
     * Metodo static que selecciona e instancia cada clase, segun el componente.
     * @param name - tipo de componente a instanciar.
     * @return - Instancia de la clase componente.
     */
    public static Componente ComponentFactory(String name){
        if (name.equals(AND.Name)){
            return new AND(new Image("ImageComponents/AND.jpg"),0,0);
        }
        else if (name.equals(NAND.Name)){
            return new NAND(new Image("ImageComponents/NAND.jpg"),0,0);
        }
        else if (name.equals(NOR.Name)){
            return new NOR(new Image("ImageComponents/NOR.jpg"),0,0);
        }
        else if (name.equals(OR.Name)){
            return new OR(new Image("ImageComponents/OR.jpg"),0,0);
        }
        else if (name.equals(XNOR.Name)){
            return new XNOR(new Image("ImageComponents/XNOR.jpg"),0,0);
        }
        else if (name.equals(XOR.Name)){
            return new XOR(new Image("ImageComponents/XOR.jpg"),0,0);
        }
        else if(name.equals(NOT.Name)){
            return new NOT(new Image("ImageComponents/NOT.jpg"),0,0);
        }
        else{
            return new Componente(null,0,0);
        }
    }
}