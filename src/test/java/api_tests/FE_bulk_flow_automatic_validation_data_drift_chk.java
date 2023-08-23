package api_tests;

import static io.restassured.RestAssured.given;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.Test;

import api_endpoints.FE_URL_paths;
import api_payloads.FE_ActivateCheck;
import api_payloads.FE_conn;
import api_payloads.FE_login;
import api_payloads.FE_template;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class FE_bulk_flow_automatic_validation_data_drift_chk {
	
	
	int id;
	String id2;
	int id3;
	String id4;
	String connection;
	String dataTemplate;
 String	 Validationid;
 String token;
 
	 public static String emailid = FE_login.emailid;
		public static String password = FE_login.password;
		public static String TokenforloginDB= FE_login.Tokenforlogin;
		
		public static String schematype=FE_conn.Schematype;
		
		public static String FromDate=FE_template.FromDate;
		public static String ToDate=FE_template.ToDate;
		public static String tablename=FE_template.Tablename;
		
		public static String DataDriftCheckCol=FE_ActivateCheck.DataDriftCheckCol;
		
	public void setup()
	{
		RestAssured.useRelaxedHTTPSValidation();
	}

static ResourceBundle getURL() {
		
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	
	@Test
	public void logindatabuck()
	{
		
	//	String post_url_login =	getURL().getString("post_url_login");

		{
			Response response=given()
					.relaxedHTTPSValidation()	
					.header("token", TokenforloginDB)
					
					.body("{\"email\":\""+emailid+"\",\"password\":\""+password+"\"}\r\n"
							+ "")
				//	.body(new File("N:\\Auto_Databuck\\fullnewui\\FirstEigen_API\\src\\test\\resources\\login.json"))
					.contentType(ContentType.JSON)
					.when()
			          .post(FE_URL_paths.post_url_login);
			response.then().log().all();
			System.out.println("-----------------------------assert start--------------------------");
			System.out.println("Response time is"+" "+ response.getTime()+"s");
			System.out.println("Status code is"+" "+ response.getStatusCode());
			Assert.assertEquals(response.getStatusCode(),200);
			JsonPath r = response.jsonPath();
		  token = r.get("token");
			System.out.println("THe token is"+" "+token);
			//Assert.assertEquals(response.body().);
		
			System.out.println("-----------------------------assert end--------------------------");
	}
	}
		
		@Test(dependsOnMethods = {"logindatabuck"})
		public  void cr_conn()
		{
			String timestamp= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			 connection = "APIconn"+timestamp;
			 System.out.println(connection);
			String json= "{\"schemaName\":\""+connection+"\",\"schemaType\":\""+schematype+"\",\"uri\":\"66.11.121.142\",\"database\":\"fe.dbo\",\"username\":\"sa\",\"password\":\"Databuck125\",\"port\":\"1457\",\"domain\":\"\",\"Domain\":\"\",\"serviceName\":\"\",\"masterKey\":\"\",\"krb5conf\":\"\",\"autoGenerateId\":\"N\",\"suffix\":\"_inc, _tmp, v_\",\"prefix\":\"_inc, _tmp, v_\",\"hivejdbchost\":\"\",\"hivejdbcport\":\"\",\"sslEnb\":\"N\",\"incrementalDataReadEnabled\":\"N\",\"sslTrustStorePath\":\"\",\"trustPassword\":\"\",\"gatewayPath\":\"\",\"jksPath\":\"\",\"zookeeperUrl\":\"\",\"folderPath\":\"\",\"fileNamePattern\":\"\",\"fileDataFormat\":\"PSV(Pipe Delimited)\",\"headerPresent\":\"Y\",\"multiFolderEnabled\":\"N\",\"partitionedFolders\":\"N\",\"headerFilePath\":\"\",\"headerFileNamePattern\":\"\",\"headerFileDataFormat\":\"PSV(Pipe Delimited)\",\"accessKey\":\"\",\"secretKey\":\"\",\"bucketName\":\"\",\"privatekey\":\"\",\"privatekeyId\":\"\",\"bigQueryProjectName\":\"\",\"datasetName\":\"\",\"clientId\":\"\",\"clientEmail\":\"\",\"azureClientId\":\"\",\"azureClientSecret\":\"\",\"azureTenantId\":\"\",\"azureServiceURI\":\"\",\"azureFilePath\":\"\",\"enableFileMonitoring\":\"N\",\"multiPattern\":\"N\",\"startingUniqueCharCount\":0,\"endingUniqueCharCount\":0,\"maxFolderDepth\":0,\"fileEncrypted\":\"N\",\"singleFile\":\"N\",\"externalFileNamePatternId\":\"N\",\"kmsAuthDisabled\":\"Y\",\"readLatestPartition\":\"N\",\"alationIntegrationEnabled\":\"N\",\"createdBy\":\"prajaktapatil\",\"idUser\":16,\"domainId\":65,\"projectId\":46,\"ignoreFile\":null,\"ignoreFolder\":null,\"externalFileName\":\"\",\"patternColumn\":\"\",\"headerColumn\":\"\",\"localDirectoryColumnIndex\":\"\",\"xsltFolderPath\":\"\",\"clusterType\":\"databricks\",\"pushDownQueryEnabled\":\"N\",\"httpPath\":\"\",\"clusterPolicyId\":\"\",\"azureAuthenticationType\":\"ActiveDirectoryManagedIdentity\"}";
		//	String post_url_login =	getURL().getString("post_cr_conn");
			{
				Response response=given()
						.relaxedHTTPSValidation()	
						.header("token", token)
						.header("accept","application/json")
						.header("Content-Type" ,"application/json")
						.body(json)
					//	.body(new File("N:\\Auto_Databuck\\fullnewui\\FirstEigen_API\\src\\test\\resources\\cr_conn.json"))
						
						.when()
				          .post(FE_URL_paths.post_url_cr_conn);
				response.then().log().all();
				System.out.println("-----------------------------assert start--------------------------");
				System.out.println("Response time is"+" "+ response.getTime()+"s");
				System.out.println("Status code is"+" "+ response.getStatusCode());
				Assert.assertEquals(response.getStatusCode(),200);
		//		JsonPath r = response.jsonPath();
				//	 id = r.get("idDataSchema");
			id =	response.path("idDataSchema");
				System.out.println("THe connection id is"+" "+id);
				//Assert.assertEquals(response.body().);
				System.out.println("-----------------------------assert end--------------------------");
				
		}
		}
			@Test(dependsOnMethods = {"cr_conn"})
			public  void cr_template() throws InterruptedException
			{
				String timestamp= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				 dataTemplate = "API_template"+timestamp;
				String json = "{\"idUser\":16,\"dataTemplateName\":\""+dataTemplate+"\",\"dataLocation\":\"MSSQL\",\"createdByUser\":\"prajaktapatil\",\"hostName\":\"\",\"schemaName\":\"\",\"srcBrokerUri\":\"\",\"srcTopicName\":\"\",\"dataFormat\":\"\",\"userName\":\"\",\"pwd\":\"\",\"tarBrokerUri\":\"\",\"tarTopicName\":\"\",\"description\":\"test\",\"idDataSchema\":"+id+",\"headerId\":\"\",\"rowsId\":\"\",\"tableName\":\""+tablename+"\",\"tableNameList\":\"\",\"whereId\":null,\"queryCheckboxId\":\"N\",\"historicDateTable\":\"\",\"selectedTables\":\"\",\"queryTextboxId\":null,\"fileQueryCheckboxid\":\"\",\"fileQueryTextboxid\":\"\",\"incrementalSourceId\":\"N\",\"dateFormatId\":\"\",\"sliceStartId\":\"\",\"sliceEndId\":\"\",\"profilingEnabled\":\"N\",\"domainfunction\":\"\",\"projectId\":46,\"domainId\":65,\"advancedRulesEnabled\":\"N\",\"rollingHeaderPresent\":\"\",\"rollingColumn\":\"\"}\r\n"
						+ "";
				Thread.sleep(1000);
		//		String post_url_login =	getURL().getString("post_cr_template");

				{
					Response response=given()
							.relaxedHTTPSValidation()	
							.header("token", token)
							.header("accept","application/json")
							.header("Content-Type" ,"application/json")	
							.body(json)
						//	.body(new File("N:\\Auto_Databuck\\fullnewui\\FirstEigen_API\\src\\test\\resources\\cr_template.json"))
							.when()
					          .post(FE_URL_paths.post_url_cr_template);
					response.then().log().all();
					System.out.println("-----------------------------assert start--------------------------");
					System.out.println("Response time is"+" "+ response.getTime()+"s");
					System.out.println("Status code is"+" "+ response.getStatusCode());
				//	Assert.assertEquals(response.getStatusCode(),200);
					JsonPath r = response.jsonPath();
					id2 = r.get("templateId");
					System.out.println("THe template id is"+" "+id2);
					id4= r.get("templateName");
					System.out.println("The template name is"+" "+id4);
				//	Assert.assertEquals(response.body().);
					System.out.println("-----------------------------assert end--------------------------");
					Thread.sleep(50000);
				}		}
			
				@Test(dependsOnMethods = {"cr_template"}) //dependsOnMethods = {"cr_template"}
				public  void search_validation() throws InterruptedException
				{
					Thread.sleep(20000);
					String json1 = "{\"countRequired\":false,\"searchOption\":\"1\",\"fromDate\":\""+FromDate+"\",\"toDate\":\""+ToDate+"\",\"projectId\":\"46\",\"domainId\":\"65\",\"pageNo\":0,\"pageSize\":5,\"columnFilter\":\"\",\"filterCondtionMap\":{\"DataTemplateName\":\""+id4+"\"},\"menuFilter\":[\"Data Forensics\"]}";
					
			//		String post_search_valid =	getURL().getString("post_search_validation");

					{
						Response response=given()
								.relaxedHTTPSValidation()	
								.header("token", token)
								.header("accept","application/json")
								.header("Content-Type" ,"application/json")	
								.body(json1)
								.when()
						          .post(FE_URL_paths.post_url_search_validation);
						response.then().log().all();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
				//	Assert.assertEquals(response.getStatusCode(),200);
				//	JsonPath r1 = new JsonPath(response.asString());
					JsonPath r1 = response.jsonPath();
				  id3 = r1.get("result.validations[1].ValidationId");
				
					//	id3 = r1.get("ValidationId");
					//	List<String> valid  = response.jsonPath().getList("result.validations.ValidationId");
						//	 id3 = valid.toArray(new Integer[0]);
					// id3 = response.jsonPath().getString("result.validations.ValidationId");
					//	 id3 = response.jsonPath().getString("validations.ValidationId");
					//	id3=Integer.valueOf(i);
					//	 Object i = response.path("result.validations.ValidationId");
						
						
					//	id3 =i.toString();
				//	id3=Integer.valueOf(f);
						System.out.println("The validation id is"+" "+id3);
					//	Assert.assertEquals(response.body().); */
						System.out.println("-----------------------------assert end--------------------------");
				} }
				
				@Test(dependsOnMethods = {"search_validation"})   //dependsOnMethods = {"cr_validation"}
				public  void activate_check() throws InterruptedException
				{
					String json2 = "{\"idApp\":"+id3+",\"checkName\":\"Data Drift Check\",\"columnNames\":[{\"name\":\""+DataDriftCheckCol+"\",\"threshold\":\"1\"}]}";
					Thread.sleep(5000);
			//		String post_act_chk =	getURL().getString("post_activate_check");

					{
						Response response=given()
								.relaxedHTTPSValidation()	
								.header("token", token)
								.header("accept","application/json")
								.header("Content-Type" ,"application/json")	
								.body(json2)
								.when()
						          .post(FE_URL_paths.post_url_activate_check);
						response.then().log().all();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} }
				@Test(dependsOnMethods = {"activate_check"})   //dependsOnMethods = {"cr_validation"}
				public  void approve_status() throws InterruptedException
				{
					String json2 = "{\"approvalStatusCode\":20,\r\n"
							+ "\"approvalComments\":\"\",\r\n"
							+ "\"idApp\":"+id3+"}";
					Thread.sleep(1000);
			//		String post_app_status =	getURL().getString("post_approve_status");

					{
						Response response=given()
								.relaxedHTTPSValidation()	
								.header("token", token)
								.header("accept","application/json")
								.header("Content-Type" ,"application/json")	
								.body(json2)
								.when()
						          .post(FE_URL_paths.post_url_approve_status);
						response.then().log().all();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} }
				
				
				
				@Test(dependsOnMethods = {"approve_status"})   //dependsOnMethods = {"activate_check"}
				public  void run_validation() throws InterruptedException
				{
					String json2 = "{\"validationRunType\":\"full_load\",\"appIds\":"+id3+"}";
					
			//		String post_run_valid=	getURL().getString("post_run_task");

					{
						Response response=given()
								.relaxedHTTPSValidation()	
								.header("token", token)
								.header("accept","application/json")
								.header("Content-Type" ,"application/json")	
								.body(json2)
								.when()
						          .post(FE_URL_paths.post_url_run_task);
						response.then().log().all();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
						Thread.sleep(100000);
				} }
				
				@Test(dependsOnMethods = {"run_validation"})   //dependsOnMethods = {"cr_validation"}
				public  void approve_status_2() throws InterruptedException
				{
					String json2 = "{\"approvalStatusCode\":20,\r\n"
							+ "\"approvalComments\":\"\",\r\n"
							+ "\"idApp\":"+id3+"}";
					Thread.sleep(1000);
			//		String post_app_status =	getURL().getString("post_approve_status");

					{
						Response response=given()
								.relaxedHTTPSValidation()	
								.header("token", token)
								.header("accept","application/json")
								.header("Content-Type" ,"application/json")	
								.body(json2)
								.when()
						          .post(FE_URL_paths.post_url_approve_status);
						response.then().log().all();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
				} }
					
				@Test(dependsOnMethods = {"approve_status_2"})   //dependsOnMethods = {"activate_check"}
				public  void run_validation_2() throws InterruptedException
				{
					String json2 = "{\"validationRunType\":\"full_load\",\"appIds\":"+id3+"}";
					
			//		String post_run_valid=	getURL().getString("post_run_task");

					{
						Response response=given()
								.relaxedHTTPSValidation()	
								.header("token", token)
								.header("accept","application/json")
								.header("Content-Type" ,"application/json")	
								.body(json2)
								.when()
						          .post(FE_URL_paths.post_url_run_task);
						response.then().log().all();
						System.out.println("-----------------------------assert start--------------------------");
						System.out.println("Response time is"+" "+ response.getTime()+"s");
						System.out.println("Status code is"+" "+ response.getStatusCode());
						System.out.println("-----------------------------assert end--------------------------");
						Thread.sleep(100000);
				} }
				
				
					@Test(dependsOnMethods = {"run_validation_2"}) 
					public  void get_results() throws InterruptedException
					{
						Thread.sleep(100000);
						String json1 = "{\"idApp\":"+id3+",\"fromDate\":\""+FromDate+"\",\"toDate\":\""+ToDate+"\",\"checkName\":\"data_drift_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"\",\"maxDate\":\"\",\"maxRun\":\"\"}";
						
			//			String post_cr_valid =	getURL().getString("post_get_results_data_drift");

						{
							Response response=given()
									.relaxedHTTPSValidation()	
									.header("token", token)
									.header("accept","application/json")
									.header("Content-Type" ,"application/json")	
									.body(json1)
									.when()
							          .post(FE_URL_paths.post_url_get_results_data_drift);
							response.then().log().all();	
							System.out.println("-----------------------------assert start--------------------------");
							
							System.out.println("Response time is"+" "+ response.getTime()+"s");
							System.out.println("Status code is"+" "+ response.getStatusCode());
							Assert.assertEquals(response.getStatusCode(),200);
							
							//	JsonPath idData = response.jsonPath();
							//  id1 = response.path("result.DATA_QUALITY_NullCheck_Summary.colName");
						//	 id1= response.pat
						//  List<Object> name = response.jsonPath().getList("result.DATA_QUALITY_NullCheck_Summary.colName");
						   
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
							 
							 
							
							//Assert.assertEquals(response.body().);
							 
							 System.out.println("-----------------------------assert end--------------------------");

						}
						
					}
}
