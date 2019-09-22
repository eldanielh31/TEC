package InterfazGrafica;

import ComponentesLogicos.Componente;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import java.util.Random;

/**
 * Clase correspondiente a los circulos de input y output.
 */
public class Circular extends Circle{
    private static boolean Draw;
    private static double StartX, StartY;
    private String Type;
    private Line line;
    private int finLine=0;
    private boolean HaveLine;
    private Componente Component;
    private static Circular Anterior;
    private double orgSceneX,orgSceneY;
    private double orgTranslateX,orgTranslateY;

    /**
     * Contructor de la clase circular.
     * @param X- Distancia x del circulo
     * @param Y- Distancia y del circulo.
     * @param component - Componente respectivo del circulo.
     * @param type - Tipo de circulo que es (output, input).
     */
    public Circular(double X,double Y, Componente component,String type) {
        super(X, Y, 5, Color.BLACK);
        Type=type;
        Component=component;
        Draw=false;
        HaveLine=false;
        line=null;

        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Click(e);
            }
        });
    }

    /**
     * Evento para asiganar la posicion inicial del circulo.
     * @param t- evento del mouse.
     */
    public void Pressed (MouseEvent t){

        orgSceneX = t.getSceneX();
        orgSceneY = t.getSceneY();
        orgTranslateX = ((Shape)(t.getSource())).getTranslateX();
        orgTranslateY = ((Shape)(t.getSource())).getTranslateY();

    }

    /**
     * Evento para transladar el circulo con forme se mueve el mouse.
     * @param t- Evento del mouse.
     */
    public void Dragged(MouseEvent t){
        double offsetX = t.getSceneX() - orgSceneX;
        double offsetY = t.getSceneY() - orgSceneY;
        double newTranslateX = orgTranslateX + offsetX;
        double newTranslateY = orgTranslateY + offsetY;

        this.setTranslateX(newTranslateX);
        this.setTranslateY(newTranslateY);

        if (finLine==1){
            line.setEndX(newTranslateX+getCenterX());
            line.setEndY(newTranslateY+getCenterY());
        }else if(finLine==2){
            line.setStartX(newTranslateX+getCenterX());
            line.setStartY(newTranslateY+getCenterY());
        }

    }

    /**
     * Evento al clickear un circulo y comience o termine el draw
     * @param e- evento del mouse.
     */
    public void Click(MouseEvent e){
        if(!HaveLine){
            if (Draw) {
                if (Component.getID()!=Anterior.getComponente().getID()) {
                    if (!this.Type.equals(Anterior.Type)) {
                        DrawLine(e);
                        Enlazar();
                        Anterior.finLine=2;
                        Anterior.line=line;
                        finLine=1;
                        StopDraw("not");
                    }
                }else{
                    StopDraw("all");
                }
            }else{
                StartDraw(e);
            }
        }
    }

    /**
     * Evento para dibujar la linea que conecta
     * visualmente los componentes.
     * @param e- evento de mouse.
     */
    private void DrawLine(MouseEvent e){
        line = new Line(StartX, StartY, e.getSceneX(), e.getSceneY());
        line.setStrokeWidth(3);
        line.setStroke(randomColor());
        this.setFill(Color.GREEN);
        RootMain.Group.getChildren().add(line);
    }

    /**
     * Metodo que llama una primera llamada de dibujo de linea.
     * @param e- evento de mouse.
     */
    private void StartDraw(MouseEvent e){
        StartX = e.getSceneX();
        StartY = e.getSceneY();
        Anterior=this;
        Draw = true;
        HaveLine=true;
        this.setFill(Color.GREEN);
    }

    /**
     * Evento para terminar el dibujo de linea.
     * @param i- String que define como parar de dibujar.
     */
    private void StopDraw(String i){
        if(i.equals("all")){
        Anterior.setFill(Color.BLACK);
        Anterior.HaveLine=false;
        Anterior=null;
        Draw=false;
        HaveLine=false;
        }else{
            Anterior = null;
            Draw = false;
            HaveLine = true;
        }
    }

    /**
     * Evento que enlaza los circulos
     * referenciando sus respectivos componentes.
     */
    private void Enlazar(){
        if (this.Type.equals("input")) {
            this.getComponente().setInput(true);
            if (Anterior.getComponente().getEntrada1() != null) {
                Anterior.getComponente().setSegundaEntrada(this.Component);
                RootMain.AreaText.appendText(Anterior.getComponente().getName()+" #"+Anterior.getComponente().getID()+" Enlazado con "+ this.getComponente().getName()+" #"+this.getComponente().getID()+"\n");
            } else {
                Anterior.getComponente().setPrimeraEntrada(this.Component);
                RootMain.AreaText.appendText(Anterior.getComponente().getName()+" #"+Anterior.getComponente().getID()+" Enlazado con "+ this.getComponente().getName()+" #"+this.getComponente().getID()+"\n");

            }
        } else {
            Anterior.getComponente().setInput(true);
            if (this.getComponente().getEntrada1() != null) {
                this.getComponente().setSegundaEntrada(Anterior.Component);
                RootMain.AreaText.appendText(this.getComponente().getName()+" #"+this.getComponente().getID()+" Enlazado con "+ Anterior.getComponente().getName()+" #"+Anterior.getComponente().getID()+"\n");

            } else {
                this.getComponente().setPrimeraEntrada(Anterior.Component);
                RootMain.AreaText.appendText(this.getComponente().getName()+" #"+this.getComponente().getID()+" Enlazado con "+ Anterior.getComponente().getName()+" #"+Anterior.getComponente().getID()+"\n");

            }
        }
    }

    /**
     * Metodo para generar un color aleatorio.
     * @return - Color
     */
    private Paint randomColor() {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return Color.rgb(r, g, b);
    }

    /**
     * Metodo para obtener el atributo componente
     * @return - Componente.
     */
    public Componente getComponente() {
        return Component;
    }
}
