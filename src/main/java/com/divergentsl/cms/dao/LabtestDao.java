package com.divergentsl.cms.dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//import com.divergentsl.cms.IDatabaseManager;


@Repository
public class LabtestDao {
	
//IDatabaseManager databaseManager;
//	
//	public LabtestDao(IDatabaseManager databaseManager) {
//		this.databaseManager=databaseManager;	
//		}
	
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
	
	public int insertLabtest(String name,String labtest_id,String labtest_price) throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement;
		String sql="INSERT INTO labtest (name,labtest_id,labtest_price) "+" VALUES('"+name+"','"+labtest_id+"','"+labtest_price+"')";
//		statement =connection.prepareStatement(sql);
//		statement.setString(1,name);
//		statement.setString(2,drug_id);
//		statement.setString(3,drug_price);
		return jdbcTemplate.update(sql);
	}
	
	public ResultSet showLabtest()throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		Statement st=connection.createStatement();
		String sqlretrive = "SELECT * from labtest";
		ResultSet rsretrive =jdbcTemplate.queryForObject(sqlretrive,ResultSet.class);
		return rsretrive;
	}
	
	public int updateName(String dname,String id) throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement = null;
		
		String sqlupdate = "UPDATE labtest SET name='"+dname+"' WHERE labtst_id='"+id+"' ";
		
		
//		statement = connection.prepareStatement(sqlupdate);
//		statement.setString(1, dname);
//		statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate);
	}
	
	public int updatePrice(String price,String id) throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement = null;
		String sqlupdate = "UPDATE labtest SET labtest_price='"+price+"' WHERE labtest_id='"+id+"' ";
//		statement = connection.prepareStatement(sqlupdate);
//		statement.setString(1, price);
//		statement.setString(2, id);
		
		return jdbcTemplate.update(sqlupdate);
	}
}
