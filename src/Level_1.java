import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;


public class Level_1 extends Pane {
    private Ball player = new Ball(100, 370);
    private Rectangle sky = new Rectangle(900, 600);
    private Rectangle grass = new Rectangle(900, 500);
    private Rectangle leftBttn = new Rectangle(100, 100);
    private Rectangle rightBttn = new Rectangle(100, 100);
    private Rectangle hole = new Rectangle(15,10);
    private Ellipse top_hole = new Ellipse(10,7);
    private Rectangle top_grass = new Rectangle(600, 10);



    public Level_1() {
        sky.setFill(Color.LIGHTBLUE);

        grass.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));
        grass.setX(0);
        grass.setY(370);
        hole.setFill(Color.RED);
        top_hole.setFill(Color.BLACK);
        hole.setX(500);
        hole.setY(365);
        top_hole.centerYProperty().setValue(364);
        top_hole.centerXProperty().setValue(507);
        top_grass.setX(0);
        top_grass.setY(365);
        top_grass.setFill(new Color(0f, 141/255f, 23/255f, 1));

        createButtons();

        getChildren().addAll(sky, grass, player, leftBttn, rightBttn, top_hole, top_grass, hole);
    }

    public Ball getPlayer() {
        return player;
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
