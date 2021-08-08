package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Escape extends ApplicationAdapter {

	//Screens available to be viewed in game
	enum Screen {
		TITLE_SCREEN, MENU_SCREEN, GAME_SCREEN
	}

	//sets start screen to TITLE_SCREEN
	Screen currentScreen = Screen.TITLE_SCREEN;

	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	BitmapFont font;

	float circleX = 300;
	float circleY = 150;
	float circleRadius = 50;

	float xSpeed = 4;
	float ySpeed = 3;

	@Override
	public void create() {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		font = new BitmapFont();

		Gdx.input.setInputProcessor(new InputAdapter() {

			@Override
			public boolean keyDown (int keyCode) {

				if(currentScreen == Screen.TITLE_SCREEN && keyCode == Input.Keys.SPACE){
					currentScreen = Screen.MENU_SCREEN;
				}
				else if(currentScreen == Screen.GAME_SCREEN && keyCode == Input.Keys.ENTER){
					currentScreen = Screen.TITLE_SCREEN;
				}

				return true;
			}

			@Override
			public boolean touchDown (int x, int y, int pointer, int button) {
				if(currentScreen == Screen.MENU_SCREEN){
					int renderY = Gdx.graphics.getHeight() - y;
					if(Vector2.dst(circleX, circleY, x, renderY) < circleRadius){
						currentScreen = Screen.GAME_SCREEN;
					}
				}
				return true;
			}
		});
	}

	@Override
	public void render() {
		if(currentScreen == Screen.TITLE_SCREEN){

			Gdx.gl.glClearColor(0, .25f, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			batch.begin();
			font.draw(batch, "Title Screen!", Gdx.graphics.getWidth()*.25f, Gdx.graphics.getHeight() * .75f);
			font.draw(batch, "Click the circle to win.", Gdx.graphics.getWidth()*.25f, Gdx.graphics.getHeight() * .5f);
			font.draw(batch, "Press space to play.", Gdx.graphics.getWidth()*.25f, Gdx.graphics.getHeight() * .25f);
			batch.end();
		}
		else if(currentScreen == Screen.MENU_SCREEN) {
			circleX += xSpeed;
			circleY += ySpeed;

			if (circleX < 0 || circleX > Gdx.graphics.getWidth()) {
				xSpeed *= -1;
			}

			if (circleY < 0 || circleY > Gdx.graphics.getHeight()) {
				ySpeed *= -1;
			}

			Gdx.gl.glClearColor(0, 0, .25f, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
			shapeRenderer.setColor(0, 1, 0, 1);
			shapeRenderer.circle(circleX, circleY, 75);
			shapeRenderer.end();
		}
		else if(currentScreen == Screen.GAME_SCREEN){
			Gdx.gl.glClearColor(.25f, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			batch.begin();
			font.draw(batch, "You win!", Gdx.graphics.getWidth()*.25f, Gdx.graphics.getHeight() * .75f);
			font.draw(batch, "Press enter to restart.", Gdx.graphics.getWidth()*.25f, Gdx.graphics.getHeight() * .25f);
			batch.end();
		}
	}

	@Override
	public void dispose () {
		shapeRenderer.dispose();
	}
}
