package org.reziq;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

    public static void main(String[] args) {

        JsonPath jsonPath = new JsonPath(HTTPMethods.CoursePrice());

        int courses = jsonPath.getInt("courses.size()");
        System.out.println(courses);
        System.out.println();

        int totalAmount = jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);
        System.out.println();

        String firstCourseTitle = jsonPath.get("courses[0].title");
        System.out.println(firstCourseTitle);
        System.out.println();

        int firstCoursePrice = jsonPath.getInt("courses[0].price");
        System.out.println(firstCoursePrice);



    }
}
