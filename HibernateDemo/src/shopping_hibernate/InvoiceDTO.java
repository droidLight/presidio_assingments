package shopping_hibernate;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="invoice")
@Table(name="invoice")
public class InvoiceDTO implements Serializable, Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int invoiceId;
	private int customerId;
	private Date invoiceDate;
	@Transient
	private static InvoiceDTO instance;

	private InvoiceDTO() {
	}

	private InvoiceDTO createClone() {
		InvoiceDTO obj = null;
		try {
			obj = (InvoiceDTO) super.clone();
		} catch (Exception e) {
		}
		return obj;
	}

	synchronized public static InvoiceDTO getInvoiceDTO() {
		if (instance == null)
			instance = new InvoiceDTO();

		return instance.createClone();
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void clearData() {
		this.invoiceId = 0;
		this.customerId = 0;
		this.invoiceDate = null;
	}

	@Override
	public String toString() {
		return "Invoice id: " + this.invoiceId + "\tCustomer id: " + this.customerId + "\tInvoice date: "
				+ this.invoiceDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		result = prime * result + ((invoiceDate == null) ? 0 : invoiceDate.hashCode());
		result = prime * result + invoiceId;
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
		InvoiceDTO other = (InvoiceDTO) obj;
		if (customerId != other.customerId)
			return false;
		if (invoiceDate == null) {
			if (other.invoiceDate != null)
				return false;
		} else if (!invoiceDate.equals(other.invoiceDate))
			return false;
		if (invoiceId != other.invoiceId)
			return false;
		return true;
	}
}
