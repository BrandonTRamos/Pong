package pong;

import java.awt.*;

public abstract class Paddle {
    protected int xLocation;
    protected int yLocation;
    protected int originalY;
    protected int frameHeight;

    public Paddle(int xLocation,int yLocation,int frameHeight){
        this.xLocation=xLocation;
        this.yLocation=yLocation;
        this.frameHeight=frameHeight;
        originalY=yLocation;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillRect(xLocation,yLocation,25,100);
    }

    public void reset(){
        this.yLocation=originalY;
    }


    public int getyLocation() {
        return yLocation;
    }

    protected void checkBoundaries(){
        if(this.yLocation<0){
            this.yLocation=0;
        } else if(this.yLocation>frameHeight-100){
            this.yLocation=frameHeight-100;
        }
    }

}
