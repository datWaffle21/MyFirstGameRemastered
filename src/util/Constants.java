package util;

import java.awt.*;

public class Constants {

    public static final int GAME_WIDTH = 700;
    public static final int GAME_HEIGHT = GAME_WIDTH / 12 * 9;
    public static final Color PURPLE = new Color(153, 50, 204);
    static final float DELTA = .30f;
    public static final float DECAY = .15f;
    public static final Rectangle spawnZone = new Rectangle(30, 30, Constants.GAME_WIDTH - 80, Constants.GAME_HEIGHT - 100);
    public static final int TOP = 0;
    public static final int TOP_RIGHT = 1;
    public static final int RIGHT = 2;
    public static final int BOTTOM_RIGHT = 3;
    public static final int BOTTOM = 4;
    public static final int BOTTOM_LEFT = 5;
    public static final int LEFT = 6;
    public static final int TOP_LEFT = 7;

}
