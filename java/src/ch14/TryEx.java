package ch14;

public class TryEx {
	public static void main(String[] args) {
		int[] nums = { 10, 20, 30, 40, 50 };
		try {
			for (int i = 0; i <= nums.length; i++) {
				System.out.println(nums[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();// 스택추적정보 출력
		} finally { // 생략 가능, 항상 실행되는 부문
			System.out.println("finally");
		}
		System.out.println("종료");
	}
}
