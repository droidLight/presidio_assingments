package servicelayer;

import java.util.List;
import daolayer.ItemDTO;

public interface InventoryService {
	
	List<ItemDTO> getAllItems() throws Exception;
	List<ItemDTO> getByCategory(String category) throws Exception;
	ItemDTO getItem(Integer itemId) throws Exception;
}
