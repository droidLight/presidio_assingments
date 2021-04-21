package shopping_hibernate;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="item")
@Table(name="item")
public class ItemDTO implements Serializable, Cloneable {
	@Id
	private int itemId;
	private String itemName;
	private String itemUnit;
	private float price;
	@Transient
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
		return "ItemDTO [itemid=" + itemId + ", item_name=" + itemName + ", item_unit=" + itemUnit + ", price="
				+ price + "]";
	}

	public final int getItemid() {
		return itemId;
	}

	public final void setItemid(int itemid) {
		this.itemId = itemid;
	}

	public final String getItem_name() {
		return itemName;
	}

	public final void setItem_name(String item_name) {
		this.itemName = item_name;
	}

	public final String getItem_unit() {
		return itemUnit;
	}

	public final void setItem_unit(String item_unit) {
		this.itemUnit = item_unit;
	}

	public final float getPrice() {
		return price;
	}

	public final void setPrice(float price) {
		this.price = price;
	}

	public void clearData() {
		this.itemId = 0;
		this.itemName = null;
		this.itemUnit = null;
		this.price = 0f;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemUnit == null) ? 0 : itemUnit.hashCode());
		result = prime * result + itemId;
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
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemUnit == null) {
			if (other.itemUnit != null)
				return false;
		} else if (!itemUnit.equals(other.itemUnit))
			return false;
		if (itemId != other.itemId)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}

}
