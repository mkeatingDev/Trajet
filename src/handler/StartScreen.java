package handler;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * 
 * @author mattkeating
 *
 */
public class StartScreen implements GameState {

	private BufferedImage screen;

	private int height;
	private int scale = 100;

	private int[] pointsX = { 175, 225, 175 };
	private int[] pointsY = { height * scale + 330, height * scale + 355, height * scale + 380 };

	public StartScreen() {
		loadImage();
		height = 0;
	}

	public void render(Graphics g) {
		g.drawImage(screen, 0, 22, null);
		g.fillPolygon(pointsX, pointsY, 3);
	}

	public void tick() {
		if (Key.sPressed && height != 2) {
			height++;
			Key.sPressed = false;
			pointsY[0] = height * scale + 330;
			pointsY[1] = height * scale + 355;
			pointsY[2] = height * scale + 380;
		}
		if (Key.wPressed && height != 0) {
			height--;
			Key.wPressed = false;
			pointsY[0] = height * scale + 330;
			pointsY[1] = height * scale + 355;
			pointsY[2] = height * scale + 380;
		}
		if (Key.enterPressed) {
			switch (height) {
			case 0:
				TrajetHandler.here.setCurrentState(TrajetHandler.here.getGame());
				break;
			case 1:
				break;
			case 2:
				System.exit(0);
				break;
			}
		}
	}

	private void loadImage() {
		try {
			screen = ImageIO.read(new File("src/startScreen.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getScreen() {
		return screen;
	}

	public int getHeight() {
		return height;
	}

}
