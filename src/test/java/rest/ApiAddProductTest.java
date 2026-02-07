package rest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class ApiAddProductTest {

    @BeforeMethod
    public static void setUp(){
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
    }

    @Test
    public static void addProduct(){
        String cookie = "3922f25c3426dde05d90ef83378f5883f93aa6fcbc6cfe7b8532f4fe8e529609;",
                body = "product_attribute_72_5_18=53" +
                        "&product_attribute_72_6_19=54" +
                        "&product_attribute_72_3_20=57" +
                        "&addtocart_72.EnteredQuantity=1";

        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("ARRAffinity", cookie)
                .body(body)
                .when()
                .post("/addproducttocart/details/72/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is (true))
                .body("message", is  ("The product has been added to your <a href=\"/cart\">shopping cart</a>"));
    }
}

