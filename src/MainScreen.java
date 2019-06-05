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
        borderPane.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
//        gridPane.gridLinesVisibleProperty().setValue(Boolean.TRUE);

//        Rectangle filler0 = new Rectangle(45, 45);
//        filler0.setFill(Color.PALEGOLDENROD);
//        filler0.setStroke(Color.PALEGOLDENROD);
//        gridPane.add(filler0, 0, 2);

//        Rectangle filler5 = new Rectangle(45, 45);
//        filler5.setFill(Color.PALEGOLDENROD);
//        filler5.setStroke(Color.PALEGOLDENROD);
//        gridPane.add(filler5, 0, 3);

//        Rectangle filler6 = new Rectangle(45, 45);
//        filler6.setFill(Color.PALEGOLDENROD);
//        filler6.setStroke(Color.PALEGOLDENROD);
//        gridPane.add(filler6, 0, 4);

        Circle level1 = new Circle(25);
        level1.setCenterX(50);
        level1.setCenterY(100);

        Circle level2 = new Circle(25);
        level2.setCenterX(250);
        level2.setCenterY(100);

        Circle level3 = new Circle(25);
        level3.setCenterX(450);
        level3.setCenterY(100);

        Circle level4 = new Circle(25);
        level4.setCenterX(650);
        level4.setCenterY(100);

        Circle level5 = new Circle(25);
        level5.setCenterX(850);
        level5.setCenterY(100);

        Circle level6 = new Circle(25);
        level6.setCenterX(100);
        level6.setCenterY(300);

        Circle level7 = new Circle(25);
        level7.setCenterX(350);
        level7.setCenterY(300);

        Circle level8 = new Circle(25);
        level8.setCenterX(575);
        level8.setCenterY(300);

        Circle level9 = new Circle(25);
        level9.setCenterX(800);
        level9.setCenterY(300);
//        level1.setShape(new Circle(350));
//        level1.setMaxSize(350, 350);
//        gridPane.add(level1, 1, 5);
//
//        Button level2 = new Button("Level 2");
//        level2.setShape(new Circle(15));
//        level2.setMaxSize(350,350);
//        gridPane.add(level2, 3, 5);

//        Rectangle filler2 = new Rectangle(45, 45);
//        filler2.setFill(Color.PALEGOLDENROD);
//        filler2.setStroke(Color.PALEGOLDENROD);
//        gridPane.add(filler2, 2, 1);


//        Rectangle filler1 = new Rectangle(1, 50);
//        filler1.setFill(Color.PALEGOLDENROD);
//        filler1.setStroke(Color.PALEGOLDENROD);
//        gridPane.add(filler1, 0,0);
//
//        Button level3 = new Button("Level 3");
//        level3.setShape(new Circle(350));
//        level3.setMaxSize(350, 350);
//        gridPane.add(level3, 4, 5);

//        Rectangle filler3 = new Rectangle(45, 45);
//        filler3.setFill(Color.PALEGOLDENROD);
//        filler3.setStroke(Color.PALEGOLDENROD);
//        gridPane.add(filler3, 5,1);

//
//        Button level4 = new Button("Level 4");
//        level4.setShape(new Circle(350));
//        level4.setMaxSize(350, 350);
//        gridPane.add(level4, 6, 5);

//        Rectangle filler4 = new Rectangle(45, 45);
//        filler4.setFill(Color.PALEGOLDENROD);
//        filler4.setStroke(Color.PALEGOLDENROD);
//        gridPane.add(filler4, 7,1);


//        Button level5 = new Button("Level 5");
//        level5.setShape(new Circle(350));
//        level5.setMaxSize(350, 350);
//        level5.
//        gridPane.add(level5, 8, 5);

        pane.getChildren().addAll(level1, level2, level3, level4, level5, level6, level7, level8, level9);


        Scene scene = new Scene(borderPane, 900, 600);
        primaryStage.setTitle("Better Flappy Golf");

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
            });
            primaryStage.setScene(lvlScene);
            primaryStage.show();
            primaryStage.requestFocus();
        });

        level2.setOnMousePressed(e -> {
            Level_2 lvl2 = new Level_2();
            Scene lvlScene = new Scene(lvl2, 900, 600);
            lvlScene.setOnKeyPressed(a -> {
                if (a.getCode() == KeyCode.LEFT)
                    lvl2.getPlayer().jumpLeft();
                else if (a.getCode() == KeyCode.RIGHT)
                    lvl2.getPlayer().jumpRight();
                if (a.getCode() == KeyCode.ESCAPE) {
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    primaryStage.requestFocus();
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
