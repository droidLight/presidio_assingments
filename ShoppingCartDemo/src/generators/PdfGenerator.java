package generators;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

import models.Invoice;

public class PdfGenerator implements Generator, Cloneable{
	
	private static PdfGenerator instance;
	Invoice invoice;
	
	private PdfGenerator() {}
	
	private PdfGenerator getClone() {
		PdfGenerator obj = null;
		try {
			obj = (PdfGenerator) super.clone();
		}catch(Exception e) {
			System.out.println("PdfGenerator: "+e);
		}
		return  obj;
	}
	private PdfGenerator clear() {
		this.invoice = null;
		return this;
	}
	
	public static PdfGenerator getInstance() {
		if(instance == null)
			instance = new PdfGenerator();
		return instance.getClone().clear();
	}
	
	@Override
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	@Override
	public String execute(String path) throws Exception {
		
		path = path + "invoice.pdf";
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
		
		
		table.addCell("Product");
		table.addCell("Quantity");
		table.addCell("Price");
		table.addCell("Total");
		
		double total =  0;
		for(int i = 0; i < invoice.getItemIds().size(); i++) {
			
			Integer quant = invoice.getQuantityList().get(i);
			Float price = invoice.getPriceList().get(i);
			
			table.addCell(invoice.getNameList().get(i));
			table.addCell(""+quant);
			table.addCell(""+price);
		
			double amount = price * quant;
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
		return path;
	}

	
	
}
