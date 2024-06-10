package ch01;
//패키지 - 디렉토리

/*public - 완전공개, private - 비공개 */

public class IntEx {//공개된 클래스
	public static void main(String[] args) {
   //메서드, 함수  static:정적인(바뀌지않음) void(비어있음, 결과값없음, 처리만)
  //String[] args : 파라미터, 인자, 매개변수, {} : 블록
		
		int a = 100; //정수형, 변수 = 값(같다x, 입력)
		System.out.println(a); //첫글자가 대문자면 클래스
		
		String str = "hello";
		System.out.println(str);
	}
}