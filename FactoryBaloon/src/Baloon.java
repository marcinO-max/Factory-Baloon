import java.awt.*;
import java.util.Random;

public class Baloon {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected BaloonColor myColor;
    protected int velocityY;
    protected int velocityX;
    protected boolean isBlocked;

    public Baloon(int x, int y, int width, int height, BaloonColor myColor, int velocityY, boolean isBlocked) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.myColor = myColor;
        this.velocityY = velocityY;
        this.isBlocked = isBlocked;
        this.velocityX = 0;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

   public void update(){
        Random random = new Random();
        if(isBlocked == false) {
            if(velocityY > 0) {
                y -= random.nextInt(velocityY) + 1;
            }
            if(velocityX > 0) {
                x += random.nextInt(velocityX) + 1;
            }
        }
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(myColor.getValue());
        g.fillOval(x,y,width,height);
        g.setColor(c);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public BaloonColor getMyColor() {
        return myColor;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public int getVelocityX() {
        return velocityX;
    }
}
