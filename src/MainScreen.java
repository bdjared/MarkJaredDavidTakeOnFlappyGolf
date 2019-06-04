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
        GridPane gridPane = new GridPane();
        borderPane.setTop(new CustomPane("Jared, David, and Mark Land"));
        borderPane.setCenter(gridPane);
        borderPane.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
        gridPane.gridLinesVisibleProperty().setValue(Boolean.TRUE);

        Rectangle filler0 = new Rectangle(45, 45);
        filler0.setFill(Color.PALEGOLDENROD);
        filler0.setStroke(Color.PALEGOLDENROD);
        gridPane.add(filler0, 0, 2);

        Button level1 = new Button("Level 1");
        level1.setShape(new Circle(350));
        level1.setMaxSize(350, 350);
        gridPane.add(level1, 1, 1);

        Button level2 = new Button("Level 2");
        level2.setShape(new Circle(15));
        level2.setMaxSize(350,350);
        gridPane.add(level2, 3, 1);

        Rectangle filler2 = new Rectangle(45, 45);
        filler2.setFill(Color.PALEGOLDENROD);
        filler2.setStroke(Color.PALEGOLDENROD);
        gridPane.add(filler2, 2, 1);


        Rectangle filler1 = new Rectangle(1, 50);
        filler1.setFill(Color.PALEGOLDENROD);
        filler1.setStroke(Color.PALEGOLDENROD);
        gridPane.add(filler1, 0,0);

        Button level3 = new Button("Level 3");
        level3.setShape(new Circle(350));
        level3.setMaxSize(350, 350);
        gridPane.add(level3, 4, 1);

        Rectangle filler3 = new Rectangle(45, 45);
        filler3.setFill(Color.PALEGOLDENROD);
        filler3.setStroke(Color.PALEGOLDENROD);
        gridPane.add(filler3, 5,1);


        Button level4 = new Button("Level 4");
        level4.setShape(new Circle(350));
        level4.setMaxSize(350, 350);
        gridPane.add(level4, 6, 1);

        Rectangle filler4 = new Rectangle(45, 45);
        filler4.setFill(Color.PALEGOLDENROD);
        filler4.setStroke(Color.PALEGOLDENROD);
        gridPane.add(filler4, 7,1);


        Button level5 = new Button("Level 5");
        level5.setShape(new Circle(350));
        level5.setMaxSize(350, 350);
        gridPane.add(level5, 8, 1);

        Scene scene = new Scene(borderPane, 800, 500);
        primaryStage.setTitle("Better Flappy Golf");

        level1.setOnMousePressed(e -> {
            Level_1 lvl1 = new Level_1();
            Scene lvlscene = new Scene(lvl1, 900, 600);
            lvlscene.setOnKeyPressed(a -> {
                if (a.getCode() == KeyCode.LEFT)
                    lvl1.getPlayer().jumpLeft();
                else if (a.getCode() == KeyCode.RIGHT)
                    lvl1.getPlayer().jumpRight();
                if (a.getCode() == KeyCode.ESCAPE) {
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    primaryStage.requestFocus();
                }
            });
            primaryStage.setScene(lvlscene);
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
