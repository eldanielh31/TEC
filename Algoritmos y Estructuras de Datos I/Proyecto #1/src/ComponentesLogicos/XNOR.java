package ComponentesLogicos;

import javafx.scene.image.Image;

/**
 * Clase que representa la clase XNOR.
 */
public class XNOR extends Componente implements Component{

    public static String Name="XNOR";

    /**
     * Constructor de la clase que llama al contructor de
     * la clase padre con su respectivos parametros.
     * @param image - Imagen del componente
     * @param entrada1 - Entrada por default.
     * @param entrada2 - Entrada por default.
     */
    public XNOR(Image image, Componente entrada1, Componente entrada2) {
        super(image, entrada1, entrada2,Name);
    }

    /**
     * Metodo para obtener el valor de la operacion logica.
     * @return - int 0 o 1, false o true respectivamente.
     */
    public int getSalida() {
        if (Entrada1.getSalida() == Entrada2.getSalida()){
            return 1;
        }
        else{
            return 0;
        }
    }

}
