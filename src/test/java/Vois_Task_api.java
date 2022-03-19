import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Vois_Task_api {
    @Test

    public void User_associated_post() {

        Response response = given().contentType(ContentType.JSON).when().get("https://jsonplaceholder.typicode.com/posts?userId=4")
                .then().assertThat().statusCode(200).extract().response();
        String responseBody = response.getBody().asString();
        System.out.println("Response_Body-->>> " + responseBody);
        System.out.println("Status Code : " + response.getStatusCode());

        // get and print the user email address from the response
        JsonPath path_value = new JsonPath(responseBody);
        String title = path_value.getString("title");
        System.out.println("User_Title is --->> " + title);
    }}