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


public class FE_Sanity_test_bulk_flow_multiple_checks_1 {
	

	
	@Test
	public void logindatabuck()
	{
		
		{
		 Response response = FE_login_endpoints.loginDB();
			System.out.println("-----------------------------assert start--------------------------");
			System.out.println("Response time is"+" "+ response.getTime()+"s");
			System.out.println("Status code is"+" "+ response.getStatusCode());
			Assert.assertEquals(response.getStatusCode(),200);
			System.out.println("-----------------------------assert end--------------------------");
	}
	}
		
		
				
				@Test(dependsOnMethods = {"logindatabuck"}) //dependsOnMethods = {"cr_template"}
				public  void search_validation() throws InterruptedException
				{
					
				Response response = FE_validation_endpoints.searchValidation_sanity();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("The validation id is"+" "+FE_validation_endpoints.id3);
						System.out.println("-----------------------------assert end--------------------------");
				
					} 
				
			
				@Test(dependsOnMethods = {"search_validation"})   //dependsOnMethods = {"cr_validation"}
				public  void activate_check_null() throws InterruptedException
				{
				Response response = FE_activateCheck_endpoints.ActivateCheck_Bulk_RCA_Null_Check();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
			
				@Test(dependsOnMethods = {"activate_check_null"})   //dependsOnMethods = {"cr_validation"}
				public  void activate_check_dup() throws InterruptedException
				
				{
					Response response = FE_activateCheck_endpoints.ActivateCheck_Bulk_RCA_Duplicate_Check();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
				
				@Test(dependsOnMethods = {"activate_check_dup"})   //dependsOnMethods = {"cr_validation"}
				public  void activate_check_date() throws InterruptedException
				
				{
				Response response = FE_activateCheck_endpoints.ActivateCheck_Bulk_RCA_Date_Check();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
			
				@Test(dependsOnMethods = {"activate_check_date"})   //dependsOnMethods = {"cr_validation"}
				public  void activate_check_VA() throws InterruptedException
				
				{
					Response response = FE_activateCheck_endpoints.ActivateCheck_Bulk_VA_Check();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
				
				
				@Test(dependsOnMethods = {"activate_check_VA"})   //dependsOnMethods = {"cr_validation"}
				public  void activate_check_Dis() throws InterruptedException
				
				{
				Response response = FE_activateCheck_endpoints.ActivateCheck_Bulk_Dist_Check();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
				
				
				
				
				@Test(dependsOnMethods = {"activate_check_Dis"})   //dependsOnMethods = {"cr_validation"}
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
						//	d.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
				} 
				
					
				
					@Test(dependsOnMethods = {"run_validation"}) 
					public  void get_results_null() throws InterruptedException
					{
						Response response = FE_get_results_endpoints.getResults_Bulk_RCA_Null_Check();
							System.out.println("-----------------------------assert start--------------------------");
							
							System.out.println("Response time is"+" "+ response.getTime()+"s");
							System.out.println("Status code is"+" "+ response.getStatusCode());
							Assert.assertEquals(response.getStatusCode(),200);
			
						List<Object> name1 = response.jsonPath().getList("result.DATA_QUALITY_NullCheck_Summary.colName");
						List<Object> per1 = response.jsonPath().getList("result.DATA_QUALITY_NullCheck_Summary.nullPercentage");
						List<Object> TotalRecords1 = response.jsonPath().getList("result.DATA_QUALITY_NullCheck_Summary.recordCount");
						List<Object> FailedRecords1 = response.jsonPath().getList("result.DATA_QUALITY_NullCheck_Summary.nullValue");
						List<Object> status1 = response.jsonPath().getList("result.DATA_QUALITY_NullCheck_Summary.status");
						
				 Object name = response.jsonPath().get("result.DATA_QUALITY_NullCheck_Summary[1].colName");
				 Object per = response.jsonPath().get("result.DATA_QUALITY_NullCheck_Summary[1].nullPercentage");
				 Object TotalRecords = response.jsonPath().get("result.DATA_QUALITY_NullCheck_Summary[1].recordCount");
				 Object FailedRecords = response.jsonPath().get("result.DATA_QUALITY_NullCheck_Summary[1].nullValue");
				 Object status = response.jsonPath().get("result.DATA_QUALITY_NullCheck_Summary[1].status");
							
							 System.out.println("The column names are"+" "+name1);
							 System.out.println("The total records are"+" "+TotalRecords1); 
							 System.out.println("The failed records are"+" "+FailedRecords1);
							 System.out.println("The null percentage is"+" "+per1);
							 System.out.println("The status are"+" "+status1);
							 
							 System.out.println("--------------------------------[Activated Null check result]----------------------------");
							 System.out.println("The column name is"+" "+name);
							 System.out.println("The total records are"+" "+TotalRecords); 
							 System.out.println("The failed records are"+" "+FailedRecords);
							 System.out.println("The null percentage is"+" "+per);
							 System.out.println("The status is"+" "+status);
							 
							 System.out.println("-----------------------------assert end--------------------------");

						}
						
					
					
					@Test(dependsOnMethods = {"get_results_null"}) 
					public  void get_results_dup() throws InterruptedException
					{
						Response response = FE_get_results_endpoints.getResults_Bulk_RCA_Dup_Check();
						
							System.out.println("-----------------------------assert start--------------------------");
							
							System.out.println("Response time is"+" "+ response.getTime()+"s");
							System.out.println("Status code is"+" "+ response.getStatusCode());
							Assert.assertEquals(response.getStatusCode(),200);
							
	
						List<Object> name1 = response.jsonPath().getList("result.DATA_QUALITY_Duplicate_Check_Summary.duplicateCheckFields");
						List<Object> per1 = response.jsonPath().getList("result.DATA_QUALITY_Duplicate_Check_Summary.percentage");
						List<Object> TotalRecords1 = response.jsonPath().getList("result.DATA_QUALITY_Duplicate_Check_Summary.totalCount");
						List<Object> FailedRecords1 = response.jsonPath().getList("result.DATA_QUALITY_Duplicate_Check_Summary.duplicate");
						List<Object> status1 = response.jsonPath().getList("result.DATA_QUALITY_Duplicate_Check_Summary.status");

				 Object name = response.jsonPath().get("result.DATA_QUALITY_Duplicate_Check_Summary[0].duplicateCheckFields");
				 Object per = response.jsonPath().get("result.DATA_QUALITY_Duplicate_Check_Summary[0].percentage");
				 Object TotalRecords = response.jsonPath().get("result.DATA_QUALITY_Duplicate_Check_Summary[0].totalCount");
				 Object FailedRecords = response.jsonPath().get("result.DATA_QUALITY_Duplicate_Check_Summary[0].duplicate");
				 Object status = response.jsonPath().get("result.DATA_QUALITY_Duplicate_Check_Summary[0].status");
							//  id = idData.get("status");
							 System.out.println("The column names are"+" "+name1);
							 System.out.println("The total records are"+" "+TotalRecords1); 
							 System.out.println("The failed records are"+" "+FailedRecords1);
							 System.out.println("The  percentage is"+" "+per1);
							 System.out.println("The status are"+" "+status1);
							 System.out.println("--------------------------------[Activated Duplicate check result]----------------------------");
							 System.out.println("The column name is"+" "+name);
							 System.out.println("The total records are"+" "+TotalRecords); 
							 System.out.println("The failed records are"+" "+FailedRecords);
							 System.out.println("The  percentage is"+" "+per);
							 System.out.println("The status is"+" "+status);
							 
							 
							
							//Assert.assertEquals(response.body().);
							 
							 System.out.println("-----------------------------assert end--------------------------");

						}
						
					
					
					
					
					@Test(dependsOnMethods = {"get_results_dup"}) 
					public  void get_results_date() throws InterruptedException
					{
					Response response = FE_get_results_endpoints.getResults_Bulk_RCA_Date_Check();	
							System.out.println("-----------------------------assert start--------------------------");
							
							System.out.println("Response time is"+" "+ response.getTime()+"s");
							System.out.println("Status code is"+" "+ response.getStatusCode());
							Assert.assertEquals(response.getStatusCode(),200);
							
						List<Object> name1 = response.jsonPath().getList("result.DATA_QUALITY_DateRule_Summary.dateField");
						List<Object> TotalRecords1 = response.jsonPath().getList("result.DATA_QUALITY_DateRule_Summary.totalNumberOfRecords");
						List<Object> FailedRecords1 = response.jsonPath().getList("result.DATA_QUALITY_DateRule_Summary.totalFailedRecords");
						
				 Object name = response.jsonPath().get("result.DATA_QUALITY_DateRule_Summary[0].dateField");
				 Object TotalRecords = response.jsonPath().get("result.DATA_QUALITY_DateRule_Summary[0].totalNumberOfRecords");
				 Object FailedRecords = response.jsonPath().get("result.DATA_QUALITY_DateRule_Summary[0].totalFailedRecords");
			
							 System.out.println("The column names are"+" "+name1);
							 System.out.println("The total records are"+" "+TotalRecords1); 
							 System.out.println("The failed records are"+" "+FailedRecords1);
		
							 System.out.println("--------------------------------[Activated Date check result]--------------------------");
							 System.out.println("The column name is"+" "+name);
							 System.out.println("The total records are"+" "+TotalRecords); 
							 System.out.println("The failed records are"+" "+FailedRecords);
			
							 
							 
							
							//Assert.assertEquals(response.body().);
							 
							 System.out.println("-----------------------------assert end--------------------------");

						}
						
					


					@Test(dependsOnMethods = {"get_results_date"}) 
					public  void get_results_VA() throws InterruptedException
					{
					Response response = FE_get_results_endpoints.getResults_Bulk_RCA_VA_Check();	
							System.out.println("-----------------------------assert start--------------------------");
							
							System.out.println("Response time is"+" "+ response.getTime()+"s");
							System.out.println("Status code is"+" "+ response.getStatusCode());
							Assert.assertEquals(response.getStatusCode(),200);
						   
						List<Object> name1 = response.jsonPath().getList("result.DATA_QUALITY_Record_Anomaly.colName");
						List<Object> stdev1 = response.jsonPath().getList("result.DATA_QUALITY_Record_Anomaly.stddev");
						List<Object> mean1 = response.jsonPath().getList("result.DATA_QUALITY_Record_Anomaly.mean");
						List<Object> failedRecords1 = response.jsonPath().getList("result.DATA_QUALITY_Record_Anomaly.colVal");
					
						List<Object> status1 = response.jsonPath().getList("result.DATA_QUALITY_Record_Anomaly.status");
				 Object name = response.jsonPath().get("result.DATA_QUALITY_Record_Anomaly[0].colName");
				 Object stdev = response.jsonPath().get("result.DATA_QUALITY_Record_Anomaly[0].stddev");
				 Object mean = response.jsonPath().get("result.DATA_QUALITY_Record_Anomaly[0].mean");
				 Object failedRecords = response.jsonPath().get("result.DATA_QUALITY_Record_Anomaly[0].colVal");
			
				 Object status = response.jsonPath().get("result.DATA_QUALITY_Record_Anomaly[0].status");
				 
							 System.out.println("The column names are"+" "+name1);
							 System.out.println("The failed records are"+" "+failedRecords1); 
						
							 System.out.println("The standard deviation are"+" "+stdev1);
							 System.out.println("The mean are"+" "+mean1);
							 System.out.println("The status are"+" "+status1);
							 
							 System.out.println("--------------------------------[Activated Value Anamoly check result]--------------------------");
							 System.out.println("The column name is"+" "+name);
							 System.out.println("The failed record is"+" "+failedRecords); 
					
							 System.out.println("The standard deviation is"+" "+stdev);
							 System.out.println("The mean is"+" "+mean);
							 System.out.println("The status is"+" "+status);
							 
							 System.out.println("-----------------------------assert end--------------------------");

						}
						
					
					
					
					
					@Test(dependsOnMethods = {"get_results_VA"}) 
					public  void get_results_dis() throws InterruptedException
					{
					Response response = FE_get_results_endpoints.getResults_Bulk_RCA_Dis_Check();	
							System.out.println("-----------------------------assert start--------------------------");
							
							System.out.println("Response time is"+" "+ response.getTime()+"s");
							System.out.println("Status code is"+" "+ response.getStatusCode());
							Assert.assertEquals(response.getStatusCode(),200);
					
						List<Object> name1 = response.jsonPath().getList("result.DATA_QUALITY_Column_Summary.colName");
						List<Object> stdev1 = response.jsonPath().getList("result.DATA_QUALITY_Column_Summary.stdDev");
						List<Object> mean1 = response.jsonPath().getList("result.DATA_QUALITY_Column_Summary.mean");
						List<Object> failedRecords1 = response.jsonPath().getList("result.DATA_QUALITY_Column_Summary.recordCount");
					
			
				 Object name = response.jsonPath().get("result.DATA_QUALITY_Column_Summary[0].colName");
				 Object stdev = response.jsonPath().get("result.DATA_QUALITY_Column_Summary[0].stdDev");
				 Object mean = response.jsonPath().get("result.DATA_QUALITY_Column_Summary[0].mean");
				 Object failedRecords = response.jsonPath().get("result.DATA_QUALITY_Column_Summary[0].recordCount");
			
							 System.out.println("The column names are"+" "+name1);
							 System.out.println("The records are"+" "+failedRecords1); 
						
							 System.out.println("The standard deviation are"+" "+stdev1);
							 System.out.println("The mean are"+" "+mean1);
				
							 System.out.println("--------------------------------[Activated Distribution check result]----------------------------");
							 System.out.println("The column name is"+" "+name);
							 System.out.println("The records are"+" "+failedRecords); 
						
							 System.out.println("The standard deviation is"+" "+stdev);
							 System.out.println("The mean is"+" "+mean);
						
							 System.out.println("-----------------------------assert end--------------------------");

						}
						
					}

					//id 613
					
//23882_API_template20230703164900_Validation 

