import javafx.scene.layout.Pane;

public class Level_1 extends Pane {

    public Level_1(){
        Ball player = new Ball();
        getChildren().add(player);
        player.centerXProperty().setValue();
    }


}
