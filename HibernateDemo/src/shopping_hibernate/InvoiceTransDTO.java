package shopping_hibernate;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="invoicetrans")
@Table(name="invoicetrans")
public class InvoiceTransDTO implements Serializable, Cloneable{

	@EmbeddedId
	private TransactionCompKey compkey;
	private int qty;	
	@Transient
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
		
	
	public TransactionCompKey getCompkey() {
		return compkey;
	}

	public void setCompkey(TransactionCompKey compkey) {
		this.compkey = compkey;
	}
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + compkey.getInvoiceId();
		result = prime * result + compkey.getItemId();
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
		if (compkey.getInvoiceId() != other.getCompkey().getInvoiceId())
			return false;
		if (compkey.getItemId() != other.getCompkey().getItemId())
			return false;
		if (qty != other.qty)
			return false;
		return true;
	}
}


//public int getInvoiceId() {
//return invoiceId;
//}
//
//public void setInvoiceId(int invoiceId) {
//this.invoiceId = invoiceId;
//}
//
//public int getItemId() {
//return itemId;
//}
//
//public void setItemId(int itemId) {
//this.itemId = itemId;
//}
