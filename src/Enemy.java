

import java.awt.*;

public class Enemy {
    private int x;
    private int y;
    private int speedEnemyX = 5;
    private int speedEnemyY = 5;

    public Enemy(int x, int y) {
        this.x = 150;
        this.y = 30;
    }


    public void draw(Graphics2D g2d) {

        g2d.setColor(Color.YELLOW);
        g2d.fillRect(x, y, 32, 32);
    }

    public void update() {
        if (GamePanel.tracking == true) {

            if( x< 150 || x> 600){
                speedEnemyX = -speedEnemyX;
            }
            if(y <30  || y > 500){
                speedEnemyY = -speedEnemyY;
            }

            x += speedEnemyX;
            y += speedEnemyY;
        }

    }
    public Rectangle bounds()
    {
        return  (new Rectangle(x,y,50,50));
    }



}
