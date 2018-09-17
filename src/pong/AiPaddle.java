package pong;

public class AiPaddle extends Paddle {
    Ball ball;
    public AiPaddle(int xLocation,int frameHeight,Ball ball) {
        super(xLocation,((frameHeight-100)/2),frameHeight);
        this.ball=ball;
    }



    public void move(){
        if (ball.getxVector()<0){
            moveToCenter();
        }else{
            trackBall();
        }
    }


    private void moveToCenter(){
        if(super.yLocation-200<0){
            this.yLocation+=1;
        } else if(this.yLocation-200>0){
            this.yLocation-=1;
        }
    }

   private void trackBall(){

       double positionDifference = ball.getYLocation()-(yLocation+50);

       if (positionDifference>4){
           yLocation+=4;
       }else if (positionDifference<-4){
           yLocation-=4;
       }else{
       yLocation=(int)ball.getYLocation()-50;
       }
       checkBoundaries();
   }
}