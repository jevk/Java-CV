package main;

import javax.swing.JTextArea;

import structs.*;

public abstract class Information {
	public void getCV(CV cv, JTextArea detail, JTextArea strength, JTextArea degree, JTextArea experience, JTextArea itSkills, JTextArea languages, JTextArea hobbies, JTextArea positions, JTextArea referees) {
		Details details = cv.details;
		detail.setText("Personal details:\n");
		detail.append("Name: " + details.name + "\n");
		detail.append("Address: " + details.address + "\n");
		detail.append("Town: " + details.town + ", " + details.zip + "\n");
		detail.append("Phone: " + details.phone + "\n");
		detail.append("Email: " + details.email);
		
		String[] strengths = cv.strengths;
		strength.setText("Strengths:\n");
		for (int i = 0; i < strengths.length; i++) {
			if (strengths[i] != null) {
				strength.append(strengths[i] + "\n");
			}
		}
		
		Degree[] degrees = cv.degrees;
		degree.setText("Degrees:\n");
		for (int i = 0; i < degrees.length; i++) {
			if (degrees[i] != null) {
				Degree deg = degrees[i];
				degree.append(deg.school + "\n");
				degree.append(deg.education + ", " + deg.degree + "\n");
				degree.append(deg.startYear + " - " + deg.endYear + "\n\n");
			}
		}
		
		Experience[] exps = cv.experience;
		experience.setText("Work experience:\n");
		for (int i = 0; i < exps.length; i++) {
			if (exps[i] != null) {
				Experience exp = exps[i];
				experience.append(exp.workplace + "\n");
				experience.append(exp.job + "\n");
				experience.append(exp.length + ", " + exp.month + ", " + exp.year + "\n\n");
			}
		}
		
		String[] it = cv.itSkills;
		itSkills.setText("IT Skills:\n");
		for (int i = 0; i < it.length; i++) {
			if (it[i] != null) {
				itSkills.append(it[i]);
			}
		}
		
		Language[] lang = cv.langs;
		languages.setText("Languages:\n");
		for (int i = 0; i < lang.length; i++) {
			if (lang[i] != null) {
				languages.append(lang[i].langName + ":\n");
				languages.append(lang[i].spoken + ":\n");
				languages.append(lang[i].written + ":\n");
			}
		}
		
		String[] hobby = cv.hobbies;
		hobbies.setText("Hobbies:\n");
		for (int i = 0; i < hobby.length; i++) {
			if (hobby[i] != null) {
				hobbies.append(hobby[i] + "\n");
			}
		}
		
		String[] position = cv.positions;
		positions.setText("Positions:\n");
		for (int i = 0; i < position.length; i++) {
			if (position[i] != null) {
				positions.append(position[i]);
			}
		}
	}
}
