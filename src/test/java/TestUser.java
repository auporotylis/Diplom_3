import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class TestUser {
    public static String email = "ivettisimos" + System.currentTimeMillis() + "@ya.ru";
    public static String password = "leozino123";


    public static RequestSpecification req = new RequestSpecBuilder()
            .setBaseUri("https://stellarburgers.education-services.ru")
            .setContentType("application/json")
            .log(LogDetail.ALL)
            .build();


    public static void createTestUser() {
        Response response = given()
                .spec(req)
                .body("{\n" +
                        "    \"email\": \"" + email + "\",\n" +
                        "    \"password\": \"" + password +"\",\n" +
                        "    \"name\": \"Ivetti\"\n" +
                        "}")
                .when()
                .post("/api/auth/register")
                .then()
                .log().all()
                .statusCode(SC_OK)
                .extract().response();

    }
}
