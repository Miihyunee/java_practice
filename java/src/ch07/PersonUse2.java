package ch07;

public class PersonUse2 {
	public static void main(String[] args) {
		Person2 p1 = new Person2();
		p1.setName("Kim");
		p1.setAge(50);
		// p1.setAge(500);
		p1.setHeight(180);
		System.out.println("Name: " + p1.getName());
		System.out.println("Age: " + p1.getAge());
		System.out.println("Height: " + p1.getHeight());
		p1.print();
	}
}
