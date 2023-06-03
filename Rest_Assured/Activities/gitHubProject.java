package Project;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class gitHubProject {
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIGnBdi+Tvn8Ixo/V8UPWhM+ux/eiRXUdKYYcdet3H4me";
    int sshKeyId;
    // Declare request specification
    RequestSpecification requestSpec;
    // Declare response specification
    ResponseSpecification responseSpec;

    @BeforeClass

    public void RequestSpecBuilder() {
         requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://api.github.com/user/keys")
                .addHeader("Authorization","token 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")
                .build();

         responseSpec = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(5000L))
                .expectBody("key", equalTo(sshKey))
                .expectBody("title", equalTo("TestAPIKey"))
                .build();
    }

    @Test
    public void postRequestTest() {
        String reqBody = "{"
                + "\"title\": \"TestAPIKey\","
                + "\"key\": \"ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIGnBdi+Tvn8Ixo/V8UPWhM+ux/eiRXUdKYYcdet3H4me\""
                + "}";

        Response response = given().spec(requestSpec).body(reqBody).when().post();
        // Assertions
        response.then().spec(responseSpec); // Use responseSpec
        sshKeyId = response.then().extract().
                path("id");
        System.out.println(sshKeyId);

    }

    @Test(dependsOnMethods = { "postRequestTest" })
    public void getKey() {

        Response response = given().spec(requestSpec).pathParam("KeyId", sshKeyId).when().get("/{KeyId}");

        // Print response
        System.out.println(response.asPrettyString());
        // Assertions
        response.then().spec(responseSpec).body("key", equalTo(sshKey));
        response.then().statusCode(200);
    }
    // Test case using a DataProvider

    @AfterClass
    public void deleteKey() {
        Response response = given().spec(requestSpec).pathParam("KeyId", sshKeyId).when().delete("/{KeyId}");
        System.out.println(response.asPrettyString());
        // Assertions
        response.then().statusCode(204);;
    }

}
