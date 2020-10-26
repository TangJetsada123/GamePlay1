

import javax.swing.*;

class Main {
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public static int H = 617;
    public static int W = 617;
    public static void main(String[] args) throws InterruptedException {

        // Create window for game , set name ;
        JFrame window = new JFrame("MAMMA") ;
        window.setSize(WIDTH , HEIGHT);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(new GamePanel());
        window.setVisible(true);
        window.setLocationRelativeTo(null);

        // write your code here
    }
}
