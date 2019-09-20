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
            return new AND(new Image("ImageComponents/AND.jpg"),null,null);
        }
        else if (name.equals(NAND.Name)){
            return new NAND(new Image("ImageComponents/NAND.jpg"),null,null);
        }
        else if (name.equals(NOR.Name)){
            return new NOR(new Image("ImageComponents/NOR.jpg"),null,null);
        }
        else if (name.equals(OR.Name)){
            return new OR(new Image("ImageComponents/OR.jpg"),null,null);
        }
        else if (name.equals(XNOR.Name)){
            return new XNOR(new Image("ImageComponents/XNOR.jpg"),null,null);
        }
        else if (name.equals(XOR.Name)){
            return new XOR(new Image("ImageComponents/XOR.jpg"),null,null);
        }
        else{
            return new NOT(new Image("ImageComponents/NOT.jpg"),null,null);
        }
    }
}