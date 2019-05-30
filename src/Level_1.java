import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Level_1 extends Application {

    public void start(Stage ps){
        Pane p = new Pane();
        Ball player = new Ball(100, 100);
        p.getChildren().add(player);

        Rectangle rS = new Rectangle(100,100);

        rS.xProperty().setValue(100);
        rS.yProperty().setValue(100);
        rS.setStroke(Color.BLACK);
        rS.setFill(Color.WHITE);
        p.getChildren().add(rS);

        Scene scene = new Scene(p, 900,600);
        ps.setScene(scene);
        ps.show();
        ps.requestFocus();





    }


}
