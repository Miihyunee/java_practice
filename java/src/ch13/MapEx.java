package ch13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapEx {
	public static void main(String[] args) {
		// <키 자료형, 값 자료형>
		Map<String, String> map = new HashMap<>();
		map.put("apple", "사과");
		System.out.println(map.get("apple"));
		map.put("grape", "포도");
		map.put("peach", "복숭아");
		System.out.println(map);// 순서대로 저장되지 않음
		String input = "grape";
		System.out.println(input + "==>" + map.get(input));

		// 반복처리를 하는 자료형 : Iterator
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) { // 다음 자료가 있으면 true
			String key = iterator.next();
			System.out.print("key=" + key);
			System.out.println(", value=" + map.get(key));
		}
	}
}
