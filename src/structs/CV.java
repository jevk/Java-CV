package structs;

import java.io.IOException;

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
			cs.setFont(font, 12);
			cs.setLeading(7f);
			cs.newLineAtOffset(0, 0);
			cs.newLine();
			cs.showText("dasdjahdkh");

			cs.newLineAtOffset(25, 727);
			cs.setLeading(14.5f);
			cs.showText("Walter Hartwell White");
			cs.newLine();
			cs.showText("308 Negra Arroyo Lane");
			cs.newLine();
			cs.showText("Albuquerque, New Mexico");
			
			cs.endText();
			cs.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PDDocumentInformation info = new PDDocumentInformation();
		info.setAuthor(cv.details.name);
		info.setTitle(cv.details.name + "'s " + "CV");
		info.setCreator(cv.details.name);
		
		pdf.setDocumentInformation(info);
		
		try {
			pdf.save("C:/Users/Jesper.Kemppainen/Documents/test/cv.pdf");
			pdf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
