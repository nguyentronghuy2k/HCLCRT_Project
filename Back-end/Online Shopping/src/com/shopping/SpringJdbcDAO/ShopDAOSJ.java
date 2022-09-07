package com.shopping.SpringJdbcDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.shopping.model.Shop;

@Component("ShopDAO")
public class ShopDAOSJ {
	@Autowired
	private JdbcTemplate jdbctemplate;
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}

	public List<Shop> getAllShop() {
		List<Shop> listShop = null;
		try {
			String query = "SELECT * FROM Shop";

			listShop = jdbctemplate.query(query, new ShopMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		return listShop;

	}

	public List<Shop> getShopbyName(String name) {
		List<Shop> listShop = null;
		try {
			String query = "SELECT * FROM Shop WHERE name = ?";
			listShop = jdbctemplate.query(query, new Object[] { name }, new ShopMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		return listShop;

	}

	public Shop getShopById(long id) {

		Shop shop = null;
		try {
			String query = "SELECT * FROM Shop WHERE id = ?";
			shop = jdbctemplate.queryForObject(query, new Object[] { id }, new ShopMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		return shop;
	}

	public class ShopMapper implements RowMapper<Shop> {

		@Override
		public Shop mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			Shop shop = new Shop();
			shop.setId(rs.getLong("id"));
			shop.setName(rs.getString("name"));
			shop.setAddress(rs.getString("address"));
			shop.setPhoneNumber(rs.getString("phoneNumber"));
			shop.setDescribe(rs.getString("describe"));
			shop.setImg(rs.getString("img"));

			return shop;
		}

	}

	public void createShop(Long id, String name, String address, String phoneNumber, String describe, String img) {
		try {
			String query = "INSERT INTO Shop VALUES(?,?,?,?,?,?,)";

			jdbctemplate.update(query, new Object[] { id, name, address, phoneNumber, describe, img });
			System.out.println("Value inserted successfully");

		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}

	}

	public void removeShop(int id) {
		try {
			String query = "DELETE FROM Shop WHERE id=?";
			jdbctemplate.update(query, new Object[] { id });
			System.out.println("Value deleted successfully");
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}

	}

	public void updateShop(int id, String phoneNumber, String name) {
		try {
			String query = "UPDATE Shop SET phoneNumber = ?, name = ? WHERE id= ? ";
			jdbctemplate.update(query, phoneNumber, name);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}

	}
}
