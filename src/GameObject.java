import java.awt.*;

public abstract class GameObject {

    protected int suit;
    protected int value;
    protected ID id;

    protected boolean coversBomb;

    public GameObject(ID id) {
        this.suit = suit;
        this.value = value;
        this.id = id;

        coversBomb = false;
    }

    public abstract void tick ();
    public abstract void render (Graphics g);
    public abstract void click();
    public ID getId () {
        return id;
    }


}
