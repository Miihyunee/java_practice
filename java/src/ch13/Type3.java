package ch13;

public class Type3<T> {// <T> 가 아니어도 다른명칭으로 통일만 하면 됨 : 자료형을 말함
	T t;

	public void setT(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public static void main(String[] args) {
		Type3<String> t = new Type3<String>();
		t.setT("100");
		System.out.println(t.getT());
		Type3<Integer> t2 = new Type3<Integer>();
		t2.setT(100);
		System.out.println(t2.getT());
	}
}
