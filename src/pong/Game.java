package pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame{
    private final int WIDTH=900;
    private final int HEIGHT=600;


    private Image i;
    private Graphics doubleG;

    private HumanPaddle human;
    private AiPaddle ai;
    private Ball ball;
    private Score score;

    public Game() {
        int humanX=50;
        int aiX=WIDTH-75;
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setFocusable(true);
        ball = new Ball(humanX,aiX,HEIGHT,WIDTH/2,new GoalListener() {
            @Override
            public void pointScored(Side side) {
                switch (side) {
                    case Ai:
                        score.increaseAiScore();
                        break;
                    default:
                        score.increaseHumanScore();
                        break;
                }
                human.reset();
                ai.reset();
                ball.reset();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        human = new HumanPaddle(HEIGHT);
        ai = new AiPaddle(WIDTH-75,HEIGHT,ball);
        score = new Score(WIDTH);
        addKeyListener(human);
        setVisible(true);
        i = createImage(WIDTH, HEIGHT);
        doubleG = i.getGraphics();
    }

    public void update (Graphics g){
        paint(g);
    }


    public void paint(Graphics g) {
        doubleG.setColor(Color.BLACK);
        doubleG.fillRect(0, 0, WIDTH, HEIGHT);
        human.draw(doubleG);
        ai.draw(doubleG);
        ball.draw(doubleG);
        score.draw(doubleG);
        g.drawImage(i, 0, 0, this);
    }


    public void gameLoop() {

        while (true) {
            ai.move();
            ball.move(human.getyLocation(), ai.getyLocation());
            repaint();
            try {
                Thread.sleep(1000 / 50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
