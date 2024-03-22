package Tests;

import ObjectData.RequestObject.RequestAccount;
import ObjectData.ResponseObject.ResponseAccountSuccess;
import PropertyUtility.PropertyUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest {

    @Test
    public void testMethod(){
        //define client
        RequestSpecification requestSpecification  = RestAssured.given();
        requestSpecification.baseUri("https://demoqa.com/");
        requestSpecification.contentType("application/json");

        //define the request body
        PropertyUtility propertyUtility = new PropertyUtility("RequestData/createAccountData");
        RequestAccount requestAccountBody = new RequestAccount(propertyUtility.getAllData());
        requestSpecification.body(requestAccountBody);

        //interact with the response
        Response response = requestSpecification.post("Account/v1/User");
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());

        //validating the response body
        ResponseAccountSuccess responseAccountBody = response.body().as(ResponseAccountSuccess.class);
        System.out.println(responseAccountBody.getUserID());
        Assert.assertEquals(responseAccountBody.getUsername(),requestAccountBody.getUserName());

    }

}
