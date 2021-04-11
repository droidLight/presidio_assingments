package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import daolayer.ItemDAOImpl;
import daolayer.ItemDTO;
import servicelayer.InventoryServiceImpl;

public class Invoice implements Cloneable, Serializable{

	private static Invoice instance;
	String invoiceId;
	List<Integer> itemIds, quantityList;
	List<Float>priceList;
	List<String> nameList;
	
	private Invoice() {}
	
	private Invoice getClone() {
		Invoice obj = null;
		try {
			obj = (Invoice) super.clone();
		}catch(Exception e) {}
		return obj;
	}
	
	public static Invoice getInvoice() {
		if(instance == null)
			instance = new Invoice();
		return instance.getClone();
	}
	
	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public List<Integer> getItemIds() {
		return itemIds;
	}

	public void setItemIds(List<Integer> itemIds) {
		this.itemIds = itemIds;
	}

	public List<Float> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<Float> priceList) {
		this.priceList = priceList;
	}

	public List<Integer> getQuantityList() {
		return quantityList;
	}

	public void setQuantityList(List<Integer> quantityList) {
		this.quantityList = quantityList;
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

}
