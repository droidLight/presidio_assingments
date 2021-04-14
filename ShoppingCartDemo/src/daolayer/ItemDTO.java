package daolayer;

import java.io.Serializable;

public class ItemDTO implements Serializable, Cloneable {
	private int itemid;
	private String item_name;
	private String item_unit;
	private String imagePath;	
	private String category;
	private float price;
	private static ItemDTO itemDTO;

	private ItemDTO() {
	}

	private ItemDTO getCloneItemDTO() {
		try {
			return (ItemDTO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	synchronized public static ItemDTO getItemDTO() {
		if (itemDTO == null) {
			itemDTO = new ItemDTO();
		}
		return itemDTO.getCloneItemDTO();
	}

	@Override
	public String toString() {
		return "ItemDTO [itemid=" + itemid + ", item_name=" + item_name + ", item_unit=" + item_unit + ", price="
				+ price + "]";
	}

	public final int getItemid() {
		return itemid;
	}

	public final void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public final String getItemName() {
		return item_name;
	}

	public final void setItemName(String item_name) {
		this.item_name = item_name;
	}

	public final String getItemUnit() {
		return item_unit;
	}

	public final void setItemUnit(String item_unit) {
		this.item_unit = item_unit;
	}

	public final float getPrice() {
		return price;
	}

	public final void setPrice(float price) {
		this.price = price;
	}

	public void clearData() {
		this.itemid = 0;
		this.item_name = null;
		this.item_unit = null;
		this.price = 0f;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
		result = prime * result + ((item_unit == null) ? 0 : item_unit.hashCode());
		result = prime * result + itemid;
		result = prime * result + Float.floatToIntBits(price);
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
		ItemDTO other = (ItemDTO) obj;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		if (item_unit == null) {
			if (other.item_unit != null)
				return false;
		} else if (!item_unit.equals(other.item_unit))
			return false;
		if (itemid != other.itemid)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}

}