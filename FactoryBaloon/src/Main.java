import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Factory f1 = new Factory(BaloonColor.RED,storage);
        Factory f2 = new Factory(BaloonColor.GREEN,storage);
        Factory f3 = new Factory(BaloonColor.BLUE,storage);


        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);
        Thread t3 = new Thread(f3);
        t1.start();
        t2.start();
        t3.start();

        BaloonsFrame frame = new BaloonsFrame(storage);;


        while(!storage.isFull()){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<Baloon> baloonList = storage.getBaloons();
        for(int i = 0 ; i < baloonList.size(); i++){
            baloonList.get(i).setBlocked(false);
        }

        boolean attack = false;
        while(!attack){
            for (int i = 0; i < baloonList.size(); i++) {
                if(baloonList.get(i).getY() < BaloonsFrame.HEIGHT/2){
                    attack = true;
                }
            }
        }

        frame.setFirstAttack(true);

        attack = false;

        while(!attack){
            for (int i = 0; i < baloonList.size(); i++) {
                if(baloonList.get(i).getY() < BaloonsFrame.HEIGHT/4){
                    attack = true;
                }
            }
        }

        frame.setSecondAttact(true);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(frame, "GAME OVER");
        System.exit(0);
    }
}