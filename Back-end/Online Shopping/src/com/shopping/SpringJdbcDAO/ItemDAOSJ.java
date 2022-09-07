package com.shopping.SpringJdbcDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.shopping.model.Item;

@Component("ItemDAO")
public class ItemDAOSJ {
	@Autowired
	private JdbcTemplate jdbctemplate;
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}

	public List<Item> getAllItem() {
		List<Item> listItem = null;
		try {
			String query = "SELECT * FROM item";

			listItem = jdbctemplate.query(query, new ItemMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		return listItem;

	}

	public List<Item> getItembyCategoty(Long idCategory) {
		List<Item> listItem = null;
		try {
			String query = "SELECT * FROM item WHERE idCategory = ?";
			listItem = jdbctemplate.query(query, new Object[] { idCategory }, new ItemMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		return listItem;

	}

	public Item getItemById(long id) {

		Item item = null;
		try {
			String query = "SELECT * FROM item WHERE id = ?";
			item = jdbctemplate.queryForObject(query, new Object[] { id }, new ItemMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		return item;
	}

	public class ItemMapper implements RowMapper<Item> {

		@Override
		public Item mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			Item item = new Item();
			item.setId(rs.getLong("id"));
			item.setName(rs.getString("name"));
			item.setPrice(rs.getLong("price"));
			item.setSaled(rs.getInt("saled"));
			item.setDescribe(rs.getString("describe"));
			item.setImg(rs.getString("img"));
			item.setReleaseDate(rs.getDate("releaseDate"));
			item.setIdCategory(rs.getLong("idCategory"));
			item.setIdProducer(rs.getLong("idProducer"));
			item.setIdShop(rs.getLong("idShop"));

			return item;
		}

	}

	public void createItem(Long id, String name, Long price, Integer saled, String describe, String img,
			Date releaseDate, Long idCategory, Long idProducer, Long idShop) {
		try {
			String query = "INSERT INTO item VALUES(?,?,?,?,?,?,?,?,?,?)";

			jdbctemplate.update(query, new Object[] { id, name, price, saled, describe, img, releaseDate, idCategory,
					idProducer, idShop });
			System.out.println("Value inserted successfully");

		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}

	}

	public void removeItem(int id) {
		try {
			String query = "DELETE FROM item WHERE id=?";
			jdbctemplate.update(query, new Object[] { id });
			System.out.println("Value deleted successfully");
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}

	}

	public void updateItem(int id, Integer saled, Long price) {
		try {
			String query = "UPDATE item SET saled = ?, price = ? WHERE id= ? ";
			jdbctemplate.update(query, saled, price);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}

	}
}
