package entity;

import java.awt.Color;
import java.awt.Graphics;

import handler.Key;
import tiles.Map;

/**
 * 
 * @author mattkeating
 *
 */
public class Player implements Entity {

	private int health;
	private int x;
	private int y;

	private int animX;
	private int animY;
	private boolean isAnimating;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;

		this.animX = x * 90;
		this.animY = y * 90;
		this.isAnimating = false;
	}

	public int getHealth() {
		return health;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getAnimX() {
		return animX;
	}

	public int getAnimY() {
		return animY;
	}

	public void move() {
		
		if (isAnimating) {
			int targetX = x * 90;
			int targetY = y * 90;

			if (targetX < animX) {
				animX -= 3;
			}
			if (targetX > animX) {
				animX += 3;
			}
			if (targetY < animY) {
				animY -= 3;
			}
			if (targetY > animY) {
				animY += 3;
			}
			if (targetX == animX && targetY == animY) {
				isAnimating = false;
			}
		}
		if (!isAnimating) {
			if (Key.aPressed) {
				if (canMoveToSquare(x - 1, y)) {
					x--;
					isAnimating = true;
				}
			} else if (Key.dPressed) {
				if (canMoveToSquare(x + 1, y)) {
					x++;
					isAnimating = true;
				}
			} else if (Key.wPressed) {
				if (canMoveToSquare(x, y - 1)) {
					y--;
					isAnimating = true;
				}
			} else if (Key.sPressed) {
				if (canMoveToSquare(x, y + 1)) {
					y++;
					isAnimating = true;
				}
			}
		}
	}
	private boolean canMoveToSquare(int x, int y) {
		if(x < 0 || x > Map.currentMapData.length - 1){
			return false;
		}
		if(y < 0 || y > Map.currentMapData.length - 1){
			return false;
		}
		if (Map.currentMapData[x][y] != 0) {
			return false;
		}
		return true;
	}

	public void render(Graphics g) {

		//Just a place holder for drawing the player
		g.setColor(Color.BLACK);
		g.fillRect(270, 292, 90, 90);

	}
}