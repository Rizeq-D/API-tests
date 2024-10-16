package org.reziq;

import io.restassured.path.json.JsonPath;
import org.reziq.pojo.Api;
import org.reziq.pojo.GetCourse;
import org.reziq.pojo.WebAutomation;

import java.util.List;

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

        GetCourse getCourse = given()
                .param("access_token", "i3GB8npAi4KUxVbie4tVXA==")
                .when().log().all()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails?access_token=i3GB8npAi4KUxVbie4tVXA==")
                        .as(GetCourse.class);

        System.out.println(getCourse.getInstructor());
        System.out.println(getCourse.getLinkedIn());
        System.out.println(getCourse.getCourses().getApi().get(1).getCourseTitle());

        List<Api> apiCourses = getCourse.getCourses().getApi();

        for (int i = 0; i < apiCourses.size(); i++) {
            if (apiCourses.get(i).getCourseTitle()
                    .equalsIgnoreCase("soapUI Webservices testing")) {
                System.out.println(apiCourses.get(i).getPrice());

            }
        }
        List<WebAutomation> webAutomationList = getCourse.getCourses().getWebAutomation();
        for (int j = 0; j < webAutomationList.size(); j++) {
            System.out.println(webAutomationList.get(j).getCourseTitle());
        }
    }
}






















