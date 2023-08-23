package api_endpoints;

import static io.restassured.RestAssured.given;

import api_payloads.FE_ActivateCheck;
import api_payloads.FE_template;
import api_payloads.FE_validation;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FE_get_results_endpoints {
	
	{
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	
	public static  Response getResults_DataDrift() throws InterruptedException {
		
		Thread.sleep(100000);
		String json1 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"checkName\":\"data_drift_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"\",\"maxDate\":\"\",\"maxRun\":\"\"}";
		
//		String post_cr_valid =	getURL().getString("post_get_results_data_drift");

		{
			Response response=given()
					.relaxedHTTPSValidation()	
					.header("token", FE_login_endpoints.token)
					.header("accept","application/json")
					.header("Content-Type" ,"application/json")	
					.body(json1)
					.when()
			          .post(FE_URL_paths.post_url_get_results_data_drift);
			response.then().log().all();	
			      
			return response;
		}
	}
	public static Response getResults_DataDrift_his_inc() throws InterruptedException {
		
		Thread.sleep(100000);
		String json = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_ActivateCheck.IncrementalStartDate+"\",\"toDate\":\""+FE_ActivateCheck.IncrementalEndDate+"\",\"checkName\":\"data_drift_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"\",\"maxDate\":\"\",\"maxRun\":\"\"}";
		
//		String post_cr_valid =	getURL().getString("post_get_results_data_drift");

		{
			Response response=given()
					.relaxedHTTPSValidation()	
					.header("token", FE_login_endpoints.token)
					.header("accept","application/json")
					.header("Content-Type" ,"application/json")	
					.body(json)
					.when()
			          .post(FE_URL_paths.post_url_get_results_data_drift);
			response.then().log().all();	
			      
			return response;
		}
	}
	
public static Response getResults_Bulk_RCA_BadDataCheck() throws InterruptedException {
		
		Thread.sleep(100000);
		String json = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"checkName\":\"bad_data_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"N\",\"maxDate\":\"\",\"maxRun\":\"\"}";
		
//		String post_cr_valid =	getURL().getString("post_get_results_data_drift");

		{
			Response response=given()
					.relaxedHTTPSValidation()	
					.header("token", FE_login_endpoints.token)
					.header("accept","application/json")
					.header("Content-Type" ,"application/json")	
					.body(json)
					.when()
			          .post(FE_URL_paths.post_url_get_results_bad);
			response.then().log().all();	
			      
			return response;
		}
	}
	public static Response getResults_Bulk_RCA_DefCheck() throws InterruptedException {
		
		Thread.sleep(7000);
		String json = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"checkName\":\"default_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"N\",\"maxDate\":\"\",\"maxRun\":\"\"}";
		
//		String post_cr_valid =	getURL().getString("post_get_results_data_drift");

		{
			Response response=given()
					.relaxedHTTPSValidation()	
					.header("token", FE_login_endpoints.token)
					.header("accept","application/json")
					.header("Content-Type" ,"application/json")	
					.body(json)
					.when()
			          .post(FE_URL_paths.post_url_get_results_def_chk);
			response.then().log().all();	
			      
			return response;
		}
	}
		
public static Response getResults_Bulk_RCA_Length_Check() throws InterruptedException {
		
		Thread.sleep(7000);
		String json = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"checkName\":\"length_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"N\",\"maxDate\":\"\",\"maxRun\":\"\"}";
		
//		String post_cr_valid =	getURL().getString("post_get_results_data_drift");

		{
			Response response=given()
					.relaxedHTTPSValidation()	
					.header("token", FE_login_endpoints.token)
					.header("accept","application/json")
					.header("Content-Type" ,"application/json")	
					.body(json)
					.when()
			          .post(FE_URL_paths.post_url_get_results_length);
			response.then().log().all();	
			      
			return response;
		}
	}
	

public static Response getResults_Bulk_RCA_Max_Length_Check() throws InterruptedException {

Thread.sleep(7000);
String json = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"checkName\":\"length_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"N\",\"maxDate\":\"\",\"maxRun\":\"\"}";



{
	Response response=given()
			.relaxedHTTPSValidation()	
			.header("token", FE_login_endpoints.token)
			.header("accept","application/json")
			.header("Content-Type" ,"application/json")	
			.body(json)
			.when()
	          .post(FE_URL_paths.post_url_get_results_length);
	response.then().log().all();	
	      
	return response;
}
}

public static Response getResults_Bulk_RCA_Regex_Pattern_Check() throws InterruptedException {

Thread.sleep(7000);
String json = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"checkName\":\"pattern_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"N\",\"maxDate\":\"\",\"maxRun\":\"\"}";


{
	Response response=given()
			.relaxedHTTPSValidation()	
			.header("token", FE_login_endpoints.token)
			.header("accept","application/json")
			.header("Content-Type" ,"application/json")	
			.body(json)
			.when()
	          .post(FE_URL_paths.post_url_get_results_reg_pattern);
	response.then().log().all();	
	      
	return response;
}
}

public static Response getResults_Bulk_RCA_Def_Pattern_Check() throws InterruptedException {

Thread.sleep(7000);
String json = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"checkName\":\"default_pattern_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"N\",\"maxDate\":\"\",\"maxRun\":\"\"}";


{
	Response response=given()
			.relaxedHTTPSValidation()	
			.header("token", FE_login_endpoints.token)
			.header("accept","application/json")
			.header("Content-Type" ,"application/json")	
			.body(json)
			.when()
	          .post(FE_URL_paths.post_url_get_results_def_pattern);
	response.then().log().all();	
	      
	return response;
}
}
public static Response getResults_Bulk_RCA_Null_Check() throws InterruptedException {

Thread.sleep(7000);
String json = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"checkName\":\"null_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"\",\"maxDate\":\"\",\"maxRun\":\"\"}";


{
	Response response=given()
			.relaxedHTTPSValidation()	
			.header("token", FE_login_endpoints.token)
			.header("accept","application/json")
			.header("Content-Type" ,"application/json")	
			.body(json)
			.when()
	          .post(FE_URL_paths.post_url_get_results_null);
	response.then().log().all();	
	      
	return response;
}
}
public static Response getResults_Bulk_RCA_Dup_Check() throws InterruptedException {

Thread.sleep(2000);
String json = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"checkName\":\"duplicate_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"N\",\"maxDate\":\"\",\"maxRun\":\"\"}";


{
	Response response=given()
			.relaxedHTTPSValidation()	
			.header("token", FE_login_endpoints.token)
			.header("accept","application/json")
			.header("Content-Type" ,"application/json")	
			.body(json)
			.when()
	          .post(FE_URL_paths.post_url_get_results_dup);
	response.then().log().all();	
	      
	return response;
}
}

public static Response getResults_Bulk_RCA_Date_Check() throws InterruptedException {

Thread.sleep(2000);
String json = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"checkName\":\"date_anomaly_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"N\",\"maxDate\":\"\",\"maxRun\":\"\"}";


{
	Response response=given()
			.relaxedHTTPSValidation()	
			.header("token", FE_login_endpoints.token)
			.header("accept","application/json")
			.header("Content-Type" ,"application/json")	
			.body(json)
			.when()
	          .post(FE_URL_paths.post_url_get_results_date);
	response.then().log().all();	
	      
	return response;
}
}

public static Response getResults_Bulk_RCA_VA_Check() throws InterruptedException {

Thread.sleep(7000);
String json = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"checkName\":\"record_anomaly_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"N\",\"maxDate\":\"\",\"maxRun\":\"\"}";


{
	Response response=given()
			.relaxedHTTPSValidation()	
			.header("token", FE_login_endpoints.token)
			.header("accept","application/json")
			.header("Content-Type" ,"application/json")	
			.body(json)
			.when()
	          .post(FE_URL_paths.post_url_get_results_VA);
	response.then().log().all();	
	      
	return response;
}
}

public static Response getResults_Bulk_RCA_Dis_Check() throws InterruptedException {

Thread.sleep(7000);
String json = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"checkName\":\"distribution_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"N\",\"maxDate\":\"\",\"maxRun\":\"\"}";


{
	Response response=given()
			.relaxedHTTPSValidation()	
			.header("token", FE_login_endpoints.token)
			.header("accept","application/json")
			.header("Content-Type" ,"application/json")	
			.body(json)
			.when()
	          .post(FE_URL_paths.post_url_get_results_dis);
	response.then().log().all();	
	      
	return response;
}
}

public static Response getResults_Bulk_Micro_Null_Check() throws InterruptedException {

	Thread.sleep(200000);
	
		String json1 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"checkName\":\"micro_null_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"\",\"maxDate\":\"\",\"maxRun\":\"\"}";
		
		
		{
			Response response=given()
					.relaxedHTTPSValidation()	
					.header("token", FE_login_endpoints.token)
					.header("accept","application/json")
					.header("Content-Type" ,"application/json")	
					.body(json1)
					.when()
			          .post(FE_URL_paths.post_url_get_results_null);
			response.then().log().all();
	return response;
}
}
public static Response getResults_Hist_Null_Check() throws InterruptedException {

	Thread.sleep(100000);
	String json1 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_ActivateCheck.HistoricStartDate+"\",\"toDate\":\""+FE_ActivateCheck.HistoricEndDate+"\",\"checkName\":\"null_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"Y\",\"maxDate\":\"1994-05-06\",\"maxRun\":\"1\"}";
	
//	String post_cr_valid =	getURL().getString("post_get_results_null");

	{
		Response response=given()
				.relaxedHTTPSValidation()	
				.header("token", FE_login_endpoints.token)
				.header("accept","application/json")
				.header("Content-Type" ,"application/json")	
				.body(json1)
				.when()
		          .post(FE_URL_paths.post_url_get_results_null);
		response.then().log().all();
		return response;
}
}
public static Response getResults_Hist_Dup_Check() throws InterruptedException {

	Thread.sleep(1000);
	String json1 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_ActivateCheck.HistoricStartDate+"\",\"toDate\":\""+FE_ActivateCheck.HistoricEndDate+"\",\"checkName\":\"duplicate_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"Y\",\"maxDate\":\"1994-05-06\",\"maxRun\":\"1\"}";
	
//	String post_cr_valid =	getURL().getString("post_get_results_null");

	{
		Response response=given()
				.relaxedHTTPSValidation()	
				.header("token", FE_login_endpoints.token)
				.header("accept","application/json")
				.header("Content-Type" ,"application/json")	
				.body(json1)
				.when()
		          .post(FE_URL_paths.post_url_get_results_dup);
		response.then().log().all();
		return response;
}
}

public static Response getResults_Hist_Date_Check() throws InterruptedException {

	Thread.sleep(1000);
	String json1 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_ActivateCheck.HistoricStartDate+"\",\"toDate\":\""+FE_ActivateCheck.HistoricEndDate+"\",\"checkName\":\"date_anomaly_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"Y\",\"maxDate\":\"\",\"maxRun\":\"\"}";
	
//	String post_cr_valid =	getURL().getString("post_get_results_null");

	{
		Response response=given()
				.relaxedHTTPSValidation()	
				.header("token", FE_login_endpoints.token)
				.header("accept","application/json")
				.header("Content-Type" ,"application/json")	
				.body(json1)
				.when()
		          .post(FE_URL_paths.post_url_get_results_date);
		response.then().log().all();
		return response;
}
}


public static Response getResults_Hist_VA_Check() throws InterruptedException {

	Thread.sleep(1000);
	String json1 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_ActivateCheck.HistoricStartDate+"\",\"toDate\":\""+FE_ActivateCheck.HistoricEndDate+"\",\"checkName\":\"record_anomaly_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"Y\",\"maxDate\":\"\",\"maxRun\":\"\"}";
	
//	String post_cr_valid =	getURL().getString("post_get_results_null");

	{
		Response response=given()
				.relaxedHTTPSValidation()	
				.header("token", FE_login_endpoints.token)
				.header("accept","application/json")
				.header("Content-Type" ,"application/json")	
				.body(json1)
				.when()
		          .post(FE_URL_paths.post_url_get_results_VA);
		response.then().log().all();
		return response;
}
}
public static Response getResults_Hist_Dis_Check() throws InterruptedException {

	Thread.sleep(1000);
	String json1 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_ActivateCheck.HistoricStartDate+"\",\"toDate\":\""+FE_ActivateCheck.HistoricEndDate+"\",\"checkName\":\"distribution_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"Y\",\"maxDate\":\"\",\"maxRun\":\"\"}";
	
//	String post_cr_valid =	getURL().getString("post_get_results_null");

	{
		Response response=given()
				.relaxedHTTPSValidation()	
				.header("token", FE_login_endpoints.token)
				.header("accept","application/json")
				.header("Content-Type" ,"application/json")	
				.body(json1)
				.when()
		          .post(FE_URL_paths.post_url_get_results_dis);
		response.then().log().all();
		return response;
}
}
public static Response getResults_Hist_Micro_Null_Check() throws InterruptedException {

	Thread.sleep(100000);
	String json1 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_ActivateCheck.HistoricStartDate+"\",\"toDate\":\""+FE_ActivateCheck.HistoricEndDate+"\",\"checkName\":\"micro_null_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"Y\",\"maxDate\":\"1994-05-06\",\"maxRun\":\"1\"}";
	
//	String post_cr_valid =	getURL().getString("post_get_results_null");

	{
		Response response=given()
				.relaxedHTTPSValidation()	
				.header("token", FE_login_endpoints.token)
				.header("accept","application/json")
				.header("Content-Type" ,"application/json")	
				.body(json1)
				.when()
		          .post(FE_URL_paths.post_url_get_results_null);
		response.then().log().all();
		return response;
}
}
public static Response getResults_Hist_BadDataCheck() throws InterruptedException {
	
	Thread.sleep(100000);
	String json = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_ActivateCheck.HistoricStartDate+"\",\"toDate\":\""+FE_ActivateCheck.HistoricEndDate+"\",\"checkName\":\"bad_data_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"Y\",\"maxDate\":\"1994-05-06\",\"maxRun\":\"1\"}";
	
//	String post_cr_valid =	getURL().getString("post_get_results_data_drift");

	{
		Response response=given()
				.relaxedHTTPSValidation()	
				.header("token", FE_login_endpoints.token)
				.header("accept","application/json")
				.header("Content-Type" ,"application/json")	
				.body(json)
				.when()
		          .post(FE_URL_paths.post_url_get_results_bad);
		response.then().log().all();	
		      
		return response;
	}
}
public static Response getResults_His_DefCheck() throws InterruptedException {
	
	Thread.sleep(7000);
	String json1 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"fromDate\":\""+FE_ActivateCheck.HistoricStartDate+"\",\"toDate\":\""+FE_ActivateCheck.HistoricEndDate+"\",\"checkName\":\"default_check\",\"colName\":\"\",\"dGroupVal\":\"\",\"globalSearchTerm\":\"\",\"historicFetch\":\"Y\",\"maxDate\":\"1994-05-06\",\"maxRun\":\"1\"}";
	
//	String post_cr_valid =	getURL().getString("post_get_results_data_drift");

	{
		Response response=given()
				.relaxedHTTPSValidation()	
				.header("token", FE_login_endpoints.token)
				.header("accept","application/json")
				.header("Content-Type" ,"application/json")	
				.body(json1)
				.when()
		          .post(FE_URL_paths.post_url_get_results_def_chk);
		response.then().log().all();	
		      
		return response;
	}
}

}
