import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isRightPress;

    GameCanvas canvas;

    static int width = 800;
    static int height = 600;

    public GameWindow() {
        this.setSize(width, height);
        this.setTitle("Game Touhou");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.canvas = new GameCanvas();
        this.add(canvas);
        this.setupEventListener();

        this.setVisible(true);

    }

    private void setupEventListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    isUpPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    isRightPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
               if (e.getKeyCode() == KeyEvent.VK_W) {
                   isUpPress = false;
               }
               if (e.getKeyCode() == KeyEvent.VK_S) {
                   isDownPress = false;
               }
               if (e.getKeyCode() == KeyEvent.VK_A) {
                   isLeftPress = false;
               }
               if (e.getKeyCode() == KeyEvent.VK_D) {
                   isRightPress = false;
               }
            }
        });
    }
}
