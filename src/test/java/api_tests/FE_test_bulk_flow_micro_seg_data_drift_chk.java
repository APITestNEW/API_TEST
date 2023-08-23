package api_tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import api_endpoints.FE_ApproveStatus_endpoints;
import api_endpoints.FE_activateCheck_endpoints;
import api_endpoints.FE_conn_endpoints;
import api_endpoints.FE_get_results_endpoints;
import api_endpoints.FE_login_endpoints;
import api_endpoints.FE_run_validation_endpoints;
import api_endpoints.FE_template_endpoints;
import api_endpoints.FE_validation_endpoints;
import io.restassured.response.Response;


public class FE_test_bulk_flow_micro_seg_data_drift_chk {	
	

	
	@Test
	public void logindatabuck()
	{
		
	Response response = FE_login_endpoints.loginDB();
			System.out.println("-----------------------------assert start--------------------------");
			System.out.println("Response time is"+" "+ response.getTime()+"s");
			System.out.println("Status code is"+" "+ response.getStatusCode());
			Assert.assertEquals(response.getStatusCode(),200);
			System.out.println("-----------------------------assert end--------------------------");
	}
	
		
		@Test(dependsOnMethods = {"logindatabuck"})
		public  void cr_conn()
		{
			Response response = FE_conn_endpoints.conn();
				System.out.println("-----------------------------assert start--------------------------");
				System.out.println("Response time is"+" "+ response.getTime()+"s");
				System.out.println("Status code is"+" "+ response.getStatusCode());
				Assert.assertEquals(response.getStatusCode(),200);
				System.out.println("THe connection id is"+" "+FE_conn_endpoints.id);
				System.out.println("-----------------------------assert end--------------------------");
				
		}
		
		
			@Test(dependsOnMethods = {"cr_conn"})
			public  void cr_template() throws InterruptedException
			{
				Response response = FE_template_endpoints.createTemplate();
					System.out.println("-----------------------------assert start--------------------------");
					System.out.println("Response time is"+" "+ response.getTime()+"s");
					System.out.println("Status code is"+" "+ response.getStatusCode());
					System.out.println("THe template id is"+" "+FE_template_endpoints.id2);
					System.out.println("The template name is"+" "+FE_template_endpoints.id4);
					System.out.println("-----------------------------assert end--------------------------");
					Thread.sleep(50000);
				}		
			
				@Test(dependsOnMethods = {"cr_template"}) //dependsOnMethods = {"cr_template"}
				public  void search_validation() throws InterruptedException
				{
					Response response = FE_validation_endpoints.searchValidation_Microseg();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("The validation id is"+" "+FE_validation_endpoints.id3);
					//	Assert.assertEquals(response.body().); */
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
				
				@Test(dependsOnMethods = {"search_validation"})   //dependsOnMethods = {"cr_validation"}
				public  void activate_check() throws InterruptedException
				{
				Response response = FE_activateCheck_endpoints.activateCheck_DataDrift();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
				
				@Test(dependsOnMethods = {"activate_check"})   //dependsOnMethods = {"cr_validation"}
				public  void approve_status() throws InterruptedException
				{
					Response response = FE_ApproveStatus_endpoints.ApproveStatusValidation();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
				
				
				@Test(dependsOnMethods = {"approve_status"})   //dependsOnMethods = {"activate_check"}
				public  void run_validation() throws InterruptedException
				{
					Response response = FE_run_validation_endpoints.run_validation();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
						Thread.sleep(100000);
				} 
				
				
				@Test(dependsOnMethods = {"run_validation"})   //dependsOnMethods = {"cr_validation"}
				public  void approve_status_2() throws InterruptedException
				{
					Response response = FE_ApproveStatus_endpoints.ApproveStatusValidation();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
					
				
				@Test(dependsOnMethods = {"approve_status_2"})   //dependsOnMethods = {"activate_check"}
				public  void run_validation_2() throws InterruptedException
				{
				Response response = FE_run_validation_endpoints.run_validation();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
						Thread.sleep(200000);
				} 
				
				
					@Test(dependsOnMethods = {"run_validation_2"}) 
					public  void get_results() throws InterruptedException
					{
					Response response = FE_get_results_endpoints.getResults_DataDrift();	
							System.out.println("-----------------------------assert start--------------------------");
							
							System.out.println("Response time is"+" "+ response.getTime()+"s");
							System.out.println("Status code is"+" "+ response.getStatusCode());
							Assert.assertEquals(response.getStatusCode(),200);
	
						   
						List<Object> name1 = response.jsonPath().getList("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY.colName");
						List<Object> UniqueValueCount1 = response.jsonPath().getList("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY.uniqueValuesCount");
						List<Object> NewValueCount1 = response.jsonPath().getList("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY.newValueCount");
						List<Object> MissingRecords1 = response.jsonPath().getList("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY.missingValueCount");
						List<Object> run1 = response.jsonPath().getList("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY.run");
						
				 Object name = response.jsonPath().get("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY[1].colName");
				 Object UniqueValueCount = response.jsonPath().get("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY[1].uniqueValuesCount");
				 Object NewValueCount = response.jsonPath().get("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY[1].newValueCount");
				 Object MissingRecords = response.jsonPath().get("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY[1].missingValueCount");
				 Object run = response.jsonPath().get("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY[1].run");
					
							 System.out.println("The column names are"+" "+name1);
							 System.out.println("The unique records are"+" "+UniqueValueCount1); 
							 System.out.println("The new records are"+" "+NewValueCount1);
							 System.out.println("The missing records are"+" "+MissingRecords1);
							 System.out.println("The recent runs are"+" "+run1);
							 
							 System.out.println("--------------------------------[Activated Data Drift check result]---------------------------------------");
							 System.out.println("The column name is"+" "+name);
							 System.out.println("The unique records are"+" "+UniqueValueCount); 
							 System.out.println("The new records are"+" "+NewValueCount);
							 System.out.println("The missing records are"+" "+MissingRecords);
							 System.out.println("The present run is"+" "+run);
							 
							 System.out.println("-----------------------------assert end--------------------------");

						}
						
					}

