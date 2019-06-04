import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;


public class Level_1 extends Hole {
    private Ball player = new Ball(100, 370, this);
    private Rectangle sky = new Rectangle(900, 600);
    private Rectangle grass = new Rectangle(900, 500);
    private Rectangle leftBttn = new Rectangle(100, 100);
    private Rectangle rightBttn = new Rectangle(100, 100);
    private Rectangle hole = new Rectangle(15,10);
    private Ellipse top_hole = new Ellipse(10,7);
    private Rectangle top_grass = new Rectangle(145, 10);



    public Level_1() {
        sky.setFill(Color.LIGHTBLUE);

        grass.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));
        grass.setX(0);
        grass.setY(370);
        hole.setFill(Color.RED);
        top_hole.setFill(Color.BLACK);
        hole.setX(660);
        hole.setY(360);
        top_hole.centerYProperty().setValue(369);
        top_hole.centerXProperty().setValue(667);
        top_grass.setX(580);
        top_grass.setY(370);
        top_grass.setArcWidth(15);
        top_grass.setArcHeight(15);
        top_grass.setFill(new Color(0f, 141/255f, 23/255f, 1));

        createButtons();

        getChildren().addAll(sky, player, grass, leftBttn, rightBttn, top_hole, top_grass, hole);
    }

    public Ball getPlayer() {
        return player;
    }

    public Rectangle getHole() {
        return hole;
    }

    public Rectangle getGrass() {
        return grass;
    }

    public void createButtons(){
        leftBttn.setFill(new Color(0.5019608f, 0.5019608f, 0.5019608f, 0.4));
        leftBttn.setX(25);
        leftBttn.setY(425);
        leftBttn.setOnMouseClicked(e -> player.jumpLeft());
        leftBttn.setArcHeight(50);
        leftBttn.setArcWidth(50);

        rightBttn.setFill(new Color(0.5019608f, 0.5019608f, 0.5019608f, 0.4));
        rightBttn.setX(775);
        rightBttn.setY(425);
        rightBttn.setOnMouseClicked(e -> player.jumpRight());
        rightBttn.setArcHeight(50);
        rightBttn.setArcWidth(50);
    }

    public Rectangle getLeftBttn() {
        return leftBttn;
    }

    public Rectangle getRightBttn() {
        return rightBttn;
    }
}
