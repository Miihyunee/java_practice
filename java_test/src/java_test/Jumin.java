package java_test;

import java.util.Scanner;

public class Jumin {
	private String jumin;
	private int age;
	private char gender;
	private String strGender;
	private String nation;

	public Jumin() {
	}

	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("주민등록번호:");
		jumin = scan.nextLine();
	}

	public void setAge() {
		int base = 0;
		gender = jumin.charAt(7);
		switch (gender) {
		case '1':
		case '2':
		case '5':
		case '6':
			base = 1900;
			break;
		case '3':
		case '4':
		case '7':
		case '8':
			base = 2000;
			break;
		}
		age = 2021 - (base + Integer.parseInt(jumin.substring(0, 2)));
	}

	public void setNation() {
		if (gender >= '1' && gender <= '4') {
			nation = "내국인";
		} else if (gender >= '5' && gender <= '8') {
			nation = "외국인";
		}
	}

	public void setStrGender() {
		switch (gender) {
		case '1':
		case '3':
		case '5':
		case '7':
			strGender = "남";
			break;
		case '2':
		case '4':
		case '6':
		case '8':
			strGender = "여";
			break;
		}
	}

	public String toString() {
		String result = "국적:" + nation + "\n" + "나이:" + age + "\n" + "성별:" + strGender;
		return result;
	}

	public static void main(String[] args) {
		Jumin ex = new Jumin();
		ex.input();
		ex.setAge();
		ex.setStrGender();
		ex.setNation();
		System.out.println(ex);
	}
}