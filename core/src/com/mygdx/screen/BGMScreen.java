package com.mygdx.screen;

import org.springframework.beans.factory.annotation.Autowired;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.assets.UiComponentAssets;
import com.mygdx.listener.SimpleTouchListener;

public class BGMScreen extends BaseScreen {
	@Autowired
	private UiComponentAssets uiComponentAssets;
	private Stage stage;
	private TextButton backButton;

	public BGMScreen() {
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		stage.draw();
	}

	@Override
	public void show() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		Table table = new Table(uiComponentAssets.getSkin());

		backButton = new TextButton("Back", uiComponentAssets.getSkin());

		backButton.addListener(new SimpleTouchListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				screenFactory.pop();
			}
		});

		table.setFillParent(true);
		table.add(backButton).bottom();
		table.row();

		stage.addActor(table);
	}
}
