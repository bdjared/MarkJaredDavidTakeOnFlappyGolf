import javafx.scene.shape.Circle;

public class Ball extends Circle {
    public final double GRAVITY = .32;
    private double hSpeed;
    private double vSpeed;

    public Ball(int xPos, int yPos) {
        hSpeed = 0;
        vSpeed = 0;
        setRadius(5);
        setCenterX(xPos);
        setCenterY(yPos);
    }

    public void jumpLeft() {
        hSpeed += 10;
        vSpeed += 5;
    }

    public void jumpRight() {
        hSpeed -= 10;
        vSpeed += 5;
    }

    public void onFrame() {
        vSpeed -= GRAVITY;
        this.setCenterX(this.getCenterX() + hSpeed);
        this.setCenterY(this.getCenterY() + vSpeed);
    }
}
