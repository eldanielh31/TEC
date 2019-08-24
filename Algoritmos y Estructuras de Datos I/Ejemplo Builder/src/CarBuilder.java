import java.awt.*;

public class CarBuilder {

    int Wheel;
    java.awt.Color Color;

    public CarBuilder setWheel(int Wheel) {
        this.Wheel = Wheel;
        return this;
    }

    public CarBuilder setColor(Color color) {
        this.Color = color;
        return this;
    }

    public Car Builder() {
        return new Car(Wheel, Color);
    }
}