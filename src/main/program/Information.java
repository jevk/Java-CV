package program;

import structs.*;

import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class Information {

	public void getCV(CV cv, JTextArea detail, JTextArea strength, JTextArea degree, JTextArea course, JTextArea experience, JTextArea itSkills, JTextArea languages, JTextArea hobbies, JTextArea positions, JTextArea referees) {
		String lang1 = cv.LOCALE;
    	Locale l = new Locale(lang1);
    	ResourceBundle r = ResourceBundle.getBundle("resources/Bundle_" + lang1, l);
    	
		Details details = cv.details;
		detail.setText("");
		detail.append(r.getString("name") + " " + details.name + "\n");
		detail.append(r.getString("address") + " " + details.address + "\n");
		detail.append(r.getString("town") + " " + details.town + ", " + details.zip + "\n");
		detail.append(r.getString("phone") + " " + details.phone + "\n");
		detail.append(r.getString("email") + " " + details.email + "\n");
		if (details.other.length() > 0) detail.append("Other: " + details.other);
		
		String[] strengths = cv.strengths;
		strength.setText("");
		for (String s : strengths) {
			if (s != null) {
				strength.append(s + "\n");
			}
		}
		
		Degree[] degrees = cv.degrees;
		degree.setText("");
		for (Degree value : degrees) {
			if (value != null) {
				degree.append(value.school + "\n");
				degree.append(value.education + ", " + value.degree + "\n");
				degree.append(value.startYear + " - " + value.endYear + "\n\n");
			}
		}
		
		String[] courses = cv.courses;
		course.setText("");
		for (String course1 : courses) {
			if (course1 != null) {
				course.append(course1 + "\n");
			}
		}
		
		Experience[] exp = cv.experience;
		experience.setText("");
		for (Experience value : exp) {
			if (value != null) {
				experience.append(value.workplace + "\n");
				experience.append(value.job + "\n");
				experience.append(value.jobtitle + "\n");
				experience.append(value.length + "\n\n");

			}
		}
		
		String[] it = cv.itSkills;
		itSkills.setText("");
		for (String s : it) {
			if (s != null) {
				itSkills.append(s + "\n");
			}
		}
		
		Language[] lang = cv.langs;
		languages.setText("");
		for (Language language : lang) {
			if (language != null) {
				if (language.nativeLang) {
					languages.append(language.langName + ":\n");
					languages.append("- " + r.getString("speech") + ":" + r.getString("native") + "\n");
					languages.append("- " + r.getString("written") + ":" + r.getString("native") + "\n\n");
				} else {
					languages.append(language.langName + ":\n");
					languages.append("- " + r.getString("speech") + ":" + language.spoken + "\n");
					languages.append("- " + r.getString("written") + ":" + language.written + "\n\n");
				}
			}
		}
		
		String[] hobby = cv.hobbies;
		hobbies.setText("");
		for (String s : hobby) {
			if (s != null) {
				hobbies.append(s + "\n");
			}
		}
		
		String[] position = cv.positions;
		positions.setText("");
		for (String s : position) {
			if (s != null) {
				positions.append(s + "\n");
			}
		}
		
		String[] referee = cv.referees;
		referees.setText("");
		for (String s : referee) {
			if (s != null) {
				referees.append(s + "\n");
			}
		}
	}
}
