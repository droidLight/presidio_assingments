package rmi_services;

import java.util.List;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

public class PDFGenerator implements InvoiceGenerator, Cloneable {

	private static PDFGenerator instance;

	private PDFGenerator() {
	}

	public static PDFGenerator getInstance() {
		if (instance == null) {
			instance = new PDFGenerator();
		}
		PDFGenerator obj = instance.createClone();
		return obj;
	}

	private PDFGenerator createClone() {
		PDFGenerator obj = null;
		try {
			obj = (PDFGenerator) super.clone();
		} catch (Exception e) {
		}
		return obj;
	}

	
	@Override
	public void generate(List<String> productList, List<String> priceList, List<String> quantityList,
			List<String> taxList, List<String> unitList) throws Exception {
		 
		PdfWriter writer = new PdfWriter("./rmi_invoice.pdf");
		PdfDocument pdfDocument = new PdfDocument(writer);		
		pdfDocument.addNewPage();
		Document document = new Document(pdfDocument);
		
		//heading
		PdfFont titleFont = PdfFontFactory.createFont(StandardFonts.COURIER_BOLD);
        Paragraph docTitle = new Paragraph("Invoice").setMarginRight(1);
        docTitle.setFont(titleFont).setFontSize(11);
        docTitle.setTextAlignment(TextAlignment.CENTER);
        document.add(docTitle);
        
        //empty lines
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        
		// table
		float[] colWidth = {100F, 100F, 100F, 100F, 100F};
		Table table = new Table(colWidth);
		
		
		table.addCell("Product");
		table.addCell("Quantity");
		table.addCell("Price Ex.GST");
		table.addCell("GST");
		table.addCell("Price Inc.GST");
		
		double total =  0;
		for(int i = 0; i < productList.size(); i++) {
			table.addCell(productList.get(i));
			table.addCell(quantityList.get(i)+" "+unitList.get(i));
			table.addCell(priceList.get(i));
			table.addCell(taxList.get(i));
			double amount = Double.valueOf(quantityList.get(i)) * Double.valueOf(priceList.get(i));
			amount = amount + (amount * Double.valueOf(taxList.get(i)))/100;
			total +=amount;
			table.addCell(String.valueOf(amount));
		}
		
		table.addCell("");
		table.addCell("");
		table.addCell("Total Price");
		table.addCell(""+total);		
		document.add(table.setHorizontalAlignment(HorizontalAlignment.CENTER));
		
		
		document.close();
		System.out.println("PDF generated");
		
	}

}
