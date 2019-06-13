import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Level_6 extends Hole {
    private Ball player = new Ball(100, 358, this);
    private Rectangle sky = new Rectangle(900, 600);
    private Polygon grass = new Polygon(0, 370,200,370, 200, 280,400,280,400,200,600,200,600,100,900,100,900, 600, 0, 600);
    private Rectangle leftBttn = new Rectangle(100, 100);
    private Rectangle rightBttn = new Rectangle(100, 100);
    private Rectangle pillar = new Rectangle(4,180);
    private Rectangle pillar1 = new Rectangle(4,100);
    private Ellipse holeOval = new Ellipse(7,3);
    private Rectangle green = new Rectangle(200, 8);
    private Line top = new Line(0, 369.9, 200, 369.9);
    private Line top1 = new Line(200,280,400,280);
    private Line top2 = new Line(400,200,600,200);
    private Line top3 = new Line(600,100,900,100);
    private double topY;


    public Level_6() {
        sky.setFill(Color.LIGHTBLUE);
        pillar.setX(200);
        pillar.setY(100);
        pillar1.setX(400);
        pillar1.setY(100);
        pillar.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));
        pillar1.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));

        grass.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));

        holeOval.setFill(Color.BLACK);
        holeOval.centerYProperty().setValue(103);
        holeOval.centerXProperty().setValue(820);

        green.setX(680);
        green.setY(99.5);
        green.setArcWidth(15);
        green.setArcHeight(15);
        green.setStrokeWidth(1);
        green.setStroke(Color.TRANSPARENT);
        green.setFill(new Color(0f, 141/255f, 23/255f, 1));

        top.setStrokeWidth(.1);
        top.setFill(Color.TRANSPARENT);

        createButtons();

        getChildren().addAll(sky, grass, green, holeOval, player, leftBttn, rightBttn, player.getWinText(), player.getReturnText(), player.textScore(),pillar,pillar1);
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
        if(player.getCenterX()>200 && player.getCenterX()<400){
            return top1;
        }
        else if(player.getCenterX()>400 && player.getCenterX()<600){
            return top2;
        }
        else if(player.getCenterX()>600){
            return top3;
        }
        return top;
    }

    public double getTopY() {
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
