package jdbc;

import java.util.List;
import java.util.Scanner;

public class ManageCar {
	// 필드변수, 프로퍼티 변수(클래스 전체에서 사용)
	CarDAO dao = new CarDAO();

	// 데이터 삭제
	void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 차량번호를 입력하세요:");
		String car_no = sc.nextLine();
		int result = dao.delete_car(car_no);
		if (result == 1) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("차량번호를 확인하세요.");
		}
	}

	// 데이터 추가
	void insert() {
		Scanner sc = new Scanner(System.in);
		System.out.print("차량번호:");
		String car_no = sc.nextLine();
		System.out.print("제조사:");
		String company = sc.nextLine();
		System.out.print("타입:");
		String type = sc.nextLine();
		System.out.print("제조연도:");
		int year = sc.nextInt();
		System.out.print("연비:");
		int efficiency = sc.nextInt();
		// 생성자에게 값 전달
		CarDTO dto = new CarDTO(car_no, company, type, year, efficiency);
		dao.insert_car(dto);
		System.out.println("추가되었습니다.");
	}

	// 목록 보기
	void list() {// 리턴값 없음
		// <> : 자료형 제한
		List<CarDTO> items = dao.list_car();
		System.out.println("차량번호\t\t연도\t제조사\t타입\t연비");
		System.out.println("============================================");

		// for(개별값 : 리스트)
		for (CarDTO dto : items) {// 전체자료 리턴받음
			System.out.print(dto.getCar_no() + "\t\t");
			System.out.print(dto.getYear() + "\t");
			System.out.print(dto.getCompany() + "\t");
			System.out.print(dto.getType() + "\t");
			System.out.print(dto.getEfficiency() + "\n");
		}
	}

	// 메인함수(1번째로 실행)
	public static void main(String[] args) {
		ManageCar car = new ManageCar();// 현재 클래스의 기능 사용을 위해, 인스턴스 생성
		Scanner sc = new Scanner(System.in);// 키보드 입력기능(in : InputStream)
		while (true) {// 무한반복
			System.out.println("작업을 선택하세요(1:목록 2:추가 3:삭제 0:종료):");
			int code = sc.nextInt();// 사용자가 입력한 키 입력값을 정수로 변환
			switch (code) {
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);// 프로그램 강제 종료(0:정상 종료)
				break;// 종료
			case 1:
				car.list();
				break;
			case 2:
				car.insert();
				break;
			case 3:
				car.delete();
				break;
			}
		}
	}
}
