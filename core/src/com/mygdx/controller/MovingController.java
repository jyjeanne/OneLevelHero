package com.mygdx.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.badlogic.gdx.Gdx;

public class MovingController {

	String got;
	JSONParser parser = new JSONParser();
	JSONObject villages;
	String key1, key2, key3;
	String delimiter = "-";

	public MovingController() {

		//JSONArray dungeons = (JSONArray) Assets.worldmap_json.get("Village-1");
		//JSONObject dg1 = (JSONObject) dungeons.get(0);
		//JSONObject dg2 = (JSONObject) dungeons.get(1);
		//JSONObject monster = (JSONObject) dg1.get("Monster");
		//JSONObject event = (JSONObject) dg1.get("Event");

	}

	public String checkStage() {
		/*
		 * if (key == haveRight) return "right"; } if (key == haveLeft) { return
		 * "left"; } if (key == haveBoth) { return "twin"; }
		 */
		Gdx.app.log("Test", "checkDirection");
		return "checkDirection";
	}

	public void keyParser(String key) {
		String[] temp = key.split(delimiter);
		key1 = temp[0];
		key2 = temp[1];
		key3 = temp[2];
	}
}
