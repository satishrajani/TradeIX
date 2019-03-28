package com.httpmethods.tradeix;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Verify_employee_update {


    @Test

    public void Create_employee_verify() throws IOException {



String b1 = "{\"name\":\"kumartest1\",\"salary\":\"123\",\"age\":\"23\"}";



         RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";

        Response res = given().body(b1).when().post().then().statusCode(200).contentType(ContentType.HTML).extract()
                .response().prettyPeek();

        String g = res.asString();

              JsonPath js = new JsonPath(g);

       String  emplyoeeid = js.get("id");




//updating the values of employee which was create above

        String b2 = "{\"name\":\"kumartest1\",\"salary\":\"11123\",\"age\":\"23\"}";

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/update/"+emplyoeeid;

        Response res1 = given().body(b2).when().put().then().statusCode(200).contentType(ContentType.HTML).extract()
                .response().prettyPeek();
        String getoutput = res1.asString();

        JsonPath js1 = new JsonPath(getoutput);
        String  getupdatedsalary = js1.get("salary");

        System.out.println("Updated Salary is equals" + getupdatedsalary);



    }


}
