import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainScreen extends Application {
    public void start(Stage primaryStage) {
        Image clouds = new Image("cloud.png");
        ImageView imageView = new ImageView(clouds);

        Image clouds2 = new Image("cloud.png");
        ImageView imageView2 = new ImageView((clouds2));

        Image clouds3 = new Image("cloud.png");
        ImageView imageView3 = new ImageView((clouds3));


        imageView3.setX(-1000);
        imageView3.setY(150);
        TranslateTransition translateTransition3 = new TranslateTransition();
        translateTransition3.setDuration(Duration.millis(35000));
        translateTransition3.setNode(imageView3);
        translateTransition3.setByX(2300);
        translateTransition3.setCycleCount(100000);
        translateTransition3.setAutoReverse(false);
        translateTransition3.play();


        imageView2.setX(-400);
        imageView2.setY(250);
        TranslateTransition translateTransition2 = new TranslateTransition();
        translateTransition2.setDuration(Duration.millis(50000));
        translateTransition2.setNode(imageView2);
        translateTransition2.setByX(1300);
        translateTransition2.setCycleCount(100000);
        translateTransition2.setAutoReverse(false);
        translateTransition2.play();



        imageView.setX(-450);
        imageView.setY(1);
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(60000));
        translateTransition.setNode(imageView);
        translateTransition.setByX(1300);
        translateTransition.setCycleCount(100000);
        translateTransition.setAutoReverse(false);
        translateTransition.play();



        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        borderPane.setTop(new CustomPane("Jared, David, and Mark Land"));
        borderPane.setCenter(pane);
        borderPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Hole[] holes = {new Level_1(), new Level_2(), new Level_3(), new Level_4(), new Level_5(), new Level_6(), new Level_7(), new Level_8(), new Level_9()};
        pane.getChildren().add(imageView);
        pane.getChildren().add(imageView2);
        pane.getChildren().add(imageView3);
        Scene scene = new Scene(borderPane, 900, 600);
        primaryStage.setTitle("Better Flappy Golf");

        for (int i = 0; i < 5; i++) {
            Circle levelBttn = new Circle(50);
            levelBttn.setCenterX(150 + i * 150);
            levelBttn.setCenterY(175);
            levelBttn.setFill(Color.WHITE);
            levelBttn.setStrokeWidth(4);
            levelBttn.setStroke(Color.LIGHTGREY);

            Text levelTxt = new Text("" + (i+1));
            levelTxt.setX(levelBttn.getCenterX());
            levelTxt.setY(levelBttn.getCenterY());
            levelTxt.setFill(Color.BLACK);

            levelBttn.setOnMouseEntered(e -> {
                levelBttn.setFill(Color.BLACK);
                levelTxt.setFill(Color.WHITE);
                levelBttn.setStroke(Color.YELLOW);
            });

            levelBttn.setOnMouseExited(e -> {
                levelBttn.setFill(Color.WHITE);
                levelTxt.setFill(Color.BLACK);
                levelBttn.setStroke(Color.LIGHTGREY);

            });

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

            Circle greyCircle = new Circle(5);
            greyCircle.setCenterX(levelBttn.getCenterX() + 15);
            greyCircle.setCenterY(levelBttn.getCenterY() + 15);
            greyCircle.setFill(Color.LIGHTGREY);

            Text levelTxt = new Text("" + (i+1));
            levelTxt.setX(levelBttn.getCenterX());
            levelTxt.setY(levelBttn.getCenterY());
            levelTxt.setFill(Color.BLACK);

            levelBttn.setOnMouseEntered(e -> {
                levelBttn.setFill(Color.BLACK);
                levelTxt.setFill(Color.WHITE);
                levelBttn.setStroke(Color.YELLOW);
            });

            levelBttn.setOnMouseExited(e -> {
                levelBttn.setFill(Color.WHITE);
                levelTxt.setFill(Color.BLACK);
                levelBttn.setStroke(Color.LIGHTGREY);


            });

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

            pane.getChildren().addAll(levelBttn, levelTxt, greyCircle);
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
