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

import com.shopping.model.User;

@Component("UserDAO")
public class UserDAOSJ {
	@Autowired
	private JdbcTemplate jdbctemplate;
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}

	public List<User> getAllUser() {
		List<User> listUser = null;
		try {
			String query = "SELECT * FROM User";

			listUser = jdbctemplate.query(query, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		return listUser;

	}

	public List<User> getUserbyEmail(String email) {
		List<User> listUser = null;
		try {
			String query = "SELECT * FROM User WHERE idCategory = ?";
			listUser = jdbctemplate.query(query, new Object[] { email }, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		return listUser;

	}

	public User getUserById(long id) {

		User User = null;
		try {
			String query = "SELECT * FROM User WHERE id = ?";
			User = jdbctemplate.queryForObject(query, new Object[] { id }, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		return User;
	}

	public class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setFullName(rs.getString("fullname"));
			user.setEmail(rs.getString("email"));
			user.setPhoneNumber(rs.getString("phoneNumber"));
			user.setAddress(rs.getString("address"));
			user.setType(rs.getInt("type"));

			return user;
		}

	}

	public void createUser(Long id, String username, String password, String fullName, String email, String phoneNumber,
			String address, Integer type) {
		try {
			String query = "INSERT INTO User VALUES(?,?,?,?,?,?,?,?)";

			jdbctemplate.update(query,
					new Object[] { id, username, password, fullName, email, phoneNumber, address, type });
			System.out.println("Value inserted successfully");

		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}

	}

	public void removeUser(int id) {
		try {
			String query = "DELETE FROM User WHERE id=?";
			jdbctemplate.update(query, new Object[] { id });
			System.out.println("Value deleted successfully");
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}

	}

	public void updateUser(int id, String username, String password) {
		try {
			String query = "UPDATE User SET saled = ?, price = ? WHERE id= ? ";
			jdbctemplate.update(query, username, password);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}

	}
}
