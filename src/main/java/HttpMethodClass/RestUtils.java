package HttpMethodClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestUtils {

    public Response getResponse(String url) {
        return RestAssured.given()
//                    .queryParam(queryValue, id)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
//                .auth().oauth2("")
//                .header("Authorization", "Bearer")
                .log().all()
                .get(url);

    }

    public Response getResponseWithVariable(String url, String key, int id) {
        return RestAssured.given()
                .param(key, id)
//                    .queryParam(queryValue, id)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
//                .auth().oauth2("")
//                .header("Authorization", "Bearer")
                .log().all()
                .get(url);

    }
}
