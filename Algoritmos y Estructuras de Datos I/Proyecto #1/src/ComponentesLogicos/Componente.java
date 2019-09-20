package ComponentesLogicos;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Clase padre para todos los componentes mas elaborados.
 */
public class Componente implements Component{
    private static int IDt;
    private int ID;
    private Image Image;
    protected Componente Entrada1;
    protected Componente Entrada2;
    protected String Name;
    protected boolean input;

    /**
     * Constructor de la clase que
     * @param image
     */
    public Componente(Image image, Componente entrada1, Componente entrada2,String name) {
        Image = image;
        Entrada1=entrada1;
        Entrada2=entrada2;
        Name=name;
        ID=IDt;
        IDt++;
        input=false;
    }

    /**
     * Metodo para establecer un input
     * @param entrada - Valor de la entrada
     */
    @Override
    public void setPrimeraEntrada(Componente entrada) {
        this.Entrada1=entrada;
    }

    /**
     * Metodo para establecer un input
     * @param entrada - Valor de la entrada
     */
    @Override
    public void setSegundaEntrada(Componente entrada) {
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

    public Componente getEntrada2() {
        return Entrada2;
    }

    public Componente getEntrada1() {
        return Entrada1;
    }

    public void setInput(boolean input) {
        this.input = input;
    }

    public String getName() {
        return Name;
    }

    public int getID() {
        return ID;
    }
}