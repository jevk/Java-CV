package structs;

import java.io.IOException;

import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

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
			PDPageContentStream contentStream = new PDPageContentStream(pdf, page1);
			contentStream.beginText();
			contentStream.endText();
			contentStream.close();
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
			pdf.save("Desktop/" + details.name + "_cv.pdf");
			pdf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
