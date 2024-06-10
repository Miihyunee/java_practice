package ch16;

public class FlyerUse {
	public static void main(String[] args) {
		Flyer f = new Flyer() {

			@Override
			public void fly() {
				System.out.println("fly");
			}

			@Override
			public void takeOff() {
				System.out.println("take off");

			}

			@Override
			public void land() {
				System.out.println("land");

			}
		};
		f.takeOff();
		f.fly();
		f.land();
	}
}
