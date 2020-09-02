import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Storage {
    List<Baloon> baloons = new ArrayList<>();

    public synchronized boolean isFull() {
        return baloons.size() >= 99;
    }

    public synchronized void addBaloon(Baloon baloon) {
        if (baloons.size() < 99) {
            baloons.add(baloon);
        }
    }

    public synchronized List<Baloon> getBaloons() {
        return baloons;
    }

    public synchronized void update() {
        for (int i = 0; i < baloons.size(); i++) {
            baloons.get(i).update();
        }
    }

    public synchronized void firstAttact(int x) {
        List<Baloon> help = new ArrayList<>();
        for (int i = 0; i < baloons.size(); i++) {
            Baloon b = baloons.get(i);
            if (b.getMyColor() == BaloonColor.RED || x < b.getX()) {
                help.add(b);
            }
        }
        baloons = help;
    }

    public synchronized void secondAttack(int x,int xSpeed) {
        Random random = new Random();
        Iterator<Baloon> it = baloons.iterator();
        while (it.hasNext()) {
            Baloon b = it.next();
            if(x > b.getX()){
                if(b.getVelocityX() == 0){
                    if(random.nextInt(2) == 0){
                        b.setVelocityY(0);
                        b.setVelocityX(xSpeed);
                    }else{
                        it.remove();
                    }
                }
            }
        }
    }




}
