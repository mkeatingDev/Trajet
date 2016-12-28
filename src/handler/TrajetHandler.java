package handler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

/**
 * 
 * @author mattkeating
 *
 *         Code to handle the game. This includes gamestates and rendering Class
 *         also sets up the JFrame
 */

public class TrajetHandler extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 900, HEIGHT = 652;
	
	public static TrajetHandler here;

	private boolean running;
	private Thread gameThread;

	private GameState startScreen;
	private GameState game;
	private GameState currentGameState;

	public TrajetHandler() {
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Trajet");
		setBackground(Color.BLACK);
		addKeyListener(new Key());

		startScreen = new StartScreen();
		game = new Game();
		currentGameState = startScreen;

		setVisible(true);
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;

		gameThread = new Thread(this);
		gameThread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;

		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		int frames = 0;

		double unprocessedSeconds = 0;
		long lastTime = System.nanoTime();
		double secondsPerTick = 1 / 60.0;
		int tickCount = 0;

		requestFocus();

		while (running) {
			long now = System.nanoTime();
			long passedTime = now - lastTime;
			lastTime = now;
			if (passedTime < 0)
				passedTime = 0;
			if (passedTime > 100000000)
				passedTime = 100000000;

			unprocessedSeconds += passedTime / 1000000000.0;

			boolean ticked = false;
			while (unprocessedSeconds > secondsPerTick) {
				tick();
				unprocessedSeconds -= secondsPerTick;
				ticked = true;

				tickCount++;
				if (tickCount % 60 == 0) {
					System.out.println(frames + " fps");
					lastTime += 1000;
					frames = 0;
				}
			}

			if (ticked) {
				render();
				frames++;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public void tick() {
		currentGameState.tick();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		currentGameState.render(g);

		g.dispose();
		bs.show();
	}
	
	public GameState getGame(){
		return game;
	}
	public void setCurrentState(GameState g){
		currentGameState = g;
	}

	public static void main(String[] args) {
		here = new TrajetHandler();
		here.start();
	}
}