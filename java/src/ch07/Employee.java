package ch07;

public class Employee {
	private String name; //전역변수, 멤버변수, 프로퍼티 변수
	private int basic;
	private int bonus;
	private int total;
	private int tax;
	private int salary;

	public void input(String name, int basic) { //지역변수(함수안에서만 사용)
		this.name = name;
		this.basic = basic;
	}

	public void calc() {
		bonus = basic * 3;
		total = basic + bonus;
		tax = (int) (total * 0.033);
		salary = total - tax;
	}

	public void print() {
		System.out.println("Name:" + name);
		System.out.println("Basic:" + basic);
		System.out.println("Bonus:" + bonus);
		System.out.println("Total:" + total);
		System.out.println("Tax:" + tax);
		System.out.println("Salary:" + salary);
	}
}
