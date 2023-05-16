package structs;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class CV {
	// Variable declarations
	public Details details;
	public String[] strengths;
	public Degree[] degrees;
	public String[] courses;
	public Experience[] experience;
	public String[] itSkills;
	public Language[] langs;
	public String[] hobbies;
	public String[] positions;
	public String[] referees;
	public String image;
	private PDFont font = PDType1Font.HELVETICA;
	
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
	
	public void BuildCV(CV cv) {
		PDDocument pdf = new PDDocument();
		PDPage page1 = new PDPage();
		pdf.addPage(page1);
		
		try {
			PDPageContentStream cs = new PDPageContentStream(pdf, page1);
			cs.beginText();
			cs.setFont(PDType1Font.HELVETICA, 12);
			cs.newLineAtOffset(100, 727);
			cs.showText(image);
			cs.newLineAtOffset(150, 727);
			cs.setLeading(14.5f);
			cs.showText(cv.details.name);
			cs.newLine();
			cs.showText(cv.details.address);
			cs.newLine();
			cs.showText(cv.details.zip + " " + cv.details.town);
			cs.newLine();
			cs.showText(cv.details.phone);
			cs.newLine();
			cs.showText(cv.details.email);
			cs.newLine();
			cs.showText(cv.details.other);
			
			cs.newLineAtOffset(345, 60);
			cs.showText("CV");
			
			cs.newLineAtOffset(-430, -110);
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Degrees");
			for(int i = 0; i < cv.degrees.length; i++) {
				if (cv.degrees[i] == null) break;
				cs.newLine();
				cs.showText("               " + cv.degrees[i].school);
				cs.newLine();
				cs.setFont(PDType1Font.HELVETICA, 12);
				cs.showText("               " + cv.degrees[i].degree + "," + cv.degrees[i].education);
				cs.newLine();
				cs.showText("               " + cv.degrees[i].startYear + "-" + cv.degrees[i].endYear);
				cs.newLine();
			}
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Strenghts");
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA, 12);
			for (int i = 0; i < cv.strengths.length; i++) {
				if (cv.strengths[i] == null) break;
				cs.showText("               " + cv.strengths[i]);
				cs.newLine();
			}
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Courses");
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA, 12);
			for(int i = 0; i < cv.courses.length; i++) {
				if (cv.courses[i] == null) break;
				cs.showText("               " + cv.courses[i]);
				cs.newLine();
			}
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Work Experience");
			for(int i = 0; i < cv.experience.length; i++) {
				if (cv.experience[i] == null) break;
				cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
				cs.showText("               " + cv.experience[i].workplace + ":");
				cs.newLine();
				cs.setFont(PDType1Font.HELVETICA, 12);
				cs.showText("               " + cv.experience[i].job + ", " + cv.experience[i].worktask);
				cs.newLine();
				cs.showText("               " + cv.experience[i].length);
				cs.newLine();
				cs.newLine();
			}
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("IT-Skills");
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA, 12);
			for(int i = 0; i < cv.itSkills.length; i++) {
				if (cv.itSkills[i] == null) break;
				cs.showText("               " + cv.itSkills[i]);
				cs.newLine();
			}
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Language Skills             Spoken   Written");
			cs.setFont(PDType1Font.HELVETICA, 12);
			cs.newLine();
			for(int i = 0; i < cv.langs.length; i++) {
				if (cv.langs[i] == null) break;
				cs.newLine();
				cs.showText("               " + cv.langs[i].langName);
				cs.newLine();
				if (cv.langs[i].nativeLang = false) cs.showText("               " + cv.langs[i].written + cv.langs[i].spoken);
				cs.newLine();
				if (cv.langs[i].nativeLang = true) cs.showText("               " + cv.langs[i].nativeLang + cv.langs[i].nativeLang);
				cs.newLine();
			}
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Hobbies          ");
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA, 12);
			for(int i = 0; i < cv.hobbies.length; i++) {
				if (cv.hobbies[i] == null) break;
				cs.showText(cv.hobbies[i] + ", ");
			}
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Positions");
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA, 12);
			for(int i = 0; i < cv.positions.length; i++) {
				if (cv.positions[i] == null) break;
				cs.showText("               " + cv.positions[i]);
				cs.newLine();
			}
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Referees");
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA, 12);
			for (int i = 0; i < cv.referees.length; i++) {
				if (cv.referees[i] == null) break;
				cs.showText("               " + cv.referees[i]);
				cs.newLine();
			}
			
			cs.endText();
			cs.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1);
		}
		
		PDDocumentInformation info = new PDDocumentInformation();
		info.setAuthor(cv.details.name);
		info.setTitle(cv.details.name + "'s " + "CV");
		info.setCreator(cv.details.name);
		
		pdf.setDocumentInformation(info);
		
		try {
			pdf.save("../cv.pdf");
			pdf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
			
		}
	}
}
