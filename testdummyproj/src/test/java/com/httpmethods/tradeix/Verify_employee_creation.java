package com.httpmethods.tradeix;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Verify_employee_creation {


    @Test

    public void Create_employee_verify() throws IOException {



String b1 = "{\"name\":\"Kumartest\",\"salary\":\"123\",\"age\":\"23\"}";

         RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";

        Response res = given().body(b1).when().post().then().statusCode(200).contentType(ContentType.HTML).extract()
                .response().prettyPeek();

        String g = res.asString();

              JsonPath js = new JsonPath(g);

       String  emplyoeeid = js.get("id");


       System.out.println("id got from from system" + emplyoeeid);


        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee/"+emplyoeeid;

        Response res1 = given().when().get().then().statusCode(200).contentType(ContentType.HTML).extract()
                .response().prettyPeek();
    }


}
