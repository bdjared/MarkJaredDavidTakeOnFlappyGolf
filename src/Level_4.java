import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Level_4 extends Hole {
    private Ball player = new Ball(100, 358, this);
    private Rectangle sky = new Rectangle(900, 600);
    private Polygon grass = new Polygon(0, 370, 900, 370, 900, 600, 0, 600);
    private Polygon grass2 = new Polygon(520, 201,520,250, 800, 250, 800, 201 );
    private Rectangle leftBttn = new Rectangle(100, 100);
    private Rectangle rightBttn = new Rectangle(100, 100);
    private Rectangle holeRect = new Rectangle(15,10);
    private Ellipse holeOval = new Ellipse(7,3);
    private Rectangle green = new Rectangle(177, 8);
    private Line top = new Line(0, 369.9, 900, 369.9);
    private Line top1 = new Line(520,201,800,201);
    private Line top2 = new Line(520,250,800,250);
    private double topY = top.getStartY();

    public Level_4() {
        sky.setFill(Color.LIGHTBLUE);

        grass.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));
        grass2.setFill(new Color(86/255f, 86/255f, 86/255f, 1));

        holeRect.setFill(new Color(86/255f, 86/255f, 86/255f, 1));
        holeRect.setX(660);
        holeRect.setY(200);

        holeOval.setFill(Color.BLACK);
        holeOval.centerYProperty().setValue(200);
        holeOval.centerXProperty().setValue(667);

        green.setX(559);
        green.setY(200.5);
        green.setArcWidth(15);
        green.setArcHeight(15);
        green.setStrokeWidth(1);
        green.setStroke(Color.TRANSPARENT);
        green.setFill(new Color(0f, 141/255f, 23/255f, 1));

        top.setStrokeWidth(.1);
        top.setFill(Color.TRANSPARENT);

        createButtons();

        getChildren().addAll(sky, grass,grass2, holeRect, green, holeOval, player, leftBttn, rightBttn, player.getWinText(), player.getReturnText(), player.textScore());
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
        if ((player.getCenterX() > 0 && player.getCenterX() < 350) && (player.getBoundsInParent().intersects(grass.getBoundsInParent()))) {
            return top;
        }
        else if(player.getBoundsInParent().intersects(520,201,800,201)) {
            return top1;
        }
        else if((player.getCenterX()>520 && player.getCenterX()< 800) && (player.getCenterY()<250 && player.getCenterY() >201)){
            return top2;
        }
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
}
