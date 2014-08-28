package com.mygdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.battle.Fight;
import com.mygdx.game.OneLevelHero;
import com.mygdx.stage.BattleStage;
import com.mygdx.ui.GameUi;
import com.mygdx.util.CurrentManager;

public class BattleScreen implements Screen {

	OneLevelHero game;
	GameUi uiTable;
	BattleStage battleStage;
	Fight fight; // 실제 전투가 일어나는 알고리즘 담당.
	TextButton fightButton;
	TextButton fleeButton;
	boolean a;

	public BattleScreen() {
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		battleStage.draw();
		uiTable.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		battleStage = new BattleStage();
		uiTable = new GameUi();
		fight = new Fight(CurrentManager.getInstance().getCurrentDungeon());

		InputMultiplexer multiplexer = new InputMultiplexer();
		
		multiplexer.addProcessor(0, uiTable);
		multiplexer.addProcessor(1, battleStage);
		
		Gdx.input.setInputProcessor(multiplexer);
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		Gdx.app.log("DEBUG","BattleScreen hide");
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
