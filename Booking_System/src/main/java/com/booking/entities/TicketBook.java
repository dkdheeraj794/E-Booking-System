package com.booking.entities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

@Entity
public class TicketBook {

	@Id
	@GeneratedValue
	private int tickets_id;
	private int bussid_s;
	private String from_s;
	private String to_s;
	private String doj_s;
	private String departure_time;
	private String arrival_time;
	private String user_name;
	private String price_s;

	public int getTickets_id() {
		return tickets_id;
	}

	public void setTickets_id(int tickets_id) {
		this.tickets_id = tickets_id;
	}

	public int getBussid_s() {
		return bussid_s;
	}

	public void setBussid_s(int bussid_s) {
		this.bussid_s = bussid_s;
	}

	public String getFrom_s() {
		return from_s;
	}

	public void setFrom_s(String from_s) {
		this.from_s = from_s;
	}

	public String getTo_s() {
		return to_s;
	}

	public void setTo_s(String to_s) {
		this.to_s = to_s;
	}

	public String getDoj_s() {
		return doj_s;
	}

	public void setDoj_s(String doj_s) {
		this.doj_s = doj_s;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPrice_s() {
		return price_s;
	}

	public void setPrice_s(String price_s) {
		this.price_s = price_s;
	}

	public TicketBook(int tickets_id, int bussid_s, String from_s, String to_s, String doj_s, String departure_time,
			String arrival_time, String user_name, String price_s) {
		super();
		this.tickets_id = tickets_id;
		this.bussid_s = bussid_s;
		this.from_s = from_s;
		this.to_s = to_s;
		this.doj_s = doj_s;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.user_name = user_name;
		this.price_s = price_s;
	}

	public TicketBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Ticket [tickets_id=" + tickets_id + ", bussid_s=" + bussid_s + ", from_s=" + from_s + ", to_s=" + to_s
				+ ", doj_s=" + doj_s + ", departure_time=" + departure_time + ", arrival_time=" + arrival_time
				+ ", user_name=" + user_name + ", price_s=" + price_s + "]";
	}

	public byte[] generatePdf() throws IOException {
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);

		PDFont font = PDType1Font.HELVETICA_BOLD;
		int fontSize = 12;
		float leading = 1.5f * fontSize;

		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.setFont(font, fontSize);

		String title = "Ticket Details";
		contentStream.beginText();
		contentStream.newLineAtOffset(100, 700);
		contentStream.showText(title);
		contentStream.endText();

		contentStream.beginText();
		contentStream.newLineAtOffset(100, 650);
		contentStream.showText("Vehicle ID: " + bussid_s);
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("Source: " + from_s);
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("Destination: " + to_s);
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("Date of Journey: " + doj_s.toString());
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("Departure Time: " + departure_time.toString());
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("Arrival Time: " + arrival_time.toString());
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("User Name: " + user_name);
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("Price: " + price_s.toString());
		contentStream.endText();

		contentStream.close();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		document.save(outputStream);
		document.close();

		return outputStream.toByteArray();
	}

}
