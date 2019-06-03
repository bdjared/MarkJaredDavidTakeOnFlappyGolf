import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball extends Circle {
    private final double GRAVITY = .25;
    private final double FRICTION = .99;
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
        if (vSpeed < -3){
            vSpeed = -8;
            hSpeed -= 2;
        }
        else {
            hSpeed -= 2;
            if (vSpeed < 0)
                vSpeed -= 5;
            else
                gravityJump();
        }
    }

    public void jumpRight() {
        if (vSpeed < -3){
            vSpeed = -8;
            hSpeed += 2;
        }
        else {
            hSpeed += 2;
            if (vSpeed < 0)
                vSpeed -= 5;
            else
                gravityJump();
        }
    }

    public void gravityJump(){
        vSpeed = -5;
    }

    public void play() {
        animation = new Timeline(new KeyFrame(Duration.millis(16.6), e -> {
            vSpeed += GRAVITY;
            hSpeed *= FRICTION;

            if (getCenterX() + hSpeed + getRadius() > 800 || getCenterX() + hSpeed - getRadius() < 0) {
                hSpeed /= -2;
            }

            if (getCenterY() + vSpeed + getRadius() > 326) {
                setCenterY(325 - getRadius());
                vSpeed /= -4;
            }
            setCenterX(getCenterX() + hSpeed);
            setCenterY(getCenterY() + vSpeed);
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
}
