package handler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entity.Entity;
import entity.Player;
import tiles.Map;
import tiles.Tile;

/**
 * 
 * @author mattkeating
 *
 */
public class Game implements GameState{

	public static BufferedImage screen;
	//The screen relative to the player(so that the screen moves with the player)
	//public static BufferedImage relScreen;
	
	private BufferedImage background;
	private Entity p = new Player(10, 10);
	
	public Game(){
		//Init the first map
		Tile.initializeTiles();
		screen = Map.initializeMaps();
		//relScreen = screen;
		initializeBackground();
	}
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, TrajetHandler.WIDTH, TrajetHandler.HEIGHT);
		g.drawImage(screen, 270 - p.getAnimX(), 270 - p.getAnimY() + 22, null);
		g.drawImage(background, 630, 0, null);
		
		p.render(g);
	}
	public void tick() {
		p.move();
	}
	private void initializeBackground(){
		background = new BufferedImage(TrajetHandler.WIDTH - 630, TrajetHandler.HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		Graphics g = background.getGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, TrajetHandler.WIDTH - 630, TrajetHandler.HEIGHT);
		
		g.setColor(Color.WHITE);
		g.drawRect(100, 100, 100, 500);
		
		g.dispose();
	}
}
