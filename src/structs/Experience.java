package structs;

public class Experience {
	// Variable declarations
	private String workplace;
	private String job;
	private String length;
	private String month;
	private int year;
	
	
	// Constructors
	public Experience() {
		this.setWorkplace("");
		this.setJob("");
		this.setLength("");
		this.setMonth("");
		this.setYear(1970);
	}
	public Experience(String workplace, String job, String length, String month, int year) {
		this.setWorkplace(workplace);
		this.setJob(job);
		this.setLength(length);
		this.setMonth(month);
		this.setYear(year);
	}
	
	
	// Getters and setters
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
