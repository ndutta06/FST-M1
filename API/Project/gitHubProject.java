package project;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;


public class gitHubProject {
    String sshKey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAILngqcdNcxcGVHjC9ZKUhoR7pAXJNHTIiuzwR9T9nl3S";
    int sshid;
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .addHeader("Authorization", "token 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")
                .setContentType(ContentType.JSON)
                .build();
        responseSpec = new ResponseSpecBuilder()
                .expectContentType("application/json")
                .build();
    }

    @Test(priority = 1)
    public void PostRequest(){
        Map<String,String> reqBody=new HashMap<>();
        reqBody.put("title","TestAPIKey");
        reqBody.put("key",sshKey);
        Response response= given().spec(requestSpec).body(reqBody).post("/user/keys");
        System.out.println(response.getBody().asPrettyString());
        sshid= response.then().extract().path("id");
        System.out.println(sshid);
        Assert.assertEquals(response.getStatusCode(), 201);
        response.then().statusCode(201).spec(responseSpec);
    }
    @Test(priority = 2)
    public void getRequest(){
        Response response = given().spec(requestSpec).pathParam("keyId",sshid)
                .get("/user/keys/{keyId}");
        System.out.println(response.getBody().asPrettyString());
        response.then().statusCode(200).spec(responseSpec);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 3)
    public void deleteRequest(){
        Response response = given().spec(requestSpec).pathParam("keyId", sshid)
                .delete("/user/keys/{keyId}");
        Reporter.log(response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 204);
    }
}