package daolayer;

import java.util.List;

public interface ItemDAO {
	
	public ItemDTO findById(Integer itemId) throws Exception;
	public List<ItemDTO> getAll() throws Exception;
	public List<ItemDTO> getByCategory(String category) throws Exception;
	public int insertItem(ItemDTO itemDTO) throws Exception;
	public int updateItem(ItemDTO itemDTO)throws Exception;
	public int deleteItemByID(Integer itemid)throws Exception;
	public int deleteItemByDTO(ItemDTO itemDTO)throws Exception;
}
