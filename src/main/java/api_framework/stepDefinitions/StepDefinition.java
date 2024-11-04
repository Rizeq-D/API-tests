package api_framework.stepDefinitions;

import api_framework.resources.TestDataBuild;
import api_framework.resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.reziq.pojo.AddPlace;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinition extends Utils {

    RequestSpecification res;
    ResponseSpecification responseSpecification;
    Response response;
    TestDataBuild testDataBuild = new TestDataBuild();

    @Given("Add Place Payload")
    public void add_place_payload() {

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        AddPlace addPlace = testDataBuild.addPlacePayload();

        res = given().spec(super.requestSpecification()).body(addPlace);

    }
    @When("user calls {string} with Post http request")
    public void user_calls_with_post_http_request(String string) {
        // Write code here that turns the phrase above into concrete actions
        response = res.when().post("/maps/api/place/add/json")
                .then().spec(responseSpecification).extract().response();
    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(response.getStatusCode(), 200);
    }
    @Then("{string} in response body is OK")
    public void in_response_body_is_ok(String KeyValue) {
        // Write code here that turns the phrase above into concrete actions
        String responseString = response.asString();
        JsonPath jsonPath = new JsonPath(responseString);
        assertEquals("OK", jsonPath.get(KeyValue).toString());
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        String responseString = response.asString();
        JsonPath jsonPath = new JsonPath(responseString);
        assertEquals(jsonPath.get(keyValue).toString(), expectedValue);
    }
}



















