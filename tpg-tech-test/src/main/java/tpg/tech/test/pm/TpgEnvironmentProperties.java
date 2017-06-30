
package tpg.tech.test.pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

public class TpgEnvironmentProperties {
	private static final Logger log = Logger.getLogger("TpgEnvironmentProperties");
	private static final Properties properties= new Properties();
	private static final PropertiesConfiguration aproperties = new PropertiesConfiguration();

	private static  String fileName;
	

	
	public TpgEnvironmentProperties(String fileName) {
		TpgEnvironmentProperties.fileName = fileName;
		load();
	}


	public static void setFileName(String fileName){
		TpgEnvironmentProperties.fileName = fileName;
	}
	


	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		String val = getProperty(key);
		return (val == null) ? defaultValue : val;
	}



	public static Properties getPropertiesObject(){
		return properties;
	}

	
	


	public static  void load() 
	{
		
		try	{
			log.info("[load] Configuration fullpath="+fileName);
			properties.clear();
						
			
			log.info("TpgEnvironmentProperties trying to load from file "+fileName);
			File temp = new File(fileName);
			InputStream inStream = new FileInputStream(temp);
			
			properties.load(inStream);
			aproperties.load(fileName);
			inStream.close();
			temp = null;
	
	} catch (Exception e)	
		{
			log.info("Error done");
			 
		}
		
	}




}



