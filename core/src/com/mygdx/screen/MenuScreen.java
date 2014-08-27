package com.mygdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.controller.ScreenController;
import com.mygdx.enums.ScreenEnum;
import com.mygdx.resource.Assets;
import com.mygdx.util.SoundManager;

public class MenuScreen implements Screen {
	Stage stage;
	ImageButton startButton;
	ImageButton optionsButton;
	ImageButton creditButton;
	ImageButton extraButton;
	Image logo;
	SpriteBatch batch;
	Sprite sprite;
	BitmapFont font;

	private static Music music;

	public MenuScreen() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		setMusic(Assets.mainMusic);
		getMusic().setVolume(Assets.musicVolume);
		SoundManager.getInstance().playMusic(getMusic());
		Texture texture = new Texture(Gdx.files.internal("texture/MainMenu_Background.png"));
		Image background = new Image(texture);

		stage = new Stage();
		Assets.loadSize(stage);
		Gdx.input.setInputProcessor(stage);
		Table table = new Table(Assets.skin);

		startButton = new ImageButton(Assets.start_before, Assets.start_after);
		optionsButton = new ImageButton(Assets.option_before, Assets.option_after);
		creditButton = new ImageButton(Assets.credit_before, Assets.credit_after);
		extraButton = new ImageButton(Assets.extra_before, Assets.extra_after);

		startButton.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				new ScreenController(ScreenEnum.LOAD);
			}
		});
		optionsButton.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				new ScreenController(ScreenEnum.OPTION);
			}
		});
		creditButton.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				new ScreenController(ScreenEnum.CREDIT);

			}
		});
		extraButton.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				new ScreenController(ScreenEnum.COLLETION);

			}
		});

		int realheight = (int) (Assets.realHeight);
		int realwidth = (int) (Assets.realWidth);

		Assets.logo.setHeight((int) (0.4f * Assets.realHeight));
		Assets.logo.setWidth((int) (0.6f * Assets.realWidth));
		table.setFillParent(true);

		table.add(extraButton).height(0.35f * realheight).width(0.3f * realwidth).expand().top().left();
		table.add(creditButton).height(0.35f * realheight).width(0.3f * realwidth).top().right();
		table.row();
		table.add(startButton).height(0.35f * realheight).width(0.3f * realwidth).bottom().left();
		table.add(optionsButton).height(0.35f * realheight).width(0.3f * realwidth).bottom().right();

		table.debug();
		table.debugTable();

		Assets.logo.setPosition((int) (0.2f * Assets.realWidth), (int) (0.3f * Assets.realHeight));

		background.setSize(realwidth, realheight);

		stage.addActor(background);
		stage.addActor(Assets.logo);

		stage.addActor(table);

	}

	@Override
	public void hide() {

		stage.dispose();

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

	public static Music getMusic() {
		return music;
	}

	public static void setMusic(Music music) {
		MenuScreen.music = music;
	}

}
