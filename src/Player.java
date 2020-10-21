
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class Player  {
    private int x;
    private int y;
    private int speedX = 0;
    private int speedY = 0;
    private int speed = 3;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        this.x += this.speedX;
        this.y += this.speedY;
        if (this.x <= 0 || this.x > Main.W) {
            this.x = Main.W;
        }

        if (this.y > Main.H) {
            this.y = Main.H;
        }
        if (this.y <= 30){
            this.y = 30;
        }

        if (this.x < 150) {
            this.x = 150;
        }

        if (this.y >  500) {
            this.y =  500;
        }

    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, 32, 32);
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 37) {
            this.speedX = -this.speed;
        }

        if (keyCode == 39) {
            this.speedX = this.speed;
        }

        if (keyCode == 38) {
            this.speedY = -this.speed;
        }

        if (keyCode == 40) {
            this.speedY = this.speed;
        }

        if (keyCode == 32) {
            GamePanel.x = this.x;
            GamePanel.y = this.y;
        }



    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 37) {
            this.speedX = 0;
        }

        if (keyCode == 39) {
            this.speedX = 0;
        }

        if (keyCode == 38) {
            this.speedY = 0;
        }

        if (keyCode == 40) {
            this.speedY = 0;
        }
        if (keyCode == KeyEvent.VK_SPACE) {
            GamePanel.tracking = true;
            GamePanel.x = x ;
            GamePanel.y = y ;
        }

    }

    public Rectangle bounds()
    {
        return  (new Rectangle(x,y,50,50));
    }


}
