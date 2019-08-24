import java.awt.*;

public class Car {

    int Wheel;
    Color Color;

    public Car (int Wheel, java.awt.Color color){
        this.Wheel=Wheel;
        this.Color=Color;
    }

    public void getDates(){
        System.out.println("Wheels= "+Wheel+" Color= "+Color);
    }
}
