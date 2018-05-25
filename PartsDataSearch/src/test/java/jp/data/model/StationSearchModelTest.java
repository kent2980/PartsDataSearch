package jp.data.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StationSearchModelTest {

	public static void main(String[] args) {
		Map<Integer,String> map1 = new HashMap<>();
		for(int i=0;i < 50;i++) {
			map1.put(i, String.valueOf("APP" + i + "0"));
		}
		Map<Integer,String> map2 = new HashMap<>();
		for(int i=51;i < 60;i++) {
			map2.put(i, String.valueOf("VPP" + i + "0"));
		}
		List<Map<Integer,String>> list = new ArrayList<>();
		list.add(map1);list.add(map2);
		StationSearchModel test = new StationSearchModel();
	}

}
