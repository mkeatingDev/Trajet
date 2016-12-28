package entity;

import java.awt.Graphics;

/**
 * 
 * @author mattkeating
 *
 */
public interface Entity {

	/**
	 * 
	 * @return entity health
	 */
	public int getHealth();

	/**
	 * X and Y position are based on an array so they start at 0 and change by 1
	 * to move 1 square
	 * 
	 * @return the x position
	 */
	public int getX();

	/**
	 * 
	 * @return the y position
	 */
	public int getY();

	/**
	 * Animated X and Animated Y are based on the standard GUI pixel system so
	 * 0, 0 is the top left Used to draw the entity
	 * 
	 * @return the animation x position
	 */
	public int getAnimX();

	/**
	 * 
	 * @return the animation x position
	 */
	public int getAnimY();

	/**
	 * Move the entity, handle both position on the array and position relative
	 * to the screen(for animation)
	 */
	public void move();

	/**
	 * render the entity
	 * 
	 * @param g
	 */
	public void render(Graphics g);
}
