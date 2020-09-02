import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BaloonsFrame extends JFrame {
    public static int WIDTH = 500;
    public static int HEIGHT = 300;

    private Storage storage;

    private boolean firstAttack;
    private int xFirstAttaack;
    private boolean secondAttact;
    private int xSecondAttact;

    public BaloonsFrame(Storage storage) {
        super("Baloons");

        this.storage = storage;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        firstAttack = false;
        xFirstAttaack = 0;
        secondAttact = false;
        xSecondAttact = 0;

        Thread paint = new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                storage.update();
                repaint();
            }
        });
        paint.start();
    }

    public void paint(Graphics graphics){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,BaloonsFrame.WIDTH, BaloonsFrame.HEIGHT);
        List<Baloon> baloonList = storage.getBaloons();
        for (int i = 0; i < baloonList.size(); i++) {
            baloonList.get(i).paint(graphics);
        }
        if(firstAttack){
            if(xFirstAttaack > WIDTH){
                firstAttack = false;
            }
            graphics.setColor(Color.black);
            graphics.fillRect(xFirstAttaack, HEIGHT/2 , 200, 30);
            storage.firstAttact(xFirstAttaack);

            xFirstAttaack += 20;
        }

        if(secondAttact){
            if(xSecondAttact > WIDTH){
                secondAttact = false;
            }
            graphics.setColor(Color.black);
            graphics.fillRect(xSecondAttact, HEIGHT/4 , 200, 50);
            graphics.setColor(Color.GREEN);
            graphics.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            graphics.drawString("USS ENTERPRISE" ,xSecondAttact - 200, HEIGHT/4  );

            storage.secondAttack(xSecondAttact, 20);

            xSecondAttact += 20;
        }
    }

    public void setFirstAttack(boolean firstAttack){
        this.firstAttack = firstAttack;
    }

    public void setSecondAttact(boolean secondAttact) {
        this.secondAttact = secondAttact;
    }

    public boolean isSecondAttact() {
        return secondAttact;
    }
}
