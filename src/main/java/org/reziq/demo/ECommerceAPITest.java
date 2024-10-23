package org.reziq.demo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

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
    }
}
