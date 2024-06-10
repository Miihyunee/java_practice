package ch05;

public class Args {
	public static void main(String[] args) {
		System.out.println("명령형 매개변수 개수:" + args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
}
