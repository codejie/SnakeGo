package jie.android.snakego.screen.test;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Snake {
	
	public interface OnUpdateListener {
		public void onUpdate(float x, float y);
	}
	
	public class Header extends DrawableBox {
		
		public Header(float x, float y) {
			super(x, y, 1);
		}

		@Override
		public void update(float dx, float dy) {
			prevPosition.x = position.x;
			prevPosition.y = position.y;
			
			position.x += dx;
			position.y += dy;
		}

		@Override
		public void draw(final SpriteBatch batch) {
			super.draw(batch);
			// TODO Auto-generated method stub
			Gdx.app.log("Header", "x = " + position.x + " y = " + position.y);
		}
	}
	
	public class Body {
		private class Segment extends DrawableBox {

			private final int index;
			
			public Segment(int index, float x, float y) {
				super(x, y, 2);
				this.index = index;
			}
			
			@Override
			public void update(float dx, float dy) {
				prevPosition.x = position.x;
				prevPosition.y = position.y;
				
				position.x = dx;
				position.y = dy;
			}

			@Override
			public void draw(final SpriteBatch batch) {
				super.draw(batch);
//				Gdx.app.log("Segment", "x = " + position.x + " y = " + position.y);				
			}
		}
		
		private ArrayList<Segment> segment = new ArrayList<Segment>();
		
		public Body() {
			segment.add(new Segment(1, 0, 0));
			segment.add(new Segment(2, 0, 0));
		}
		
		public void update(int dx, int dy) {
			Vector2 last = new Vector2(dx, dy);
			for (final Segment s : segment) {
				s.update((int)last.x, (int)last.y);
				last = s.getPrevPosition();
			}
		}

		public void draw(final SpriteBatch batch) {
			for (final Segment s : segment) {
				s.draw(batch);
			}			
		}		
	}
	
	public static final float INTERVAL_UPDATE = (1.0f / 60.0f) * 15.0f;
	public static final int INTERVAL_STEP = 24;
	
	private Header header = new Header(0, 0);
	private Body body = new Body();
	
	private int stepCounter = 0;
	private float lastDelta = 0.0f;
	private float dx = 0.0f;
	private float dy = 32.0f;
	
	private float tdx = -1.0f;
	private float tdy = -1.0f;
	
	private OnUpdateListener updateListener = null;
	
	public Snake(final OnUpdateListener listener) {
		updateListener = listener;
	}
	
	public void update(float delta) {
		lastDelta += delta;
		if (lastDelta > INTERVAL_UPDATE) {
			
//			header.update(dx, dy);
//			final Vector2 l = header.getPrevPosition();
//			body.update((int)l.x, (int)l.y);
			
			if (updateListener != null) {
				updateListener.onUpdate(header.position.x, header.position.y);
			}
			
			check();

			Gdx.app.log("===", "delta = " + lastDelta + " - setpCounter = " + stepCounter);
			lastDelta = 0.0f;
		}
	}
	
	public void draw(final SpriteBatch batch) {
			header.draw(batch);
			body.draw(batch);
	}
	
	private void check() {
		if (tdx != -1.0f) {
			if (dx != -tdx) {
				dx = tdx;
			}
		}
		if (tdy != -1.0f) {
			dy = tdy;
		}
	}

	public boolean onTouchDown(float x, float y) {
		if (x > 0) {
			tdx = 32.0f;
		} else {
			tdx = -32.0f;
		}
		tdy = 0.0f;
		return true;
	}

	public boolean onTouchUp(float x, float y) {
		tdx = 0.0f;
		tdy = 32.0f;
		return true;
	}

	public boolean onTouchDragged(float x, float y) {
		
		return false;
	}
	
}
