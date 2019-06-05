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
    private double xStart;
    private double yStart;
    private Timeline animation;
    private Hole lvl;

    public void reset() {
        this.score = 0;
        setCenterX(xStart);
        setCenterY(yStart);
        textScore.setText(String.format("%f", score));
        animation.play();
    }

    private int score;
    private Text winText = new Text();
    private Text returnText = new Text();
    private Text textScore = new Text("" + score);

    public Ball(double xPos, double yPos, Hole hole) {
        hSpeed = 0;
        vSpeed = 0;
        score = 0;
        lvl = hole;
        xStart= xPos;
        yStart = yPos;
        setRadius(6);
        setCenterX(xPos);
        setCenterY(yPos);
        setFill(Color.WHITE);
        play();
    }

    public void jumpLeft() {
        textScore.setText("" + ++score);
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
        textScore.setText("" + ++score);
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

    public Text getReturnText() {
        return returnText;
    }

    public void play() {
        animation = new Timeline(new KeyFrame(Duration.millis(1000 / 60.0), e -> {
            if (Math.round(getCenterY() + getRadius()) != lvl.getGrass().getY() || (getCenterX() < lvl.getHoleOval().getCenterX() + (lvl.getHoleOval().getRadiusX() / 2) && getCenterX() > lvl.getHoleOval().getCenterX() - (lvl.getHoleOval().getRadiusX() / 2))) {
                vSpeed += GRAVITY;
            }

            if (Math.round(getCenterY() + getRadius()) < lvl.getGrass().getY() - 1) {
                hSpeed *= FRICTION;
            }
            else{
                hSpeed *= .975;
            }

            if (hSpeed < .08 && hSpeed > -.08) {
                hSpeed = 0;
            }

            if (getCenterX() + hSpeed + getRadius() > lvl.getWidth() || getCenterX() + hSpeed - getRadius() < 0) {
                hSpeed /= -2;
            }

            for (int x = 0; x <= lvl.getWidth(); x++) {
                if (contains(x, lvl.getGrass().getY()) && (getCenterX() > lvl.getHoleOval().getCenterX() + (lvl.getHoleOval().getRadiusX() / 2) || getCenterX() < lvl.getHoleOval().getCenterX() - (lvl.getHoleOval().getRadiusX() / 2))) {
                    setCenterY(lvl.getGrass().getY() - getRadius());
                    vSpeed /= -4;
                }
                else if ((getCenterX() < lvl.getHoleOval().getCenterX() + (lvl.getHoleOval().getRadiusX() / 2) && getCenterX() > lvl.getHoleOval().getCenterX() - (lvl.getHoleOval().getRadiusX() / 2) && contains(x, lvl.getGrass().getY() - lvl.getHoleRect().getHeight()))) {
                    toFront();
                    if (vSpeed < 1)
                        vSpeed = .75;
                    setCenterY(getCenterY() + vSpeed);
                }
            }

            if (getCenterY() + vSpeed - getRadius() < 0) {
                vSpeed = 0;
            }

            if (getCenterY() - getRadius() > lvl.getGrass().getY() - getRadius()) {
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
        returnText.setText("Press 'ESC' to return to the main screen.");
        returnText.setFill(Color.DIMGRAY);
        returnText.setX(lvl.getWidth() / 4.1);
        returnText.setY(lvl.getHeight()/ 1.5);
        returnText.setFont(new Font(25));
    }
}
