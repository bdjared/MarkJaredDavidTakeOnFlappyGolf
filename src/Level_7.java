import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Level_7 extends Hole {
    private Ball player = new Ball(200, 163, this);
    private Rectangle sky = new Rectangle(900, 603);
    private Polygon grass = new Polygon(0, 370, 900, 370, 900, 600, 0, 600);
    private Rectangle platform1 = new Rectangle(200, 40);
    private Rectangle platform2 = new Rectangle(200, 40);
    private Rectangle leftBttn = new Rectangle(100, 100);
    private Rectangle rightBttn = new Rectangle(100, 100);

    private Ellipse holeOval = new Ellipse(7,3);
    private Rectangle green = new Rectangle(130, 8);
    private Line top1 = new Line(0, 969.9, 900, 969.9);
    private Line top2 = new Line(575,175,775,175);
    private Line top3 = new Line(575,215,775,215);
    private Line top4 = new Line(125,175,325,175);
    private Line top5 = new Line(125,215,325,215);
    private double topY = top1.getStartY();

    public Level_7() {
        sky.setFill(Color.LIGHTBLUE);

        grass.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));

        platform1.setFill(grass.getFill());
        platform1.setX(575);
        platform1.setY(175);

        platform2.setFill(grass.getFill());
        platform2.setX(125);
        platform2.setY(175);

        holeOval.setFill(Color.BLACK);
        holeOval.centerYProperty().setValue(179);
        holeOval.centerXProperty().setValue(687);

        green.setX(605);
        green.setY(174.5);
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

        top5.setStrokeWidth(.1);
        top5.setFill(Color.TRANSPARENT);

        createButtons();

        getChildren().addAll(sky, platform1, platform2, green, holeOval, player, leftBttn, rightBttn, player.getWinText(), player.getReturnText(), player.textScore());
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
        if (player.getCenterY() > 215)
            return top1;
        if (player.getCenterY() < 175 && player.getCenterX() > top2.getStartX() && player.getCenterX() < top2.getEndX())
            return top2;
        if (player.getCenterY() < 215 && player.getCenterX() > top3.getStartX() && player.getCenterX() < top3.getEndX())
            return top3;
        if (player.getCenterY() < 175 && player.getCenterX() > top4.getStartX() && player.getCenterX() < top4.getEndX())
            return top4;
        return top5;
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
