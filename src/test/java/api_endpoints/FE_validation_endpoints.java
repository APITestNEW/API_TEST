package api_endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api_payloads.FE_template;
import api_payloads.FE_validation;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FE_validation_endpoints {

 public static int id3;
	
	public static Response searchValidation() throws InterruptedException {
		
		{
			Thread.sleep(50000);
			String json = "{\"countRequired\":false,\"searchOption\":\"1\",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"projectId\":\""+FE_template.ProjId+"\",\"domainId\":\""+FE_template.DomainId+"\",\"pageNo\":0,\"pageSize\":10,\"columnFilter\":\"\",\"globalSearchOption\":\""+FE_template_endpoints.id4+"\",\"filterCondtionMap\":{}}";
			
	//		String post_search_valid =	getURL().getString("post_search_validation");

			{
				Response response=given()
						.relaxedHTTPSValidation()	
						.header("token", FE_login_endpoints.token)
						.header("accept","application/json")
						.header("Content-Type" ,"application/json")	
						.body(json)
						.when()
				          .post(FE_URL_paths.post_url_search_validation);
				response.then().log().all();
				JsonPath r1 = response.jsonPath();
				  id3 = r1.get("result.validations[1].ValidationId");
			return response;
			}
		}
	}
		
		public static Response searchValidation_RCA() throws InterruptedException {
			
			{
				Thread.sleep(50000);
				String json = "{\"countRequired\":false,\"searchOption\":\"1\",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"projectId\":\""+FE_template.ProjId+"\",\"domainId\":\""+FE_template.DomainId+"\",\"pageNo\":0,\"pageSize\":10,\"columnFilter\":\"\",\"globalSearchOption\":\""+FE_template_endpoints.id4+"\",\"filterCondtionMap\":{}}";
				
		//		String post_search_valid =	getURL().getString("post_search_validation");

				{
					Response response=given()
							.relaxedHTTPSValidation()	
							.header("token", FE_login_endpoints.token)
							.header("accept","application/json")
							.header("Content-Type" ,"application/json")	
							.body(json)
							.when()
					          .post(FE_URL_paths.post_url_search_validation);
					response.then().log().all();
					JsonPath r1 = response.jsonPath();
					  id3 = r1.get("result.validations[1].ValidationId");
				return response;
				}
			
		}
		}
		
			public static Response searchValidation_Microseg() throws InterruptedException {
				
				{
					Thread.sleep(50000);
					String json = "{\"countRequired\":false,\"searchOption\":\"1\",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"projectId\":\""+FE_template.ProjId+"\",\"domainId\":\""+FE_template.DomainId+"\",\"pageNo\":0,\"pageSize\":10,\"columnFilter\":\"\",\"globalSearchOption\":\""+FE_template_endpoints.id4+"\",\"filterCondtionMap\":{}}";
					
			//		String post_search_valid =	getURL().getString("post_search_validation");

					{
						Response response=given()
								.relaxedHTTPSValidation()	
								.header("token", FE_login_endpoints.token)
								.header("accept","application/json")
								.header("Content-Type" ,"application/json")	
								.body(json)
								.when()
						          .post(FE_URL_paths.post_url_search_validation);
						response.then().log().all();
						JsonPath r1 = response.jsonPath();
						  id3 = r1.get("result.validations[0].ValidationId");
					return response;
				}
				}
			}
			
			public static Response searchValidation_sanity() throws InterruptedException {
				
				{
					Thread.sleep(2000);
					String json = "{\"countRequired\":false,\"searchOption\":\"1\",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"projectId\":\""+FE_template.ProjId+"\",\"domainId\":\""+FE_template.DomainId+"\",\"pageNo\":0,\"pageSize\":10,\"columnFilter\":\"\",\"globalSearchOption\":\""+FE_template_endpoints.sanity_id+"\",\"filterCondtionMap\":{}}";
					
			//		String post_search_valid =	getURL().getString("post_search_validation");

					{
						Response response=given()
								.relaxedHTTPSValidation()	
								.header("token", FE_login_endpoints.token)
								.header("accept","application/json")
								.header("Content-Type" ,"application/json")	
								.body(json)
								.when()
						          .post(FE_URL_paths.post_url_search_validation);
						response.then().log().all();
						JsonPath r1 = response.jsonPath();
						  id3 = r1.get("result.validations[1].ValidationId");
					return response;
					}
				}
			}
			
	public static Response searchValidation_micro_sanity() throws InterruptedException {
				
				{
					Thread.sleep(2000);
					String json = "{\"countRequired\":false,\"searchOption\":\"1\",\"fromDate\":\""+FE_template.FromDate+"\",\"toDate\":\""+FE_template.ToDate+"\",\"projectId\":\""+FE_template.ProjId+"\",\"domainId\":\""+FE_template.DomainId+"\",\"pageNo\":0,\"pageSize\":10,\"columnFilter\":\"\",\"globalSearchOption\":\""+FE_template_endpoints.sanity_id+"\",\"filterCondtionMap\":{}}";
					
			//		String post_search_valid =	getURL().getString("post_search_validation");

					{
						Response response=given()
								.relaxedHTTPSValidation()	
								.header("token", FE_login_endpoints.token)
								.header("accept","application/json")
								.header("Content-Type" ,"application/json")	
								.body(json)
								.when()
						          .post(FE_URL_paths.post_url_search_validation);
						response.then().log().all();
						JsonPath r1 = response.jsonPath();
						  id3 = r1.get("result.validations[0].ValidationId");
					return response;
					}
				}
			}
		}
		
/*

	public static Response FE_Bulk_test(FE_validation load3) {
		
		String post_cr_validation =	getURL().getString("post_cr_validation");
		{
			Response response=given()
					.relaxedHTTPSValidation()	
					.header("token", "f57b8f02-c96f-46fe-a590-11632bde3a62")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(load3)
					.when()
			          .post(post_cr_validation);
			      
			return response;
		
		}
		}*/

	


