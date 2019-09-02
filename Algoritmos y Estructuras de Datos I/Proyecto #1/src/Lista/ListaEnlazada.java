package Lista;

import ComponentesLogicos.Componente;

/**
 * Esta clase es una lista enlazada simple. (Estructura de datos)
 */
public class ListaEnlazada{

    private Nodo cabeza;
    private int Tamano;

    /**
     * Esta clase interna funciona como nodo de la
     * lista enlazada.
     */
    private class Nodo{
        public Nodo siguiente=null;
        public Componente componente;

        /**
         * Constructor de la clase Nodo que le asigna
         * un valor al nodo
         * @param componente - valor del nodo
         */
        public Nodo(Componente componente) {
            this.componente = componente;
        }
    }

    /**
     * Este metodo inseta un nodo al inicio de la lista
     * @param c - Nodo a insertar
     */
    public void InsertarInicio(Componente c){
        Nodo nodo=new Nodo(c);
        nodo.siguiente=cabeza;
        cabeza=nodo;
        Tamano++;
    }

    /**
     * Este metodo inserta un nodo al final de la lista
     * @param c - Nodo a insertar
     */
    public void InsertarFinal(Componente c){
        Nodo nodo =new Nodo(c);
        if (cabeza==null){
            InsertarInicio(c);
        }else{
            Nodo puntero = cabeza;
            while(puntero.siguiente!=null){
                puntero=puntero.siguiente;
            }
            puntero.siguiente=nodo;
            Tamano++;
        }
    }

    /**
     * Este metodo inserta un valor en un index "n"
     * de la lista
     * @param n - index de la lista en el que se desea insertar
     * @param c - Valor que se insertará
     */
    public void Insertar(int n, Componente c){
        Nodo nodo=new Nodo(c);
        if (cabeza==null||n==0){
            this.InsertarInicio(c);
        }else{
            Nodo puntero = cabeza;
            int contador=0;
            while(contador<n && puntero.siguiente!=null){
                puntero=puntero.siguiente;
                contador++;
            }
            nodo.siguiente=puntero.siguiente;
            puntero.siguiente=nodo;
            Tamano++;
        }
    }

    /**
     * Este metodo obtiene el valor en un index "n" de la lista.
     * @param n - Numero de posicion a obtener
     * @return
     */
    public Componente Obtener(int n){
        if(cabeza==null){
            return null;
        }else{
            Nodo puntero = cabeza;
            int contador=0;
            while (contador<n&&puntero.siguiente!=null){
                puntero=puntero.siguiente;
                contador++;
            }
            if(contador!=n){
                return null;
            }else{
                return puntero.componente;
            }
        }
    }

    /**
     * Este metodo retorna el tamaño de la lista.
     * @return  Variable tamano de la clase.
     */
    public int Tamano(){
        return Tamano;
    }

    /**
     * Este metodo elimina la cabeza de la lista.
     */
    public void EliminarInicio(){
        if (cabeza!=null) {
            Nodo primer = cabeza;
            cabeza = cabeza.siguiente;
            primer.siguiente = null;
            Tamano--;
        }
    }

    /**
     * Este metodo elimina el nodo final de la lista.
     */
    public void EliminarFinal(){
        if(cabeza!=null){
            if(cabeza.siguiente==null){
                cabeza=null;
            }else{
                Nodo puntero=cabeza;
                while (puntero.siguiente.siguiente!=null){
                    puntero=puntero.siguiente;
                }
                puntero.siguiente=null;
                Tamano--;
            }
        }
    }

    /**
     * Este metodo elimina el nodo de una posicion "n".
     * @param n - Posicion del nodo a eliminar.
     */
    public void eliminar(int n){
        if (cabeza!=null){
            if(n==0){
                this.EliminarInicio();
            }else if(n<Tamano) {
                Nodo puntero = cabeza;
                int contador = 0;
                while (contador < (n - 1)) {
                    puntero = puntero.siguiente;
                    contador++;
                }
                Nodo temp = puntero.siguiente;
                puntero.siguiente = temp.siguiente;
                temp.siguiente = null;
                Tamano--;
            }
        }
    }

}
