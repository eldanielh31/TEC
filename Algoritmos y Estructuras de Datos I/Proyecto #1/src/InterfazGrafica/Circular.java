package InterfazGrafica;

import ComponentesLogicos.Componente;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class Circular extends Circle{
    private static boolean Draw;
    private static double StartX, StartY;
    private String Type;
    private Line line;
    private boolean HaveLine;
    private Componente Component;
    private Circular Enlazado;
    private static Componente temp;
    private static Circular Anterior;
    //Variables para mover el circulo
    private double orgSceneX,orgSceneY;
    private double orgTranslateX,orgTranslateY;

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


    public void Pressed (MouseEvent t){

        orgSceneX = t.getSceneX();
        orgSceneY = t.getSceneY();
        orgTranslateX = ((Shape)(t.getSource())).getTranslateX();
        orgTranslateY = ((Shape)(t.getSource())).getTranslateY();
    }

    public void Dragged(MouseEvent t){
        double offsetX = t.getSceneX() - orgSceneX;
        double offsetY = t.getSceneY() - orgSceneY;
        double newTranslateX = orgTranslateX + offsetX;
        double newTranslateY = orgTranslateY + offsetY;

        this.setTranslateX(newTranslateX);
        this.setTranslateY(newTranslateY);

    }

    public void Click(MouseEvent e){
        if(!HaveLine){
            if (Draw) {
                if (Component.getID()!=Anterior.getComponente().getID()) {
                    if (!this.Type.equals(Anterior.Type)) {
                        DrawLine(e);
                        Enlazar();
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

    private void DrawLine(MouseEvent e){
        line = new Line(StartX, StartY, e.getSceneX(), e.getSceneY());
        this.setFill(Color.GREEN);
        RootMain.AreaText.appendText(Component.getName() + "..." + temp.getName());
        RootMain.Group.getChildren().add(line);
    }

    private void StartDraw(MouseEvent e){
        StartX = e.getSceneX();
        StartY = e.getSceneY();
        temp=this.Component;
        Anterior=this;
        RootMain.AreaText.appendText(Component.getName());
        Draw = true;
        HaveLine=true;
        this.setFill(Color.GREEN);
    }

    private void StopDraw(String i){
        if(i.equals("all")){
        Anterior.setFill(Color.BLACK);
        Anterior.HaveLine=false;
        Anterior=null;
        temp=null;
        Draw=false;
        HaveLine=false;
        }else{
            Enlazado = Anterior;
            Anterior.Enlazado = this;
            Anterior = null;
            temp = null;
            Draw = false;
            HaveLine = true;
        }
    }

    private void Enlazar(){
        if (this.Type.equals("input")) {
            this.getComponente().setInput(true);
            if (Anterior.getComponente().getEntrada1() != null) {
                Anterior.getComponente().setSegundaEntrada(this.Component);
            } else {
                Anterior.getComponente().setPrimeraEntrada(this.Component);
            }
        } else {
            Anterior.getComponente().setInput(true);
            if (this.getComponente().getEntrada1() != null) {
                this.getComponente().setSegundaEntrada(Anterior.Component);
            } else {
                this.getComponente().setPrimeraEntrada(Anterior.Component);
            }
        }
    }


    public Line getLine() {
        return line;
    }

    public Componente getComponente() {
        return Component;
    }
}
