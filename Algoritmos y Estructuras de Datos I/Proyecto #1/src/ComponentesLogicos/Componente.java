package ComponentesLogicos;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Clase padre para todos los componentes mas elaborados.
 */
public class Componente implements Component{
    private static int IDt=-6;
    private int ID;
    private Image Image;
    protected Componente Entrada1;
    protected Componente Entrada2;
    protected String Name;
    protected boolean input;
    protected int Output;
    protected int input1,input2;

    /**
     * Constructor de la clase componente.
     * @param image- Imagen por default.
     * @param entrada1- Entrada por default(null)
     * @param entrada2- Entrada por default (null)
     * @param name- Nombre por default.
     */
    public Componente(Image image, Componente entrada1, Componente entrada2,String name) {
        Image = image;
        Entrada1=entrada1;
        Entrada2=entrada2;
        Name=name;
        Output=2;
        ID=IDt;
        IDt++;
        input=false;
        input1=2;
        input2=2;
    }

    /**
     * Metodo para establecer un input
     * @param entrada - Valor de la entrada
     */
    @Override
    public void setPrimeraEntrada(Componente entrada) {
        if(Name.equals("NOT")){
            Entrada1=entrada;
            Entrada2=entrada;
        }else {
            this.Entrada1 = entrada;
        }
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

    /**
     * Metodo que retorna el atributo de input1.
     * @return - entero representativo de input 1.
     */
    public int getInput1() {
        return input1;
    }

    /**
     * Metodo que retorna el atributo de input2.
     * @return - entero representativo de input 2.
     */
    public int getInput2() {
        return input2;
    }

    /**
     * Metodo que le da un valor al atributo de input1.
     * @param input1- Valor para reemplazar.
     */
    public void setInput1(int input1) {
        this.input1 = input1;
    }

    /**
     * Metodo que le da un valor al atributo de input2.
     * @param input2- Valor para reemplazar.
     */
    public void setInput2(int input2) {
        this.input2 = input2;
    }

    /**
     * Metodo para obtener el componente enlazado en el input 2.
     * @return - Componente enlazado.
     */
    public Componente getEntrada2() {
        return Entrada2;
    }

    /**
     * Metodo para obtener el componente enlazado en el input 1.
     * @return - Componente enlazado.
     */
    public Componente getEntrada1() {
        return Entrada1;
    }

    /**
     * Metodo que retorna el atributo input.
     * @return - boolean.
     */
    public boolean isInput() {
        return input;
    }

    /**
     * Metodo que sobreescribe el valor de input.
     * @param input - Valor a reemplazar.
     */
    public void setInput(boolean input) {
        this.input = input;
    }

    /**
     * String que representa el tipo de componente que es.
     * @return - Atributo Name.
     */
    public String getName() {
        return Name;
    }

    /**
     * Retorna el atributo ID.
     * @return - Entero representativo de ID.
     */
    public int getID() {
        return ID;
    }

    /**
     * Metodo para obtener el valor del output
     * @return - entero.
     */
    public int getOutput() {
        return Output;
    }

    /**
     * Metodo para establecer un valor en el atributo output.
     * @param output - entero para reemplazar.
     */
    public void setOutput(int output) {
        Output = output;
    }

    /**
     * Metodo para establecer un valor de IDt.
     * @param IDt - valor para reemplazar.
     */
    public static void setIDt(int IDt) {
        Componente.IDt = IDt;
    }
}