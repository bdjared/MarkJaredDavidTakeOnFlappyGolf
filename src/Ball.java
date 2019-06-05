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
    private Text textScore = new Text(String.format("%d", score));

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
        textScore.setText(String.format("%d", ++score));
        if ((getCenterX() < lvl.getGreen().getX() || getCenterX() > lvl.getGreen().getX() + lvl.getGreen().getWidth()) || Math.round(getCenterY() + getRadius()) < lvl.getGrass().getY() - 1) {
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
            hSpeed -= 1.5;
            vSpeed = 0;
        }
    }

    public void jumpRight() {
        textScore.setText(String.format("%d", ++score));
        if ((getCenterX() < lvl.getGreen().getX() || getCenterX() > lvl.getGreen().getX() + lvl.getGreen().getWidth()) || Math.round(getCenterY() + getRadius()) < lvl.getGrass().getY() - 1) {
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
            hSpeed += 1.5;
            vSpeed = 0;
        }
    }

    public void gravityJump() {
        vSpeed = -5;
    }

    public int numSize() {
        int scoreCopy = score;
        int length = 0;
        while (scoreCopy > 10) {
            scoreCopy /= 10;
            length++;
        }
        return length * 8;
    }

    public Text textScore() {
        textScore.setFont(new Font(10));
        textScore.xProperty().bind(centerXProperty().subtract(numSize()));
        textScore.yProperty().bind(centerYProperty().subtract(10));
        textScore.setFill(Color.WHITE);
        return textScore;
    }

    public Text getWinText() {
        return winText;
    }

    public void play() {
        animation = new Timeline(new KeyFrame(Duration.millis(16.6), e -> {
            if (Math.round(getCenterY() + getRadius()) != lvl.getGrass().getY() || (getCenterX() < 671 && getCenterX() > 664)) {
                vSpeed += GRAVITY;
            }

            if (Math.round(getCenterY() + getRadius()) < lvl.getGrass().getY() - 1) {
                hSpeed *= FRICTION;
            }
            else{
                hSpeed *= .97;
            }

            if (hSpeed < .09 && hSpeed > -.09) {
                hSpeed = 0;
            }

            if (getCenterX() + hSpeed + getRadius() > 900 || getCenterX() + hSpeed - getRadius() < 0) {
                hSpeed /= -2;
            }

            for (int x = 0; x <= 900; x++) {
                if (contains(x, lvl.getGrass().getY()) && (getCenterX() > 671 || getCenterX() < 664)) {
                    setCenterY(370 - getRadius());
                    vSpeed /= -4;
                }
                else if ((getCenterX() < 671 && getCenterX() > 664) && contains(x, lvl.getGrass().getY() - lvl.getHole().getHeight())) {
                    if (vSpeed < 1)
                        vSpeed = .75;
                    setCenterY(getCenterY() + vSpeed);
                }
            }

            if (getCenterY() + vSpeed - getRadius() < 0) {
                vSpeed = 0;
            }

            if (getCenterY() - getRadius() > lvl.getGrass().getY() - 6) {
                setFill(Color.TRANSPARENT);
                textScore.setFill(Color.TRANSPARENT);
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
        winText.setFont(new Font(100));
    }
}
