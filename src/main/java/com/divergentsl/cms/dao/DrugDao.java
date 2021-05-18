package com.divergentsl.cms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class DrugDao {
	
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
	
	
//	IDatabaseManager databaseManager;
//	
//	public DrugDao(IDatabaseManager databaseManager) {
//		this.databaseManager=databaseManager;	
//		}
	
	public int insertDrug(String name,String drug_id,String drug_price) throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement;
		String sql="INSERT INTO drug (name,drug_id,drug_price) "+" VALUES("+name+","+drug_id+","+drug_price+")";
//		statement =connection.prepareStatement(sql);
//		statement.setString(1,name);
//		statement.setString(2,drug_id);
//		statement.setString(3,drug_price);
		return jdbcTemplate.update(sql);
		
	}
	
	public ResultSet showDrug() throws SQLException
	{
		
//		Connection connection=databaseManager.getConnection();
//		Statement st=connection.createStatement();
		String sqlretrive = "SELECT * from drug";
		ResultSet rsretrive =jdbcTemplate.queryForObject(sqlretrive,ResultSet.class);
		return rsretrive;
	}
	
	public int updatedrugName(String drugname,String id)throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement = null;
		String sqlupdate = "UPDATE drug SET name='"+drugname+"' WHERE drug_id='"+id+"' ";
//		statement = connection.prepareStatement(sqlupdate);
//		statement.setString(1, drugname);
//		statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate);
	}
	
	public int updatedrugPrice(String price,String id)throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement = null;
		String sqlupdate = "UPDATE drug SET drug_price='"+price+"' WHERE drug_id='"+id+"' ";
		
//		statement = connection.prepareStatement(sqlupdate);
//		statement.setString(1, price);
//		statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate);
	}

}
