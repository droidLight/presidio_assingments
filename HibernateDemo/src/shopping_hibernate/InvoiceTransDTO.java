package shopping_hibernate;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="invoicetrans")
@Table(name="invoicetrans")
public class InvoiceTransDTO implements Serializable, Cloneable{

	/*@EmbeddedId	
	private TransactionCompKey compkey;*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	
	private int itemId;	
	private int qty;	
	
	@ManyToOne
	@JoinColumn(name = "invoiceId")
	private InvoiceDTO invoice;
	
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
		
	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public InvoiceDTO getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceDTO invoice) {
		this.invoice = invoice;
	}
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
		
}

//public TransactionCompKey getCompkey() {
//return compkey;
//}
//
//public void setCompkey(TransactionCompKey compkey) {
//this.compkey = compkey;
//}