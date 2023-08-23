package api_endpoints;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class demo {
	public static Logger log = LogManager.getLogger(demo.class);
	
	
	
	@Test
	public void newTest() {
	//	System.setProperty("log4j.configurationFile", "./src/test/java/log4j.properties");
		
		log.info("--Date Format Start");
		String datenew= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println("Date is"+datenew);
	}

}
