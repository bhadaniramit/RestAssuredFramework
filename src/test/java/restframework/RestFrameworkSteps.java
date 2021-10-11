package restframework;

import HttpMethodClass.RestUtils;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import java.io.IOException;

public class RestFrameworkSteps {
    ReadFile readProperties;
    String baseURI;

    @Given("I will run the Get Call from my Framework")
    public void getURL() {
        baseURI = "https://reqres.in/api/users?page=2";
        RestUtils utilityMethod = new RestUtils();
        Response response = utilityMethod.getResponse(baseURI);
        System.out.println("Response Body " + response.asPrettyString());
    }

    @Given("I will trigger the API with Param {string} and {int}")
    public void getURLWithParam(String key, int id) throws IOException {
        baseURI = "https://reqres.in/api/users";
        RestUtils utilityMethod = new RestUtils();
        Response response = utilityMethod.getResponseWithVariable(baseURI, key, id);
        System.out.println("Response Body " + response.asPrettyString());
    }
}
