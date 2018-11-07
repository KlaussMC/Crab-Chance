import java.awt.*;
import java.lang.Math;

public class Bucket extends GameObject {
    boolean broken;
    boolean catchesCrab;
    int value;

    public Bucket (ID id) {
        super (id);
        this.catchesCrab = Math.random() > 0.5;
    }

    public void render (Graphics g) {

    }

    public void tick () {

    }

    public void click () {

    }
}
