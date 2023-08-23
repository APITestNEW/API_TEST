package api_endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api_payloads.FE_ActivateCheck;
import api_payloads.FE_login;
import api_payloads.FE_template;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class FE_activateCheck_endpoints {
	
	public void setup()
	{
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	
	
	public static Response activateCheck_DataDrift() throws InterruptedException {
		
		{
			String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"checkName\":\"Data Drift Check\",\"columnNames\":[{\"name\":\""+FE_ActivateCheck.DataDriftCheckCol+"\",\"threshold\":\"1\"}]}";
			Thread.sleep(5000);
		//	String post_act_chk =	getURL().getString("post_activate_check");

			{
				Response response=given()
						.relaxedHTTPSValidation()	
						.header("token", FE_login_endpoints.token)
						.header("accept","application/json")
						.header("Content-Type" ,"application/json")	
						.body(json2)
						.when()
				          .post(FE_URL_paths.post_url_activate_check);
				response.then().log().all();
			return response;
		}
	}

	}
public static Response ActivateCheck_his_DataDrift() throws InterruptedException {
		
		{
			String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"idData\":"+FE_template_endpoints.id2+",\"buildHistoricFingerPrint\":\"Y\",\"historicStartDate\":\"1889-05-24\",\"historicEndDate\":\"2015-05-30\",\"historicDateFormat\":\"yyyy/MM/dd\",\"incrementalMatching\":\"Y\",\"recordCountAnomaly\":\"Y\",\"keyBasedRecordCountAnomaly\":\"N\",\"recordCountAnomalyThreshold\":3,\"dupRowAll\":\"Y\",\"dupRowIdentity\":\"N\",\"dupRowAllThreshold\":0,\"dupRowIdentityThreshold\":0,\"groupEquality\":\"N\",\"groupEqualityThreshold\":0,\"dataDriftCheck\":\"N\",\"dataDriftThreshold\":0,\"numericalStatCheck\":\"N\",\"numericalStatThreshold\":\"0.0\",\"stringStatCheck\":\"N\",\"stringStatThreshold\":\"\",\"fileNameValidation\":\"N\",\"colOrderValidation\":\"N\",\"entityColumn\":\"N\",\"recordAnomalyCheck\":\"N\",\"recordAnomalyThreshold\":\"\",\"nonNullCheck\":\"Y\",\"nonNullThreshold\":\"\",\"applyRules\":\"N\",\"applyDerivedColumns\":\"N\",\"csvDir\":\"\",\"updateFrequency\":\"Never\",\"frequencyDays\":0,\"timeSeries\":\"None\",\"duplicateCheck\":\"Y\",\"timelinessKeyChk\":\"N\",\"defaultCheck\":\"N\",\"defaultValues\":null,\"patternCheck\":\"N\",\"dateRuleChk\":\"N\",\"badData\":\"N\",\"lengthCheck\":\"N\",\"maxLengthCheck\":\"N\",\"dGroupNullCheck\":\"N\",\"dGroupDateRuleCheck\":\"N\",\"validityThreshold\":1,\"dGroupDataDriftCheck\":\"N\",\"thresholdsApplyOption\":0,\"defaultPatternCheck\":\"N\",\"createdByUser\":\"prajaktapatil\",\"data_domain\":2,\"reprofiling\":\"N\"}\r\n"
					+ "";
			Thread.sleep(5000);
	//		String post_act_chk_his =	getURL().getString("post_activate_check_his");

			{
				Response response=given()
						.relaxedHTTPSValidation()	
						.header("token", FE_login_endpoints.token)
						.header("accept","application/json")
						.header("Content-Type" ,"application/json")	
						.body(json2)
						.when()
				          .post(FE_URL_paths.post_url_activate_check_his);
				response.then().log().all();
			return response;
		}
	}

	}

public static Response ActivateCheck_incr_DataDrift() throws InterruptedException {
	
	{
		String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"idData\":"+FE_template_endpoints.id2+",\"buildHistoricFingerPrint\":\"N\",\"historicStartDate\":null,\"historicEndDate\":null,\"historicDateFormat\":\"\",\"incrementalMatching\":\"Y\",\"recordCountAnomaly\":\"Y\",\"keyBasedRecordCountAnomaly\":\"N\",\"recordCountAnomalyThreshold\":3,\"dupRowAll\":\"N\",\"dupRowIdentity\":\"N\",\"dupRowAllThreshold\":0,\"dupRowIdentityThreshold\":0,\"groupEquality\":\"N\",\"groupEqualityThreshold\":0,\"dataDriftCheck\":\"Y\",\"dataDriftThreshold\":0,\"numericalStatCheck\":\"N\",\"numericalStatThreshold\":\"0.0\",\"stringStatCheck\":\"N\",\"stringStatThreshold\":\"\",\"fileNameValidation\":\"N\",\"colOrderValidation\":\"N\",\"entityColumn\":\"N\",\"recordAnomalyCheck\":\"N\",\"recordAnomalyThreshold\":\"\",\"nonNullCheck\":\"N\",\"nonNullThreshold\":\"\",\"applyRules\":\"N\",\"applyDerivedColumns\":\"N\",\"csvDir\":\"\",\"updateFrequency\":\"Never\",\"frequencyDays\":0,\"timeSeries\":\"None\",\"duplicateCheck\":\"N\",\"timelinessKeyChk\":\"N\",\"defaultCheck\":\"N\",\"defaultValues\":null,\"patternCheck\":\"N\",\"dateRuleChk\":\"N\",\"badData\":\"N\",\"lengthCheck\":\"N\",\"maxLengthCheck\":\"N\",\"dGroupNullCheck\":\"N\",\"dGroupDateRuleCheck\":\"N\",\"validityThreshold\":1,\"dGroupDataDriftCheck\":\"N\",\"thresholdsApplyOption\":0,\"defaultPatternCheck\":\"N\",\"createdByUser\":\"prajaktapatil\",\"data_domain\":2,\"reprofiling\":\"N\"}";
		Thread.sleep(50000);
//		String post_act_chk_his =	getURL().getString("post_activate_check_his");

		{
			Response response=given()
					.relaxedHTTPSValidation()	
					.header("token", FE_login_endpoints.token)
					.header("accept","application/json")
					.header("Content-Type" ,"application/json")	
					.body(json2)
					.when()
			          .post(FE_URL_paths.post_url_activate_check_his);
			response.then().log().all();
		return response;
	}
}

}
public static Response ActivateCheck_Bulk_RCA_BadData() throws InterruptedException {
	
	{
		String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"checkName\":\"Bad Data Check\",\"columnNames\":[{\"name\":\""+FE_ActivateCheck.BadDataCheckCol+"\",\"threshold\":\"1\"}]}";
		Thread.sleep(3000);
		//	d.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//			String post_act_chk =	getURL().getString("post_activate_check");

			{
				Response response=given()
						.relaxedHTTPSValidation()	
						.header("token", FE_login_endpoints.token)
						.header("accept","application/json")
						.header("Content-Type" ,"application/json")	
						.body(json2)
						.when()
				          .post(FE_URL_paths.post_url_activate_check);
				response.then().log().all();
		return response;
	}
}

}

	public static Response ActivateCheck_Bulk_RCA_Def_Check() throws InterruptedException {
	
	{
		String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"checkName\":\"Default Check\",\"columnNames\":[{\"name\":\""+FE_ActivateCheck.DefcheckCheckCol+"\",\"threshold\":\"0\",\"defaultvalues\":\""+FE_ActivateCheck.DefaultValue+"\"}]}";
		Thread.sleep(3000);
		//	d.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//			String post_act_chk =	getURL().getString("post_activate_check");

			{
				Response response=given()
						.relaxedHTTPSValidation()	
						.header("token", FE_login_endpoints.token)
						.header("accept","application/json")
						.header("Content-Type" ,"application/json")	
						.body(json2)
						.when()
				          .post(FE_URL_paths.post_url_activate_check);
				response.then().log().all();
		return response;
	}
}

}
	
	public static Response ActivateCheck_Bulk_RCA_Length_Check() throws InterruptedException {
		
		{
			String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"checkName\":\"Length Check\",\"columnNames\":[{\"name\":\""+FE_ActivateCheck.LengthcheckCol+"\",\"threshold\":\"0\",\"lengthValue\":\""+FE_ActivateCheck.LengthCheckVal+"\"}]}";
			Thread.sleep(3000);
			//	d.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//				String post_act_chk =	getURL().getString("post_activate_check");

				{
					Response response=given()
							.relaxedHTTPSValidation()	
							.header("token", FE_login_endpoints.token)
							.header("accept","application/json")
							.header("Content-Type" ,"application/json")	
							.body(json2)
							.when()
					          .post(FE_URL_paths.post_url_activate_check);
					response.then().log().all();
			return response;
		}
	}

	}
	
	
	public static Response ActivateCheck_Bulk_RCA_Max_Length_Check() throws InterruptedException {
		
		{
			String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"checkName\":\"Max Length Check\",\"columnNames\":[{\"name\":\""+FE_ActivateCheck.MaxLengthCheckCol+"\",\"threshold\":\"0\",\"lengthValue\":\""+FE_ActivateCheck.MaxLengthCheckVal+"\"}]}";
			Thread.sleep(3000);
			//	d.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//				String post_act_chk =	getURL().getString("post_activate_check");

				{
					Response response=given()
							.relaxedHTTPSValidation()	
							.header("token", FE_login_endpoints.token)
							.header("accept","application/json")
							.header("Content-Type" ,"application/json")	
							.body(json2)
							.when()
					          .post(FE_URL_paths.post_url_activate_check);
					response.then().log().all();
			return response;
		}
	}

	}
	
public static Response ActivateCheck_Bulk_RCA_Regex_Pattern_Check() throws InterruptedException {
		
		{
			String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"checkName\":\"Pattern Check\",\"columnNames\":[{\"name\":\""+FE_ActivateCheck.RegexPatternCheckCol+"\",\"threshold\":\"1\", \"patterns\":\""+FE_ActivateCheck.RegexPattern+"\"}]}";
			Thread.sleep(3000);
			//	d.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//				String post_act_chk =	getURL().getString("post_activate_check");

				{
					Response response=given()
							.relaxedHTTPSValidation()	
							.header("token", FE_login_endpoints.token)
							.header("accept","application/json")
							.header("Content-Type" ,"application/json")	
							.body(json2)
							.when()
					          .post(FE_URL_paths.post_url_activate_check);
					response.then().log().all();
			return response;
		}
	}

	}	
	
public static Response ActivateCheck_Bulk_RCA_Default_Pattern_Check() throws InterruptedException {
	
	{
		String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"checkName\":\"Default Pattern Check\",\"columnNames\":[{\"name\":\""+FE_ActivateCheck.DefaultPatternCheckCol+"\",\"threshold\":\"0\"}]}";
		Thread.sleep(3000);
		//	d.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//			String post_act_chk =	getURL().getString("post_activate_check");

			{
				Response response=given()
						.relaxedHTTPSValidation()	
						.header("token", FE_login_endpoints.token)
						.header("accept","application/json")
						.header("Content-Type" ,"application/json")	
						.body(json2)
						.when()
				          .post(FE_URL_paths.post_url_activate_check);
				response.then().log().all();
		return response;
	}
}

}
public static Response ActivateCheck_Bulk_RCA_Null_Check() throws InterruptedException {
	
	{
		String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"checkName\":\"Null Check\",\"columnNames\":[{\"name\":\""+FE_ActivateCheck.NullCheckCol+"\",\"threshold\":\"1\"}]}";
		Thread.sleep(3000);
		//	d.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//			String post_act_chk =	getURL().getString("post_activate_check");

			{
				Response response=given()
						.relaxedHTTPSValidation()	
						.header("token", FE_login_endpoints.token)
						.header("accept","application/json")
						.header("Content-Type" ,"application/json")	
						.body(json2)
						.when()
				          .post(FE_URL_paths.post_url_activate_check);
				response.then().log().all();
		return response;
	}
}

}

public static Response ActivateCheck_Bulk_RCA_Duplicate_Check() throws InterruptedException {
	
	{
		String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"checkName\":\"Duplicate Check SelectedFields\",\"columnNames\":[{\"name\":\""+FE_ActivateCheck.DuplicateCheckCol+"\",\"threshold\":\"1\"}]}";
		Thread.sleep(3000);
		//	d.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//			String post_act_chk =	getURL().getString("post_activate_check");

			{
				Response response=given()
						.relaxedHTTPSValidation()	
						.header("token", FE_login_endpoints.token)
						.header("accept","application/json")
						.header("Content-Type" ,"application/json")	
						.body(json2)
						.when()
				          .post(FE_URL_paths.post_url_activate_check);
				response.then().log().all();
		return response;
	}
}

}
public static Response ActivateCheck_Bulk_RCA_Date_Check() throws InterruptedException {
	
	{
		String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"checkName\":\"Date Rule Check\",\"columnNames\":[{\"name\":\""+FE_ActivateCheck.DateCheckCol+"\",\"threshold\":\"0\",\"dateformat\":\"yyyy-MM-dd\"}]}";
		Thread.sleep(3000);
		//	d.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//			String post_act_chk =	getURL().getString("post_activate_check");

			{
				Response response=given()
						.relaxedHTTPSValidation()	
						.header("token", FE_login_endpoints.token)
						.header("accept","application/json")
						.header("Content-Type" ,"application/json")	
						.body(json2)
						.when()
				          .post(FE_URL_paths.post_url_activate_check);
				response.then().log().all();
		return response;
	}
}

}

public static Response ActivateCheck_Bulk_VA_Check() throws InterruptedException {
	
	{
		String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"checkName\":\"Value Anomaly Check\",\"columnNames\":[{\"name\":\""+FE_ActivateCheck.VACheckCol+"\",\"threshold\":\"1\"}]}";
		Thread.sleep(3000);
		//	d.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//			String post_act_chk =	getURL().getString("post_activate_check");

			{
				Response response=given()
						.relaxedHTTPSValidation()	
						.header("token", FE_login_endpoints.token)
						.header("accept","application/json")
						.header("Content-Type" ,"application/json")	
						.body(json2)
						.when()
				          .post(FE_URL_paths.post_url_activate_check);
				response.then().log().all();
		return response;
	}
}

}
public static Response ActivateCheck_Bulk_Dist_Check() throws InterruptedException {
	
	{
		String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"checkName\":\"Numerical Statistics Check\",\"columnNames\":[{\"name\":\""+FE_ActivateCheck.DistCheckCol1+"\",\"threshold\":\"0\"},{\"name\":\""+FE_ActivateCheck.DistCheckCol2+"\",\"threshold\":\"0\"}]}";
		Thread.sleep(3000);
		//	d.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//			String post_act_chk =	getURL().getString("post_activate_check");

			{
				Response response=given()
						.relaxedHTTPSValidation()	
						.header("token", FE_login_endpoints.token)
						.header("accept","application/json")
						.header("Content-Type" ,"application/json")	
						.body(json2)
						.when()
				          .post(FE_URL_paths.post_url_activate_check);
				response.then().log().all();
		return response;
	}
}
}
public static Response ActivateCheck_His_Check_1() throws InterruptedException {
	
	{
		String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"idData\":"+FE_template_endpoints.id2+",\"buildHistoricFingerPrint\":\"Y\",\"historicStartDate\":\"1889-05-24\",\"historicEndDate\":\"2015-05-30\",\"historicDateFormat\":\"\",\"incrementalMatching\":\"Y\",\"recordCountAnomaly\":\"Y\",\"keyBasedRecordCountAnomaly\":\"N\",\"recordCountAnomalyThreshold\":3,\"dupRowAll\":\"Y\",\"dupRowIdentity\":\"N\",\"dupRowAllThreshold\":0,\"dupRowIdentityThreshold\":0,\"groupEquality\":\"N\",\"groupEqualityThreshold\":0,\"dataDriftCheck\":\"N\",\"dataDriftThreshold\":0,\"numericalStatCheck\":\"N\",\"numericalStatThreshold\":\"0.0\",\"stringStatCheck\":\"N\",\"stringStatThreshold\":\"\",\"fileNameValidation\":\"N\",\"colOrderValidation\":\"N\",\"entityColumn\":\"N\",\"recordAnomalyCheck\":\"N\",\"recordAnomalyThreshold\":\"\",\"nonNullCheck\":\"Y\",\"nonNullThreshold\":\"\",\"applyRules\":\"N\",\"applyDerivedColumns\":\"N\",\"csvDir\":\"\",\"updateFrequency\":\"Never\",\"frequencyDays\":0,\"timeSeries\":\"None\",\"duplicateCheck\":\"Y\",\"timelinessKeyChk\":\"N\",\"defaultCheck\":\"N\",\"defaultValues\":null,\"patternCheck\":\"N\",\"dateRuleChk\":\"N\",\"badData\":\"N\",\"lengthCheck\":\"N\",\"maxLengthCheck\":\"N\",\"dGroupNullCheck\":\"N\",\"dGroupDateRuleCheck\":\"N\",\"validityThreshold\":1,\"dGroupDataDriftCheck\":\"N\",\"thresholdsApplyOption\":0,\"defaultPatternCheck\":\"N\",\"createdByUser\":\"prajaktapatil\",\"data_domain\":2,\"reprofiling\":\"N\"}\r\n"
				+ "";
		Thread.sleep(5000);
//		String post_act_chk_his =	getURL().getString("post_activate_check_his");

		{
			Response response=given()
					.relaxedHTTPSValidation()	
					.header("token", FE_login_endpoints.token)
					.header("accept","application/json")
					.header("Content-Type" ,"application/json")	
					.body(json2)
					.when()
			          .post(FE_URL_paths.post_url_activate_check_his);
			response.then().log().all();
		return response;
	}
}
}
public static Response ActivateCheck_His_Check_2() throws InterruptedException {
	
	{
		String json2 = "{\"idApp\":"+FE_validation_endpoints.id3+",\"idData\":"+FE_template_endpoints.id2+",\"buildHistoricFingerPrint\":\"Y\",\"historicStartDate\":\""+FE_ActivateCheck.HistoricStartDate+"\",\"historicEndDate\":\""+FE_ActivateCheck.HistoricEndDate+"\",\"historicDateFormat\":\"\",\"incrementalMatching\":\"Y\",\"recordCountAnomaly\":\"Y\",\"keyBasedRecordCountAnomaly\":\"N\",\"recordCountAnomalyThreshold\":3,\"dupRowAll\":\"Y\",\"dupRowIdentity\":\"N\",\"dupRowAllThreshold\":0,\"dupRowIdentityThreshold\":0,\"groupEquality\":\"N\",\"groupEqualityThreshold\":0,\"dataDriftCheck\":\"Y\",\"dataDriftThreshold\":0,\"numericalStatCheck\":\"N\",\"numericalStatThreshold\":\"0.0\",\"stringStatCheck\":\"N\",\"stringStatThreshold\":\"\",\"fileNameValidation\":\"N\",\"colOrderValidation\":\"N\",\"entityColumn\":\"N\",\"recordAnomalyCheck\":\"N\",\"recordAnomalyThreshold\":\"\",\"nonNullCheck\":\"Y\",\"nonNullThreshold\":\"\",\"applyRules\":\"Y\",\"applyDerivedColumns\":\"N\",\"csvDir\":\"\",\"updateFrequency\":\"Never\",\"frequencyDays\":0,\"timeSeries\":\"None\",\"duplicateCheck\":\"Y\",\"timelinessKeyChk\":\"N\",\"defaultCheck\":\"N\",\"defaultValues\":null,\"patternCheck\":\"N\",\"dateRuleChk\":\"N\",\"badData\":\"N\",\"lengthCheck\":\"N\",\"maxLengthCheck\":\"N\",\"dGroupNullCheck\":\"N\",\"dGroupDateRuleCheck\":\"N\",\"validityThreshold\":1,\"dGroupDataDriftCheck\":\"N\",\"thresholdsApplyOption\":0,\"defaultPatternCheck\":\"N\",\"createdByUser\":\"prajaktapatil\",\"data_domain\":2,\"reprofiling\":\"N\"}\r\n"
				+ "";
		Thread.sleep(5000);
//		String post_act_chk_his =	getURL().getString("post_activate_check_his");

		{
			Response response=given()
					.relaxedHTTPSValidation()	
					.header("token", FE_login_endpoints.token)
					.header("accept","application/json")
					.header("Content-Type" ,"application/json")	
					.body(json2)
					.when()
			          .post(FE_URL_paths.post_url_activate_check_his);
			response.then().log().all();
		return response;
	}
}
}


	
	
	}
