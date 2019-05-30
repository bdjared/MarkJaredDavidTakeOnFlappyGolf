import javafx.scene.shape.Circle;

public class Ball extends Circle {
    public final double GRAVITY = 9.8;
    public final double FRICTION = 5;
    private double hSpeed;
    private double vSpeed;

    public Ball(int xPos, int yPos) {
        hSpeed = 0;
        vSpeed = 0;
        setRadius(10);
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
        hSpeed -= FRICTION;
        if (getCenterX() + hSpeed > 900 || getCenterX() + hSpeed < 0) {
            hSpeed /= -2;
        }
        setCenterX(getCenterX() + hSpeed);
        setCenterY(getCenterY() + vSpeed);
    }
}
