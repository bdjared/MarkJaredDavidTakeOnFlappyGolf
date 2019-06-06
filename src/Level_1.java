import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Level_1 extends Hole {
    private Ball player = new Ball(100, 358, this);
    private Rectangle sky = new Rectangle(900, 600);
    private Rectangle grass = new Rectangle(900.2, 500.2);
    private Rectangle leftBttn = new Rectangle(100, 100);
    private Rectangle rightBttn = new Rectangle(100, 100);
    private Rectangle holeRect = new Rectangle(15,10);
    private Ellipse holeOval = new Ellipse(7,3);
    private Rectangle green = new Rectangle(175, 7);

    public Level_1() {
        sky.setFill(Color.LIGHTBLUE);

        grass.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));
        grass.setY(369.9);
        grass.setX(-.1);
        grass.setStrokeWidth(.2);
        grass.setStroke(Color.LIGHTBLUE);

        holeRect.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));
        holeRect.setX(660);
        holeRect.setY(370);

        holeOval.setFill(Color.BLACK);
        holeOval.centerYProperty().setValue(373);
        holeOval.centerXProperty().setValue(667);

        green.setX(560);
        green.setY(369.5);
        green.setArcWidth(15);
        green.setArcHeight(15);
        green.setFill(new Color(0f, 141/255f, 23/255f, 1));

        createButtons();

        getChildren().addAll(sky, grass, holeRect, green, holeOval, player, leftBttn, rightBttn, player.getWinText(), player.getReturnText(), player.textScore());
    }

    public void createButtons(){
        leftBttn.setFill(new Color(0.5019608f, 0.5019608f, 0.5019608f, 0.4));
        leftBttn.setX(25);
        leftBttn.setY(475);
        leftBttn.setOnMouseClicked(e -> player.jumpLeft());
        leftBttn.setArcHeight(50);
        leftBttn.setArcWidth(50);

        rightBttn.setFill(new Color(0.5019608f, 0.5019608f, 0.5019608f, 0.4));
        rightBttn.setX(775);
        rightBttn.setY(475);
        rightBttn.setOnMouseClicked(e -> player.jumpRight());
        rightBttn.setArcHeight(50);
        rightBttn.setArcWidth(50);
    }

    public Ball getPlayer() {
        return player;
    }

    public Rectangle getHoleRect() {
        return holeRect;
    }

    public Ellipse getHoleOval() {
        return holeOval;
    }

    public Rectangle getGrass() {
        return grass;
    }

    public Rectangle getGreen() {
        return green;
    }

    public double getGrassY() {
        return grass.getY() + .1;
    }
}
