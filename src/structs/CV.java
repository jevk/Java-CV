package structs;

import java.awt.TextArea;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import main.Languages;

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
//		getCV(cv, details, strengths, degrees, courses, langs, positions, referees);
		
		try {
			PDPageContentStream cs = new PDPageContentStream(pdf, page1);
			cs.beginText();
			cs.setFont(font, 12);
			cs.setLeading(7f);
			cs.newLineAtOffset(0, 0);
			cs.newLine();
			cs.showText("dasdjahdkh");

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
			cs.showText("Degrees               " /*+ cv.degrees*/);
	/*		cs.showText("School:");
			cs.newLine();
			cs.showText("Education:");
			cs.newLine();
			cs.showText("Degree:");
			cs.newLine();
			cs.showText("Starting Year:");
			cs.newLine();
			cs.showText("End Year:"); */
			cs.newLine();
			cs.showText("    " + cv.degrees[0]);
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Strenghts" /*+ cv.strengths*/);
			/*cs.showText("Your Strenghts:");*/
			cs.setFont(PDType1Font.HELVETICA, 12);
			cs.showText("               " + cv.strengths[0]);
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Courses");
			cs.setFont(PDType1Font.HELVETICA, 12);
			cs.showText("               " + cv.courses.toString());
			/*cs.showText("Your Courses:");*/
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Work Experience");
			cs.setFont(PDType1Font.HELVETICA, 12);
			cs.showText("               " + cv.experience);
			/*cs.newLine();
			cs.newLine();
			cs.showText("Workplace:");
			cs.newLine();
			cs.showText("Job:");
			cs.newLine();
			cs.showText("Lenght:");
			cs.newLine();
			cs.showText("Month:");
			cs.newLine();
			cs.showText("Year:");
			cs.newLine();
			cs.showText("Work task:");  */
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("IT-Skills");
			cs.setFont(PDType1Font.HELVETICA, 12);
			cs.showText("               " + cv.itSkills);
//			cs.newLine();
//			cs.showText("Programs you can use: ");
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Language Skills");
//			cs.setFont(PDType1Font.HELVETICA, 12);
//			cs.showText("               " + cv.langs);
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Hobbies");
			cs.setFont(PDType1Font.HELVETICA, 12);
			cs.showText("               " + cv.hobbies);
			cs.newLine();
//			hobbies = cv.hobbies;
//			cv.hobbies = hobbies;
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Positions");
//			cs.setFont(PDType1Font.HELVETICA, 12);
//			cs.showText("               " + cv.positions);
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText("Referees");
			cs.setFont(PDType1Font.HELVETICA, 12);
			cs.newLine();
//			cs.showText("               " + cv.referees.toString());
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
		
		for (int i = 0; i < cv.strengths.length; i++) {
			System.out.println(cv.strengths[i]);
		}
	}
	
/*	    for(int i = 0; i < cv.positions.length; i++) {
        	System.out.println(cv.positions[i]); 
	}
}    */

		// TODO Auto-generated method stub 
		
	} 
