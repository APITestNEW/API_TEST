package api_tests;

import static io.restassured.RestAssured.given;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


import org.testng.Assert;
import org.testng.annotations.Test;

import api_endpoints.FE_ApproveStatus_endpoints;
import api_endpoints.FE_URL_paths;
import api_endpoints.FE_activateCheck_endpoints;
import api_endpoints.FE_conn_endpoints;
import api_endpoints.FE_get_results_endpoints;
import api_endpoints.FE_login_endpoints;
import api_endpoints.FE_run_validation_endpoints;
import api_endpoints.FE_template_endpoints;
import api_endpoints.FE_validation_endpoints;
import api_payloads.FE_ActivateCheck;
import api_payloads.FE_login;
import api_payloads.FE_template;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class FE_Sanity_test_bulk_multiple_checks_2 {
	
	
	
	@Test
	public void logindatabuck()
	{
		
	Response resp = FE_login_endpoints.loginDB();
			System.out.println("-----------------------------assert start--------------------------");
			System.out.println("Response time is"+" "+ resp.getTime()+"s");
			System.out.println("Status code is"+" "+ resp.getStatusCode());
			Assert.assertEquals(resp.getStatusCode(),200);
			System.out.println("-----------------------------assert end--------------------------");
	}
	
				
				@Test(dependsOnMethods = {"logindatabuck"}) //dependsOnMethods = {"cr_template"}
				public  void search_validation() throws InterruptedException
				{
					Response resp = FE_validation_endpoints.searchValidation_sanity();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("The validation id is"+" "+FE_validation_endpoints.id3);
						System.out.println("-----------------------------assert end--------------------------");
				
					} 
				
			
				@Test(dependsOnMethods = {"search_validation"})   //dependsOnMethods = {"cr_validation"}
				public  void activate_check_bad_data() throws InterruptedException
				{
					Response resp = FE_activateCheck_endpoints.ActivateCheck_Bulk_RCA_BadData();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
				@Test(dependsOnMethods = {"activate_check_bad_data"})   //dependsOnMethods = {"cr_validation"}
				public  void activate_check_def_chk() throws InterruptedException
				{
				Response resp = FE_activateCheck_endpoints.ActivateCheck_Bulk_RCA_Def_Check();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
			
				@Test(dependsOnMethods = {"activate_check_def_chk"})   //dependsOnMethods = {"cr_validation"}
				public  void activate_check_length() throws InterruptedException
				
				{
				Response resp = FE_activateCheck_endpoints.ActivateCheck_Bulk_RCA_Length_Check();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
				
				@Test(dependsOnMethods = {"activate_check_length"})   //dependsOnMethods = {"cr_validation"} //dependsOnMethods = {"activate_check_length"}
				public  void activate_check_max_length() throws InterruptedException
				
				{
					Response resp = FE_activateCheck_endpoints.ActivateCheck_Bulk_RCA_Max_Length_Check();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
			
				@Test(dependsOnMethods = {"activate_check_max_length"})   //dependsOnMethods = {"cr_validation"}
				public  void activate_check_regex_pattern() throws InterruptedException
				
				{
				Response resp = FE_activateCheck_endpoints.ActivateCheck_Bulk_RCA_Regex_Pattern_Check();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
				
				
				@Test(dependsOnMethods = {"activate_check_regex_pattern"})   //dependsOnMethods = {"cr_validation"}
				public  void activate_check_def_pattern() throws InterruptedException
				
				{
				Response resp = FE_activateCheck_endpoints.ActivateCheck_Bulk_RCA_Default_Pattern_Check();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
				
				
				
				
				@Test(dependsOnMethods = {"activate_check_def_pattern"})   //dependsOnMethods = {"cr_validation"}
				public  void approve_status() throws InterruptedException
				{
					Response resp = FE_ApproveStatus_endpoints.ApproveStatusValidation();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} 
				
				
				
				
				@Test(dependsOnMethods = {"approve_status"})   //dependsOnMethods = {"activate_check"}
				public  void run_validation() throws InterruptedException
				{
				Response resp = FE_run_validation_endpoints.run_validation();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
						Thread.sleep(100000);
						//	d.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
				} 
				
					
				
					@Test(dependsOnMethods = {"run_validation"}) 
					public  void get_results_bad_data() throws InterruptedException
					{
						Response resp = FE_get_results_endpoints.getResults_Bulk_RCA_BadDataCheck();
							System.out.println("-----------------------------assert start--------------------------");
							System.out.println("Response time is"+" "+ resp.getTime()+"s");
							System.out.println("Status code is"+" "+ resp.getStatusCode());
							Assert.assertEquals(resp.getStatusCode(),200);
						List<Object> name1 = resp.jsonPath().getList("result.DATA_QUALITY_badData.colName");
						List<Object> per1 = resp.jsonPath().getList("result.DATA_QUALITY_badData.badDataPercentage");
						List<Object> TotalRecords1 = resp.jsonPath().getList("result.DATA_QUALITY_badData.totalRecord");
						List<Object> FailedRecords1 = resp.jsonPath().getList("result.DATA_QUALITY_badData.totalBadRecord");
						List<Object> status1 = resp.jsonPath().getList("result.DATA_QUALITY_badData.status");
				 Object name = resp.jsonPath().get("result.DATA_QUALITY_badData[0].colName");
				 Object per = resp.jsonPath().get("result.DATA_QUALITY_badData[0].badDataPercentage");
				 Object TotalRecords = resp.jsonPath().get("result.DATA_QUALITY_badData[0].totalRecord");
				 Object FailedRecords = resp.jsonPath().get("result.DATA_QUALITY_badData[0].totalBadRecord");
				 Object status = resp.jsonPath().get("result.DATA_QUALITY_badData[0].status");
							//  id = idData.get("status");
							 System.out.println("The column names are"+" "+name1);
							 System.out.println("The total records are"+" "+TotalRecords1); 
							 System.out.println("The failed records are"+" "+FailedRecords1);
							 System.out.println("The percentage is"+" "+per1);
							 System.out.println("The status are"+" "+status1);
							 System.out.println("--------------------------------[Activated BadData check result]----------------------------");
							 System.out.println("The column name is"+" "+name);
							 System.out.println("The total records are"+" "+TotalRecords); 
							 System.out.println("The failed records are"+" "+FailedRecords);
							 System.out.println("The percentage is"+" "+per);
							 System.out.println("The status is"+" "+status);
							 
							 
							
							//Assert.assertEquals(response.body().);
							 
							 System.out.println("-----------------------------assert end--------------------------");

						}
						
				
					
					@Test(dependsOnMethods = {"get_results_bad_data"}) 
					public  void get_results_def_check() throws InterruptedException
					{
						Response response = FE_get_results_endpoints.getResults_Bulk_RCA_DefCheck();
							System.out.println("-----------------------------assert start--------------------------");
							System.out.println("Response time is"+" "+ response.getTime()+"s");
							System.out.println("Status code is"+" "+ response.getStatusCode());
							Assert.assertEquals(response.getStatusCode(),200);
							
						List<Object> name1 = response.jsonPath().getList("result.DATA_QUALITY_default_value.colName");
						List<Object> per1 = response.jsonPath().getList("result.DATA_QUALITY_default_value.defaultPercentage");
						List<Object> def_value1 = response.jsonPath().getList("result.DATA_QUALITY_default_value.defaultValue");
						List<Object> def_count1 = response.jsonPath().getList("result.DATA_QUALITY_default_value.defaultCount");
				
				 Object name = response.jsonPath().get("result.DATA_QUALITY_default_value[0].colName");
				 Object per = response.jsonPath().get("result.DATA_QUALITY_default_value[0].defaultPercentage");
				 Object def_value = response.jsonPath().get("result.DATA_QUALITY_default_value[0].defaultValue");
				 Object def_count = response.jsonPath().get("result.DATA_QUALITY_default_value[0].defaultCount");
			
							 System.out.println("The column names are"+" "+name1);
							 System.out.println("The total records are"+" "+def_value1); 
							 System.out.println("The failed records are"+" "+def_count1);
							 System.out.println("The  percentage is"+" "+per1);
						
							 System.out.println("--------------------------------[Activated default check result]----------------------------");
							 System.out.println("The column name is"+" "+name);
							 System.out.println("The total records are"+" "+def_value); 
							 System.out.println("The failed records are"+" "+def_count);
							 System.out.println("The  percentage is"+" "+per);
						
							 System.out.println("-----------------------------assert end--------------------------");

						}
						
					
					
					
					
					@Test(dependsOnMethods = {"get_results_def_check"}) 
					public  void get_results_Length_chk() throws InterruptedException
					{
						Response response = FE_get_results_endpoints.getResults_Bulk_RCA_Length_Check();
							System.out.println("-----------------------------assert start--------------------------");
			
							System.out.println("Response time is"+" "+ response.getTime()+"s");
							System.out.println("Status code is"+" "+ response.getStatusCode());
							Assert.assertEquals(response.getStatusCode(),200);
							
						List<Object> name1 = response.jsonPath().getList("result.DATA_QUALITY_Length_Check.colName");
						List<Object> per1 = response.jsonPath().getList("result.DATA_QUALITY_Length_Check.failedRecordsPercentage");
						List<Object> TotalRecords1 = response.jsonPath().getList("result.DATA_QUALITY_Length_Check.recordCount");
						List<Object> FailedRecords1 = response.jsonPath().getList("result.DATA_QUALITY_Length_Check.totalFailedRecords");
						List<Object> status1 = response.jsonPath().getList("result.DATA_QUALITY_Length_Check.status");
						
				 Object name = response.jsonPath().get("result.DATA_QUALITY_Length_Check[1].colName");
				 Object per = response.jsonPath().get("result.DATA_QUALITY_Length_Check[1].failedRecordsPercentage");
				 Object TotalRecords = response.jsonPath().get("result.DATA_QUALITY_Length_Check[1].recordCount");
				 Object FailedRecords = response.jsonPath().get("result.DATA_QUALITY_Length_Check[1].totalFailedRecords");
				 Object status = response.jsonPath().get("result.DATA_QUALITY_Length_Check[1].status");
						
							 System.out.println("The column names are"+" "+name1);
							 System.out.println("The total records are"+" "+TotalRecords1); 
							 System.out.println("The failed records are"+" "+FailedRecords1);
							 System.out.println("The percentage is"+" "+per1);
							 System.out.println("The status are"+" "+status1);
							 
							 System.out.println("--------------------------------[Activated Length check result]--------------------------");
							 System.out.println("The column name is"+" "+name);
							 System.out.println("The total records are"+" "+TotalRecords); 
							 System.out.println("The failed records are"+" "+FailedRecords);
							 System.out.println("The percentage is"+" "+per);
							 System.out.println("The status is"+" "+status);
						
							 System.out.println("-----------------------------assert end--------------------------");

						}
						


					@Test(dependsOnMethods = {"get_results_Length_chk"}) 
					public  void get_results_Max_length_check() throws InterruptedException
					{
					Response response = FE_get_results_endpoints.getResults_Bulk_RCA_Max_Length_Check();
							System.out.println("-----------------------------assert start--------------------------");
							
							System.out.println("Response time is"+" "+ response.getTime()+"s");
							System.out.println("Status code is"+" "+ response.getStatusCode());
							Assert.assertEquals(response.getStatusCode(),200);
							
						List<Object> name1 = response.jsonPath().getList("result.DATA_QUALITY_Length_Check.colName");
						List<Object> per1 = response.jsonPath().getList("result.DATA_QUALITY_Length_Check.failedRecordsPercentage");
						List<Object> TotalRecords1 = response.jsonPath().getList("result.DATA_QUALITY_Length_Check.recordCount");
						List<Object> FailedRecords1 = response.jsonPath().getList("result.DATA_QUALITY_Length_Check.totalFailedRecords");
						List<Object> status1 = response.jsonPath().getList("result.DATA_QUALITY_Length_Check.status");
						
						Object name = response.jsonPath().get("result.DATA_QUALITY_Length_Check[0].colName");
						Object per = response.jsonPath().get("result.DATA_QUALITY_Length_Check[0].failedRecordsPercentage");
						Object TotalRecords = response.jsonPath().get("result.DATA_QUALITY_Length_Check[0].recordCount");
						Object FailedRecords = response.jsonPath().get("result.DATA_QUALITY_Length_Check[0].totalFailedRecords");
						Object status = response.jsonPath().get("result.DATA_QUALITY_Length_Check[0].status");
						
							 System.out.println("The column names are"+" "+name1);
							 System.out.println("The percentage are"+" "+per1); 
							 System.out.println("The total records are"+" "+TotalRecords1);
							 System.out.println("The failed records are"+" "+FailedRecords1);				 
							 System.out.println("The status are"+" "+status1);
							 
							 System.out.println("--------------------------------[Activated MaxLength check result]-------------------------");
							 System.out.println("The column name is"+" "+name);
							 System.out.println("The percentage is"+" "+per); 
							 System.out.println("The total records are"+" "+TotalRecords);
							 System.out.println("The failed records are"+" "+FailedRecords);
							 System.out.println("The status is"+" "+status);
							
							 System.out.println("-----------------------------assert end--------------------------");

						}
						
					
					
					
					
					@Test(dependsOnMethods = {"get_results_Max_length_check"}) 
					public  void get_results_regex_pattern() throws InterruptedException
					{
						Response response = FE_get_results_endpoints.getResults_Bulk_RCA_Regex_Pattern_Check();
							System.out.println("-----------------------------assert start--------------------------");
							
							System.out.println("Response time is"+" "+ response.getTime()+"s");
							System.out.println("Status code is"+" "+ response.getStatusCode());
							Assert.assertEquals(response.getStatusCode(),200);
							
							//	JsonPath idData = response.jsonPath();
							//  id1 = response.path("result.DATA_QUALITY_NullCheck_Summary.colName");
						//	 id1= response.pat
						//  List<Object> name = response.jsonPath().getList("result.DATA_QUALITY_NullCheck_Summary.colName");
						   
						List<Object> name1 = response.jsonPath().getList("result.DATA_QUALITY_Unmatched_Pattern_Data.colName");
						List<Object> per1 = response.jsonPath().getList("result.DATA_QUALITY_Unmatched_Pattern_Data.failedRecordsPercentage");
						List<Object> totalrecords1 = response.jsonPath().getList("result.DATA_QUALITY_Unmatched_Pattern_Data.totalRecords");
						List<Object> failedRecords1 = response.jsonPath().getList("result.DATA_QUALITY_Unmatched_Pattern_Data.totalFailedRecords");
					
						List<Object> status1 = response.jsonPath().getList("result.DATA_QUALITY_Unmatched_Pattern_Data.status");
				 Object name = response.jsonPath().get("result.DATA_QUALITY_Unmatched_Pattern_Data[0].colName");
				 Object per = response.jsonPath().get("result.DATA_QUALITY_Unmatched_Pattern_Data[0].failedRecordsPercentage");
				 Object totalrecords = response.jsonPath().get("result.DATA_QUALITY_Unmatched_Pattern_Data[0].totalRecords");
				 Object failedRecords = response.jsonPath().get("result.DATA_QUALITY_Unmatched_Pattern_Data[0].totalFailedRecords");
			
				 Object status = response.jsonPath().get("result.DATA_QUALITY_Unmatched_Pattern_Data[0].status");
							
							 System.out.println("The column names are"+" "+name1);
							 System.out.println("The total records are"+" "+totalrecords1); 
							 System.out.println("The failed records are"+" "+failedRecords1);
							 System.out.println("The percentages are"+" "+per1);
							 ;
							 System.out.println("The status are"+" "+status1);
							 System.out.println("--------------------------------[Activated RegexPattern check result]----------------------------");
							 System.out.println("The column name is"+" "+name);
							 System.out.println("The total records are"+" "+totalrecords); 
							 System.out.println("The failed records are"+" "+failedRecords);
							 System.out.println("The percentage is"+" "+per);
							
							 System.out.println("The status is"+" "+status);
						 
							 System.out.println("-----------------------------assert end--------------------------");

						}
						
					
					@Test(dependsOnMethods = {"get_results_regex_pattern"}) 
					public  void get_results_def_pattern() throws InterruptedException
					{
					Response response = FE_get_results_endpoints.getResults_Bulk_RCA_Def_Pattern_Check();
							System.out.println("-----------------------------assert start--------------------------");
							
							System.out.println("Response time is"+" "+ response.getTime()+"s");
							System.out.println("Status code is"+" "+ response.getStatusCode());
							Assert.assertEquals(response.getStatusCode(),200);
						   
							List<Object> name1 = response.jsonPath().getList("result.DATA_QUALITY_Unmatched_Default_Pattern_Data.colName");
							List<Object> per1 = response.jsonPath().getList("result.DATA_QUALITY_Unmatched_Default_Pattern_Data.failedRecordsPercentage");
							List<Object> totalrecords1 = response.jsonPath().getList("result.DATA_QUALITY_Unmatched_Default_Pattern_Data.totalRecords");
							List<Object> failedRecords1 = response.jsonPath().getList("result.DATA_QUALITY_Unmatched_Default_Pattern_Data.totalFailedRecords");
							List<Object> matchedRecords1 = response.jsonPath().getList("result.DATA_QUALITY_Unmatched_Default_Pattern_Data.totalMatchedRecords");
							List<Object> status1 = response.jsonPath().getList("result.DATA_QUALITY_Unmatched_Default_Pattern_Data.status");
							
					 Object name = response.jsonPath().get("result.DATA_QUALITY_Unmatched_Default_Pattern_Data[0].colName");
					 Object per = response.jsonPath().get("result.DATA_QUALITY_Unmatched_Default_Pattern_Data[0].failedRecordsPercentage");
					 Object totalrecords = response.jsonPath().get("result.DATA_QUALITY_Unmatched_Default_Pattern_Data[0].totalRecords");
					 Object failedRecords = response.jsonPath().get("result.DATA_QUALITY_Unmatched_Default_Pattern_Data[0].totalFailedRecords");
					 Object matchedRecords = response.jsonPath().get("result.DATA_QUALITY_Unmatched_Default_Pattern_Data[0].totalMatchedRecords");
				
					 Object status = response.jsonPath().get("result.DATA_QUALITY_Unmatched_Default_Pattern_Data[0].status");
							
								 System.out.println("The column names are"+" "+name1);
								 System.out.println("The total records are"+" "+totalrecords1); 
								 System.out.println("The failed records are"+" "+failedRecords1);
								 System.out.println("The matched records are"+" "+matchedRecords1);
								 System.out.println("The percentages are"+" "+per1);
								 
								 System.out.println("The status are"+" "+status1);
								 System.out.println("--------------------------------[Activated Default_Pattern check result]----------------------------");
								 System.out.println("The column name is"+" "+name);
								 System.out.println("The total records are"+" "+totalrecords); 
								 System.out.println("The failed records are"+" "+failedRecords);
								 System.out.println("The matched records are"+" "+matchedRecords);
								 System.out.println("The percentage is"+" "+per);
								
								 System.out.println("The status is"+" "+status);
								 
							
							 System.out.println("-----------------------------assert end--------------------------");

						}
						
					}

					
					
//23882_API_template20230703164900_Validation 

