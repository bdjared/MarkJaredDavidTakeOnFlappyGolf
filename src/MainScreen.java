import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainScreen extends Application {
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        borderPane.setTop(new CustomPane("Jared, David, and Mark Land"));
        borderPane.setCenter(pane);
        borderPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Hole[] holes = {new Level_1(), new Level_2(), new Level_3(), new Level_4(), new Level_5(), new Level_6(), new Level_7(), new Level_8(), new Level_9()};

        Scene scene = new Scene(borderPane, 900, 600);
        primaryStage.setTitle("Better Flappy Golf");

        for (int i = 0; i < 5; i++) {
            Circle levelBttn = new Circle(50);
            levelBttn.setCenterX(150 + i * 150);
            levelBttn.setCenterY(175);
            levelBttn.setFill(Color.WHITE);
            levelBttn.setStrokeWidth(4);
            levelBttn.setStroke(Color.LIGHTGREY);

            Text levelTxt = new Text("" + i);
            levelTxt.setX(levelBttn.getCenterX());
            levelTxt.setY(levelBttn.getCenterY());

            levelBttn.setOnMouseEntered(e -> levelBttn.setStrokeWidth(6));

            levelBttn.setOnMouseExited(e -> levelBttn.setStrokeWidth(4));

            Hole lvl = holes[i];
            Scene lvlScene = new Scene(lvl, 900, 600);

            levelBttn.setOnMousePressed(e -> {
                lvl.getPlayer().reset();

                lvlScene.setOnKeyPressed(a -> {
                    if (a.getCode() == KeyCode.LEFT)
                        lvl.getPlayer().jumpLeft();
                    else if (a.getCode() == KeyCode.RIGHT)
                        lvl.getPlayer().jumpRight();
                    if (a.getCode() == KeyCode.ESCAPE) {
                        lvl.getPlayer().getAnimation().pause();
                        primaryStage.setScene(scene);
                        primaryStage.show();
                        primaryStage.requestFocus();
                    }
                    if (a.getCode() == KeyCode.R){
                        lvl.getPlayer().reset();
                    }
                });

                primaryStage.setScene(lvlScene);
                primaryStage.show();
                primaryStage.requestFocus();
            });

            pane.getChildren().addAll(levelBttn, levelTxt);
        }

        for (int i = 5; i < 9; ++i) {
            Circle levelBttn = new Circle(50);
            levelBttn.setCenterX(225 + (i - 5) * 150);
            levelBttn.setCenterY(325);
            levelBttn.setFill(Color.WHITE);
            levelBttn.setStrokeWidth(4);
            levelBttn.setStroke(Color.LIGHTGREY);

            Text levelTxt = new Text("" + i);
            levelTxt.setX(levelBttn.getCenterX());
            levelTxt.setY(levelBttn.getCenterY());

            levelBttn.setOnMouseEntered(e -> levelBttn.setFill(Color.BLACK));

            levelBttn.setOnMouseExited(e -> levelBttn.setFill(Color.WHITE));

            Hole lvl = holes[i];
            Scene lvlScene = new Scene(lvl, 900, 600);

            levelBttn.setOnMousePressed(e -> {
                lvl.getPlayer().reset();

                lvlScene.setOnKeyPressed(a -> {
                    if (a.getCode() == KeyCode.LEFT)
                        lvl.getPlayer().jumpLeft();
                    else if (a.getCode() == KeyCode.RIGHT)
                        lvl.getPlayer().jumpRight();
                    if (a.getCode() == KeyCode.ESCAPE) {
                        lvl.getPlayer().getAnimation().pause();
                        primaryStage.setScene(scene);
                        primaryStage.show();
                        primaryStage.requestFocus();
                    }
                    if (a.getCode() == KeyCode.R){
                        lvl.getPlayer().reset();
                    }
                });

                primaryStage.setScene(lvlScene);
                primaryStage.show();
                primaryStage.requestFocus();
            });

            pane.getChildren().addAll(levelBttn, levelTxt);
        }

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}

class CustomPane extends StackPane {
    public CustomPane(String title) {
        getChildren().add(new Label(title));
        setStyle("-fx-border-color: blue");
        setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    }
}
