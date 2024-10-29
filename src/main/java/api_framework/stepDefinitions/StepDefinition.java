package api_framework.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.reziq.pojo.AddPlace;
import org.reziq.pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StepDefinition {

    @Given("Add Place Payload")
    public void add_place_payload() {

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

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON).build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        RequestSpecification res = given().spec(requestSpecification).body(addPlace);

        Response response = res.when().post("/maps/api/place/add/json")
                .then().spec(responseSpecification).extract().response();

        String responseString = response.asString();
        System.out.println(responseString);

        throw new io.cucumber.java.PendingException();
    }
    @When("user calls {string} with Post http request")
    public void user_calls_with_post_http_request(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("{string} in response body is OK")
    public void in_response_body_is_ok(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
