package util;

import java.util.Random;

import enemy.BasicEnemy;
import enemy.FastEnemy;
import enemy.SlowEnemy;
import enemy.SmartEnemy;
import interfaces.HUD;
import main.Game;
import main.GameObject;
import main.Handler;
import main.ID;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private GameObject object;
	private Game game;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}
	
	public void setScoreKeep(int i) {
		scoreKeep = i;
	}
	
	public void increaseLevel() {
		scoreKeep = 600;
	}
	
	public void updateSpawn() {
		if(scoreKeep >= 600) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			HUD.HEALTH += 10;
			
			//levels to add a basic enemy
			if(hud.getLevel() == 2 || hud.getLevel() == 3 || hud.getLevel() == 5) {
				handler.addObject(new BasicEnemy((Math.abs((r.nextFloat() - Constants.DELTA)) * Constants.GAME_WIDTH), (Math.abs((r.nextFloat() - Constants.DELTA)) * Constants.GAME_HEIGHT), ID.Enemy, handler, game.getMenu()));
			}
			//levels to add a smart enemy
			if(hud.getLevel() == 4) {
				handler.addObject(new SmartEnemy((Math.abs((r.nextFloat() - Constants.DELTA)) * Constants.GAME_WIDTH), (Math.abs((r.nextFloat() - Constants.DELTA)) * Constants.GAME_HEIGHT), ID.Enemy, handler));
			}
			
			//levels to add a slow enemy
			if(hud.getLevel() == 5) {
				handler.addObject(new SlowEnemy((Math.abs((r.nextFloat() - Constants.DELTA)) * Constants.GAME_WIDTH), (Math.abs((r.nextFloat() - Constants.DELTA)) * Constants.GAME_HEIGHT), ID.SlowEnemy, handler, game.getMenu()));
			}
			
			//levels to add a fast enemy
			if(hud.getLevel() == 5 || hud.getLevel() == 6) {
				handler.addObject(new FastEnemy((Math.abs((r.nextFloat() - Constants.DELTA)) * Constants.GAME_WIDTH), (Math.abs((r.nextFloat() - Constants.DELTA)) * Constants.GAME_HEIGHT), ID.Enemy, handler, game.getMenu()));
			}
		}
	}
	
	public void tick() {
		scoreKeep++;
		
		updateSpawn();
	}
	
}
