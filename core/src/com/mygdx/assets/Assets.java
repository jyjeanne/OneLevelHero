package com.mygdx.assets;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.badlogic.gdx.Gdx;
import com.mygdx.enums.JsonEnum;
import com.mygdx.model.JsonStringFile;
import com.mygdx.util.JsonParser;

/**
 * 각종 리소스들을 관리해주는 assets 클래스, Stage및 Screen에 필요한 요소들을 전달해준다.
 *
 * @author Velmont
 *
 */
public class Assets {
	@Autowired
	private MusicAssets musicAssets;
	@Autowired
	private AtlasUiAssets atlasUiAssets;
	@Autowired
	private UiComponentAssets uiComponentAssets;
	@Autowired
	private EventAssets eventAssets;
	@Autowired
	private UnitAssets unitAssets;
	@Autowired
	private WorldMapAssets worldMapAssets;
	@Autowired
	private WorldNodeAssets worldNodeAssets;

	public void initialize() {
		Map<String, JsonStringFile> filePathMap = loadFilePathMap();
		Map<String, String> jsonStringMap = loadJsonStringMap(filePathMap);

		eventAssets.set(jsonStringMap);
		musicAssets.set(filePathMap);
		atlasUiAssets.set(filePathMap);
		uiComponentAssets.set(filePathMap);
		unitAssets.set(jsonStringMap);
		musicAssets.set(filePathMap);
		worldMapAssets.set(jsonStringMap);
		worldNodeAssets.set(jsonStringMap);
	}

	private Map<String, JsonStringFile> loadFilePathMap() {
		Map<String, JsonStringFile> filePathMap = JsonParser.parseMap(
				JsonStringFile.class,
				Gdx.files.internal("data/load/file_path.json").readString());
		return filePathMap;
	}

	private Map<String, String> loadJsonStringMap(
			Map<String, JsonStringFile> filePathMap) {
		Map<String, JsonStringFile> jsonFileMap = JsonParser.parseMap(
				JsonStringFile.class,
				filePathMap.get(JsonEnum.JSON_FILE_PATH.toString()).loadFile());
		Map<String, String> jsonStringMap = new HashMap<>();
		for (Entry<String, JsonStringFile> entry : jsonFileMap.entrySet())
			jsonStringMap.put(entry.getKey(), entry.getValue().loadFile());
		return jsonStringMap;
	}
}