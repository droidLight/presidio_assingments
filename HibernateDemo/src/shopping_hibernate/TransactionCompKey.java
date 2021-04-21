package shopping_hibernate;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TransactionCompKey  implements Serializable{
	
	private int invoiceId;
	private int itemId;
	
	public TransactionCompKey() {}
	
	public TransactionCompKey(int invoiceId, int itemId) {
		this.invoiceId = invoiceId;
		this.itemId = itemId;
	}
	
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
}
