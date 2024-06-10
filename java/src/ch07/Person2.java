package ch07;

public class Person2 {
	private String name;
	private int age;
	private double height;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0 || age > 150) {
			System.out.println("error!");
		} else {
			this.age = age;
		}
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void print() {
		System.out.println("Name:" + name + ", Age:" + age + ", Height:" + height);
	}

}
