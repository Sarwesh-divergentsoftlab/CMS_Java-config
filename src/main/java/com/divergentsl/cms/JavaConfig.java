package com.divergentsl.cms;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan(basePackages = {"com.divergentsl.cms"})
//@Profile("dev")
@PropertySource("classpath:/application.properties")
@EnableAspectJAutoProxy

public class JavaConfig 
{

	@Value("${db.url}")
	public String databaseURL;
	@Value("${db.username}")
	public String databaseUsername;
	@Value("${db.password}")
	public String databasePassword;
	
	 @Bean
	    public DataSource mysqlDataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        dataSource.setUrl(databaseURL);
	        dataSource.setUsername(databaseUsername);
	        dataSource.setPassword(databasePassword);
	        return dataSource;
	    }
	 
	 @Bean
	 public JdbcTemplate jdbcTemplate() {
		 return new JdbcTemplate(mysqlDataSource());
	 }


	/*@Bean
	public Home getHome()
	{
	return new Home();
	}
	
	@Bean
	public LoginAdmin getAdmin()
	{
	return new LoginAdmin();
	}
	
	@Bean
	public LoginDoctor getDoctor()
	{
	return new LoginDoctor();
	}
	
	@Bean
	public CRUDdoctor getcrudDoctor()
	{
	return new CRUDdoctor();
	}
	
	@Bean
	public CRUDpatient getcrudPatient()
	{
	return new CRUDpatient();
	}
	
	@Bean
	public CRUDdrug getcrudDrug()
	{
	return new CRUDdrug();
	}
	
	@Bean
	public CRUDlabtest getcrudLabtest()
	{
	return new CRUDlabtest();
	}
	
	@Bean
	public Appointment getAppointment()
	{
	return new Appointment();
	}
	
	
	*/
	
	
}
