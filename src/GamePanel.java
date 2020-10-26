

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;




public class GamePanel extends JPanel implements ActionListener {
    //make a tracking system;
    public static int x;
    private boolean GameOver = false;
    private boolean collision = false;
    private boolean getKey = true;
    private boolean CanDraw = true;
    //private boolean
    public static int y = 200;
    private int score = 0;
    private String a;
    Player player;
    Enemy enemy;
    Timer loop;
    Key key;

    public static boolean tracking = false;

    //initialize
    public GamePanel() throws InterruptedException {
        loop = new Timer(10, this);
        loop.start();
        GamePanel.tracking = true;
        player = new Player(100, 100);
        enemy = new Enemy(200, 200);
        key = new Key(300, 300);
        addKeyListener(new KeyPress(player));
        setFocusable(true);
        requestFocus();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
        if (GameOver = true) {
            Map.draw(g2d);
            player.draw(g2d);
            enemy.draw(g2d);
            if (getKey) {
                key.addScore();
                key.drawKey = false;
                g2d.setColor(Color.RED);
            }
        }


        if (CanDraw) {
            key.draw(g2d);
        }

        if (collision) {
            g2d.setFont(new Font("Game Over", Font.PLAIN, 60));
            g2d.setColor(Color.white);
            g2d.drawString("Game Over", 250, 250);
            g2d.setFont(new Font("Press SpaceBar to restart", Font.PLAIN, 30));
            g2d.drawString("Press SpaceBar to restart", 250, 300);
            repaint();
            GamePanel.tracking = false;
            this.loop.stop();
        }

    }

    public void collision() {
        Rectangle rectangle1 = player.bounds();
        Rectangle rectangle2 = enemy.bounds();


        if (rectangle1.intersects(rectangle2)) {
            collision = true;
        }
    }

    public void setGetKey() {
        Rectangle rectangle1 = player.bounds();
        Rectangle rectangle3 = key.bounds();
        if (rectangle1.intersects(rectangle3)) {
            getKey = true;
        } else getKey = false;
    }



        @Override
        public void actionPerformed(ActionEvent e) {
            player.update();
            enemy.update();
            collision();
            setGetKey();
            repaint();

    }


}
