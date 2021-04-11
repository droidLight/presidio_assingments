package daolayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO, Cloneable {
	private Connection connection;
	private static ItemDAOImpl instance;

	private ItemDAOImpl() {}

	private ItemDAOImpl setConnection(Connection connection) {
		this.connection = connection;
		return this;
	}

	private ItemDAOImpl createClone() {
		ItemDAOImpl obj = null;
		try {
			obj = (ItemDAOImpl) super.clone();
		} catch (Exception e) {
		}
		return obj;
	}

	synchronized public static ItemDAOImpl getInstance(Connection connection) {
		if (instance == null)
			instance = new ItemDAOImpl();

		return instance.createClone().setConnection(connection);
	}

	@Override
	public ItemDTO findById(Integer itemId) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("select * from itemmaster where itemid=?");
		st.setInt(1, itemId);
		ResultSet res = st.executeQuery();

		if (res.next()) {
			ItemDTO item = ItemDTO.getItemDTO();
			item.setItemName(res.getString("itemname"));
			item.setItemid(res.getInt("itemid"));
			item.setItemUnit(res.getString("itemunit"));
			item.setPrice(res.getFloat("price"));
			st.close();
			return item;
		} else {
			System.out.println("No item found with item id: " + itemId);
			st.close();
			return null;
		}

	}

	@Override
	public List<ItemDTO> getAll() throws Exception {
		List<ItemDTO> itemList = new ArrayList<>();
		Statement st = this.connection.createStatement();
		ResultSet res = st.executeQuery("select * from itemmaster");

		while (res.next()) {
			ItemDTO item = ItemDTO.getItemDTO();
			item.setItemName(res.getString("itemname"));
			item.setItemid(res.getInt("itemid"));
			item.setItemUnit(res.getString("itemunit"));
			item.setPrice(res.getFloat("price"));

			itemList.add(item);
		}
		st.close();
		res.close();
		return itemList;
	}

	@Override
	public int insertItem(ItemDTO itemDTO) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("insert into itemmaster values(?, ?, ?, ?)");
		st.setInt(1, itemDTO.getItemid());
		st.setString(2, itemDTO.getItemName());
		st.setString(3, itemDTO.getItemUnit());
		st.setFloat(4, itemDTO.getPrice());

		int rowsAffected = st.executeUpdate();
		st.close();
		return rowsAffected;
	}

	@Override
	public int updateItem(ItemDTO itemDTO) throws Exception {
		PreparedStatement st = this.connection
				.prepareStatement("update itemmaster itemname = ?,  itemunit = ?, price = ? where itemid = ?");
		st.setString(1, itemDTO.getItemName());
		st.setString(2, itemDTO.getItemUnit());
		st.setFloat(3, itemDTO.getPrice());
		st.setInt(4, itemDTO.getItemid());
		;

		int rowsAffected = st.executeUpdate();
		st.close();
		return rowsAffected;
	}

	@Override
	public int deleteItemByID(Integer itemid) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("delete from itemmaster where itemid = ?");
		st.setInt(0, itemid);
		int rowsAffected = st.executeUpdate();
		st.close();
		return rowsAffected;
	}

	@Override
	public int deleteItemByDTO(ItemDTO itemDTO) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("delete from itemmaster where itemid = ?");
		st.setInt(0, itemDTO.getItemid());
		int rowsAffected = st.executeUpdate();
		st.close();
		return rowsAffected;
	}

}
