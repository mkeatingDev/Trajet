package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 
 * @author mattkeating
 *
 */
public abstract class Map {

	int[][] map;
	String id;

	public static Map currentMap;
	public static int[][] currentMapData;

	public Map(String id) {
		this.id = id;
		this.map = readMapFromFile();
		
		currentMapData = map;
	}

	public abstract void changeMap();

	public static BufferedImage initializeMaps() {
		Map map = new Map2();
		currentMap = map;
		return map.makeMap();
	}

	public BufferedImage makeMap() {
		BufferedImage mapImage = new BufferedImage(map.length * 90, map.length * 90, BufferedImage.TYPE_INT_RGB);
		Graphics g = mapImage.getGraphics();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				g.setColor(Tile.tiles.get(map[i][j]).c);
				g.fill3DRect(i * 90, j * 90, 90, 90, true);
			}
		}
		g.dispose();
		
		return mapImage;
	}

	public int[][] readMapFromFile() {

		// Ok so there are problably better ways to do this, but because this is
		// an initialization thing and is only executed once per map, I think
		// its fine as long as it works
		
		//So first I want to find the line that has the id for the map(based on String id^)
		int startLine = 0;
		String line = null;
		int iterator = 0;
		
		try {
			FileReader fr = new FileReader("src/MapInfo.txt");
			BufferedReader br = new BufferedReader(fr);

			while ((line = br.readLine()) != null) {
				iterator++;
				if(line.equals("*" + id + "*")){
					startLine = iterator;
					break;
				}
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int length = 0;
		line = null;
		
		try {
			FileReader fr = new FileReader("src/MapInfo.txt");
			BufferedReader br = new BufferedReader(fr);

			//Kind of a bad way to do it but whatever
			for(int i = 0; i < startLine; i++){
				br.readLine();
			}
			while ((line = br.readLine()) != null) {
				length = line.length();
				break;
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		int[][] m = new int[length][length];
		int heightAt = 0;
		int currentLine = startLine;

		line = null;

		try {
			FileReader fr = new FileReader("src/MapInfo.txt");
			BufferedReader br = new BufferedReader(fr);

			for(int i = 0; i < startLine; i++){
				br.readLine();
			}
			while ((line = br.readLine()) != null) {
				currentLine++;
				if(currentLine - startLine > length){
					break;
				}
				for (int i = 0; i < line.length(); i++) {
					m[i][heightAt] = (int) (line.charAt(i)) - 48;
				}
				heightAt++;
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return m;
	}
}