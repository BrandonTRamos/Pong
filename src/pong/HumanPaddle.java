package pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HumanPaddle extends Paddle implements KeyListener {
    public HumanPaddle(int frameHeight) {
        super(50,((frameHeight-100)/2),frameHeight);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode()==KeyEvent.VK_UP){
            this.yLocation-=15;
        } else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            this.yLocation+=15;
        }
            checkBoundaries();
        }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
