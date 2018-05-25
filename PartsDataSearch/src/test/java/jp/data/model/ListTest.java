package jp.data.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTest {

	public static void main(String[] args) {
		Map<Integer,String> map1 = new HashMap<>();
		Map<Integer,String> map2 = new HashMap<>();

		for(int i = 0; i < 10; i++) {
			map1.put(i, String.valueOf((char)0x304 + i));
		}

		for(int i = 10; i < 20; i++) {
			map2.put(i, String.valueOf((char)0x61 + i));
		}

		List<Map<Integer,String>> list = new ArrayList<>();
		list.add(map1);
		list.add(map2);

		list.stream()
			.flatMap(s->s.entrySet().stream())
			.map(s->s.getValue())
			.forEach(System.out::println);

	}

}
