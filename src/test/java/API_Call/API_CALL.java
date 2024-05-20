package API_Call;



import org.apache.hc.core5.http.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.hamcrest.MatcherAssert;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;

    public class API_CALL {



        public static void main(String[] args) {
            String extractedOtp;
            try {
            String FirstapiUrl = "http://ec2-3-7-14-188.ap-south-1.compute.amazonaws.com/qa/api/v1/user/email-delete";
            JsonObject jsonBody = new JsonObject();
            jsonBody.addProperty("email_address", "test123@yopmail.com");  // Replace with the actual email address

                String Firstresponse = makeApiPostCall(FirstapiUrl, jsonBody.toString(),true);
                System.out.println("First API Response: " + Firstresponse);


                // Parse the first API response
                /*JsonObject jsonResponse = JsonParser.parseString(Firstresponse).getAsJsonObject();
                JsonObject data = jsonResponse.getAsJsonObject("data");
                //String emailAddress = data.get("email_address").getAsString();
                extractedOtp = data.get("code").getAsString();
                String otptrimed = extractedOtp.trim();
                System.out.println("Extracted OTP Code: " + otptrimed);*/


                // Use extracted values for the second API call
               /* String SecondApiUrl = "http://ec2-3-7-14-188.ap-south-1.compute.amazonaws.com/qa/api/v1/user/verify-otp";
                JsonObject secondApiJsonBody = new JsonObject();

                secondApiJsonBody.addProperty("email_address","adityapawar@yopmail.com");
                secondApiJsonBody.addProperty("otp",otptrimed);
                String Secondresponse = makeApiPostCall(SecondApiUrl, secondApiJsonBody.toString(),true);
                System.out.println("SECOND API Response: " + Secondresponse);

                // Parse the Second API response
                JsonObject SecondjsonResponse = JsonParser.parseString(Secondresponse).getAsJsonObject();
                JsonObject datasecond = SecondjsonResponse.getAsJsonObject("data");
                String token = datasecond.get("loginToken").getAsString();
                System.out.println("Extracted Email Token: " + token);*/








            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        }

        private static String makeApiPostCall(String apiUrl, String jsonBody, boolean setContentType) throws IOException, ParseException {

            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                HttpPost request = new HttpPost(apiUrl);
                request.setEntity(new StringEntity(jsonBody));

                if (setContentType) {
                    request.setHeader("Content-type", "application/json");
                }

                try (CloseableHttpResponse response = httpClient.execute(request)) {
                    int statusCode = response.getCode();

                    // Parse the JSON response
                    String responseData = EntityUtils.toString(response.getEntity());


                    // Use Hamcrest to validate the API response status code
                    //MatcherAssert.assertThat("API response status code", statusCode, equalTo(200));


                    return responseData;
                }
            }
        }
    }
