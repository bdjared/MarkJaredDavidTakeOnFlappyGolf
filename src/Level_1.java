import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Level_1 extends Hole {
    private Ball player = new Ball(100, 358, this);
    private Rectangle sky = new Rectangle(900, 600);
    private Polygon grass = new Polygon(0, 370, 900, 370, 900, 600, 0, 600);
    private Rectangle leftBttn = new Rectangle(100, 100);
    private Rectangle rightBttn = new Rectangle(100, 100);
    private Rectangle holeRect = new Rectangle(15,10);
    private Ellipse holeOval = new Ellipse(7,3);
    private Rectangle green = new Rectangle(177, 8);
    private Line top = new Line(0, 369.9, 900, 369.9);
    private double topY = top.getStartY();

    public Level_1() {
        sky.setFill(Color.LIGHTBLUE);

        grass.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));

        holeRect.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));
        holeRect.setX(660);
        holeRect.setY(370);

        holeOval.setFill(Color.BLACK);
        holeOval.centerYProperty().setValue(373);
        holeOval.centerXProperty().setValue(667);

        green.setX(559);
        green.setY(369.5);
        green.setArcWidth(15);
        green.setArcHeight(15);
        green.setStrokeWidth(1);
        green.setStroke(Color.TRANSPARENT);
        green.setFill(new Color(0f, 141/255f, 23/255f, 1));

        top.setStrokeWidth(.1);
        top.setStroke(Color.TRANSPARENT);

        createButtons();

        getChildren().addAll(sky, grass, holeRect, green, holeOval, player, leftBttn, rightBttn, player.getWinText(), player.getReturnText(), player.textScore(), top);
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

    public Line getTop() {
        return top;
    }

    public double getTopY() {
        return topY;
    }

    public Ellipse getHoleOval() {
        return holeOval;
    }

    public Polygon getGrass() {
        return grass;
    }

    public Rectangle getGreen() {
        return green;
    }

    public Rectangle getSky() {
        return sky;
    }
}
