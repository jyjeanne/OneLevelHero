package com.mygdx.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.mygdx.assets.Assets;
import com.mygdx.currentState.MovingInfo;
import com.mygdx.currentState.PartyInfo;
import com.mygdx.currentState.PositionInfo;
import com.mygdx.currentState.TimeInfo;
import com.mygdx.factory.ScreenFactory;
import com.mygdx.manager.CameraManager;
import com.uwsoft.editor.renderer.Overlap2DStage;

public class BaseOverlapStage extends Overlap2DStage {
	@Autowired
	protected Assets assets;
	@Autowired
	protected ScreenFactory screenFactory;
	@Autowired
	protected CameraManager cameraManager;
	@Autowired
	protected PartyInfo partyInfo;
	@Autowired
	protected PositionInfo positionInfo;
	@Autowired
	protected TimeInfo timeInfo;
	@Autowired
	protected MovingInfo movingInfo;

	public Assets getAssets() {
		return assets;
	}

	public void setAssets(Assets assets) {
		this.assets = assets;
	}

	public ScreenFactory getScreenFactory() {
		return screenFactory;
	}

	public void setScreenFactory(ScreenFactory screenFactory) {
		this.screenFactory = screenFactory;
	}

	public CameraManager getCameraManager() {
		return cameraManager;
	}

	public void setCameraManager(CameraManager cameraManager) {
		this.cameraManager = cameraManager;
	}

	public PartyInfo getPartyInfo() {
		return partyInfo;
	}

	public void setPartyInfo(PartyInfo partyInfo) {
		this.partyInfo = partyInfo;
	}

	public PositionInfo getPositionInfo() {
		return positionInfo;
	}

	public void setPositionInfo(PositionInfo positionInfo) {
		this.positionInfo = positionInfo;
	}

	public TimeInfo getTimeInfo() {
		return timeInfo;
	}

	public void setTimeInfo(TimeInfo timeInfo) {
		this.timeInfo = timeInfo;
	}

	public MovingInfo getMovingInfo() {
		return movingInfo;
	}

	public void setMovingInfo(MovingInfo movingInfo) {
		this.movingInfo = movingInfo;
	}
}
