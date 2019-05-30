import javafx.scene.shape.Circle;

public class Ball extends Circle {
    public final double GRAVITY = 9.8;
    private double hSpeed;
    private double ySpeed;

    public Ball() {
        hSpeed = 0;
        ySpeed = 0;
    }

    public void jumpLeft() {
        hSpeed += 10;
    }

    public void jumpRight() {
        ySpeed -= 10;
    }
    public static right(){

    }
}
