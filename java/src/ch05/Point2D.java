package ch05;

public class Point2D {
	public static void main(String[] args) {
		int[][] point = { { 80, 90, 100, 0, 0 }, { 70, 60, 95, 0, 0 }, { 88, 77, 66, 0, 0 }, { 99, 89, 95, 0, 0 },
				{ 100, 60, 50, 0, 0 } };
		for (int i = 0; i < 5; i++) {
			point[i][3] = point[i][0] + point[i][1] + point[i][2]; // Tot
			point[i][4] = point[i][3] / 3; // Avg
		}
		System.out.println("Java\tDB\tMath\tTot\tAvg");
		System.out.println("====================================");
		for (int i = 0; i < 5; i++) {
			System.out.println(
					point[i][0] + "\t" + point[i][1] + "\t" + point[i][2] + "\t" + point[i][3] + "\t" + point[i][4]);
		}
	}
}
