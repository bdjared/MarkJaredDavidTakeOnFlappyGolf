import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public abstract class Hole extends Pane {

    public abstract Ellipse getHoleOval();

    public abstract Rectangle getGreen();

    public abstract Polygon getGrass();

    public abstract Line getTop();

    public abstract Ball getPlayer();

    public abstract double getTopY();

    public abstract Rectangle getSky();
}
