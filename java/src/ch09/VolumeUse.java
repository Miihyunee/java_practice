package ch09;

public class VolumeUse {
	public static void main(String[] args) {
		Volume vol1 = new Volume();
		System.out.println("Volume:" + vol1.getVolume());

		Volume vol2 = new Volume(10, 20, 30);
		System.out.println("Volume:" + vol2.getVolume());
	}
}
