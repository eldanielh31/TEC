package ComponentesLogicos;

public class OR implements Component {

    private int Entrada1;
    private int Entrada2;

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
        if (Entrada1 == 0 && Entrada2==0){
            return 0;
        }
        else{
            return 1;
        }
    }
}