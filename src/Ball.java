import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball extends Circle {
    private final double GRAVITY = .17;
    private final double FRICTION = .99;
    private double hSpeed;
    private double vSpeed;
    private Timeline animation;

    public Ball(int xPos, int yPos, Hole lvl) {
        hSpeed = 0;
        vSpeed = 0;
        setRadius(6);
        setCenterX(xPos);
        setCenterY(yPos);
        setFill(Color.WHITE);
        play(lvl);
    }

    public void jumpLeft() {
        if (vSpeed < -3){
            vSpeed = -8;
            hSpeed -= 1.5;
        }
        else {
            hSpeed -= 1.5;
            if (vSpeed < 0)
                vSpeed -= 5;
            else
                gravityJump();
        }
    }

    public void jumpRight() {
        if (vSpeed < -3){
            vSpeed = -8;
            hSpeed += 1.5;
        }
        else {
            hSpeed += 1.5;
            if (vSpeed < 0)
                vSpeed -= 5;
            else
                gravityJump();
        }
    }

    public void gravityJump(){
        vSpeed = -5;
    }

    public void play(Hole lvl) {
        animation = new Timeline(new KeyFrame(Duration.millis(16.6), e -> {
            vSpeed += GRAVITY;
            hSpeed *= FRICTION;

            if (getCenterX() + hSpeed + getRadius() > 900 || getCenterX() + hSpeed - getRadius() < 0) {
                hSpeed /= -2;
            }

            for (int x = 0; x <= 900; x++) {
                if (contains(x, lvl.getGrass().getY())) {
                    setCenterY(370 - getRadius());
                    vSpeed /= -4;
                }
            }

            if (getCenterY() + vSpeed - getRadius() < 0) {
                vSpeed = 0;
            }
            setCenterX(getCenterX() + hSpeed);
            setCenterY(getCenterY() + vSpeed);
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
}
