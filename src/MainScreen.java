import javafx.animation.Timeline;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainScreen extends Application {
    public void start(Stage primaryStage) {
        Image golfBall = new Image("cbt.png.png");

        Image clouds = new Image("cloud.png");
        ImageView imageView = new ImageView(clouds);
        imageView.setX(-450);
        imageView.setY(1);

        Image clouds2 = new Image("cloud.png");
        ImageView imageView2 = new ImageView((clouds2));
        imageView2.setX(-400);
        imageView2.setY(250);

        Image clouds3 = new Image("cloud.png");
        ImageView imageView3 = new ImageView((clouds3));
        imageView3.setX(-1000);
        imageView3.setY(150);

        TranslateTransition translateTransition3 = new TranslateTransition();
        translateTransition3.setDuration(Duration.millis(35000));
        translateTransition3.setNode(imageView3);
        translateTransition3.setByX(2300);
        translateTransition3.setCycleCount(Timeline.INDEFINITE);
        translateTransition3.setAutoReverse(false);
        translateTransition3.play();

        TranslateTransition translateTransition2 = new TranslateTransition();
        translateTransition2.setDuration(Duration.millis(50000));
        translateTransition2.setNode(imageView2);
        translateTransition2.setByX(1300);
        translateTransition2.setCycleCount(Timeline.INDEFINITE);
        translateTransition2.setAutoReverse(false);
        translateTransition2.play();

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(60000));
        translateTransition.setNode(imageView);
        translateTransition.setByX(1400);
        translateTransition.setCycleCount(Timeline.INDEFINITE);
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
        primaryStage.setTitle("Mark, Jared, David take on Flappy Golf");

        for (int i = 0; i < 5; i++) {
            ImageView levelBttn = new ImageView(golfBall);
            levelBttn.setFitHeight(100);
            levelBttn.setFitWidth(136);
            levelBttn.setX(150 + i * 150 - 50);
            levelBttn.setY(150);

            Text levelTxt = new Text("" + (i + 1));
            levelTxt.setFont(Font.font("comic sans ms", FontWeight.BOLD, 30));
            levelTxt.setX(levelBttn.getX() + 65);
            levelTxt.setY(levelBttn.getY() + 60);
            levelTxt.setFill(Color.BLACK);

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
                    if (a.getCode() == KeyCode.R) {
                        lvl.getPlayer().reset();
                    }
                });

                primaryStage.setScene(lvlScene);
                primaryStage.show();
                primaryStage.requestFocus();
            });
            levelTxt.setOnMousePressed(e -> {
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
                    if (a.getCode() == KeyCode.R) {
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
            ImageView levelBttn = new ImageView(golfBall);
            levelBttn.setFitHeight(100);
            levelBttn.setFitWidth(136);
            levelBttn.setX(225 + (i-5) * 150 - 50);
            levelBttn.setY(300);


            Text levelTxt = new Text("" + (i+1));
            levelTxt.setFont(Font.font("comic sans ms", FontWeight.BOLD, 30));
            levelTxt.setX(levelBttn.getX() + 65);
            levelTxt.setY(levelBttn.getY() + 60);
            levelTxt.setFill(Color.BLACK);

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
            levelTxt.setOnMousePressed(e -> {
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
                    if (a.getCode() == KeyCode.R) {
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
        Label top = new Label(title);
        top.setFont(Font.font("comic sans ms"));
        getChildren().add(top);
        setStyle("-fx-border-color: blue");
        setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    }
}
