package com.mygdx.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.currentState.PositionInfo;
import com.mygdx.enums.ScreenEnum;
import com.mygdx.manager.CameraManager.CameraPosition;
import com.mygdx.state.StaticAssets;
import com.uwsoft.editor.renderer.actor.CompositeItem;

/**
 * @author Velmont
 *
 */
public class DungeonStage extends BaseOverlapStage {
	@Autowired
	private PositionInfo positionInfo; // 나중에 쓸거임 지우지 마셈
	private CompositeItem arrowUp, arrowDown, arrowLeft, arrowRight;

	public Stage makeStage() {
		initSceneLoader(StaticAssets.rm);

		makeScene();
		setButton();

		return this;
	}

	private void makeScene() {
		// 우선은 blackwood_forest_dungeon_scene으로 통일하자
		sceneLoader.loadScene("blackwood_forest_dungeon_scene");
		cameraManager.setCameraSize(this, CameraPosition.BELOW_GAME_UI);
		addActor(sceneLoader.getRoot());
	}

	private void setButton() {
		arrowUp = sceneLoader.getRoot().getCompositeById("arrow_up");
		arrowDown = sceneLoader.getRoot().getCompositeById("arrow_down");
		arrowLeft = sceneLoader.getRoot().getCompositeById("arrow_left");
		arrowRight = sceneLoader.getRoot().getCompositeById("arrow_right");

		arrowUp.setTouchable(Touchable.enabled);
		arrowUp.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				Gdx.app.debug("DungeonStage", "앞으로 이동");
			}
		});

		arrowDown.setTouchable(Touchable.enabled);
		arrowDown.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				Gdx.app.debug("DungeonStage", "뒤로 이동");
				screenFactory.show(ScreenEnum.DUNGEON_ENTRANCE);
			}
		});

		arrowLeft.setTouchable(Touchable.enabled);
		arrowLeft.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				Gdx.app.debug("DungeonStage", "왼쪽으로 이동");
			}
		});

		arrowRight.setTouchable(Touchable.enabled);
		arrowRight.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				Gdx.app.debug("DungeonStage", "오른쪽으로 이동");
			}
		});
	}

	public PositionInfo getPositionInfo() {
		return positionInfo;
	}

	public void setPositionInfo(PositionInfo positionInfo) {
		this.positionInfo = positionInfo;
	}
}