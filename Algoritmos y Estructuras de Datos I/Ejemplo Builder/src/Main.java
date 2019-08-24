import java.awt.*;

public class Main {
    public static void main(String[] arg){
        Car c=new CarBuilder().setWheel(4).setColor(Color.BLACK).Builder();
        c.getDates();
    }

}