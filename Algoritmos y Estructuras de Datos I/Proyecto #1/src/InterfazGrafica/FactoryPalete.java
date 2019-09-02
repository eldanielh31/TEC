package InterfazGrafica;

import ComponentesLogicos.*;
import javafx.scene.image.Image;

/**
 * Esta clase es un factory de las clases componente.
 */
public class FactoryPalete {

    /**
     * Metodo static que selecciona e instancia cada clase, segun el componente.
     * @param t - Enum del tipo de componente.
     * @return - Instancia de la clase componente.
     */
    public static Componente ComponentFactory(TypeComponent t){
        if (t==TypeComponent.AND){
            return new AND(new Image("ImageComponents/AND.jpg"),0,0);
        }
        else if (t==TypeComponent.NAND){
            return new NAND(new Image("ImageComponents/NAND.jpg"),0,0);
        }
        else if (t==TypeComponent.NOR){
            return new NOR(new Image("ImageComponents/NOR.jpg"),0,0);
        }
        else if (t==TypeComponent.OR){
            return new OR(new Image("ImageComponents/OR.jpg"),0,0);
        }
        else if (t==TypeComponent.XNOR){
            return new XNOR(new Image("ImageComponents/XNOR.jpg"),0,0);
        }
        else if (t==TypeComponent.XOR){
            return new XOR(new Image("ImageComponents/XOR.jpg"),0,0);
        }
        else if(t==TypeComponent.NOT){
            return new NOT(new Image("ImageComponents/NOT.jpg"),0,0);
        }
        else{
            return new Componente(null,0,0);
        }
    }
}