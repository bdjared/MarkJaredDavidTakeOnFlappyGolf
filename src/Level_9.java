import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Level_9 extends Hole {
    private Ball player = new Ball(100, 358, this);
    private Rectangle sky = new Rectangle(900, 600);
    private Polygon grass = new Polygon(0, 370, 200, 370, 200, 900, 600, 900, 600, 594, 614, 594, 614, 900, 900, 900, 900, 1100, 0, 1100);
    private Rectangle leftBttn = new Rectangle(100, 100);
    private Rectangle rightBttn = new Rectangle(100, 100);
    private Ellipse holeOval = new Ellipse(7,3);
    private Rectangle green = new Rectangle(15, 7);
    private Line top1 = new Line(0, 369.9, 200, 369.9);
    private Line top2 = new Line(200, 900, 600, 900);
    private Line top3 = new Line(600, 594, 614, 594);
    private Line top4 = new Line(614, 900, 900, 900);

    public Level_9() {
        sky.setFill(Color.LIGHTBLUE);

        grass.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));

        holeOval.setFill(Color.BLACK);
        holeOval.centerYProperty().setValue(597);
        holeOval.centerXProperty().setValue(607);

        top1.setStrokeWidth(.1);
        top1.setStroke(Color.TRANSPARENT);

        top2.setStrokeWidth(.1);
        top2.setStroke(Color.TRANSPARENT);

        top3.setStrokeWidth(.1);
        top3.setStroke(Color.TRANSPARENT);

        green.setX(599.5);
        green.setY(593.5);
        green.setArcWidth(15);
        green.setArcHeight(15);
        green.setStrokeWidth(1);
        green.setStroke(Color.TRANSPARENT);
        green.setFill(new Color(0f, 141/255f, 23/255f, 1));

        createButtons();

        getChildren().addAll(sky, grass, green, holeOval, player, leftBttn, rightBttn, player.getWinText(), player.getReturnText(), player.textScore(), top1, top2, top3);
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
        if (player.getCenterX() < 200)
            return top1;
        if (player.getCenterX() < 600)
            return top2;
        if (player.getCenterX() < 614)
            return top3;
        return top4;
    }

    public double getTopY() {
        if (player.getCenterX() < 207)
        return top1.getStartY();
        return top3.getStartY();
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
