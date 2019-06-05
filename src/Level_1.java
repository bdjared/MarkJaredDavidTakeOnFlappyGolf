import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;


public class Level_1 extends Hole {
    private Ball player = new Ball(100, 370, this);
    private Rectangle sky = new Rectangle(900, 600);
    private Rectangle grass = new Rectangle(900, 500);
    private Rectangle leftBttn = new Rectangle(100, 100);
    private Rectangle rightBttn = new Rectangle(100, 100);
    private Rectangle hole_rect = new Rectangle(15,10);
    private Ellipse hole_oval = new Ellipse(7,3);
    private Rectangle green = new Rectangle(175, 7);



    public Level_1() {
        sky.setFill(Color.LIGHTBLUE);

        grass.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));
        grass.setX(0);
        grass.setY(370);
        hole_rect.setFill(new Color(0.23529411764f, 0.8525490196f, 0.01176470588f, 1));
        hole_oval.setFill(Color.BLACK);
        hole_rect.setX(660);
        hole_rect.setY(370);
        hole_oval.centerYProperty().setValue(373);
        hole_oval.centerXProperty().setValue(667);
        green.setX(560);
        green.setY(370);
        green.setArcWidth(15);
        green.setArcHeight(15);
        green.setFill(new Color(0f, 141/255f, 23/255f, 1));

        createButtons();

        getChildren().addAll(sky, player, grass, hole_rect, green, hole_oval, leftBttn, rightBttn, player.getWinText(), player.textScore());
    }

    public Ball getPlayer() {
        return player;
    }

    public Rectangle getHole() {
        return hole_rect;
    }

    public Rectangle getGrass() {
        return grass;
    }

    public Rectangle getGreen() {
        return green;
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
