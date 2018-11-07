import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Window extends Canvas {
    private JFrame frame;
    private Game game;
    public Window (int w, int h, String title, Game game) {
        this.game = game;
        frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(w, h));
        frame.setMaximumSize(new Dimension(w, h));
        frame.setMinimumSize(new Dimension(w, h));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        game.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                game.mouseClicked(e);
            }
        });
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        Rectangle r = frame.getBounds();
        Game.WIDTH = r.width;
        Game.HEIGHT = r.height;
        game.start();
    }

    public void tick () {
        game.frameCoords = frame.getLocationOnScreen();
    }
}
