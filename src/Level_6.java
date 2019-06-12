import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Level_6 extends Hole {
    private Ball player = new Ball(100, 99, this);
    private Rectangle sky = new Rectangle(900, 600);
    private Polygon grass = new Polygon(0, 100, 300, 100, 300, 500, 850, 500, 850, 300,600,300,600,100, 900,100,900,900,0,900);
    private Rectangle leftBttn = new Rectangle(100, 100);
    private Rectangle rightBttn = new Rectangle(100, 100);
    private Ellipse holeOval = new Ellipse(7,3);
    private Rectangle green = new Rectangle(250, 8);
    private Line top = new Line(0, 100, 900, 100);
    private Line top1 = new Line(300,500,850,500);
    private Line top2 = new Line(600,300,850 ,300);
    private double topY = top.getStartY();

    public Level_6() {
        sky.setFill(Color.LIGHTBLUE);

        grass.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));


        holeOval.setFill(Color.BLACK);
        holeOval.centerYProperty().setValue(503);
        holeOval.centerXProperty().setValue(750);

        green.setX(565);
        green.setY(499.5);
        green.setArcWidth(15);
        green.setArcHeight(15);
        green.setStrokeWidth(1);
        green.setStroke(Color.TRANSPARENT);
        green.setFill(new Color(0f, 141/255f, 23/255f, 1));

        top.setStrokeWidth(.1);
        top.setFill(Color.TRANSPARENT);

        createButtons();

        getChildren().addAll(sky, grass, green, holeOval, player, leftBttn, rightBttn, player.getWinText(), player.getReturnText(), player.textScore());
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
        if ((player.getCenterX()<=300 || player.getCenterX()> 600) && player.getCenterY() <100)  {
            return top;
        }
        return top1;
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
