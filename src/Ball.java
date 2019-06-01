import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball extends Circle {
    private final double gravity = .5;
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
        if (vSpeed < -2){
            vSpeed = -8;
            hSpeed -= 3;
        }
        else {
            hSpeed -= 3;
            if (vSpeed < 0)
                vSpeed -= 6;
            else
                gravityJump();
        }
    }

    public void jumpRight() {
        if (vSpeed < -2){
            vSpeed = -8;
            hSpeed += 3;
        }
        else {
            hSpeed += 3;
            if (vSpeed < 0)
                vSpeed -= 6;
            else
                gravityJump();
        }
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
        vSpeed = -6;
    }

    public void play() {
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            vSpeed += gravity;
            hSpeed *= FRICTION;

            if (getCenterX() + hSpeed + getRadius() > 800 || getCenterX() + hSpeed - getRadius() < 0) {
                hSpeed /= -2;
            }

            if (getCenterY() + vSpeed + getRadius() > 325 || getCenterY() + vSpeed - getRadius() < 0) {
                vSpeed /= -4;
                Math.floor(vSpeed);
            }
            setCenterX(getCenterX() + hSpeed);
            setCenterY(getCenterY() + vSpeed);
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
}
