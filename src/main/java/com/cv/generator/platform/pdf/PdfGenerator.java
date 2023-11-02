package com.cv.generator.platform.pdf;

import com.cv.generator.platform.domain.Education;
import com.cv.generator.platform.domain.Job;
import com.cv.generator.platform.domain.User;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Element;
import com.itextpdf.text.BaseColor;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class PdfGenerator {

    public void generateCV(User user, List<Job> jobs, List<Education> educations) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("user_cv.pdf"));
        document.open();

        // Add user information
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Paragraph userSection = new Paragraph("User Information", font);
        userSection.setAlignment(Element.ALIGN_CENTER);
        document.add(userSection);

        document.add(new Paragraph("Name: " + user.getName()));
        document.add(new Paragraph("Email: " + user.getEmail()));
        document.add(new Paragraph("Phone Number: " + user.getPhoneNumber()));
        document.add(new Paragraph("Address: " + user.getAddress()));
        document.add(new Paragraph("Current Position: " + user.getCurrentPosition()));
        document.add(new Paragraph("Date of Birth: " + user.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));

        // Add job information
        Font jobFont = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
        Paragraph jobSection = new Paragraph("Job History", jobFont);
        jobSection.setAlignment(Element.ALIGN_CENTER);
        document.add(jobSection);

        PdfPTable jobTable = new PdfPTable(4);
        jobTable.setWidthPercentage(100);

        for (Job job : jobs) {
            PdfPCell cell = new PdfPCell(new Paragraph(job.getCompany(), FontFactory.getFont(FontFactory.COURIER_BOLD, 12, BaseColor.BLACK)));
            cell.setColspan(4);
            jobTable.addCell(cell);

            jobTable.addCell("Position: " + job.getPosition());
            jobTable.addCell("Start Date: " + job.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            jobTable.addCell("End Date: " + job.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            PdfPTable descriptionTable = new PdfPTable(1);
            descriptionTable.setWidthPercentage(100);
            PdfPCell descriptionCell = new PdfPCell(new Paragraph("Description: " + job.getJobDescription()));
            descriptionTable.addCell(descriptionCell);
            jobTable.addCell(descriptionTable);
        }

        document.add(jobTable);

        // Add education information
        Font educationFont = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
        Paragraph educationSection = new Paragraph("Education", educationFont);
        educationSection.setAlignment(Element.ALIGN_CENTER);
        document.add(educationSection);

        for (Education education : educations) {
            document.add(new Paragraph("Name: " + education.getName()));
            document.add(new Paragraph("Country: " + education.getCountry()));
            document.add(new Paragraph("County: " + education.getCounty()));
            document.add(new Paragraph("Diploma: " + education.getDiploma()));
            document.add(new Paragraph("Profile: " + education.getProfile()));
            document.add(new Paragraph("Start Date: " + education.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
            document.add(new Paragraph("End Date: " + education.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        }
        document.close();
    }
}

