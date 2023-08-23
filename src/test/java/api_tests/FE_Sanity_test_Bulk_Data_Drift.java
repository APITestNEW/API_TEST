package api_tests;


import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import api_endpoints.FE_ApproveStatus_endpoints;
import api_endpoints.FE_activateCheck_endpoints;
import api_endpoints.FE_get_results_endpoints;
import api_endpoints.FE_login_endpoints;
import api_endpoints.FE_run_validation_endpoints;
import api_endpoints.FE_validation_endpoints;
import io.restassured.response.Response;


public class FE_Sanity_test_Bulk_Data_Drift {
	
	@Test
	public void logindatabuck()
	
		{
		
			Response resp = FE_login_endpoints.loginDB();			
			System.out.println("-----------------------------assert Login start--------------------------");
			System.out.println("Response time is"+" "+ resp.time() +"s");
			System.out.println("Status code is"+" "+ resp.getStatusCode());
			Assert.assertEquals(resp.getStatusCode(),200);
			System.out.println("-----------------------------assert end--------------------------");
	}

			
				@Test(dependsOnMethods = {"logindatabuck"}) //dependsOnMethods = {"cr_template"}
				public  void search_validation() throws InterruptedException
				{
				
						Response resp = FE_validation_endpoints.searchValidation_sanity();
						System.out.println("-----------------------------assert Search Valildation start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("The validation id is"+" "+FE_validation_endpoints.id3);					
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
				@Test(dependsOnMethods = {"search_validation"})   //dependsOnMethods = {"cr_validation"}
				public  void activate_check() throws InterruptedException
				{
						Response resp = FE_activateCheck_endpoints.activateCheck_DataDrift();
						System.out.println("-----------------------------assert  Activate Check start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
				
				
				@Test(dependsOnMethods = {"activate_check"})   //dependsOnMethods = {"cr_validation"}
				public  void approve_status() throws InterruptedException
				{
					Response resp = FE_ApproveStatus_endpoints.ApproveStatusValidation();
						System.out.println("-----------------------------assert Approve Status start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
				
				
				@Test(dependsOnMethods = {"approve_status"})   //dependsOnMethods = {"activate_check"}
				public  void run_validation() throws InterruptedException
				{
					Response resp = FE_run_validation_endpoints.run_validation();
						System.out.println("-----------------------------assert Run Validation start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
						
				} 
				
				@Test(dependsOnMethods = {"run_validation"})   //dependsOnMethods = {"cr_validation"}
				public  void approve_status_2() throws InterruptedException
				{
					Response resp = FE_ApproveStatus_endpoints.ApproveStatusValidation();
						System.out.println("-----------------------assert Approve Status start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("------------------------assert Approve Status end--------------------------");
				} 
					
				@Test(dependsOnMethods = {"approve_status_2"})   //dependsOnMethods = {"activate_check"}
				public  void run_validation_2() throws InterruptedException
				{
						Response resp = FE_run_validation_endpoints.run_validation();
						System.out.println("---------------------------assert Run Validation start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
						Thread.sleep(100000);
				} 
				
				
					@Test(dependsOnMethods = {"run_validation_2"}) 
					public  void get_results() throws InterruptedException
					{
							Response resp = FE_get_results_endpoints.getResults_DataDrift();
							System.out.println("------------------------assert get results start--------------------------");	
							System.out.println("Response time is"+" "+ resp.getTime()+"s");
							System.out.println("Status code is"+" "+ resp.getStatusCode());
							Assert.assertEquals(resp.getStatusCode(),200);
						
						List<Object> name1 = resp.jsonPath().getList("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY.colName");
						List<Object> UniqueValueCount1 = resp.jsonPath().getList("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY.uniqueValuesCount");
						List<Object> NewValueCount1 = resp.jsonPath().getList("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY.newValueCount");
						List<Object> MissingRecords1 = resp.jsonPath().getList("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY.missingValueCount");
						List<Object> run1 = resp.jsonPath().getList("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY.run");
				 Object name = resp.jsonPath().get("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY[1].colName");
				 Object UniqueValueCount = resp.jsonPath().get("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY[1].uniqueValuesCount");
				 Object NewValueCount = resp.jsonPath().get("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY[1].newValueCount");
				 Object MissingRecords = resp.jsonPath().get("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY[1].missingValueCount");
				 Object run = resp.jsonPath().get("result.DATA_QUALITY_DATA_DRIFT_COUNT_SUMMARY[1].run");

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

