package core.enemies.specialEnemies;

import core.main.GameObject;
import core.main.Handler;
import core.main.ID;
import core.util.Constants;

import java.awt.*;
import java.util.Random;

public class RandomEnemyBullet extends GameObject {

	private int HEALTH = 50;

	private Handler handler;
	private Random r = new Random();


	public RandomEnemyBullet(float x, float y, ID id, Handler handler, float velX, float velY) {
		super(x, y, id);
		this.handler = handler;

		this.velX = velX;
		this.velY = velY;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		GameObject o = null;

		for (int i = 0; i < handler.getObject().size(); i++) {
			GameObject tempObject = handler.getObject().get(i);

			if (tempObject.getId() == ID.RandomEnemy) o = tempObject;
		}

		if (o == null) {
			handler.removeObject(this);
		}

		collision();

		if (y <= 0) {
			handler.removeObject(this);
		}
		if (y >= Constants.GAME_HEIGHT - 60) {
			handler.removeObject(this);
		}
		if (x <= 0) {
			handler.removeObject(this);
		}
		if (x >= Constants.GAME_WIDTH - 40) {
			handler.removeObject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		int loc = r.nextInt(7);
		g.setColor(Color.yellow);
		switch (loc) {
			case 0:
				g.fillRect((int) x - 3, (int) y - 3, 6, 6);
				break;
			case 1:
				g.fillRect((int) x, (int) y - 3, 6, 6);
				break;
			case 2:
				g.fillRect((int) x - 2, (int) y + 3, 6, 6);
				break;
			case 3:
				g.fillRect((int) x - 5, (int) y, 6, 6);
				break;
			case 4:
				g.fillRect((int) x + 1, (int) y - 4, 6, 6);
				break;
			case 5:
				g.fillRect((int) x + 1, (int) y + 4, 6, 6);
				break;
			case 6:
				g.fillRect((int) x, (int) y, 6, 6);
				break;
		}
	}

	private void collision() {
		for (int i = 0; i < handler.getObject().size(); i++) {

			GameObject tempObject = handler.getObject().get(i);

			if (tempObject.getId() == ID.Bullet) {
				HEALTH -= .5f;
			}
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 26, 26);
	}
}