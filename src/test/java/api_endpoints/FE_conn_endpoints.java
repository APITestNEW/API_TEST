package api_endpoints;

import static io.restassured.RestAssured.given;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeTest;

import api_payloads.FE_template;
import io.restassured.RestAssured;

import io.restassured.response.Response;

public class FE_conn_endpoints {
	
	static String token;
	public static int id;
	
	
	public void setup()
	{
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	
	public static Response conn() {
		
	
	String timestamp= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	String connection = "APIconn"+timestamp;
	 System.out.println(connection);
	String json= "{\"schemaName\":\""+connection+"\",\"schemaType\":\"MSSQL\",\"uri\":\"66.11.121.142\",\"database\":\"fe.dbo\",\"username\":\"sa\",\"password\":\"Databuck125\",\"port\":\"1457\",\"domain\":\"\",\"Domain\":\"\",\"serviceName\":\"\",\"masterKey\":\"\",\"krb5conf\":\"\",\"autoGenerateId\":\"N\",\"suffix\":\"_inc, _tmp, v_\",\"prefix\":\"_inc, _tmp, v_\",\"hivejdbchost\":\"\",\"hivejdbcport\":\"\",\"sslEnb\":\"N\",\"incrementalDataReadEnabled\":\"N\",\"sslTrustStorePath\":\"\",\"trustPassword\":\"\",\"gatewayPath\":\"\",\"jksPath\":\"\",\"zookeeperUrl\":\"\",\"folderPath\":\"\",\"fileNamePattern\":\"\",\"fileDataFormat\":\"PSV(Pipe Delimited)\",\"headerPresent\":\"Y\",\"multiFolderEnabled\":\"N\",\"partitionedFolders\":\"N\",\"headerFilePath\":\"\",\"headerFileNamePattern\":\"\",\"headerFileDataFormat\":\"PSV(Pipe Delimited)\",\"accessKey\":\"\",\"secretKey\":\"\",\"bucketName\":\"\",\"privatekey\":\"\",\"privatekeyId\":\"\",\"bigQueryProjectName\":\"\",\"datasetName\":\"\",\"clientId\":\"\",\"clientEmail\":\"\",\"azureClientId\":\"\",\"azureClientSecret\":\"\",\"azureTenantId\":\"\",\"azureServiceURI\":\"\",\"azureFilePath\":\"\",\"enableFileMonitoring\":\"N\",\"multiPattern\":\"N\",\"startingUniqueCharCount\":0,\"endingUniqueCharCount\":0,\"maxFolderDepth\":0,\"fileEncrypted\":\"N\",\"singleFile\":\"N\",\"externalFileNamePatternId\":\"N\",\"kmsAuthDisabled\":\"Y\",\"readLatestPartition\":\"N\",\"alationIntegrationEnabled\":\"N\",\"createdBy\":\""+FE_template.CreatedBy+"\",\"idUser\":"+FE_template.UserId+",\"domainId\":"+FE_template.DomainId+",\"projectId\":"+FE_template.ProjId+",\"ignoreFile\":null,\"ignoreFolder\":null,\"externalFileName\":\"\",\"patternColumn\":\"\",\"headerColumn\":\"\",\"localDirectoryColumnIndex\":\"\",\"xsltFolderPath\":\"\",\"clusterType\":\"databricks\",\"pushDownQueryEnabled\":\"N\",\"httpPath\":\"\",\"clusterPolicyId\":\"\",\"azureAuthenticationType\":\"ActiveDirectoryManagedIdentity\"}";
//		String post_url_login =	getURL().getString("post_cr_conn");
	{
		Response response=given()
				.relaxedHTTPSValidation()	
				.header("token", FE_login_endpoints.token)
				.header("accept","application/json")
				.header("Content-Type" ,"application/json")
				.body(json)	
				.when()
		          .post(FE_URL_paths.post_url_cr_conn);
		response.then().log().all();
		id =	response.path("idDataSchema");
		
		
		
		
		return response;
	} } 
/*static ResourceBundle getURL() {
		
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	
	public static Response cr_conn(FE_conn load2) {
		
		String post_cr_conn =	getURL().getString("post_cr_conn");
		{
			Response response=given()
					.relaxedHTTPSValidation()	
					.header("token", "f57b8f02-c96f-46fe-a590-11632bde3a62")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(load2)
					.when()
			          .post(post_cr_conn);
			      
			return response; */

	
	}


