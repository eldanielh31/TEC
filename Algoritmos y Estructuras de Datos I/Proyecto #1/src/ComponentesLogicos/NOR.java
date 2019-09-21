package ComponentesLogicos;

import javafx.scene.image.Image;

/**
 * Clase representativa del componente NOR.
 */
public class NOR extends Componente implements Component{

    public static String Name="NOR";

    /**
     * Constructor de la clase que llama a la clase
     * padre con los parametros requeridos.
     * @param image - Imagen del componente.
     * @param entrada1 - Input por default.
     * @param entrada2 - Input por default.
     */
    public NOR(Image image, Componente entrada1, Componente entrada2) {
        super(image, entrada1, entrada2,Name);
    }

        /**
     * Metodo para obtener la salida.
     * @return - Retorna 0 o 1 que representa false
     * o true respectivamente.
     */
    public int getSalida() {
        if (getInput1() == 0 && getInput2()==0){
            return 1;
        }
        else{
            return 0;
        }
    }

}
