package tiles;

import java.awt.Color;
import java.util.ArrayList;

/**
 * 
 * @author mattkeating
 *
 */
public class Tile {

	Color c;
	public static ArrayList<Tile> tiles = new ArrayList<Tile>();

	public Tile(Color c) {
		this.c = c;
	}

	public static void initializeTiles() {
		addTile(new Tile(Color.GREEN));
		addTile(new Tile(Color.BLUE));
		addTile(new Tile(Color.GRAY));
	}

	public static void addTile(Tile t) {
		tiles.add(t);
	}

	public static void clearTiles() {
		for (int i = 0; i < tiles.size(); i++) {
			tiles.remove(i);
		}
	}
}
