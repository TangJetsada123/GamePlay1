

import java.awt.*;

public class Key {
    private int x;
    private int y;
    private int S;
    public boolean drawKey = true;
    public Key(int x, int y) {
        this.x = 550;
        this.y = 108;
    }
    public void addScore(){
        S = 1;
    }

    public void draw(Graphics2D g2d) {
        if(drawKey) {
            g2d.setColor(Color.GRAY);
            g2d.fillRect(x, y, 20, 20);
        }
        g2d.setColor(Color.RED);
        g2d.drawString("GetKey"+S,700,30);

    }



    public Rectangle bounds()
    {
        return  (new Rectangle(x,y,20,20));
    }



}
