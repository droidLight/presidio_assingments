package day19;

import java.io.Serializable;
import java.sql.Date;

public class InvoiceTransDTO implements Serializable, Cloneable{

	private int invoiceId, itemId, qty;	
	private static InvoiceTransDTO instance;
	
	private InvoiceTransDTO() {}
	
	private InvoiceTransDTO createClone() {
		InvoiceTransDTO obj = null;
		try {
			obj = (InvoiceTransDTO)super.clone();
		}catch(Exception e) {}
		return obj;
	}
	
	synchronized public static InvoiceTransDTO getInvoiceTransDTO() {
		if(instance == null)
			instance = new InvoiceTransDTO();
		return instance.createClone();
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + invoiceId;
		result = prime * result + itemId;
		result = prime * result + qty;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceTransDTO other = (InvoiceTransDTO) obj;
		if (invoiceId != other.invoiceId)
			return false;
		if (itemId != other.itemId)
			return false;
		if (qty != other.qty)
			return false;
		return true;
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public void clearData() {
		this.invoiceId = 0;
		this.itemId = 0;
		this.qty = 0;	
	}
}
