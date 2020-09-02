import java.awt.Color;
import java.util.Random;

public class Factory implements Runnable {
    BaloonColor myColor;
    Storage storage;

    public Factory(BaloonColor myColor, Storage storage) {
        this.myColor = myColor;
        this.storage = storage;
    }


    @Override
    public void run() {
        Random random = new Random();
        while(!storage.isFull()){
            try {
                Thread.sleep((int)Math.random()*500+300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int width = (int)Math.random()*20 + 30;
            int height = (int)Math.random()*20 + 30;
            int x = random.nextInt(BaloonsFrame.WIDTH-width);
            int y = -random.nextInt(80+1) + BaloonsFrame.HEIGHT - height;
            Baloon b = new Baloon(x,y,width,height,myColor,6 , true);
            storage.addBaloon(b);
        }
    }
}
