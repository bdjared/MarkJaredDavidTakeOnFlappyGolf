import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Ball extends Circle {
    private final double GRAVITY = .17;
    private final double FRICTION = .99;
    private double hSpeed;
    private double vSpeed;
    private Timeline animation;
    private Hole lvl;
    private int score;
    private Text winText = new Text();

    public Ball(int xPos, int yPos, Hole hole) {
        hSpeed = 0;
        vSpeed = 0;
        score = 0;
        lvl = hole;
        setRadius(6);
        setCenterX(xPos);
        setCenterY(yPos);
        setFill(Color.WHITE);
        play();
    }

    public void jumpLeft() {
        score++;
        if ((getCenterX() < 580 || getCenterX() > 580 + 145) && getCenterY() < lvl.getGrass().getY() - getRadius()) {
            if (vSpeed < -3) {
                vSpeed = -8;
                hSpeed -= 1.5;
            } else {
                hSpeed -= 1.5;
                if (vSpeed < 0)
                    vSpeed -= 5;
                else
                    gravityJump();
            }
        }
        else{
            hSpeed -= .5;
        }
    }

    public void jumpRight() {
        score++;
        if ((getCenterX() < 580 || getCenterX() > 580 + 145) && getCenterY() < lvl.getGrass().getY() - getRadius()) {
            if (vSpeed < -3) {
                vSpeed = -8;
                hSpeed += 1.5;
            } else {
                hSpeed += 1.5;
                if (vSpeed < 0)
                    vSpeed -= 5;
                else
                    gravityJump();
            }
        }
        else {
            hSpeed += .5;
        }
    }

    public void gravityJump(){
        vSpeed = -5;
    }

    public Text getWinText() {
        return winText;
    }

    public void play() {
        animation = new Timeline(new KeyFrame(Duration.millis(16.6), e -> {
            if (Math.round(getCenterY() + getRadius()) != lvl.getGrass().getY() || (getCenterX() < 670 && getCenterX() > 665)) {
                vSpeed += GRAVITY;
            }

            hSpeed *= FRICTION;
            if (hSpeed < .08 && hSpeed > -.08) {
                hSpeed = 0;
            }

            if (getCenterX() + hSpeed + getRadius() > 900 || getCenterX() + hSpeed - getRadius() < 0) {
                hSpeed /= -2;
            }

            for (int x = 0; x <= 900; x++) {
                if (contains(x, lvl.getGrass().getY()) && (getCenterX() > 670 || getCenterX() < 665)) {
                    setCenterY(370 - getRadius());
                    vSpeed /= -4;
                }
                else if ((getCenterX() < 670 && getCenterX() > 665) && contains(x, lvl.getGrass().getY() - lvl.getHole().getHeight())) {
                    vSpeed = 1.5;
                    setCenterY(getCenterY() + vSpeed);
                    if (getCenterY() > 385 + getRadius()) {
                        setCenterY(385 + getRadius());
                    }
                }
            }

            if (getCenterY() + vSpeed - getRadius() < 0) {
                vSpeed = 0;
            }

            if (getCenterY() - getRadius() > lvl.getGrass().getY()) {
                win();
            }

            setCenterX(getCenterX() + hSpeed);
            setCenterY(getCenterY() + vSpeed);
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    private void win() {
        animation.pause();
        winText.setText(score + " flaps!");
        winText.setFill(Color.WHITE);
        winText.setX(lvl.getWidth() / 3.5);
        winText.setY(lvl.getHeight() / 2);
        winText.setFont(new Font("Open Sans", 100));
    }
}
