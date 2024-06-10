package ch05;

public class Point1D {
	public static void main(String[] args) {
		String[] name = { "A", "B", "C", "D", "E" };
		int[] java = { 100, 80, 70, 60, 90 };
		int[] db = { 80, 90, 95, 85, 75 };
		int[] math = { 99, 89, 79, 69, 77 };
		int[] tot = { 0, 0, 0, 0, 0 };
		double[] avg = new double[5];
		for (int i = 0; i < 5; i++) {
			tot[i] = java[i] + db[i] + math[i];
			avg[i] = tot[i] / 3.0;
		}
		System.out.println("Name\tJava\tDB\tMath\tTot\tAvg");
		System.out.println("============================================");
		for (int i = 0; i < 5; i++) {
			System.out.println(name[i] + "\t" + java[i] + "\t" + db[i] + "\t" + math[i] + "\t" + tot[i] + "\t"
					+ String.format("%4.1f", avg[i]));
		}
	}
}
