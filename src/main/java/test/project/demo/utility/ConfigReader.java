package test.project.demo.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;
	
	public ConfigReader(){
		
			File src = new File("./configuration/config.properties");

			try {
				FileInputStream fis = new FileInputStream(src);
				prop = new Properties();
				prop.load(fis);
			}catch (FileNotFoundException e) {
				e.printStackTrace();
				
			} 
			catch (Exception e) {
				e.printStackTrace();
				
			}
		
		}
	
	public String getBaseApplicationUrl(){
	String baseURL=prop.getProperty("baseURL");	
	return baseURL;
	}
	
	public String getApplicationLoginUrl(){
		String baseURL=prop.getProperty("loginUrl");	
		return baseURL;
		}
	
	public String getUsername()
	{
	String userName=prop.getProperty("userName");
	return userName;
	}
	
	public String getUserEmail()
	{
	String userEmail=prop.getProperty("userEmail");
	return userEmail;
	}
	
	public String getPassword()
	{
	String password=prop.getProperty("passWord");
	return password;
	}
	
	public String getBrowserName()
	{
	String browserName=prop.getProperty("browserName");
	return browserName;
	}
	

}
