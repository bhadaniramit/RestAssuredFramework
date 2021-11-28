package restframework;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.Map;

public class PostCall {



    String URL = "https://reqres.in/api/users";

    public String postCallBody(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "helloUser" );
        jsonObject.put("job", "politician");
        return jsonObject.toJSONString();
    }

    public void makeaPostCall(Map<String, String> myMap) {
    PostCall postCall = new PostCall();
    String postBody = postCall.postCallBody();
           given()
                    .body(postBody)
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .post(URL)
                    .then()
                    .assertThat()
                    .body("", equalTo(""));

    }
}
