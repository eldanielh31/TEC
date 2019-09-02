package ComponentesLogicos;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Clase padre para todos los componentes mas elaborados.
 */
public class Componente implements Component{

    private Image Image;
    protected int Entrada1;
    protected int Entrada2;

    /**
     * Constructor de la clase que
     * @param image
     * @param entrada1
     * @param entrada2
     */
    public Componente(Image image, int entrada1, int entrada2) {
        Image = image;
        Entrada1 = entrada1;
        Entrada2 = entrada2;
    }

    /**
     * Metodo para establecer un input
     * @param entrada - Valor de la entrada
     */
    @Override
    public void setPrimeraEntrada(int entrada) {
        this.Entrada1=entrada;
    }

    /**
     * Metodo para establecer un input
     * @param entrada - Valor de la entrada
     */
    @Override
    public void setSegundaEntrada(int entrada) {
        this.Entrada2=entrada;
    }

    /**
     * Metodo base para retornar una salida segun el componente.
     * @return  - int correspondiente a 0 o 1.
     */
    @Override
    public int getSalida() {
        return 0;
    }

    /**
     * Metodo para obtener la imagen del componente.
     * @return - ImageView del componente.
     */
    public ImageView getImage() {
        ImageView and = new ImageView(Image);
        and.setFitWidth(70);
        and.setFitHeight(50);
        return and;
    }
}