package main;

import javax.swing.JTextArea;

import structs.*;

public abstract class Information {
	public void getCV(CV cv, JTextArea detail, JTextArea strength, JTextArea degree, JTextArea course, JTextArea experience, JTextArea itSkills, JTextArea languages, JTextArea hobbies, JTextArea positions, JTextArea referees) {
		Details details = cv.details;
		detail.setText("");
		detail.append("Name: " + details.name + "\n");
		detail.append("Address: " + details.address + "\n");
		detail.append("Town: " + details.town + ", " + details.zip + "\n");
		detail.append("Phone: " + details.phone + "\n");
		detail.append("Email: " + details.email + "\n");
		if (details.other.length() > 0) detail.append("Other: " + details.other);
		
		String[] strengths = cv.strengths;
		strength.setText("");
		for (int i = 0; i < strengths.length; i++) {
			if (strengths[i] != null) {
				strength.append(strengths[i] + "\n");
			}
		}
		
		Degree[] degrees = cv.degrees;
		degree.setText("");
		for (int i = 0; i < degrees.length; i++) {
			if (degrees[i] != null) {
				Degree deg = degrees[i];
				degree.append(deg.school + "\n");
				degree.append(deg.education + ", " + deg.degree + "\n");
				degree.append(deg.startYear + " - " + deg.endYear + "\n\n");
			}
		}
		
		String[] courses = cv.courses;
		course.setText("");
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] != null) {
				course.append(courses[i] + "\n");
			}
		}
		
		Experience[] exps = cv.experience;
		experience.setText("");
		for (int i = 0; i < exps.length; i++) {
			if (exps[i] != null) {
				Experience exp = exps[i];
				experience.append(exp.workplace + "\n");
				experience.append(exp.job + "\n");
				experience.append(exp.jobtitle + "\n");
				experience.append(exp.length + ", " + exp.date +  "\n\n");
			}
		}
		
		String[] it = cv.itSkills;
		itSkills.setText("");
		for (int i = 0; i < it.length; i++) {
			if (it[i] != null) {
				itSkills.append(it[i] + "\n");
			}
		}
		
		Language[] lang = cv.langs;
		languages.setText("");
		for (int i = 0; i < lang.length; i++) {
			if (lang[i] != null) {
				if (lang[i].nativeLang) languages.append("Native " + lang[i].langName + " speaker.\n\n");
				else {
					languages.append(lang[i].langName + ":\n");
					languages.append("- Speech: " + lang[i].spoken + "\n");
					languages.append("- Written: " + lang[i].written + "\n\n");
				}
			}
		}
		
		String[] hobby = cv.hobbies;
		hobbies.setText("");
		for (int i = 0; i < hobby.length; i++) {
			if (hobby[i] != null) {
				hobbies.append(hobby[i] + "\n");
			}
		}
		
		String[] position = cv.positions;
		positions.setText("");
		for (int i = 0; i < position.length; i++) {
			if (position[i] != null) {
				positions.append(position[i] + "\n");
			}
		}
		
		String[] referee = cv.referees;
		referees.setText("");
		for (int i = 0; i < referee.length; i++) {
			if (referee[i] != null) {
				referees.append(referee[i] + "\n");
			}
		}
	}
}
