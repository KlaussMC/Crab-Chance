import java.awt.*;
import java.util.LinkedList;

public class Handler {
    public LinkedList <GameObject> object = new LinkedList();
    public LinkedList <Player> players = new LinkedList();

    public void tick () {
        for (int i = 0; i < object.size(); i++) {
            GameObject tmp =  object.get(i);
            tmp.tick();

        }
        for (Player p : players) {
            p.tick();
        }

        Game.day.tick();
    }

    public void render (Graphics g) {
        for (GameObject obj : object) {
            obj.render(g);
        }

        for (Player p : players) {
            p.render(g);
        }


        Game.day.render(g);
    }

    public void click () {

    }

    public boolean exists(ID id) {
        for (GameObject obj : object) {
            if (obj.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
    public void removePLayer(Player player) {
        this.players.remove(player);
    }
}