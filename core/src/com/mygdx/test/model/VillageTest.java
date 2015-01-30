package com.mygdx.test.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.mygdx.enums.WorldNodeEnum;
import com.mygdx.manager.JsonParser;
import com.mygdx.model.Village;

public class VillageTest {
	private Map<String, Village> villageMap;

	@Before
	public void villageParseTest() throws IOException {

		String filePath = "../android/assets/data/map/village.json";

		Scanner in = new Scanner(new File(filePath));
		StringBuffer buffer = new StringBuffer();

		while (in.hasNext()) {
			buffer.append(in.next());
		}

		in.close();

		villageMap = JsonParser.parseMap(Village.class, buffer.toString());
	}

	@Test
	public void parseVillage() {
		assertThat(villageMap.get(WorldNodeEnum.BLACKWOOD.toString()),
				notNullValue());
		assertThat(villageMap.get(WorldNodeEnum.BLACKWOOD.toString())
				.getVillageName(), is("블랙우드"));
		assertThat(villageMap.get(WorldNodeEnum.BLACKWOOD.toString())
				.getVillageNpc().contains("waiji"), notNullValue());
		assertThat(villageMap.get(WorldNodeEnum.BLACKWOOD.toString())
				.getBuilding(), notNullValue());
	}
}
