package com.divergentsl.cms.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;




@Repository
public class PatientDao {
//	
//IDatabaseManager databaseManager;
//	
//	
//	public PatientDao(IDatabaseManager databaseManager) {
//	this.databaseManager=databaseManager;	
//	}
	
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
	public int insertPatient(String name,String patient_age,String pId,String weight,String problem,String app_date,String contact)throws SQLException
		{
//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement;
	
		String sql="INSERT INTO patient (name,age,patient_id,weight,problem,app_date,contact) "+" VALUES("+name+","+patient_age+","+pId+","+weight+","+problem+","+app_date+","+contact+")";
//		statement =connection.prepareStatement(sql);
//		statement.setString(1,name);
//		statement.setString(2,patient_age);
//		statement.setString(3,pId);
//		statement.setString(4,weight);
//		statement.setString(5,problem);
//		statement.setString(6,app_date);
//		statement.setString(7,contact);
		return jdbcTemplate.update(sql);
		}

	public ResultSet showPatient() throws SQLException
	{
		String sqlretrive = "SELECT * from patient";
//		Connection connection=databaseManager.getConnection();
//		Statement st=connection.createStatement();
		ResultSet rsretrive =jdbcTemplate.queryForObject(sqlretrive,ResultSet.class);
		return rsretrive;
	}
	public int updateName(String dname,String id) throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement = null;
		
		String sqlupdate = "UPDATE patient SET name="+dname+" WHERE patient_id="+id+" ";
		
		
//		statement = connection.prepareStatement(sqlupdate);
//		statement.setString(1, dname);
//		statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate);
	}
	
	public int updateAge(String age,String id) throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement = null;
		String sqlupdate = "UPDATE patient SET age="+age+" WHERE patient_id="+id+" ";
//		statement = connection.prepareStatement(sqlupdate);
//		statement.setString(1, age);
//		statement.setString(2, id);
		
		return jdbcTemplate.update(sqlupdate);
	}
	
	public int updateWieght(String weight,String id)throws SQLException
	{

//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement = null;
		String sqlupdate = "UPDATE patient SET weight="+weight+" WHERE patient_id="+id+" ";
		
//		statement = connection.prepareStatement(sqlupdate);
//		statement.setString(1, weight);
//		statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate);
	}
	
	public int updateProblem(String problem,String id)throws SQLException
	{

//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement = null;
		String sqlupdate = "UPDATE patient SET problem="+problem+" WHERE patient_id="+id+" ";
//		statement = connection.prepareStatement(sqlupdate);
//		statement.setString(1, problem);
//		statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate);
	}
	
	public int updateAppDate(String app,String id)throws SQLException
	{

//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement = null;
		String sqlupdate = "UPDATE patient SET app_date="+app+" WHERE patient_id="+id+" ";
//		statement = connection.prepareStatement(sqlupdate);
//		statement.setString(1, app);
//		statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate);
	}
	
	public int updateContact(String contact,String id)throws SQLException
	{

//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement = null;
		String sqlupdate = "UPDATE patient SET contact="+contact+" WHERE patient_id="+id+" ";
//		statement = connection.prepareStatement(sqlupdate);
//		statement.setString(1, contact);
//		statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate);
	}
	
	public int deletePatient(String pId)throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement = null;
		String sql="DELETE from patient where patient_id="+pId+"";
//		statement.setString(1, pId);
		return jdbcTemplate.update(sql);
		
	}
}
