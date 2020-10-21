

import java.awt.Color;
import java.awt.Graphics2D;

public class Map {
    public static int x;
    public  static int y;

    public Map(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void draw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(150, 30, 500, 500);
    }
}
