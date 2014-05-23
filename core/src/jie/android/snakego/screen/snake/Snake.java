package jie.android.snakego.screen.snake;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import jie.android.snakego.screen.DrawableBox;

public class Snake {
	
	protected class Segment extends DrawableBox {
		
		protected int prevX;
		protected int prevY;
		
		public Segment(int x, int y, int type) {
			super(x, y, Snake.makeImage(type));
		}
		
		public void updateXY(int dx, int dy) {
			prevX = x;
			prevY = y;
			
			this.setXY(calcX(dx), calcY(dy));
		}
		
		public int getPrevX() {
			return prevX;
		}
		
		public int getPrevY() {
			return prevY;
		}
		
		protected int calcX(int dx) {
			return dx;
		};
		
		protected int calcY(int dy) {
			return dy;
		}
	}
	
	public class Header extends Segment {

		public Header(int x, int y) {
			super(x, y, 0);
		}

		@Override
		protected int calcX(int dx) {
			return x + dx;
		}

		@Override
		protected int calcY(int dy) {
			return y + dy;
		}		
	}
	
	public class Body {
		private ArrayList<Segment> segments = new ArrayList<Segment>();
		
		public Body() {
		}
		
		public Body(int x, int y, int size) {
			for (int i = 0; i < size; ++ i) {
				addSegment(x, y - i, 1);
			}
		}
		
		public void addSegment(int x, int y, int type) {
			segments.add(new Segment(x, y, type));
		}
		
		public void addSegment(final Stage stage, int type) {
			final Segment segment = segments.get(segments.size() - 1);
			final Segment n = new Segment(segment.getPrevX(), segment.getPrevY(), type); 
			n.put(stage);
			segments.add(n);
		}
		
		public void removeSegment() {
			if (segments.size() > 4) {
				segments.remove(segments.size() - 1);
			}
		}
		
		public int getLength() {
			return segments.size();
		}
		
		public void put(final Stage stage) {
			for (final Segment s : segments) {
				s.put(stage);
			}
		}

		public void updateXY(int dx, int dy) {			
			for (final Segment s : segments) {
				s.updateXY(dx, dy);
				dx = s.getPrevX();
				dy = s.getPrevY();
			}
		}
	}
	
	public interface OnUpdateListener {
		public void onXYUpdate(int x, int y, int dx, int dy);
	}
	
	public static final Image makeImage(int type) {
		if (type == 0) {
			return new Image(new Texture("header.png"));
		} else {
			return new Image(new Texture("body.png"));
		}
	}
	
	private final Stage stage;
	private OnUpdateListener updateListener = null;
	
	private Header header;
	private Body body;
	
	private float lastDelta = 0.0f;
	private float updateInterval = (1.0f / 60.0f) * 15.0f;
	
	private int dx = 0;
	private int dy = 1;	
	private int tdx = 0;
	private int tdy = 1;	
	
	public Snake(final Stage stage) {
		this(stage, 8, 5, 4);
	}
	
	public Snake(final Stage stage, int x, int y, int size) {
		this.stage = stage;
		header = new Header(x, y);
		body = new Body(x, y - 1, size);
		
		put(this.stage);
	}

	private void put(final Stage stage) {
		header.put(stage);
		body.put(stage);
	}
	
	public final Header getHeader() {
		return header;
	}
	
	public final Body getBody() {
		return body;
	}
	
	public void update(float delta) {
		lastDelta += delta;
		if (lastDelta > updateInterval) {
			header.updateXY(dx, dy);
			body.updateXY(header.getPrevX(), header.getPrevY());
			
			if (updateListener != null) {
				if (header.getY() > 10) {
					updateListener.onXYUpdate(header.getX(), header.getY(), dx, dy);
				}
			}
			
			checkXY();
			lastDelta = 0.0f;
		}
	}

	private void checkXY() {
		if ((dy == 0) && (dx == -tdx)) {
			dy = 1;
			dx = 0;
		} else {
			dx = tdx;
			dy = tdy;
		}
	}
	
	public void touchDown(int x, int y) {

		if (x > header.getX()) {
			tdx = 1;
		} else {
			tdx = -1;
		}
		tdy = 0;
	}

	public void touchUp(int x, int y) {
		tdx = 0;
		tdy = 1;		
	}
	
	public void setUpdateListener(final OnUpdateListener listener) {
		updateListener = listener;
	}

	public void stop() {
		tdx = 0;
		tdy = 0;
	}
}
