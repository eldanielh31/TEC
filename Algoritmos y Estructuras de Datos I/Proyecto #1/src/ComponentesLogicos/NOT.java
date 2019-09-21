package ComponentesLogicos;

import javafx.scene.image.Image;

/**
 * Clase representativa del componente NOT.
 */
public class NOT extends Componente implements Component{

    public static String Name="NOT";

    /**
     * Contructor de la clase que llama a la clase padre
     * con los parametros requeridos.
     * @param image - Imagen del componente.
     * @param entrada1 - Entrada por default.
     * @param entrada2 - Entrada por default.
     */
    public NOT(Image image, Componente entrada1, Componente entrada2) {
        super(image, entrada1, entrada2,Name);
    }

    /**
     * Metodo para obtener la operacion logica
     * segun las entradas.
     * @return - int 0 o 1, false o true
     * respectivamente.
     */
    public int getSalida() {
        if (getInput1()==1 || getInput2()==1){
            return 0;
        }
        else{
            return 1;
        }
    }

}
