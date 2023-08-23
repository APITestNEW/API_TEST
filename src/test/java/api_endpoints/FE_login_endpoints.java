package api_endpoints;

import static io.restassured.RestAssured.given;

import api_payloads.FE_login;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FE_login_endpoints {
	
	static String token;

	public void setup()
	{
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	
	public static Response loginDB() {
		
	//	String post_url_login =	getURL().getString("post_url_login");
		{
			String json="{\"email\":\""+FE_login.emailid+"\",\"password\":\""+FE_login.password+"\"}";
			Response response=given()
					.relaxedHTTPSValidation()	
					.header("token", FE_login.Tokenforlogin)
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(json)
					.when()
			          .post(FE_URL_paths.post_url_login);
						response.then().log().all();
						JsonPath r = response.jsonPath();
						  token = r.get("token");
							
			      
			return response;
		}
	}
}
