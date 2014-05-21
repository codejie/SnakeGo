package jie.android.snakego.screen.snake;

import java.util.HashMap;

public class BrickFrame {
	
	public class XY {
	    private final int x;
	    private final int y;

	    public XY(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof XY)) return false;
	        XY key = (XY) o;
	        return x == key.x && y == key.y;
	    }

	    @Override
	    public int hashCode() {
	        int result = x;
	        result = 31 * result + y;
	        return result;
	    }
	}
	
	private HashMap<XY, Brick> brickMap = new HashMap<XY, Brick>();
	
	public BrickFrame() {
		
	}
	
	public boolean init() {
		return false;
	}
	
	public boolean load() {
		return false;
	}
	
	
	
}
