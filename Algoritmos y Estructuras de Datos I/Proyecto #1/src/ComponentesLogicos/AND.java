package ComponentesLogicos;

import javafx.scene.image.Image;

public class AND implements Component {
    private int Entrada1;
    private int Entrada2;
    private Image Image;

    public AND(Image image) {
        this.Image = image;
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
        if (Entrada1 == 1 && Entrada2==1){
            return 1;
        }
        else{
            return 0;
        }
    }

    public Image getImage() {
        return Image;
    }
}