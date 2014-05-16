package jie.android.snakego.screen.test;

import jie.android.snakego.SnakeGo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;

public class T2Screen implements Screen {

	private final SnakeGo game;

	private Texture img;
	private float y = 0;
	private float dy = -1.0f;
	
	public T2Screen(final SnakeGo game) {
		this.game = game;
		
		img = new Texture("badlogic.jpg");

		final OrthographicCamera cam = game.getCamera();
//		cam = new OrthographicCamera(10, 10);
//		cam.position.set(10 / 2, 10 / 2, 0);
//		game.getSpriteBatch().setProjectionMatrix(cam.combined);
		
//		dy = cam.position.y; 
	}
	
	@Override
	public void render(float delta) {
//		final OrthographicCamera cam = game.getCamera();
//		
//		cam.translate(0, 1, 0);
//		//cam.zoom += 0.01f;
//		cam.update();
//		Gdx.gl.glViewport(0, 0, 768, 1280);
//		
//		final SpriteBatch batch = game.getSpriteBatch();
//		
//		//Gdx.gl.glViewport((int)cam.position.x, (int)cam.position.y, (int)cam.viewportWidth, (int)cam.viewportHeight);
//		
//		batch.setProjectionMatrix(cam.combined);
//		cam.apply(Gdx.gl);
		
//		
//		
//		
//		
//		final Vector2 scale = game.getScreenScale();
//		final OrthographicCamera cam = game.getCamera();
//		final SpriteBatch batch = game.getSpriteBatch();
//		
//		int width = Gdx.graphics.getWidth();
//		int height = Gdx.graphics.getHeight();
//		
//		Vector2 size = new Vector2(scale.x * Gdx.graphics.getWidth(), scale.y * Gdx.graphics.getHeight());		
//		
////	    int viewportX = (int)(width - size.x) / 2;
////	    int viewportY = (int)(height - size.y) / 2;
////	    int viewportWidth = (int)width;//size.x;
////	    int viewportHeight = (int)height;//size.y;
////	    //Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);
////
//////		float centerX = this.width / 2;
//////		float centerY = this.height / 2;
////		cam.position.set(viewportX, viewportY, 0);
////		cam.viewportWidth = viewportWidth;
////		cam.viewportHeight = viewportHeight;		
////		
//		
//		
//		cam.position.y += 1.0f * scale.y;
//		cam.update();
		//batch.setProjectionMatrix(cam.combined);
		//dy = dy + 1.0f * scale.y;// 
		
//		if (dy == -1.0) {
//			dy = cam.position.y;
//		} else {
//			dy -= 1.0f * scale.y;
//		}
//		
//		Gdx.gl.glViewport((int)cam.position.x, (int)dy, (int)size.x, (int)size.y);
		
		
		
		
//		
//		
//		
//		final OrthographicCamera cam = game.getCamera();
//		
//		Gdx.app.log("===", "gdx width = " + Gdx.graphics.getWidth() + " height = " + Gdx.graphics.getHeight());
//		
//		int width = Gdx.graphics.getWidth();
//		int height = Gdx.graphics.getHeight();
//		Vector2 size = new Vector2(scale.x * Gdx.graphics.getWidth(), scale.y * Gdx.graphics.getHeight()); 
//		
//		
////		cam.position.y = cam.position.y + 1;		
////		
////		
////		
////		Vector2 size = Scaling.fit.apply(WIDTH, HEIGHT, width, height);
////		
////		screenScaling = new Vector2(size.x / WIDTH, size.y / HEIGHT);
////		
//	    int viewportX = (int)(width) / 2;
//	    int viewportY = (int)(height) / 2;
//	    
//	    int viewportWidth = (int)width;
//	    int viewportHeight = (int)height;
//	    Gdx.gl20.glViewport(x, y, viewportWidth, viewportHeight);
////	    Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);
////
//////		float centerX = this.width / 2;
//////		float centerY = this.height / 2;
//		cam.position.set(viewportX, viewportY, 0);
//		cam.viewportWidth = viewportWidth;
//		cam.viewportHeight = viewportHeight;		
//		
//		
//		
//		
//		
//		cam.update();
//		game.getSpriteBatch().setProjectionMatrix(cam.combined);
//		
//		final OrthographicCamera camera = game.getCamera();
//		final SpriteBatch batch = game.getSpriteBatch();		
//		
//		camera.translate(0, 1, 0);
//		camera.update();
//		batch.setProjectionMatrix(camera.combined);		
		
		
		game.getSpriteBatch().disableBlending();
		game.getSpriteBatch().begin();
		y = 1.0f;// / scale.y;
		game.getSpriteBatch().draw(img, 0, y);
		game.getSpriteBatch().end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
