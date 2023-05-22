package structs;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

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
	public PDImageXObject pdImage;
	public PDPage page1 = new PDPage(PDRectangle.LETTER);
	public String LOCALE;
	
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
    	Locale l = new Locale(cv.LOCALE);
    	ResourceBundle r = ResourceBundle.getBundle("locales/Bundle_"+cv.LOCALE, l);
		
		PDDocument pdf = new PDDocument();
		pdf.addPage(page1);
		
		try {
			PDPageContentStream cs = new PDPageContentStream(pdf, page1);
			if (image != null) {
				pdImage = PDImageXObject.createFromFile(image, pdf);
				cs.drawImage(pdImage, 40, 640, 100, 100);
			}
			cs.beginText();
			cs.setFont(PDType1Font.HELVETICA, 12);
//			cs.newLineAtOffset(margin, heightCounter - startX);
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
			cs.showText(r.getString("degrees"));
			for(int i = 0; i < cv.degrees.length; i++) {
				if (cv.degrees[i] == null) break;
				cs.showText("               " + cv.degrees[i].school);
				cs.newLine();
				cs.setFont(PDType1Font.HELVETICA, 12);
				cs.showText("                              " + cv.degrees[i].degree + "," + cv.degrees[i].education);
				cs.newLine();
				cs.showText("                              " + cv.degrees[i].startYear + "-" + cv.degrees[i].endYear);
				cs.newLine();
			}
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText(r.getString("strengths"));
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
			cs.showText(r.getString("courses"));
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
			cs.showText(r.getString("experience"));
			for(int i = 0; i < cv.experience.length; i++) {
				if (cv.experience[i] == null) break;
				cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
				cs.showText("               " + cv.experience[i].workplace + ":");
				cs.newLine();
				cs.setFont(PDType1Font.HELVETICA, 12);
				cs.showText("                              " + cv.experience[i].job + ", " + cv.experience[i].worktask);
				cs.newLine();
				cs.showText("                              " + cv.experience[i].length);
				cs.newLine();
				cs.newLine();
			}
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText(r.getString("skills"));
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
			String space = "      ";
			if (cv.LOCALE == "en") space = "    ";
			
			cs.showText(r.getString("langSkill")+"             "+r.getString("speech")+space+r.getString("written"));
			cs.setFont(PDType1Font.HELVETICA, 12);
			cs.newLine();
			for(int i = 0; i < cv.langs.length; i++) {
				if (cv.langs[i] == null) break;
				cs.newLine();
				cs.showText(cv.langs[i].langName);
				cs.newLine();
				cs.showText("               " + cv.langs[i].written + space + cv.langs[i].spoken);
				cs.newLine();
				cs.newLine();
			}
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText(r.getString("hobbies"));
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA, 12);
			for(int i = 0; i < cv.hobbies.length; i++) {
				if (cv.hobbies[i] == null) break;
				cs.showText(cv.hobbies[i] + ", ");
			}
			cs.newLine();
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
			cs.showText(r.getString("positions"));
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
			cs.showText(r.getString("references"));
			cs.newLine();
			cs.setFont(PDType1Font.HELVETICA, 12);
			for (int i = 0; i < cv.referees.length; i++) {
				if (cv.referees[i] == null) break;
				cs.showText("               " + cv.referees[i]);
				cs.newLine();
			}
			
			cs.endText();
			page1 = new PDPage(PDRectangle.LETTER);
			pdf.addPage(page1);
			cs.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1);
		}
		
		PDDocumentInformation info = new PDDocumentInformation();
		info.setAuthor(cv.details.name);
		info.setTitle(cv.details.name + r.getString("genitive") + " CV");
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
