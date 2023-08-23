package api_endpoints;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.Test;



public class reference {
	
	

	@Test
	public static void Date()
	
	{
	//	private static final Logger log = LogManager.getLogger(reference.class);
		
			String datenew= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			System.out.println("Date is"+datenew);
		} 
}

		
	


