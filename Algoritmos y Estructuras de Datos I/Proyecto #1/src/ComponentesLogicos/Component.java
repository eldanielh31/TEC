package ComponentesLogicos;

/**
 * Esta interfaz es la base para
 * la creacion de cualquier componente
 * logico.
 */
public interface Component {
    /**
     * Metodo para establecer el valor de la entrada 1
     * @param entrada - Valor de la entrada
     */
    public void setPrimeraEntrada(Componente entrada);

    /**
     * Metodo para establecer el valor de la segunda entrada
     * @param entrada - Valor de la entrada
     */
    public void setSegundaEntrada(Componente entrada);

    /**
     * Metodo para obtener la salida de la operacion logica
     * @return - Resultado de la operacion logica
     */
    public int getSalida();

}