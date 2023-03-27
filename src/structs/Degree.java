package structs;

public class Degree {
	// Variable declarations
	private String school;
	private String education;
	private String degree;
	private int startYear;
	private int endYear;
	
	
	// Constructors
	public Degree() {
		this.setSchool("");
		this.setEducation("");
		this.setDegree("");
		this.setStartYear(1970);
		this.setEndYear(1970);
	}
	public Degree(String school, String education, String degree, int startYear) {
		this.setSchool(school);
		this.setEducation(education);
		this.setDegree(degree);
		this.setStartYear(startYear);
		this.setEndYear(startYear + 3);
	}
	public Degree(String school, String education, String degree, int startYear, int endYear) {
		this.setSchool(school);
		this.setEducation(education);
		this.setDegree(degree);
		this.setStartYear(startYear);
		this.setEndYear(endYear);
	}
	
	// Getters and setters
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public int getStartYear() {
		return startYear;
	}
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	
	public int getEndYear() {
		return endYear;
	}
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
}
