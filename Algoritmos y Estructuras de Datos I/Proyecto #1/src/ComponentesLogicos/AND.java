package ComponentesLogicos;

import javafx.scene.image.Image;

/**
 * Clase que representa el componente AND
 */
public class AND extends Componente implements Component {

    public static String Name="AND";

    /**
     * Constructor de la clase AND
     * @param image - Imagen del componente
     * @param entrada1 - Entrada del input
     * @param entrada2 - Entrada del input
     */
    public AND(Image image, int entrada1, int entrada2) {
        super(image, entrada1, entrada2);

    }

    /**
     * Este metodo retorna la salida del componente segun las entradas
     * asignadas
     * @return - Retorna un int segun su valor de true or false
     */
    public int getSalida() {
        if (Entrada1 == 1 && Entrada2==1){
            return 1;
        }
        else{
            return 0;
        }
    }

}