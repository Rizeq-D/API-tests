package org.reziq;


import io.restassured.path.json.JsonPath;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.given;

public class OAuthTesting {

    public static void main(String[] args) {

        String responsePost = given()
                .formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type", "client_credentials")
                .formParam("scope", "trust")
                .when().log().all()
                .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
                .asString();

        System.out.println(responsePost);

        JsonPath jsonPath = new JsonPath(responsePost);
        String accessToken = jsonPath.getString("access_token");
        System.out.println(accessToken);

        String responseGet = given()
                .param("access_token", "NqG79vjTl9nENeFatNjxNw==")
                .when().log().all()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails?access_token=NqG79vjTl9nENeFatNjxNw==")
                .asString();

        System.out.println(responseGet);
        
    }
}






















