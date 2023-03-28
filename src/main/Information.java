package main;

import javax.swing.JTextArea;

import structs.*;

public abstract class Information {
	public void getCV(CV cv, JTextArea detail, JTextArea strength, JTextArea degree, JTextArea experience) {
		Details details = cv.getDetails();
		detail.setText("Personal details:");
		detail.append(details.getName() + "\n");
		detail.append(details.getAddress() + "\n");
		detail.append(details.getZip() + " " + details.getTown() + "\n");
		detail.append(details.getPhone() + "\n");
		detail.append(details.getEmail());
		
		String[] strengths = cv.getStrengths();
		strength.setText("Strengths:\n");
		for (int i = 0; i < strengths.length; i++) {
			if (strengths[i] != null) {
				strength.append(strengths[i] + "\n");
			}
		}
		
		Degree[] degrees = cv.getDegrees();
		degree.setText("Degrees:\n");
		for (int i = 0; i < degrees.length; i++) {
			if (degrees[i] != null) {
				Degree deg = degrees[i];
				degree.append(deg.getSchool() + "\n");
				degree.append(deg.getEducation() + ", " + deg.getDegree() + "\n");
				degree.append(deg.getStartYear() + " - " + deg.getEndYear() + "\n\n");
			}
		}
		
		Experience[] exps = cv.getExperience();
		experience.setText("Work experience:\n");
		for (int i = 0; i < exps.length; i++) {
			Experience exp = exps[i];
			experience.append(exp.getWorkplace() + "\n");
			experience.append(exp.getJob() + "\n");
			experience.append(exp.getLength() + ", " + exp.getMonth() + ", " + exp.getYear() + "\n\n");
		}
		
		
	}
}
