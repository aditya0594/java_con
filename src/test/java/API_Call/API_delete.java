package API_Call;

//public class API_delete {


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class API_delete {


    public static void testDeleteAPI() {
        // Base URL for the API
        String baseUrl = "http://ec2-3-7-14-188.ap-south-1.compute.amazonaws.com/qa/api/v1/";
        String endpoint = "/user/email-delete"; // Endpoint for the delete request
        String requestBody = "{ \"email_address\": \"test123@yopmail.com\" }";
        // Perform the DELETE request
        Response response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();

        // Assert the response status code
        assertThat(response.getStatusCode(), Matchers.equalTo(200));
        // Optionally, assert the response body or headers
        assertThat(response.getBody().asString(), Matchers.containsString("This Email address user deleted sucessfully."));
        String responseBody = response.getBody().asString();
        System.out.println("This the API response "+ responseBody);
        boolean status = response.jsonPath().getBoolean("status");
        int code = response.jsonPath().getInt("code");
        String message = response.jsonPath().getString("message");
        int data = response.jsonPath().getInt("data");
        System.out.println("Status: " + status);
        System.out.println("Code: " + code);
        System.out.println("Message: " + message);
        System.out.println("Data: " + data);
        assertThat(status, Matchers.equalTo(false));
        assertThat(code, Matchers.equalTo(200));
        assertThat(message, Matchers.equalTo("This Email address user deleted sucessfully."));
        assertThat(data, Matchers.equalTo(1));
    }

    public static void main(String[] args) {
        testDeleteAPI();
    }
}