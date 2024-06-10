package ch13;

// Ctrl + shift + O → 자동 import
import java.util.ArrayList;
import java.util.List;

public class ListEx {
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>(); // 사이즈 지정하지 않아도 자동으로 10개 배정
		list.add("one");
		list.add(2);
		list.add(5.5);
		list.add(false);
		list.add(3, 4); // 인덱스 3번에 값 4를 추가
		list.remove(0); // 인덱스 0 삭제
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + "\t");
		}

	}
}
