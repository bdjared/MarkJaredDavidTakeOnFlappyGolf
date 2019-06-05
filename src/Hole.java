import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public abstract class Hole extends Pane {
    private Rectangle grass;
    private Rectangle holeRect;
    private Rectangle green;
    private Ellipse holeOval;

    public abstract Ellipse getHoleOval();

    public abstract Rectangle getGreen();

    public abstract Rectangle getGrass();

    public abstract Rectangle getHoleRect();
}
