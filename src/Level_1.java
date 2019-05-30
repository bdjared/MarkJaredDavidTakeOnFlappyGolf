import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Level_1 extends Application {

    public void start(Stage ps){
        Pane p = new Pane();
        Ball player = new Ball(100, 100);
        p.getChildren().add(player);

        Rectangle rS = new Rectangle();
        rS.xProperty().setValue(100);
        rS.yProperty().setValue(100);
        p.getChildren().add(rS);

        Scene scene = new Scene(p);
        ps.setScene(scene);
        ps.show();
        ps.requestFocus();





    }


}
