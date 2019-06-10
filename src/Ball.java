import javafx.animation.Animation;
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
    }

    public void jumpLeft() {
        textScore.setText("" + ++score);
        if (!getBoundsInParent().intersects(lvl.getGreen().getBoundsInParent())) {
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
        } else {
            hSpeed -= 1.5;
            vSpeed = 0;
        }
    }


    public void jumpRight() {
        textScore.setText("" + ++score);
        if (!getBoundsInParent().intersects(lvl.getGreen().getBoundsInParent())) {
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
        } else {
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

    public Timeline getAnimation() {
        return animation;
    }

    public void reset() {
        this.score = 0;
        setCenterX(xStart);
        setCenterY(yStart);
        hSpeed = 0;
        vSpeed = 0;
        setFill(Color.WHITE);
        textScore.setText("" + score);
        textScore.setFill(Color.WHITE);
        returnText.setFill(Color.TRANSPARENT);
        winText.setFill(Color.TRANSPARENT);
        if((animation!= null) && (animation.getStatus() == Animation.Status.RUNNING)) {
            animation.stop();
        }
        play();
    }


    public void play() {
        animation = new Timeline(new KeyFrame(Duration.millis(1000 / 60.0), e -> {
            if (!getBoundsInParent().intersects(lvl.getTop().getBoundsInParent()) || (getCenterX() < lvl.getHoleOval().getCenterX() + (lvl.getHoleOval().getRadiusX() / 2) && getCenterX() > lvl.getHoleOval().getCenterX() - (lvl.getHoleOval().getRadiusX() / 2))) {
                vSpeed += GRAVITY;
            }

            if (!getBoundsInParent().intersects(lvl.getTop().getBoundsInParent())) {
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


            if (getBoundsInParent().intersects(lvl.getTop().getBoundsInParent()) && (getCenterX() > lvl.getHoleOval().getCenterX() + (lvl.getHoleOval().getRadiusX() / 2) || getCenterX() < lvl.getHoleOval().getCenterX() - (lvl.getHoleOval().getRadiusX() / 2))) {
                do {
                    setCenterY(getCenterY() - .1);
                } while (getBoundsInParent().intersects(lvl.getTop().getBoundsInParent()));
                if (vSpeed > 0)
                vSpeed /= -3;
            }
            else if ((getCenterX() < lvl.getHoleOval().getCenterX() + (lvl.getHoleOval().getRadiusX() / 2) && getCenterX() > lvl.getHoleOval().getCenterX() - (lvl.getHoleOval().getRadiusX() / 2) && getBoundsInParent().intersects(lvl.getTop().getBoundsInParent()))) {
                toFront();
                if (vSpeed < 1)
                    vSpeed = .9;
                setCenterY(getCenterY() + vSpeed);
            }


            if (getCenterY() + vSpeed - getRadius() < 0) {
                vSpeed = 0;
            }

            if (getCenterY() - getRadius() > lvl.getGreen().getY() - getRadius() && (getCenterX() < lvl.getHoleOval().getCenterX() + (lvl.getHoleOval().getRadiusX() / 2)) && (getCenterX() > lvl.getHoleOval().getCenterX() - (lvl.getHoleOval().getRadiusX() / 2))) {
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
