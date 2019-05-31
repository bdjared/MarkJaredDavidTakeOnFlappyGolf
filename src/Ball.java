import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball extends Circle {
    private double gravity = .32;
    private final double FRICTION = .96;
    private double hSpeed;
    private double vSpeed;
    private Timeline animation;

    public Ball(int xPos, int yPos) {
        hSpeed = 0;
        vSpeed = 0;
        setRadius(7);
        setCenterX(xPos);
        setCenterY(yPos);
        setFill(Color.WHITE);
        play();
    }

    public void jumpLeft() {
        hSpeed -= 5;
        vSpeed -= 5;
        if (vSpeed > 0)
        gravityJump();
    }

    public void jumpRight() {
        hSpeed += 5;
        vSpeed -= 5;
        if (vSpeed > 0)
        gravityJump();
    }

    public double getGravity() {
        return gravity;
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

    public Timeline getAnimation() {
        return animation;
    }

    public void gravityJump(){
        vSpeed = -5;
    }

    public void play() {
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            vSpeed += gravity;
            hSpeed *= FRICTION;

            if (getCenterX() + hSpeed + getRadius() > 800 || getCenterX() + hSpeed - getRadius() < 0) {
                hSpeed /= -2;
            }

            if (getCenterY() + vSpeed + getRadius() > 325 || getCenterY() + vSpeed - getRadius() < 0) {
                vSpeed /= -2;
            }
            setCenterX(getCenterX() + hSpeed);
            setCenterY(getCenterY() + vSpeed);
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
}
