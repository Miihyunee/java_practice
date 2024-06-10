package jdbc;

public class CarDTO {
	private String car_no;
	private String company;
	private String type;
	private int year;
	private int efficiency;

	public String getCar_no() {
		return car_no;
	}

	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(int efficiency) {
		this.efficiency = efficiency;
	}

	@Override
	public String toString() {
		return "CarDTO [car_no=" + car_no + ", company=" + company + ", type=" + type + ", year=" + year
				+ ", efficiency=" + efficiency + "]";
	}

	public CarDTO() {
	}

	public CarDTO(String car_no, String company, String type, int year, int efficiency) {
		this.car_no = car_no;
		this.company = company;
		this.type = type;
		this.year = year;
		this.efficiency = efficiency;
	}

}
