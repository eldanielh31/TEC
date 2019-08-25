package ComponentesLogicos;

public class Componente implements Component{

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
        return 0;
    }
}