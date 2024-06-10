package ch12;

public class StringEx {
	public static void main(String[] args) {
		String str = "Hello Java";
		System.out.println(str);
		System.out.println(str.toUpperCase());// 대문자로 변경
		System.out.println(str.toLowerCase());// 소문자로 변경
		System.out.println(str);// 그대로
		str = str.toLowerCase();
		System.out.println(str);

		str = "";// 빈문자열
		System.out.println(str);
		str = null;// 가리키는 내용 없음
		System.out.println(str);

		char ch = '\0';// null character : 문자열의 끝을 표시
		System.out.println(ch + ",code:" + (int) ch);
		ch = ' ';// 스페이스(코드번호 :32)
		System.out.println(ch + ",code:" + (int) ch);
	}
}
