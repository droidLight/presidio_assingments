package shopping_hibernate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateSessionUtility;

public class ItemDAOImpl implements ItemDAO, Cloneable {
	private static ItemDAOImpl instance;

	private ItemDAOImpl() {}


	private ItemDAOImpl createClone() {
		ItemDAOImpl obj = null;
		try {
			obj = (ItemDAOImpl) super.clone();
		} catch (Exception e) {
		}
		return obj;
	}

	synchronized public static ItemDAOImpl getInstance() {
		if (instance == null)
			instance = new ItemDAOImpl();

		return instance.createClone();
	}

	@Override
	public ItemDTO findById(Integer itemId) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		ItemDTO item = (ItemDTO) session.get(ItemDTO.class, itemId);
		return item;
	}

	@Override
	public List<ItemDTO> getAll() throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("from item");
		List list = query.list();

		Iterator<ItemDTO> iter = list.iterator();
		List<ItemDTO> result = new ArrayList();
		while (iter.hasNext()) {
			ItemDTO temp = (ItemDTO) iter.next();
			result.add(temp);
		}
		return result;
	}

	@Override
	public int insertItem(ItemDTO itemDTO) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		session.save(itemDTO);

		Query query = session.createQuery("select i.itemName from item i where i.itemId=:id");
		query.setParameter("id", itemDTO.getItemid());

		List list = query.list();
		HibernateSessionUtility.closeSession(null);
		return list.size();
	}

	@Override
	public int updateItem(ItemDTO itemDTO) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("update item set itemName=:name, itemUnit=:unit, price=:pr where itemId=:id");
		query.setParameter("name", itemDTO.getItem_name());
		query.setParameter("unit", itemDTO.getItem_unit());
		query.setParameter("pr", itemDTO.getPrice());
		query.setParameter("id", itemDTO.getItemid());
		
		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;	}

	@Override
	public int deleteItemByID(Integer itemId) throws Exception {		
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("delete from item where itemId=:id");
		query.setParameter("id", itemId);
		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

	@Override
	public int deleteItemByDTO(ItemDTO itemDTO) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("delete from item where itemId=:id");
		query.setParameter("id", itemDTO.getItemid());
		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

}
