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
            return new NAND();
        }
        else if (t==TypeComponent.NOR){
            return new NOR();
        }
        else if (t==TypeComponent.OR){
            return new OR();
        }
        else if (t==TypeComponent.XNOR){
            return new XNOR();
        }
        else if (t==TypeComponent.XOR){
            return new XOR();
        }
        else{
            return new Componente();
        }
    }
}