package enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import main.Game;
import main.GameObject;
import main.Handler;
import main.ID;
import util.Constants;

public class BasicEnemy extends GameObject {
	
	private Handler handler;
	private Random r;

	public BasicEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		r = new Random();
		
		velX = (r.nextFloat() * 2.9f) + 1.333f;
		velY = (r.nextFloat() * 2.9f) + 1.333f;
		
		
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Constants.GAME_HEIGHT - 50) velY *= -1;
		if(x <= 0 || x >= Constants.GAME_WIDTH - 30) velX *= -1;
		
		//TODO add trail here eventually
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 24, 24);
	}

	@Override
	public Rectangle getBounds() {
		return(new Rectangle((int)x, (int)y, 24, 24));
	}

}
