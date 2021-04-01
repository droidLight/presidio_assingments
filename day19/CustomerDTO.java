package day19;

import java.io.Serializable;

public class CustomerDTO implements Serializable, Cloneable {

	private int customerId, phone;	
	private String customerName, address, accountDetails;
	private static CustomerDTO instance;

	private CustomerDTO() {
	}

	private CustomerDTO getCloneCustomerDTO() {
		try {
			return (CustomerDTO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	synchronized public static CustomerDTO getCustomerDTO() {
		if (instance == null) {
			instance = new CustomerDTO();
		}
		return instance.getCloneCustomerDTO();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountDetails == null) ? 0 : accountDetails.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + phone;
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
		CustomerDTO other = (CustomerDTO) obj;
		if (accountDetails == null) {
			if (other.accountDetails != null)
				return false;
		} else if (!accountDetails.equals(other.accountDetails))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (phone != other.phone)
			return false;
		return true;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(String accountDetails) {
		this.accountDetails = accountDetails;
	}
	
	public void clearData() {
		this.customerId = 0;
		this.phone =  0;	
		this.customerName = null;
		this.address = null;
		this.accountDetails = null;;
	}

}
