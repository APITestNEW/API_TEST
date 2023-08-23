package api_tests;

import static io.restassured.RestAssured.given;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;


public class FE_test_Bulk_Data_Drift {
	
//	private static final Logger log = LogManager.getLogger(FE_bulk_flow_automatic_validation_demo.class);
	
	
	
	int id;
	String id2;
	int id3;
	String id4;
	String connection;
	String dataTemplate;
 String	 Validationid;
 String token;
 public static  String json;
 public  static Response response;
 // public  static String datenew;
 
 public static String emailid = FE_login.emailid;
	public static String password = FE_login.password;
	public static String FromDate=FE_template.FromDate;
	public static String ToDate=FE_template.ToDate;
	public static String tablename=FE_template.Tablename;
	public static String DataDriftCheckCol=FE_ActivateCheck.DataDriftCheckCol;
	public static String UserId=FE_template.UserId;
	public static String ProjId=FE_template.ProjId;
	public static String DomainId=FE_template.DomainId;
	public static String CreatedBy=FE_template.CreatedBy;
	
	
	
	public void setup()
	{
		RestAssured.useRelaxedHTTPSValidation();
	}

static ResourceBundle getURL() {
		
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	

public static void generic()

{
	/*	response=given()
			.relaxedHTTPSValidation()	
			.header("token", FE_login.Tokenforlogin)
			.body(json)
			.contentType(ContentType.JSON)
			.when()
			.post(FE_URL_paths.post_url_login);
			response.then().log().all();
			*/
}
	
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
	


		@Test(dependsOnMethods = {"logindatabuck"}) //dependsOnMethods = {"logindatabuck"}
		public  void cr_conn()
		{
			
			Response resp=FE_conn_endpoints.conn();
				System.out.println("-------------------------assert Create Connection start--------------------------");
				System.out.println("Response time is"+" "+ resp.getTime()+"s");
				System.out.println("Status code is"+" "+ resp.getStatusCode());
				Assert.assertEquals(resp.getStatusCode(),200);	
				System.out.println("THe connection id is"+" "+FE_conn_endpoints.id);
				System.out.println("-----------------------------assert end--------------------------");
				
		}
		
			@Test(dependsOnMethods = {"cr_conn"})
			public  void cr_template() throws InterruptedException
			{
				Response resp = FE_template_endpoints.createTemplate();
					System.out.println("-----------------------------assert Create Template start--------------------------");
					System.out.println("Response time is"+" "+ resp.getTime()+"s");
					System.out.println("Status code is"+" "+ resp.getStatusCode());
					Assert.assertEquals(resp.getStatusCode(),200);
					System.out.println("THe template id is"+" "+FE_template_endpoints.id2);
					System.out.println("The template name is"+" "+FE_template_endpoints.id4);
					System.out.println("-----------------------------assert end--------------------------");
					Thread.sleep(50000);
						}
			
			
				@Test(dependsOnMethods = {"cr_template"}) //dependsOnMethods = {"cr_template"}
				public  void search_validation() throws InterruptedException
				{
				
						Response resp = FE_validation_endpoints.searchValidation();
						System.out.println("-----------------------------assert Search Valildation start--------------------------");
						System.out.println("Response time is"+" "+ resp.getTime()+"s");
						System.out.println("Status code is"+" "+ resp.getStatusCode());
				//	Assert.assertEquals(response.getStatusCode(),200);
				//	JsonPath r1 = new JsonPath(response.asString());
					
				
					//	id3 = r1.get("ValidationId");
					//	List<String> valid  = response.jsonPath().getList("result.validations.ValidationId");
						//	 id3 = valid.toArray(new Integer[0]);
					// id3 = response.jsonPath().getString("result.validations.ValidationId");
					//	 id3 = response.jsonPath().getString("validations.ValidationId");
					//	id3=Integer.valueOf(i);
					//	 Object i = response.path("result.validations.ValidationId");
						
						
					//	id3 =i.toString();
				//	id3=Integer.valueOf(f);
						System.out.println("The validation id is"+" "+FE_validation_endpoints.id3);
					//	Assert.assertEquals(response.body().); */
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
							
							//	JsonPath idData = response.jsonPath();
							//  id1 = response.path("result.DATA_QUALITY_NullCheck_Summary.colName");
						//	 id1= response.pat
						//  List<Object> name = response.jsonPath().getList("result.DATA_QUALITY_NullCheck_Summary.colName");
						   
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
							//  id = idData.get("status");
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

