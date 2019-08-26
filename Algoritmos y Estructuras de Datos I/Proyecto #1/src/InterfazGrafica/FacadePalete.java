package InterfazGrafica;

import ComponentesLogicos.*;
import javafx.scene.image.Image;

import java.io.FileNotFoundException;

public class FacadePalete {

    public static Componente ComponentFacade(TypeComponent t){
        if (t==TypeComponent.AND){
            return new AND(new Image("ImageComponents/AND.jpg"));
        }
        else if (t==TypeComponent.NAND){
            return new NAND(new Image("ImageComponents/NAND.jpg"));
        }
        else if (t==TypeComponent.NOR){
            return new NOR(new Image("ImageComponents/NOR.jpg"));
        }
        else if (t==TypeComponent.OR){
            return new OR(new Image("ImageComponents/OR.jpg"));
        }
        else if (t==TypeComponent.XNOR){
            return new XNOR(new Image("ImageComponents/XNOR.jpg"));
        }
        else if (t==TypeComponent.XOR){
            return new XOR(new Image("ImageComponents/XOR.jpg"));
        }
        else{
            return new Componente();
        }
    }
}