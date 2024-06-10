package quiz;

public class Gugudan {
	public static void main(String[] args) {
	/* cmd창에서 매개변수를 활용하여 컴파일 확인을 위한 소스 */
//		if (args.length == 0) {
//			System.out.println("사용방법: Gugudan 숫자");
//			System.exit(0);
//		}
		int dan = Integer.parseInt(args[0]);
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + "x" + i + "=" + dan * i);
		}
	}
}
