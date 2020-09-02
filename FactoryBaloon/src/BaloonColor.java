import java.awt.*;

public enum BaloonColor {
    RED(Color.RED),
    ORANGE(Color.ORANGE),
    BLACK(Color.BLACK),
    GREEN(Color.GREEN),
    YELLOW(Color.YELLOW),
    PINK(Color.PINK),
    BLUE(Color.BLUE),
    PURPLE(new Color(50, 0, 50)),
    BANANA(new Color(255, 225, 53)),
    BROWN(new Color(101, 67, 33)),
    LIME(new Color(184, 3, 254)),
    OLIVE(new Color(50, 50, 0)),
    FUXIA(new Color(100, 0, 100)),
    GREY(new Color(50, 50, 50)),
    KORAL(new Color(100, 97, 50)),
    KHAKI(new Color(94, 90, 55));


    private final Color color;

    BaloonColor(Color color){
        this.color = color;
    }

    public Color getValue(){
        return color;
    }

}