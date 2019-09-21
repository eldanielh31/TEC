package InterfazGrafica;

import ComponentesLogicos.*;
import Lista.ListaEnlazada;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Esta clase funciona como un refactor de eventos.
 */
public class Eventos {

    /**
     * Este metodo gestiona el drag de la imagen
     * que se encuentra en la paleta.
     * @param e - Evento de mouse al mover la imagen.
     * @param Comp - Imagen del componente.
     * @param Name - Nombre del componente que se está moviendo.
     */
   static void DragDetected(MouseEvent e, ImageView Comp, String Name){
        Dragboard db= Comp.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content=new ClipboardContent();
        content.putString(Name);
        db.setContent(content);
        e.consume();
    }

      /**
     * Este metodo es un auxiliar del evento drop de la imagen.
     * En este se coloca la imagen en un rectangulo para la
     * implementacion en el panel principal.
     * @param e - Evento tipo drag.
     * @param i - Imagen del componente.
     * @param C - String para identificar el componente.
     */
    private static void DroppedAux(DragEvent e,ImageView i,String C,Componente c){
        Circular output;
        Circular input;
        Rectangle rectangle;
        if (!C.equals("NOT")) {
            output = new Circular(e.getSceneX(), e.getSceneY() + 10,c,"output");
            Circular outputII = new Circular(e.getSceneX(), e.getSceneY() + 30,c,"output");
            input = new Circular(e.getSceneX() + 50, e.getSceneY() + 20,c,"input");
            rectangle = new Rectangular(50, 40, i, e, output, outputII, input);
            RootMain.Group.getChildren().addAll(rectangle, output, outputII, input);
        }
        else{
            output = new Circular(e.getSceneX(), e.getSceneY() + 20,c,"output");
            input = new Circular(e.getSceneX() + 50, e.getSceneY() + 20,c,"input");
            rectangle = new Rectangular(50, 40, i, e, output, null, input);
            RootMain.Group.getChildren().addAll(rectangle, output, input);
        }
    }

    /**
     * Este metodo gestiona el drop de la imagen del componente.
     * Identifica que componente se está moviendo, imprime en un TextArea
     * e introduce en una lista enlazada cada componente.
     * @param e - Evento tipo DragEvent.
     */
    static void Dropped(DragEvent e, ImageView[] i){
        int cont=0;
        for (String x:RootMain.Names){
            if (e.getDragboard().getString().equals(x)){
                Componente c=new FactoryPalete().ComponentFactory(x);
                Eventos.DroppedAux(e,i[cont],x,c);
                RootMain.AreaText.appendText("Agrega componente "+ x +"\n");
                if (RootMain.Lista.Tamano()==0){
                    RootMain.Lista.InsertarInicio(c); }
                else{
                    RootMain.Lista.InsertarFinal(c); }
            }
            cont++;
        }
    }

    /**
     * Este metodo es llamado por el botón para iniciar
     * las operaciones y obtener la salida del circuito.
     */
    static void Play(){
        CleanLista();
        ListaEnlazada outputs=new ListaEnlazada();
        ListaEnlazada inputs=new ListaEnlazada();
        for (int x=0;x<RootMain.Lista.Tamano();x++){
            Componente c=RootMain.Lista.Obtener(x);

            if (c.getEntrada1()!=null&&c.getEntrada2()!=null&&c.isInput()==false){
                outputs.Insertar(x,c);
                System.out.println(c.getName()+"   o");
            }
            else if (c.getEntrada1()==null&&c.getEntrada2()==null&&c.isInput()==true){
                inputs.Insertar(x,c);
                System.out.println(c.getName()+"    i");
                SetInputs(c);
            }
        }
        Asignar(RootMain.Lista);
        for (int x=0;x<outputs.Tamano();x++){
            for(int y=0;y<RootMain.Lista.Tamano();y++){
                Componente c1=outputs.Obtener(x);
                Componente c2=RootMain.Lista.Obtener(y);
                if (c1.getID()==c2.getID()){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Su valor de verdad para "+c2.getID()+" es: "+ c2.getOutput());
                    alert.showAndWait();
                }
            }
        }
        //RootMain.Play.setDisable(true);
        System.out.println(RootMain.Lista.Tamano());
    }

    /**
     * Metodo que establece los inputs de los componentes "cabeza"
     * @param c- Componente "cabeza".
     */
    private static void SetInputs(Componente c) {
        if (c.getEntrada1() == null && c.getEntrada2() == null) {
            for (int x=0; x< 2; x++) {
                List<String> choices = new ArrayList<>();
                choices.add("1");
                choices.add("0");
                ChoiceDialog<String> dialog = new ChoiceDialog<>("1", choices);
                dialog.setTitle("Choice");
                dialog.setHeaderText("Choice Value of input :"+ c.getName());
                dialog.setContentText("Value: ");

                Optional<String> result = dialog.showAndWait();
                if(x==0) {
                    result.ifPresent(number -> c.setInput1(Integer.parseInt(number)));
                }else {
                    result.ifPresent(number -> c.setInput2(Integer.parseInt(number)));
                }
            }
            System.out.println(c.getInput1() + " "+ c.getInput2());
        }
    }

    /**
     * Metodo que asigna a cada elemento de la lista de componentes
     * un valor entero para la variable output.
     * @param l- lista enlazada diseñada.
     */
    private static void Asignar(ListaEnlazada l){
        int listos=Listos(l);
        int x= l.Tamano();
        int temp=0;
        while (listos<x) {
            Componente c = l.Obtener(temp);
            if (c.getEntrada1() != null && c.getEntrada1() != null) {
                Componente i1 = c.getEntrada1();
                Componente i2 = c.getEntrada2();
                if (i1.getOutput()<2 && i2.getOutput()< 2 && c.getOutput()==2) {
                    c.setInput1(i1.getOutput());
                    c.setInput2(i2.getOutput());
                    c.setOutput(ClasiCompo(c));
                    temp = 0;
                    listos++;
                } else {
                    temp++;
                }
            } else {
                temp++;
            }
        }
    }

    /**
     * Se obtiene la cantidad de componentes que ya
     * poseen un output.
     * @param l- lista enlazada.
     * @return - cantidad de componentes listos.
     */
    private static int Listos(ListaEnlazada l){
        int listos=0;
        for (int x=0;x<l.Tamano();x++){
            if (l.Obtener(x).getInput2()<2 && l.Obtener(x).getInput1()<2){
                l.Obtener(x).setOutput(ClasiCompo(l.Obtener(x)));
                listos++;
            }
        }
        return listos;
    }

    /**
     * Metodo que clasifica el componente y realiza su operacion logica
     * correspondiente.
     * @param c - Componente.
     * @return - entero correspondiente a la salida.
     */
    private static int ClasiCompo(Componente c) {
        if (c.getName().equals("AND")) {
            AND v = (AND) c;
            return v.getSalida();
        }
        if (c.getName().equals("OR")) {
            OR v = (OR) c;
            return v.getSalida();
        }
        if (c.getName().equals("NAND")) {
            NAND v = (NAND) c;
            return v.getSalida();
        }
        if (c.getName().equals("XOR")) {
            XOR v = (XOR) c;
            return v.getSalida();
        }
        if (c.getName().equals("XNOR")) {
            XNOR v = (XNOR) c;
            return v.getSalida();
        }
        if (c.getName().equals("NOT")) {
            NOT v = (NOT) c;
            return v.getSalida();
        }else{
            NOR v = (NOR) c;
            return v.getSalida();
        }
    }

    /**
     * Metodo que limpia cada output e input de los
     * componentes de la lista.
     */
    private static void CleanLista(){
        for(int x=0;x<RootMain.Lista.Tamano();x++){
            RootMain.Lista.Obtener(x).setOutput(2);
            RootMain.Lista.Obtener(x).setInput1(2);
            RootMain.Lista.Obtener(x).setInput2(2);
        }

            /*
            if(RootMain.Lista.Obtener(x).getEntrada1()==null&&RootMain.Lista.Obtener(x).getEntrada2()==null){
                RootMain.Lista.Obtener(x).setOutput(2);
            }
            if(RootMain.Lista.Obtener(x).isInput()==false){
                RootMain.Lista.Obtener(x).setInput1(2);
                RootMain.Lista.Obtener(x).setInput2(2);
            }else{
                RootMain.Lista.Obtener(x).setOutput(2);
                RootMain.Lista.Obtener(x).setInput1(2);
                RootMain.Lista.Obtener(x).setInput2(2);
            }
        }

             */
    }

    static void Reset(){
        for(int x=0;x<RootMain.Lista.Tamano();x++){
            RootMain.Lista.eliminar(x);
        }
        RootMain.Group.getChildren().clear();
        RootMain.AreaText.clear();
        //RootMain.Play.setDisable(false);
        System.out.println(RootMain.Lista.Tamano());
    }

}


