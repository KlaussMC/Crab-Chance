import java.awt.*;
import java.lang.Math;

import static java.lang.System.currentTimeMillis;

public class Day extends GameObject {

    public boolean goodDay;
    public int total;

    public int remainingTime;
    private int startTime;

    public Bucket buckets[];

    public Day () {
        super (ID.Day);

        this.goodDay = Math.random() > 0.5;
        this.total = 0;

        this.buckets = new Bucket[5];

            this.buckets[0] = new Bucket(ID.Bucket);
            this.buckets[1] = new Bucket(ID.Bucket);
            this.buckets[2] = new Bucket(ID.Bucket);
            this.buckets[3] = new Bucket(ID.Bucket);
            this.buckets[4] = new Bucket(ID.Bucket);

            this.remainingTime = 300;

            this.startTime = (int)(currentTimeMillis() / 1000);

    }

    void catchCrab (int value) {
        this.total += value;
    }

    public void render (Graphics g) {
        g.setColor(new Color(117, 255, 240));
        g.setFont(new Font("Consolas", Font.BOLD, 55));
        g.drawString(((int)Math.floor(this.remainingTime / 60)) + ":" + (String.format("%02d", this.remainingTime % 60)), 10, 55);
//        g.drawString(Integer.toString(this.remainingTime), 10, 55);
    }

    public void tick () {
        remainingTime = 300 + (startTime - (int)(currentTimeMillis() / 1000));
    }

    public void click () {

    }
}
