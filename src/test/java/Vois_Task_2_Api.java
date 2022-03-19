import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Vois_Task_2_Api {
    @Test

    // get the user details From the query id-=4 Request

    public void getUserId() {
        Response response = given().when().get("https://jsonplaceholder.typicode.com/users?id=4")
                .then().assertThat().statusCode(200).extract().response();
        String responseBody = response.getBody().asString();
        System.out.println("Response_Body-->>> " + responseBody);
        System.out.println("Status Code : " + response.getStatusCode());

        // get and print the user email address from the response
        JsonPath path_value = new JsonPath(responseBody);
        String emailAddress = path_value.getString("email");
        System.out.println("User_Email_Address_is --->> " + emailAddress);
    }}