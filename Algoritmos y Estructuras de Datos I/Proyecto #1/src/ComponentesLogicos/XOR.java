package ComponentesLogicos;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class XOR extends Componente implements Component{

    private int Entrada1;
    private int Entrada2;
    private Image Image;

    public XOR(Image image) {
        Image = image;
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
        if (Entrada1 == Entrada2){
            return 0;
        }
        else{
            return 1;
        }
    }

    public ImageView getImage() {
        ImageView and=new ImageView(Image);
        and.setFitWidth(90);
        and.setFitHeight(50);
        return and;
    }

}