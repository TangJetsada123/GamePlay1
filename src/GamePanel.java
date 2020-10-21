

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    //make a tracking system;
    public  static int x ;
    private boolean collision = false ;
    private boolean getKey    = true;
    private boolean CanDraw   = true;
    public static int y = 200 ;
    private int score = 0;
    private String a;
    Player player ;
    Enemy enemy ;
    Timer  loop ;
    Key    key;

    public static boolean tracking = false;
    //initialize
    public GamePanel(){
        loop = new Timer(10 ,this);
        loop.start();
        player = new Player(100,100);
        enemy = new Enemy(200,200) ;
        key   = new Key(300,300);
        addKeyListener(new KeyPress(player));
        setFocusable(true);
        requestFocus();
    }

    public void paint (Graphics g ) {

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
        Map.draw(g2d);
        player.draw(g2d);
        enemy.draw(g2d);

        if (CanDraw) {
            key.draw(g2d);
        }

        if (collision) {
            g2d.drawString("Game Over", 30, 100);
        }

        if (getKey) {
            key.addScore();
            key.drawKey = false;
            g2d.setColor(Color.RED);

        }

    }


    public void collision(){
        Rectangle rectangle1 = player.bounds();
        Rectangle rectangle2 = enemy.bounds();

        if(rectangle1.intersects(rectangle2)){
                collision = true;}
        else    collision = false; }

    public void setGetKey(){


        Rectangle rectangle1 = player.bounds();
        Rectangle rectangle3 = key.bounds();
        
        if(rectangle1.intersects(rectangle3)){
                getKey = true;
        }
        else    getKey = false; }


    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        enemy.update();
        collision();
        setGetKey();

        repaint();
    }


}
