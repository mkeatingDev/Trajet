package handler;

import java.awt.Graphics;

/**
 * 
 * @author mattkeating
 *
 */
public interface GameState {

	/**
	 * Render the game state
	 * 
	 * @param g
	 */
	public void render(Graphics g);

	/**
	 * Timer for the game state, handle all game things
	 */
	public void tick();
}
