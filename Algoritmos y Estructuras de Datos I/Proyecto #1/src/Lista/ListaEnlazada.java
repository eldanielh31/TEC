package Lista;

import ComponentesLogicos.Componente;


public class ListaEnlazada{

    private Nodo cabeza;
    private int Tamano;

    private class Nodo{
        public Nodo siguiente=null;
        public Componente componente;

        public Nodo(Componente componente) {
            this.componente = componente;
        }
    }

    public void InsertarInicio(Componente c){
        Nodo nodo=new Nodo(c);
        nodo.siguiente=cabeza;
        cabeza=nodo;
        Tamano++;
    }

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

    public int Tamano(){
        return Tamano;
    }

    public void EliminarInicio(){
        if (cabeza!=null) {
            Nodo primer = cabeza;
            cabeza = cabeza.siguiente;
            primer.siguiente = null;
            Tamano--;
        }
    }

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
