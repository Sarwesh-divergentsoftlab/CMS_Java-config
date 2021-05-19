package com.divergentsl.cms.dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;

import java.sql.SQLException;
//import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//import com.divergentsl.cms.IDatabaseManager;
@Repository
public class AppointmentDao {
	
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
	
//IDatabaseManager databaseManager;
//	
//	
//	public AppointmentDao(IDatabaseManager databaseManager) {
//	this.databaseManager=databaseManager;	
//	}
	
	public List<Map<String , Object>> showAssignedAppointment(String dId)throws SQLException
	{
//			Connection connection=databaseManager.getConnection();
//			Statement st = connection.createStatement();
			String sqlretrive = "SELECT * from patient where doctor_id='"+dId+"'";
			List<Map<String, Object>> list =jdbcTemplate.queryForList(sqlretrive);
			return list;
	}
	
	public int addPrescription(String pid,String pres) throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement;
		String sql="update patient SET prescription='"+pres+"' where patient_id='"+pid+"'";
//		statement =connection.prepareStatement(sql);
//		statement.setString(1,pres);
		return jdbcTemplate.update(sql);
	}
	
	public List<Map<String, Object>> patHistory(String pId) throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		Statement st = connection.createStatement();
	
		String sqlretrive = "SELECT * from patient where patient_id='"+pId+"'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlretrive);
		return list;
				
	}
	
	public int addAppointment(String pid,String did, String problem,String date,String time) throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		Statement st = connection.createStatement();
//		PreparedStatement statement;
		String sql="INSERT INTO appointment (patient_id,doctor_id,problem,app_date,time) "+" VALUES('"+pid+"','"+did+"','"+problem+"','"+date+"','"+time+"')";
//		statement =connection.prepareStatement(sql);
//		statement.setString(1,pid);
//		statement.setString(2,did);
//		statement.setString(3,problem);
//		statement.setString(4,date);
//		statement.setString(5,time);
		return jdbcTemplate.update(sql);
	}
	
	public List<Map<String, Object>>  invoice()throws SQLException 
	{
//		 Connection connection=databaseManager.getConnection();			
//		 Statement st = connection.createStatement();
			
		String sqlretrive = "SELECT patient.name,patient.age,patient.patient_id,patient.weight,patient.problem,patient.app_date,patient.contact,patient.doctor_id,patient.prescription,doctor.name,doctor.fees,doctor.specializatio,doctor.prescription FROM patient JOIN doctor ON patient.doctor_id=doctor.doctor_id\r\n";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlretrive);
		return list;
	}

}
