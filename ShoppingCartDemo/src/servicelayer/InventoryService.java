package servicelayer;

import java.util.List;
import daolayer.ItemDTO;

public interface InventoryService {
	
	List<ItemDTO> getAllItems() throws Exception;
	ItemDTO getItem(Integer itemId) throws Exception;
}
