package ComponentesLogicos;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Componente implements Component{

    private Image Image;
    protected int Entrada1;
    protected int Entrada2;

    public Componente(javafx.scene.image.Image image, int entrada1, int entrada2) {
        Image = image;
        Entrada1 = entrada1;
        Entrada2 = entrada2;
    }


    @Override
    public void setPrimeraEntrada(int entrada) {
        this.Entrada1=entrada;
    }

    @Override
    public void setSegundaEntrada(int entrada) {
        this.Entrada2=entrada;
    }

    @Override
    public int getSalida() {
        return 0;
    }

    public ImageView getImage() {
        ImageView and = new ImageView(Image);
        and.setFitWidth(70);
        and.setFitHeight(50);
        return and;
    }
}