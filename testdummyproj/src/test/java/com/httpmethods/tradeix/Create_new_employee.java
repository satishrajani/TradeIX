package com.httpmethods.tradeix;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Create_new_employee {

//    Properties prop=new Properties();
//    @BeforeTest
//    public void getData() throws IOException
//    {
//
//        FileInputStream fis=new FileInputStream("\\testdummyproj\\src\\test\\java\\resource\\env.properties");
//        prop.load(fis);
//
//        //prop.get("HOST");
//    }

    @Test

    public void Create_employee_verify() throws IOException {



String b1 = "{\"name\":\"Kumartest\",\"salary\":\"123\",\"age\":\"23\"}";

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";
       // RestAssured.baseURI=prop.getProperty("HOST");
        Response res = given().body(b1).when().post().then().statusCode(200).contentType(ContentType.HTML).extract()
                .response().prettyPeek();

            }


}
