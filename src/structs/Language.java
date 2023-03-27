package structs;

public class Language {
	private String langName;
	private String spoken;
	private String written;
	
	public Language(String langName, String spoken, String written) {
		this.langName = langName;
		this.spoken = spoken;
		this.written = written;
	}
	
	// Getters and setters
	public String getLangName() {
		return langName;
	}
	public void setLangName(String langName) {
		this.langName = langName;
	}
	
	public String getSpoken() {
		return spoken;
	}
	public void setSpoken(String spoken) {
		this.spoken = spoken;
	}
	
	public String getWritten() {
		return written;
	}
	public void setWritten(String written) {
		this.written = written;
	}
}
