package org.reziq.demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.reziq.pojo.AddPlace;
import org.reziq.pojo.Location;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

public class SerializeTest {

    public static void main (String [] args) {

        RestAssured.baseURI  = "https://rahulshettyacademy.com";

        AddPlace addPlace = new AddPlace();
        Location location = new Location();

        addPlace.setAccuracy(50);
        addPlace.setAddress("29, side layout, cohen 09");
        addPlace.setLanguage("French");
        addPlace.setName("FrontLine house");
        addPlace.setPhone_number("(+91) 983 893 3937");
        addPlace.setWebsite("http://google.com");
        List<String> myList = new ArrayList<>();
        myList.add("shoe park");
        myList.add("shop");
        addPlace.setTypes(myList);
        location.setLat(-38.383494);
        location.setLat(33.427362);
        addPlace.setLocation(location);

        Response res = given().log().all().queryParam("key", "qaclick123")
                .body(addPlace)
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .extract().response();

        String responseString = res.asString();
        System.out.println(responseString);

    }
}























