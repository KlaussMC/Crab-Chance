import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    private boolean running = false;
    private Thread thread;
    private Window window;

    public static Point frameCoords;
    public static Point mouseCoords;

    public static int WIDTH, HEIGHT;
    public static int SCL;

    public Handler handler;

    public Game () {
        handler = new Handler();
        this.window = new Window(WIDTH, HEIGHT, "Crab Chance", this);
        // init

        handler.addPlayer(new Player());
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        mouseCoords = MouseInfo.getPointerInfo().getLocation();

        window.tick();
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(new Color(30, 30, 30));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public void mouseClicked(MouseEvent e) {
        handler.click();
    }

    public static int loop (int val, int min, int max) {
        if (val > max) {
            return val % max;
        } else if (val < min) {
            return max - Math.abs(val % max);
        } else {
            return val;
        }
    }

    public static void main(String args[]) {
        new Game();
    }
}
