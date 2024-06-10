package ch11;

public class Drone implements Flyer {
	@Override
	public void takeOff() {
		System.out.println("Drone 이륙");
	}

	@Override
	public void fly() {
		System.out.println("Drone 비행");
	}

	@Override
	public void land() {
		System.out.println("Drone 착륙");
	}
}
