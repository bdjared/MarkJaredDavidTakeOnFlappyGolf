import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public abstract class Hole extends Pane {
    private Rectangle grass;
    private Rectangle hole;
    private Rectangle green;

    public abstract Rectangle getGreen();

    public abstract Rectangle getGrass();

    public abstract Rectangle getHole();
}
