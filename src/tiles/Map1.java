package tiles;

/**
 * 
 * @author mattkeating
 *
 */
public class Map1 extends Map{

	public Map1(){
		super("1");
	}

	@Override
	public void changeMap() {
		currentMap = new Map2();
	}
}
