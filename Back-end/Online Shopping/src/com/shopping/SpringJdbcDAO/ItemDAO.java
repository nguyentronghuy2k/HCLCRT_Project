package com.shopping.SpringJdbcDAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class ItemDAO {
	@Autowired
	JdbcTemplate jdbctemplate;
	DataSource datasource;

}
