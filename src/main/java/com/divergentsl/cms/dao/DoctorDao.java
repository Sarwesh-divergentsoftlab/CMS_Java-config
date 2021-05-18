package com.divergentsl.cms.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorDao {
	
	public static String ID = "did";
	public static String NAME = "dname";
	public static String SPECIALITY = "speciality";
	public static String CONTACT_NO = "dcontact";
	public static String FEE = "dfee";
	public static String DEGREE = "ddegree";
	
	/*
	IDatabaseManager databaseManager;
	
	public DoctorDao(IDatabaseManager databaseManager) {
	this.databaseManager=databaseManager;	
	}
	*/
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
	
	
	public void insertDoctor(String name,String doctor_id,String fees,String degree,String prescription)throws SQLException{
		
		String sql="INSERT INTO doctor VALUES('"+name+"','"+doctor_id+"','"+fees+"','"+degree+"','"+prescription+"')";
	
		int rowinsert= jdbcTemplate.update(sql);
		
		if(rowinsert>0)
		{
			System.out.println("new doctor information added\n");
		}
	}
	
	public List<Map<String, Object>> showDoctor() throws SQLException
	{
	//	Connection connection=databaseManager.getConnection();
	//	Statement st=connection.createStatement();
		String sqlretrive = "SELECT * from doctor";
		List<Map<String, Object>> list =jdbcTemplate.queryForList(sqlretrive);
		return list;
	}
	
	public int updateName(String dname,String id) throws SQLException
	{
		//Connection connection=databaseManager.getConnection();
		//PreparedStatement statement = null;
		
		String sqlupdate = "UPDATE doctor SET name='"+dname+"' WHERE doctor_id='"+id+"' ";
		//statement = connection.prepareStatement(sqlupdate);
		//statement.setString(1, dname);
		//statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate);
	}
	
	public int updateSpecialization(String dspec,String id) throws SQLException
	{
		//Connection connection=databaseManager.getConnection();
		//PreparedStatement statement = null;
		String sqlupdate = "UPDATE doctor SET specialization='"+dspec+"' WHERE doctor_id='"+id+"' ";
		//statement = connection.prepareStatement(sqlupdate);
		//statement.setString(1, dspec);
		//statement.setString(2, id);
		
		return jdbcTemplate.update(sqlupdate);
	}
	
	public int updateFees(String dfees,String id)throws SQLException
	{

		//Connection connection=databaseManager.getConnection();
		//PreparedStatement statement = null;
		String sqlupdate = "UPDATE doctor SET fees='"+dfees+"' WHERE doctor_id='"+id+"' ";
		//statement = connection.prepareStatement(sqlupdate);
		//statement.setString(1, dfees);
		//statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate);
	}
	
	public int updateDegree(String ddegree,String id)throws SQLException
	{

		//Connection connection=databaseManager.getConnection();
		//PreparedStatement statement = null;
		String sqlupdate = "UPDATE doctor SET degree='"+ddegree+"' WHERE doctor_id='"+id+"' ";
		//statement = connection.prepareStatement(sqlupdate);
		//statement.setString(1, ddegree);
		//statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate);
	}
	
	public int updatePrescription(String dpres,String id)throws SQLException
	{

		//Connection connection=databaseManager.getConnection();
		//PreparedStatement statement = null;
		String sqlupdate = "UPDATE doctor SET prescription='"+dpres+"' WHERE doctor_id='"+id+"' ";
		//statement = connection.prepareStatement(sqlupdate);
		//statement.setString(1, dpres);
		//statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate);
	}
	public int deleteDotor(String idd)throws SQLException
	{
		//Connection connection=databaseManager.getConnection();
		//PreparedStatement statement = null;
		//statement =connection.prepareStatement("DELETE from doctor where doctor_id=?");
		//statement.setString(1, idd);
		return jdbcTemplate.update("DELETE from doctor where doctor_id='"+idd+"'",idd);
	}
	
}
