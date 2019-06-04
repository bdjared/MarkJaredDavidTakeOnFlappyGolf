import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public abstract class Hole extends Pane {
    private Rectangle grass = new Rectangle();
    private Rectangle hole = new Rectangle();

    public abstract Rectangle getGrass();

    public abstract Rectangle getHole();
}
