package org.reziq.demo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ECommerceAPITest {

    public static void main(String[] args) {

        RequestSpecification requestSpecification =
                new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                        .setContentType(ContentType.JSON).build();

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserEmail("rahulshetty@gmail.com");
        loginRequest.setUserPassword("Iamking@000");

        RequestSpecification requestLogin =
                given().log().all().spec(requestSpecification).body(loginRequest);

        LoginResponse loginResponse = requestLogin.when().post("/api/ecom/auth/login")
                .then().log().all().extract().response().as(LoginResponse.class);

        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getUserId());
        System.out.println(loginResponse.getMessage());

        String token = loginResponse.getToken();
        String userId = loginResponse.getUserId();

        // Add a product to the fictional e-commerce.
        RequestSpecification addProductBaseRequest =
                new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                        .addHeader("authorization", token).build();

        RequestSpecification requestAddProduct = given().log().all().spec(addProductBaseRequest)
                .param("productName", "Bike")
                .param("productAddedBy", userId)
                .param("productCategory", "fashion")
                .param("productSubCategory", "shirts")
                .param("productPrice", "500")
                .param("productDescription", "Lenova")
                .param("productFor", "men");

        String addProductResponse = requestAddProduct.when()
                .post("/api/ecom/product/add-product")
                .then().log().all().extract().response().asString();
        JsonPath jsonPath = new JsonPath(addProductResponse);
        String productId = jsonPath.getString("productId");

    }
}
























