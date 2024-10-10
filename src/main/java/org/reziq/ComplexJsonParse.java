package org.reziq;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class ComplexJsonParse {

    public static void main(String[] args) {

        JsonPath jsonPath = new JsonPath(HTTPMethods.CoursePrice());

        int courses = jsonPath.getInt("courses.size()");
        System.out.println(courses);
        System.out.println();

        String firstCourseTitle = jsonPath.get("courses[0].title");
        System.out.println(firstCourseTitle);
        System.out.println();

        int firstCoursePrice = jsonPath.getInt("courses[0].price");
        System.out.println(firstCoursePrice);
        System.out.println("--------------------------------------------------------");

        int sum = 0;
        for (int i = 0; i<courses; i++) {
            String coursesTitles = jsonPath.get("courses["+i+"].title");
            int copies = jsonPath.getInt("courses["+i+"].copies");
            int coursePrice = jsonPath.getInt("courses["+i+"].price");
            int sumCoursePrices = copies * coursePrice;
            System.out.println(coursesTitles);

            sum = sum + sumCoursePrices;

            if(coursesTitles.equalsIgnoreCase("RPA")) {
                System.out.println(copies);
                System.out.println(coursePrice);
                System.out.println("the sum of RPA courses are: " + sumCoursePrices);
                System.out.println();
            }
            if (coursesTitles.equalsIgnoreCase("Selenium Python")) {
                System.out.println(copies);
                System.out.println(coursePrice);
                System.out.println("the sum of Selenium Python courses are: " + sumCoursePrices);
                System.out.println();
            }
            if (coursesTitles.equalsIgnoreCase("Cypress")) {
                System.out.println(copies);
                System.out.println(coursePrice);
                System.out.println("the sum of Cypress courses are: " + sumCoursePrices);
                System.out.println();
            }
        }
        System.out.println(sum);
        int purchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum, purchaseAmount);
    }
}
