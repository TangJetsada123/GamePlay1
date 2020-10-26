

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//Create for manage keyboard event ;
public class KeyPress extends KeyAdapter {

    Player player;
    private KeyEvent e;

    public KeyPress(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed (KeyEvent e){ player.keyPressed(e); }

    @Override
    public void keyReleased(KeyEvent e) { player.keyReleased(e); }
}
