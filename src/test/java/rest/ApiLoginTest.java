package rest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class ApiLoginTest {
    @BeforeMethod
    public static void setUp(){
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
    }
    @Test
    public static void Login() {

        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", "user@user.ru")
                .formParam("Password", "123456")
                .formParam("RememberMe", "false")
                .when()
                .post("/login")
                .then()
                .log().all()
                //.statusCode(200)
                .log().headers();
                //.body(containsString("Demo Web Shop"));
    }
}
