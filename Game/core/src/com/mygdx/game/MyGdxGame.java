package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	BackGround bg;
	Person bird;
	Obstacles obstacles;
	boolean gameOver;
	Texture restartTexture;
	private static Obstacles.WallPair currentWallpair;
	private static int pairCounter;
	private BitmapFont FontRed1;
	private int score;

	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new BackGround();
		bird = new Person();
		obstacles = new Obstacles();
		gameOver = false;
		restartTexture = new Texture("restart.jpg");
		pairCounter = 0;
		currentWallpair = Obstacles.obs[pairCounter];
		FontRed1 = new BitmapFont();
		FontRed1.setColor(Color.RED);
		score = 0;
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		bg.render(batch);
		obstacles.render(batch);
		FontRed1.draw(batch, "score: "+score, 10, 20);
		if(!gameOver) {
			bird.render(batch);
		}else{
			batch.draw(restartTexture, 200, 200);
		}
		batch.end();
	}

	public void update(){
		bg.update();
		bird.update();
		obstacles.update();
		if(bird.pos.x > currentWallpair.position.x + 50){
			pairCounter++;
			if(pairCounter == 4){
				pairCounter = 0;
			}
			currentWallpair = Obstacles.obs[pairCounter];
		}
		for (int i = 0; i < Obstacles.obs.length; i++) {
			if(bird.pos.x > currentWallpair.position.x && bird.pos.x < currentWallpair.position.x + 50){
				if(currentWallpair.emptySpace.y >= bird.pos.y || currentWallpair.emptySpace.y + currentWallpair.emptySpace.height <= bird.pos.y) {
					gameOver = true;
				}
				else{
					score++;
				}
			}
			else{
				score++;
			}
		}
		if(bird.pos.y <0 || bird.pos.y > 600){
			gameOver = true;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver){
			recreate();
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	public void recreate(){
		bird.recreate();
		obstacles.recreate();
		gameOver = false;
		create();
	}
}
