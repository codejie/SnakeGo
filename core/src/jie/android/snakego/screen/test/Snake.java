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
	
	
	private Header header = new Header();
	private Body body = new Body();
	
	private final int stepLength = 24;
	
	public void update(float delta) {
		
		
		header.update(delta);
		body.update(delta);
	}
	
	public void draw() {
		
	}
	
}
