import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.apache.http.HttpStatus.SC_OK;

public class TestUser {
    public static String email;
    public static String password;

    public static RequestSpecification req = new RequestSpecBuilder()
            .setBaseUri("https://stellarburgers.education-services.ru")
            .setContentType("application/json")
            .log(LogDetail.ALL)
            .build();


    public static Response createTestUser() {

        email = "ivettisimos" + System.currentTimeMillis() + "@ya.ru";
        password = "leozino123";
        User user = new User(email, password, "Ivetti");
        return RestAssured.given()
                .spec(req)
                .body(user)
                .when()
                .post("/api/auth/register");
    }

    public static void checkCreateUserStatus(Response response) {
        response.then()
                .log().all()
                .statusCode(SC_OK)
                .extract().response();
    }
}
