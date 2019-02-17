package util;

import java.util.Random;

import enemy.BasicEnemy;
import enemy.FastEnemy;
import enemy.SlowEnemy;
import enemy.SmartEnemy;
import interfaces.HUD;
import main.GameObject;
import main.Handler;
import main.ID;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private GameObject object;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void setScoreKeep(int i) {
		scoreKeep = i;
	}
	
	public void increaseLevel() {
		scoreKeep = 600;
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 600) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			
			
			//levels to add a basic enemy
			if(hud.getLevel() == 2 || hud.getLevel() == 3 || hud.getLevel() == 5) {
				handler.addObject(new BasicEnemy((Math.abs(r.nextFloat() - Constants.DELTA) * Constants.GAME_WIDTH), (Math.abs(r.nextFloat() - Constants.DELTA) * Constants.GAME_HEIGHT), ID.Enemy, handler));
			}
			//levels to add a smart enemy
			if(hud.getLevel() == 4) {
				handler.addObject(new SmartEnemy((Math.abs(r.nextFloat() - Constants.DELTA) * Constants.GAME_WIDTH), (Math.abs(r.nextFloat() - Constants.DELTA) * Constants.GAME_HEIGHT), ID.Enemy, handler));
			}
			
			//levels to add a slow enemy
			if(hud.getLevel() == 5) {
				handler.addObject(new SlowEnemy((Math.abs(r.nextFloat() - Constants.DELTA) * Constants.GAME_WIDTH), (Math.abs(r.nextFloat() - Constants.DELTA) * Constants.GAME_HEIGHT), ID.SlowEnemy, handler));
			}
			
			//levels to add a fast enemy
			if(hud.getLevel() == 5 || hud.getLevel() == 6) {
				handler.addObject(new FastEnemy((Math.abs(r.nextFloat() - Constants.DELTA) * Constants.GAME_WIDTH), (Math.abs(r.nextFloat() - Constants.DELTA) * Constants.GAME_HEIGHT), ID.Enemy, handler));
			}
		}
	}
	
}
