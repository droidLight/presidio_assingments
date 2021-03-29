package invoice_generator;

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
	private TaxReport taxReport;

	private PDFGenerator() {
	}

	public static PDFGenerator getInstance(TaxReport taxReport) {
		if (instance == null) {
			instance = new PDFGenerator();
		}
		PDFGenerator obj = instance.createClone();
		obj.taxReport = taxReport;
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
	public void generate(String path) throws Exception {
		
		PdfWriter writer = new PdfWriter(path);
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
		float[] colWidth = {100F, 100F, 100F, 100F};
		Table table = new Table(colWidth);
		
		List<String> productList = this.taxReport.getProductList();
		List<Double> priceList = this.taxReport.getPriceList();
		List<Double> priceAfterTax = this.taxReport.getPriceListAfterTax();
		List<Double> taxList = this.taxReport.getTaxList();
		
		table.addCell("Product");
		table.addCell("Price Ex.GST");
		table.addCell("GST");
		table.addCell("Price Inc.GST");
		
		for(int i = 0; i < productList.size(); i++) {
			table.addCell(productList.get(i));
			table.addCell(String.valueOf(priceList.get(i)));			
			table.addCell(String.valueOf(taxList.get(i)));
			table.addCell(String.valueOf(priceAfterTax.get(i)));
		}
		table.addCell("");
		table.addCell("");
		table.addCell("Total Price");
		table.addCell(""+this.taxReport.getTotalAmount());		
		document.add(table.setHorizontalAlignment(HorizontalAlignment.CENTER));
		
		
		document.close();
		System.out.println("PDF generated");
	}

}
