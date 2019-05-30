import javafx.scene.shape.Circle;

public class Ball extends Circle {
    private final double GRAVITY = 9.8;
    private final double FRICTION = 5;
    private double hSpeed;
    private double vSpeed;

    private Ball(int xPos, int yPos) {
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

    public double getGRAVITY() {
        return GRAVITY;
    }

    public double getFRICTION() {
        return FRICTION;
    }

    public double gethSpeed() {
        return hSpeed;
    }

    public double getvSpeed() {
        return vSpeed;
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
