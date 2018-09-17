package pong;

import java.awt.*;
import java.util.Random;

public class Ball {

    private final int humanX;
    private final int aiX;
    private int startX;
    private int startY;
    private int xLocation;
    private int yLocation;
    private int xVector;
    private int yVector;
    private int frameHeight;


    private GoalListener gl;

    public Ball(int humanX,int aiX,int frameHeight, int startX,GoalListener gl){
        this.humanX=humanX+25;
        this.aiX=aiX;
        this.gl=gl;
        this.frameHeight=frameHeight;
        this.startX=startX;
        this.startY=frameHeight/2;
        this.xLocation=startX;
        this.yLocation=frameHeight/2;
        this.xVector= randomStartVector();
        this.yVector= randomStartVector();

    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(xLocation-10,yLocation-10,15,15);
    }

    public void move(int humanY,int aiY){
        xLocation+=xVector;
        yLocation+=yVector;
        if(this.xLocation<humanX&&this.xLocation>humanX-4&&this.yLocation<humanY+100&&this.yLocation>=humanY){
            xVector=-(xVector);
        }else if(this.xLocation>aiX&&this.xLocation<aiX+4&&this.yLocation<aiY+100&&this.yLocation>=aiY){
            xVector=-(xVector);
        }else if(yLocation<=0){
            yVector=-(yVector);
        } else if(yLocation>=frameHeight){
            yVector=-(yVector);
        }

        if(this.xLocation<humanX-90){
            gl.pointScored(Side.Ai);
        }
        else if (this.xLocation>aiX+115){
            gl.pointScored(Side.Human);
        }

    }

    private int randomStartVector(){
        int[] direction = new int[]{-1,1};
        int rnd = new Random().nextInt(direction.length);
        return 4*direction[rnd];
    }

    public void reset(){
        this.xLocation=startX;
        this.yLocation=startY;
        this.yVector= randomStartVector();
        this.xVector= randomStartVector();
    }

    public double getxVector() {
        return xVector;
    }

    public double getYLocation() {return yLocation;}
}

