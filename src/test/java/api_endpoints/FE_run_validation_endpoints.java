package api_endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;


import api_payloads.FE_run_task;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FE_run_validation_endpoints {
	
	public void setup()
	{
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	
	public static Response run_validation() throws InterruptedException {
		
		String json = "{\"validationRunType\":\"full_load\",\"appIds\":"+FE_validation_endpoints.id3+"}";
		
		//		String post_run_valid=	getURL().getString("post_run_task");

				{
					Response response=given()
							.relaxedHTTPSValidation()	
							.header("token", FE_login_endpoints.token)
							.header("accept","application/json")
							.header("Content-Type" ,"application/json")	
							.body(json)
							.when()
					          .post(FE_URL_paths.post_url_run_task);
					response.then().log().all();   
					Thread.sleep(100000);
			return response;
			
		}
	}

}
