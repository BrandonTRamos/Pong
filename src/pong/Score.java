package pong;

import java.awt.*;

public class Score {
    int humanScore=0;
    int aiScore=0;
    int width;

    public Score(int width) {
        this.width=width;
    }


    public void increaseHumanScore(){
        humanScore++;
    }

    public void increaseAiScore(){
        aiScore++;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 35));
        g.drawString(String.format("%d | %d",humanScore,aiScore),(width/2)-50,50);
    }

}
