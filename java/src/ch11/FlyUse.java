package ch11;

public class FlyUse {
	public static void main(String[] args) {
		Flyer f = new Drone();//다형성
		//left side(좌변), 상위자료형	=	right side(우변), 하위자료형
		f.takeOff();
		f.fly();
		f.land();
		f = new Airplane();
		f.takeOff();
		f.fly();
		f.land();
	}
}
