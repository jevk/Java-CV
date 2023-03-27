package structs;

public class CV {
	// Variable declarations
	private Details details;
	private String[] strengths;
	private Degree[] degrees;
	private String[] courses;
	private Experience[] experience;
	private String[] itSkills;
	private Language[] langs;
	private String[] hobbies;
	private String[] positions;
	private String[] referees;
	
	
	// Constructors
	public CV() {
		this.details = new Details();
		this.strengths = new String[10];
		this.degrees = new Degree[10];
		this.courses = new String[10];
		this.experience = new Experience[10];
		this.itSkills = new String[10];
		this.langs = new Language[10];
		this.hobbies = new String[10];
		this.positions = new String[10];
		this.referees = new String[10];
	}
	
	
	// Getters and setters
	public String[] getStrengths() {
		return strengths;
	}
	public void setStrengths(String[] strengths) {
		this.strengths = strengths;
	}
	
	public Language[] getLanguages() {
		return langs;
	}
	public void setLanguages(Language[] langs) {
		this.langs = langs;
	}

	public Details getDetails() {
		return details;
	}
	public void setDetails(Details details) {
		this.details = details;
	}

	public Degree[] getDegrees() {
		return degrees;
	}
	public void setDegrees(Degree[] degrees) {
		this.degrees = degrees;
	}

	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	public Experience[] getExperience() {
		return experience;
	}
	public void setExperience(Experience[] experience) {
		this.experience = experience;
	}

	public String[] getItSkills() {
		return itSkills;
	}
	public void setItSkills(String[] itSkills) {
		this.itSkills = itSkills;
	}

	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String[] getPositions() {
		return positions;
	}
	public void setPositions(String[] positions) {
		this.positions = positions;
	}

	public String[] getReferees() {
		return referees;
	}
	public void setReferees(String[] referees) {
		this.referees = referees;
	}
}
