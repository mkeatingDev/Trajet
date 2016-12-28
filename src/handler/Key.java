package handler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author mattkeating
 *
 */
public class Key extends KeyAdapter {

	public static boolean wPressed = false;
	public static boolean aPressed = false;
	public static boolean sPressed = false;
	public static boolean dPressed = false;

	public static boolean enterPressed = false;
	public static boolean spacePressed = false;

	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_W) {
			wPressed = true;
		} else if (keyCode == KeyEvent.VK_A) {
			aPressed = true;
		} else if (keyCode == KeyEvent.VK_S) {
			sPressed = true;
		} else if (keyCode == KeyEvent.VK_D) {
			dPressed = true;
		} else if (keyCode == KeyEvent.VK_ENTER) {
			enterPressed = true;
		} else if (keyCode == KeyEvent.VK_SPACE) {
			spacePressed = true;
		}
	}

	public void keyReleased(KeyEvent e) {

		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_W) {
			wPressed = false;
		} else if (keyCode == KeyEvent.VK_A) {
			aPressed = false;
		} else if (keyCode == KeyEvent.VK_S) {
			sPressed = false;
		} else if (keyCode == KeyEvent.VK_D) {
			dPressed = false;
		} else if (keyCode == KeyEvent.VK_ENTER) {
			enterPressed = false;
		} else if (keyCode == KeyEvent.VK_SPACE) {
			spacePressed = false;
		}
	}
}