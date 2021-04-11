package generators;

import models.Invoice;

public interface Generator {
	public void setInvoice(Invoice invoice);
	public String execute(String path) throws Exception;
}
