package api_endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api_payloads.FE_ActivateCheck;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FE_ApproveStatus_endpoints {
	
	public void setup()
	{
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	
	public static Response ApproveStatusValidation() throws InterruptedException {
		
			{
				String json = "{\"approvalStatusCode\":20,\r\n"
						+ "\"approvalComments\":\"\",\r\n"
						+ "\"idApp\":"+FE_validation_endpoints.id3+"}";
				Thread.sleep(1000);
			//	String post_app_status =	getURL().getString("post_approve_status");

				{
					Response response=given()
							.relaxedHTTPSValidation()	
							.header("token", FE_login_endpoints.token)
							.header("accept","application/json")
							.header("Content-Type" ,"application/json")	
							.body(json)
							.when()
					          .post(FE_URL_paths.post_url_approve_status);
					response.then().log().all();
			return response;
		}
	}

	}
	}
