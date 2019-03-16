package core.enemies.basicEnemies;

import core.main.GameObject;
import core.main.Handler;
import core.main.ID;
import core.player.PlayerShield;
import core.util.Constants;

import java.awt.*;

public class SmartEnemy extends GameObject {

    private int HEALTH = 100;

    private Handler handler;
    private GameObject player;

    public SmartEnemy(Rectangle location, ID id, Handler handler) {
        super(location, id);
        this.handler = handler;

        for (int i = 0; i < handler.getObject().size(); i++) {
            if (handler.getObject().get(i).getId() == ID.Player) player = handler.getObject().get(i);
        }
    }

    public SmartEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for (int i = 0; i < handler.getObject().size(); i++) {
            if (handler.getObject().get(i).getId() == ID.Player) player = handler.getObject().get(i);
        }
    }


    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        setX(x += getVelX());
        setY(y += getVelY());

        float diffX = x - player.getX() - 8f;
        float diffY = y - player.getY() - 8f;
        float distance = (float) Math.sqrt(
                (
                        (Math.pow(getX() - player.getX(), 2)) // x2 - x1 **2
                )
                        +
                        (Math.pow(getY() - player.getY(), 2))   // y2 - y1 ** 2
        );

        collision();

        velX = (float) ((-1.0 / distance) * diffX);
        velY = (float) ((-1.0 / distance) * diffY);

        // Could add but it doesn't look good imo
        //handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.03f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    private void collision() {
        for (int i = 0; i < handler.getObject().size(); i++) {

            GameObject tempObject = handler.getObject().get(i);

            if (tempObject.getId() == ID.Bullet) {
                HEALTH-= .5f;
            }
        }
    }
}