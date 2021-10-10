package BasicPackage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class RestAssuredBasicClass {
    @Given("Trigger the basic Get Call and use of log all")
    public void trigger_the_basic_get_call_and_use_of_log_all(DataTable dataTable){
        List<String> myTable = dataTable.asList();
        String HeaderOfTable  = myTable.get(0);
        baseURI = "https://reqres.in/api/";
        basePath= "users";
        String Pattern = "YYYY/MM/DD";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Pattern);
        given()
                .queryParam("page", myTable.get(1))
                .get()
                .then()
                .log().everything()
                .body("per_page", equalTo(6))
                .and()
                .body("data[0].first_name", is("Michael"))
                .and()
                .body("data[1].first_name", equalToIgnoringCase("LINDSAY"))
                .assertThat()
                .contentType("application/json")
                .header("Content-Type", startsWith("application/json"))
                .header("Age", is(1765))
                .log().all();
    }
    @Given("I will follow the best way to assert {string}")
    public void assertionBestWay(String valueforQuery){
        int page, per_page, total_pages;
        String  email, first_name;
        baseURI = "https://reqres.in/api/users";

        Response response = given()
                .queryParam("page", valueforQuery)
                .when()
                .get();
        page = JsonPath.from(response.getBody().asPrettyString()).get("page");
        per_page = JsonPath.from(response.getBody().asPrettyString()).get("per_page");
        total_pages = JsonPath.from(response.getBody().asPrettyString()).get("total_pages");
        email = JsonPath.from(response.getBody().asPrettyString()).get("data[0].email");
        first_name = JsonPath.from(response.getBody().asPrettyString()).get("data[1].first_name");
        assertThat(new Object[]{page,per_page,total_pages,email,first_name}, equalTo(new Object[]{2,6,2,"Michael.lawson@reqres.in",
        "Lindsay"}));
    }
}