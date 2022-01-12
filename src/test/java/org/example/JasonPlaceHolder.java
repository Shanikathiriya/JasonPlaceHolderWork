package org.example;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class JasonPlaceHolder {


    @Test
    public void verify_post_byUsers()
    {
        Response response=given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .basePath("users")
                .when()

                .get("5");

        Assert.assertEquals(200,response.statusCode());

        System.out.println(response.body().asString());
        JsonPath responseJson=response.getBody().jsonPath();

        Assert.assertEquals("Chelsey Dietrich",responseJson.getString("name"));
        Assert.assertEquals("Skiles Walks",responseJson.getString("address.street"));
        Assert.assertEquals("-31.8129",responseJson.getString("address.geo.lat"));

        Assert.assertEquals("User-centric fault-tolerant solution",responseJson.getString("company.catchPhrase"));






    }
    @Test
    public void verify_post_getbyid()
    {
        Response response=given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .basePath("posts")
                .when()

                .get("15");

        Assert.assertEquals(200,response.statusCode());

        System.out.println(response.body().asString());
        JsonPath responseJson=response.getBody().jsonPath();

        Assert.assertEquals(2,responseJson.getInt("userId"));
        Assert.assertEquals("eveniet quod temporibus",responseJson.getString("title"));
    }
    @Test
     public void verify_By_Endpoint()
        {
            Response response=given()
                    .baseUri("https://jsonplaceholder.typicode.com/")
                    .basePath("todos")
                    .when()
                    .get("29");
            System.out.println(response.body().asString());
            JsonPath responseJson=response.getBody().jsonPath();
            Assert.assertEquals(200,response.statusCode());
            Assert.assertEquals("laborum aut in quam",responseJson.getString("title"));
            Assert.assertEquals(false,responseJson.getBoolean("completed"));

        }
}
