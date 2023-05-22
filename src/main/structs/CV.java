package structs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

	private void lineBreak(Document pdf) throws IOException {
		Paragraph p = new Paragraph();
		p.addText(" ", 12, PDType1Font.HELVETICA);
		pdf.add(p);
	}

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

	public void BuildCV(CV cv) {
    	Locale l = new Locale(cv.LOCALE);
    	ResourceBundle r = ResourceBundle.getBundle("Bundle_"+cv.LOCALE, l);

		Document pdf = new Document(40, 50, 40, 60);

		try {
			pdf.add(new ColumnLayout(3, 0));
			if (image != null) {
				ImageElement ie = new ImageElement(cv.image);
				ie.setWidth(120);
				ie.setHeight(120);
				pdf.add(ie);
			}

			pdf.add(ColumnLayout.NEWCOLUMN);

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

			p = new Paragraph();
			p.addText("CV", 20, PDType1Font.HELVETICA_BOLD);
			p.setAlignment(Alignment.Right);
			pdf.add(p);

			p = new Paragraph();
			p.addText(" ", 12, PDType1Font.HELVETICA);
			pdf.add(p);

			// String based sections
			addSectionString(cv.strengths, r.getString("strengths"), pdf);
			addSectionString(cv.positions, r.getString("positions"), pdf);
			addSectionString(cv.courses, r.getString("courses"), pdf);
			addSectionString(cv.itSkills, r.getString("skills"), pdf);
			if (pdf.getPDDocument().getNumberOfPages() == 1) pdf.add(ControlElement.NEWPAGE);
			addSectionString(cv.hobbies, r.getString("hobbies"), pdf);
			addSectionString(cv.referees, r.getString("references"), pdf);
			pdf.add(ControlElement.NEWPAGE);

			// Struct based sections
			// Degrees
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
				String info = lang.langName +
						":\n  - " + r.getString("speech")+ ": " + lang.spoken +
						"\n  - " + r.getString("written")+ ": " + lang.written;
				p.addText(info + "\n\n", 12, PDType1Font.HELVETICA);
			}
			pdf.add(p);

			final OutputStream os = new FileOutputStream("CV_" + cv.details.name + ".pdf");

			try {
				pdf.save(os);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e + " REEEEEEEEEE YOU FORGOR");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}