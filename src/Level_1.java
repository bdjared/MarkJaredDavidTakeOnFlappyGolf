import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Level_1 extends Pane {
    private Ball player = new Ball(100, 318);
    private Rectangle sky = new Rectangle(800, 500);
    private Rectangle grass = new Rectangle(800, 175);
    private Rectangle leftBttn = new Rectangle(100, 100);
    private Rectangle rightBttn = new Rectangle(100, 100);

    public Level_1() {
        sky.setFill(Color.LIGHTBLUE);

        grass.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));
        grass.setX(0);
        grass.setY(325);

        leftBttn.setFill(new Color(0.5019608f, 0.5019608f, 0.5019608f, 0.4));
        leftBttn.setX(25);
        leftBttn.setY(375);
        leftBttn.setOnMouseClicked(e -> player.jumpLeft());

        rightBttn.setFill(new Color(0.5019608f, 0.5019608f, 0.5019608f, 0.4));
        rightBttn.setX(675);
        rightBttn.setY(375);
        rightBttn.setOnMouseClicked(e -> player.jumpRight());

        getChildren().addAll(sky, player, grass, leftBttn, rightBttn);
    }

    public Ball getPlayer() {
        return player;
    }

    public Rectangle getLeftBttn() {
        return leftBttn;
    }

    public Rectangle getRightBttn() {
        return rightBttn;
    }
}
