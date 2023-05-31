package structs;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.pdfbox.pdmodel.font.PDType1Font;

import rst.pdfbox.layout.elements.ControlElement;
import rst.pdfbox.layout.elements.Document;
import rst.pdfbox.layout.elements.ImageElement;
import rst.pdfbox.layout.elements.Paragraph;
import rst.pdfbox.layout.elements.render.ColumnLayout;
import rst.pdfbox.layout.elements.render.VerticalLayoutHint;
import rst.pdfbox.layout.text.Alignment;

import javax.swing.*;

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

	/*
	 * Adds a line break to the pdf document
	 */
	private void lineBreak(Document pdf) throws IOException {
		Paragraph p = new Paragraph();
		p.addText(" ", 12, PDType1Font.HELVETICA);
		pdf.add(p);
	}

	/*
	 * Adds a section to the pdf document
	 */
	private void addSectionString(String[] strings, String title, Document pdf) throws IOException {
		Paragraph p = new Paragraph();
		p.addText(title, 12, PDType1Font.HELVETICA_BOLD);
		pdf.add(new ColumnLayout(2, 0));
		pdf.add(p);
		pdf.add(ColumnLayout.NEWCOLUMN);

		p = new Paragraph();
		for (String s : strings) {
			if (s == null) break;
			p.addText(s + "\n", 12, PDType1Font.HELVETICA);
		}
		pdf.add(p);

		lineBreak(pdf);
	}

	/*
	 * Builds the CV into a pdf document
	 */
	public void BuildCV(CV cv) {
    	Locale l = new Locale(cv.LOCALE);
    	ResourceBundle r = ResourceBundle.getBundle("resources/Bundle_"+cv.LOCALE, l);
		
		Document pdf = new Document(40, 50, 40, 60);

		try {
			pdf.add(new ColumnLayout(3, 0));
			//Image
			if (image != null) {
				ImageElement ie = new ImageElement(cv.image);
				ie.setWidth(120);
				ie.setHeight(120);
				pdf.add(ie);
				lineBreak(pdf);
			}

			pdf.add(ColumnLayout.NEWCOLUMN);
			//Details
			Paragraph p = new Paragraph();
			p.addText(
			cv.details.name + "\n" +
				cv.details.address + "\n" +
				cv.details.zip + " " + cv.details.town + "\n" +
				cv.details.phone + "\n" +
				cv.details.email + "\n" +
				cv.details.other, 12, PDType1Font.HELVETICA
			);
			p.setAlignment(Alignment.Left);
			pdf.add(p, new VerticalLayoutHint(Alignment.Left, -10, 0, 0, 0));

			pdf.add(ColumnLayout.NEWCOLUMN);
			//Text "CV"
			lineBreak(pdf);
			p = new Paragraph();
			p.addText("CV", 12, PDType1Font.HELVETICA);
			p.setAlignment(Alignment.Right);
			pdf.add(p);
			lineBreak(pdf);
			addSectionString(cv.strengths, r.getString("strengths"), pdf);
			// Degrees
			lineBreak(pdf);
			p = new Paragraph();
			p.addText(r.getString("degrees"), 12, PDType1Font.HELVETICA_BOLD);
			pdf.add(new ColumnLayout(2, 0));
			pdf.add(p);
			pdf.add(ColumnLayout.NEWCOLUMN);

			p = new Paragraph();
			for (Degree d : cv.degrees) {
				if (d == null) break;
				String info = d.school + "\n" + d.education + "\n" + d.degree + "\n" + d.startYear + " - " + d.endYear;
				p.addText(info + "\n\n", 12, PDType1Font.HELVETICA);
			}
			pdf.add(p);
			lineBreak(pdf);
			addSectionString(cv.courses, r.getString("courses"), pdf);
			// Experience
			lineBreak(pdf);
			p = new Paragraph();
			p.addText(r.getString("experience"), 12, PDType1Font.HELVETICA_BOLD);
			pdf.add(new ColumnLayout(2, 0));
			pdf.add(p);
			pdf.add(ColumnLayout.NEWCOLUMN);

			p = new Paragraph();
			for (Experience w : cv.experience) {
				if (w == null) break;
				String info = w.workplace + "\n" + w.jobtitle + "\n" + w.job + ", " + w.worktask + "\n" + w.length;
				p.addText(info + "\n\n", 12, PDType1Font.HELVETICA);
			}
			pdf.add(p);
			lineBreak(pdf);
			addSectionString(cv.itSkills, r.getString("skills"), pdf);
			if (pdf.getPDDocument().getNumberOfPages() == 1) pdf.add(ControlElement.NEWPAGE);
			// Language
			lineBreak(pdf);
			p = new Paragraph();
			p.addText(r.getString("langSkill"), 12, PDType1Font.HELVETICA_BOLD);
			pdf.add(new ColumnLayout(2, 0));
			pdf.add(p);
			pdf.add(ColumnLayout.NEWCOLUMN);

			p = new Paragraph();
			for (Language lang : cv.langs) {
				if (lang == null) break;
				String info;
				if (!lang.nativeLang) {
					info = lang.langName +
					":\n  - " + r.getString("speech") + ": " + lang.spoken + "\n  - " + r.getString("written") + ": " + lang.written;
				}
				else {
					info = lang.langName +
					":\n  - " + r.getString("native");
				}
				p.addText(info + "\n\n", 12, PDType1Font.HELVETICA);
			}
			pdf.add(p);
			//Hobbies
			lineBreak(pdf);
			addSectionString(cv.hobbies, r.getString("hobbies"), pdf);
			lineBreak(pdf);
			//Posiotions
			addSectionString(cv.positions, r.getString("positions"), pdf);
			lineBreak(pdf);
			//references
			addSectionString(cv.referees, r.getString("references"), pdf);
			//File saving
			final OutputStream os = Files.newOutputStream(Paths.get("CV_" + cv.details.name + ".pdf"));

			try {
				pdf.save(os);
				JOptionPane.showMessageDialog(null, r.getString("save"));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e + " REEEEEEEEEE YOU FORGOR");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
