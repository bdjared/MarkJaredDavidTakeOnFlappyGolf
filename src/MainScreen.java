import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainScreen extends Application {
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        borderPane.setTop(new CustomPane("Jared, David, and Mark Land"));
        borderPane.setCenter(pane);
        borderPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Circle level1 = new Circle(35);
        level1.setCenterX(50);
        level1.setCenterY(100);
        level1.setStroke(Color.WHITE);

        Circle level2 = new Circle(35);
        level2.setCenterX(250);
        level2.setCenterY(100);
        level2.setStroke(Color.WHITE);

        Circle level3 = new Circle(35);
        level3.setCenterX(450);
        level3.setCenterY(100);
        level3.setStroke(Color.WHITE);

        Circle level4 = new Circle(35);
        level4.setCenterX(650);
        level4.setCenterY(100);
        level4.setStroke(Color.WHITE);

        Circle level5 = new Circle(35);
        level5.setCenterX(850);
        level5.setCenterY(100);
        level5.setStroke(Color.WHITE);

        Circle level6 = new Circle(35);
        level6.setCenterX(100);
        level6.setCenterY(300);
        level6.setStroke(Color.WHITE);

        Circle level7 = new Circle(35);
        level7.setCenterX(350);
        level7.setCenterY(300);
        level7.setStroke(Color.WHITE);

        Circle level8 = new Circle(35);
        level8.setCenterX(575);
        level8.setCenterY(300);
        level8.setStroke(Color.WHITE);

        Circle level9 = new Circle(35);
        level9.setCenterX(800);
        level9.setCenterY(300);
        level9.setStroke(Color.WHITE);

        pane.getChildren().addAll(level1, level2, level3, level4, level5, level6, level7, level8, level9);

        Scene scene = new Scene(borderPane, 900, 600);
        primaryStage.setTitle("Better Flappy Golf");

        level1.setOnMouseEntered(e -> {
            level1.setStrokeWidth(5);
        });

        level1.setOnMouseExited(e -> {
            level1.setStrokeWidth(1);
        });

        level2.setOnMouseEntered(e -> {
            level2.setStrokeWidth(5);
        });

        level2.setOnMouseExited(e -> {
            level2.setStrokeWidth(1);
        });

        level3.setOnMouseEntered(e -> {
            level3.setStrokeWidth(5);
        });

        level3.setOnMouseExited(e -> {
            level3.setStrokeWidth(1);
        });

        level4.setOnMouseEntered(e -> {
            level4.setStrokeWidth(5);
        });

        level4.setOnMouseExited(e -> {
            level4.setStrokeWidth(1);
        });

        level5.setOnMouseEntered(e -> {
            level5.setStrokeWidth(5);
        });

        level5.setOnMouseExited( e -> {
            level5.setStrokeWidth(1);
        });

        level6.setOnMouseEntered(e -> {
            level6.setStrokeWidth(5);
        });

        level6.setOnMouseExited( e -> {
            level6.setStrokeWidth(1);
        });

        level7.setOnMouseEntered(e -> {
            level7.setStrokeWidth(5);
        });

        level7.setOnMouseExited( e -> {
            level7.setStrokeWidth(1);
        });

        level8.setOnMouseEntered(e -> {
            level8.setStrokeWidth(5);
        });

        level8.setOnMouseExited( e -> {
            level8.setStrokeWidth(1);
        });

        level9.setOnMouseEntered(e -> {
            level9.setStrokeWidth(5);
        });

        level9.setOnMouseExited( e -> {
            level9.setStrokeWidth(1);
        });


        level1.setOnMousePressed(e -> {
            Level_1 lvl1 = new Level_1();
            Scene lvlScene = new Scene(lvl1, 900, 600);
            lvlScene.setOnKeyPressed(a -> {
                if (a.getCode() == KeyCode.LEFT)
                    lvl1.getPlayer().jumpLeft();
                else if (a.getCode() == KeyCode.RIGHT)
                    lvl1.getPlayer().jumpRight();
                if (a.getCode() == KeyCode.ESCAPE) {
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    primaryStage.requestFocus();
                }
                if (a.getCode() == KeyCode.R){
                    lvl1.getPlayer().reset();
                }
            });
            primaryStage.setScene(lvlScene);
            primaryStage.show();
            primaryStage.requestFocus();
        });

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
