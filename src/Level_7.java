import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Level_7 extends Hole {
    private Ball player = new Ball(175, 163, this);
    private Rectangle sky = new Rectangle(900, 600);
    private Polygon grass = new Polygon(0, 370, 900, 370, 900, 600, 0, 600);
    private Rectangle leftBttn = new Rectangle(100, 100);
    private Rectangle rightBttn = new Rectangle(100, 100);
    private Ellipse holeOval = new Ellipse(7,3);
    private Rectangle green = new Rectangle(177, 8);
    private Line top1 = new Line(150,175,350,175);
    private Line top2 = new Line(150,215,350,215);
    private Line top3 = new Line(550,175,750,175);
    private Line top4 = new Line(550,215,750,215);
    private double topY;
    private Rectangle startPlatform = new Rectangle(200, 40);
    private Rectangle endPlatform = new Rectangle(200, 40);

    public Level_7() {
        sky.setFill(Color.LIGHTBLUE);

        grass.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));

        startPlatform.setX(150);
        startPlatform.setY(175);
        startPlatform.setFill(grass.getFill());

        endPlatform.setX(550);
        endPlatform.setY(175);
        endPlatform.setFill(grass.getFill());

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

        top1.setStrokeWidth(.1);
        top1.setFill(Color.TRANSPARENT);

        top2.setStrokeWidth(.1);
        top2.setFill(Color.TRANSPARENT);

        top3.setStrokeWidth(.1);
        top3.setFill(Color.TRANSPARENT);

        top4.setStrokeWidth(.1);
        top4.setFill(Color.TRANSPARENT);

        createButtons();

        getChildren().addAll(sky, startPlatform, endPlatform, holeOval, player, leftBttn, rightBttn, player.getWinText(), player.getReturnText(), player.textScore());
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
        if (player.getBoundsInParent().intersects(top1.getBoundsInParent()))
            return top1;
        if (player.getBoundsInParent().intersects(top2.getBoundsInParent()))
            return top2;
        if (player.getBoundsInParent().intersects(top2.getBoundsInParent()))
            return top3;
        return top4;
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
}
