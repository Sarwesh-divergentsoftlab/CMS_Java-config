package com.divergentsl.cms.dao;

//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//import java.sql.Statement;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



//import com.divergentsl.cms.IDatabaseManager;


@Repository
public class LoginDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//@Autowired
	//NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
//	
//IDatabaseManager databaseManager;
//	
//	public LoginDao(IDatabaseManager databaseManager) {
//		this.databaseManager=databaseManager;	
//		}
	
	public boolean adminLogin(String user, String pass)throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
		String sqlst="Select * from login_admin where username = '"+user+"' and password='"+pass+"'";
//		Statement statement=connection.createStatement();
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlst);
		
		if(list.isEmpty())
		{
			return false;
		}
		else return true;
		
	}
	
	public boolean doctorLogin(String user,String pass)throws SQLException
	{
		
//		Connection connection=databaseManager.getConnection();
		String sqlst="Select * from login_doctor where username = '"+user+"' and password='"+pass+"'";
//		Statement statement=connection.createStatement();
		List<Map<String,Object>> list= jdbcTemplate.queryForList(sqlst);
		if(list.isEmpty())
		{
		return false;
		}
		else return true;
		
	}

}
