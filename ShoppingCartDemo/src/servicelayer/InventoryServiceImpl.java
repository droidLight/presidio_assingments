package servicelayer;

import java.util.List;

import daolayer.ItemDAO;
import daolayer.ItemDTO;

public class InventoryServiceImpl implements InventoryService, Cloneable{

	ItemDAO itemDAO;
	private static InventoryServiceImpl instance;
	
	private InventoryServiceImpl() {}
	
	private InventoryServiceImpl getClone() {
		InventoryServiceImpl obj = null;
		try {
			obj = (InventoryServiceImpl) super.clone();
		}catch(Exception e) {
			System.out.println("InventoryServiceImpl: "+e);
		}
		return obj;
	}
	
	synchronized public static InventoryServiceImpl getInstance(ItemDAO itemDAO) {
		if(instance == null)
			instance = new InventoryServiceImpl();
		return instance.getClone().setDAO(itemDAO);
	} 
	
	private InventoryServiceImpl setDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
		return this;
	}
	
	@Override
	public List<ItemDTO> getAllItems() throws Exception {		
		List<ItemDTO> itemList = this.itemDAO.getAll();
		return itemList;
	}

	@Override
	public ItemDTO getItem(Integer itemId) throws Exception {
		ItemDTO item = this.itemDAO.findById(itemId);		
		return item;
	}

	
	
}
