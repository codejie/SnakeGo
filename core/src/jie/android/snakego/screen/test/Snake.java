package jie.android.snakego.screen.test;

import java.util.ArrayList;

public class Snake {
	public class Header extends Box {

		@Override
		public void update(float delta) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void draw() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class Body {
		private class Segment extends Box {

			@Override
			public void update(float delta) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void draw() {
				// TODO Auto-generated method stub
				
			}
			
		}
		
		private ArrayList<Segment> segment = new ArrayList<Segment>();
		
		public void update(float delta) {
			for (final Segment s : segment) {
				s.update(delta);
			}
		}

		public void draw() {
			for (final Segment s : segment) {
				s.draw();
			}			
		}		
	}
	
	public static final float INTERVAL_UPDATE = 100.0f;
	public static final int INTERVAL_STEP = 24;
	
	private Header header = new Header();
	private Body body = new Body();
	
	private int stepCounter = 0;
	private float lastDelta = 0.0f;
	
	public void update(float delta) {
		if (delta - lastDelta > INTERVAL_UPDATE) {
			header.update(delta);
			body.update(delta);
			
			if (++ stepCounter >= INTERVAL_STEP) {
				stepCounter = 0;
				//listener
			}
		}
	}
	
	public void draw() {
		header.draw();
		body.draw();
	}
	
}
