package com.example.groupactiontest;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGame implements ApplicationListener {

	SpriteBatch batch;
	
	ParticleEffect effect;//粒子效果类
	InputProcessor inputProcessor;
	float Position_X,Position_Y;
	
	TextureAtlas atlas;//应以一个TextureAtlas对象
	TextureRegion bgRegion;//定义一个TextureRegion对象.
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		
		atlas = new TextureAtlas(Gdx.files.internal("data/movebg.atlas"));//初始化TextureAtlas对象
		bgRegion = atlas.findRegion("movebg");//初始化TextureAtlas
		
		effect = new ParticleEffect();//初始化粒子效果类
		effect.load(Gdx.files.internal("data/test.p"), Gdx.files.internal("data/"));//加载粒子编辑器类文件
		
		inputProcessor = new InputProcessor() {
			
			@Override
			public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean touchDragged(int screen_X, int screen_Y, int pointer) {
				Position_X = screen_X;
				Position_Y = Gdx.graphics.getHeight() - screen_Y;
				
				return false;
			}
			
			@Override
			public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean scrolled(int arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean mouseMoved(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean keyUp(int arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean keyTyped(char arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean keyDown(int arg0) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		Gdx.input.setInputProcessor(inputProcessor);//为整个屏幕注册监听事件《一定要有,否则出不来效果
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		effect.setPosition(Position_X, Position_Y);//设置粒子的位置
		
		batch.begin();
		batch.draw(bgRegion, 0, 0, 480, 800);
		effect.draw(batch, Gdx.graphics.getDeltaTime());//绘制粒子效果
		batch.end();
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}
