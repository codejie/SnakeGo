package jie.android.snakego.screen.test;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Snake {
	public class Header extends DrawableBox {
		
		public Header(float x, float y, int type) {
			super(x, y, type);
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
			
			public Segment(int index, float x, float y, int type) {
				super(x, y, type);
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
				Gdx.app.log("Segment", "x = " + position.x + " y = " + position.y);				
			}
		}
		
		private ArrayList<Segment> segment = new ArrayList<Segment>();
		
		public Body() {
			segment.add(new Segment(1, 2, 0, 0));
			segment.add(new Segment(2, 1, 0, 0));
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
	
	public static final float INTERVAL_UPDATE = (1.0f / 60.0f) * 60.0f;
	public static final int INTERVAL_STEP = 24;
	
	private Header header = new Header(3, 0, 0);
	private Body body = new Body();
	
	private boolean invalidation = false;
	private int stepCounter = 0;
	private float lastDelta = 0.0f;
	
	public void update(float delta) {
		lastDelta += delta;
		if (lastDelta > INTERVAL_UPDATE) {
			header.update(1, 1);
			final Vector2 l = header.getPrevPosition();
			body.update((int)l.x, (int)l.y);
			

			
//			if (++ stepCounter >= INTERVAL_STEP) {
//				stepCounter = 0;				
//				check();
//				//listener
//			}
			Gdx.app.log("===", "delta = " + lastDelta + " - setpCounter = " + stepCounter);
			lastDelta = 0.0f;
			invalidation = false;
		}
	}
	
	public void draw(final SpriteBatch batch) {
		if (!invalidation) {
			header.draw(batch);
			body.draw(batch);
			invalidation = true;
		}
	}
	
	private void check() {
		
	}
}
