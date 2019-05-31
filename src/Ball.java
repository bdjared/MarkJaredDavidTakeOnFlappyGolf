import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
    private final double GRAVITY = .31;
    private final double FRICTION = .47;
    private double hSpeed;
    private double vSpeed;

    public Ball(int xPos, int yPos) {
        hSpeed = 0;
        vSpeed = 0;
        setRadius(7);
        setCenterX(xPos);
        setCenterY(yPos);
        setFill(Color.WHITE);
    }

    public void jumpLeft() {
        hSpeed -= .5;
        vSpeed += .24;
        this.onFrame();
    }

    public void jumpRight() {
        hSpeed += .5;
        vSpeed += .24;
        this.onFrame();
    }

    public double getGravity() {
        return GRAVITY;
    }

    public double getFriction() {
        return FRICTION;
    }

    public double getHSpeed() {
        return hSpeed;
    }

    public double getVSpeed() {
        return vSpeed;
    }

    public void gravity() {
        vSpeed -= GRAVITY;
    }

    public void onFrame() {
        vSpeed -= GRAVITY;
        hSpeed *= FRICTION;
        if (getCenterX() + hSpeed > 800 || getCenterX() + hSpeed < 0) {
            hSpeed /= -2;
        }

        if (getCenterY() + vSpeed > 500 || getCenterX() + vSpeed < 0) {
            vSpeed /= -2;
        }

        setCenterX(getCenterX() + hSpeed);
        setCenterY(getCenterY() - vSpeed);
    }
}
