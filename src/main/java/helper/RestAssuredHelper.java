package helper;

import com.aventstack.extentreports.ExtentTest;
import globalconstants.RequestType;

import globalconstants.RestAssuredConstants;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import reportmanagement.ExtentManager;
import io.restassured.filter.log.ResponseLoggingFilter;

import static globalconstants.CommonConstants.MAX_TIMEOUT;


public class RestAssuredHelper {
	public static String logs;
	protected  ResponseSpecBuilder resBuilder;
	protected RequestSpecification request;
	protected Response response = null;

	
	public Response SpecifyAndSendRequest(RequestType requestType, String url, String postModelAsString, boolean auth) {
		ExtentTest node = ExtentManager.getTest();
		resBuilder = new ResponseSpecBuilder();
		resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
//		resBuilder.expectStatusCode(200); // Expecting status code 200 (OK) as an example
		resBuilder.expectContentType(ContentType.JSON); // Expecting JSON content type as an example
		RestAssured.responseSpecification = resBuilder.build();

		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		/*authScheme.setUserName("Admin");
		authScheme.setPassword("secret");
		RestAssured.authentication = authScheme;*/

		request = RestAssured.given().log().all();
		try {
			if (auth) {
				request.headers( "Authorization", RestAssuredConstants.auth);
				System.out.println(RestAssuredConstants.auth);
				node.info("Headers : " +  "Authorization : " + RestAssuredConstants.auth);
			} else {
				//request.auth().preemptive().basic(ExecutionProperties.getProperty("username"),ExecutionProperties.getProperty("password"));
				request.headers(RestAssuredConstants.ContentType, RestAssuredConstants.ApplicationJson,"skipSecurityHeaderValidation","true");
				node.info("Headers : " + RestAssuredConstants.ContentType + " " + RestAssuredConstants.ApplicationJson);
			}
			//request.headers(RestAssuredConstants.ContentType, RestAssuredConstants.ApplicationJson, "Authorization", "Bearer mnmtrlv4e9vj5b115fcftrohpvcnbyfm");
			if (postModelAsString != null) {
				request.body(postModelAsString);
				node.info(postModelAsString);
			}
			switch (requestType) {
				case Delete:
					response = request.delete(url);
					//node.info("Request Type : DELETE");
					//node.info("URL : "+"https://psmw.gpay.digital/dev_mobiq_api"+url);
					break;
				case Get:
					node.info("Request Type : GET");
					node.info("URL : " + "https://dwdev1.qnb.com/extensibility/v1" + url);
					response = request.get(url);
					break;
				case Patch:
					response = request.patch(url);
					//	node.info("Request Type : PATCH");
					//	node.info("URL : "+"https://psmw.gpay.digital/dev_mobiq_api"+url);
					break;
				case Post:
					response = request.post(url);
					//	node.info("Request Type : POST");
					//	node.info("URL : "+"https://psmw.gpay.digital/dev_mobiq_api"+url);
					break;
				case Put:
					response = request.put(url);
					//	node.info("Request Type : PUT");
					//	node.info("URL : "+"https://psmw.gpay.digital/dev_mobiq_api"+url);
					break;
				default:
					throw new UnsupportedOperationException("Request type is not supported.");
			}
			response.then().log().all();
			node.info(response.asPrettyString());
		}

		catch (Exception e){
			e.printStackTrace();
		}
		return response;
	}

}
