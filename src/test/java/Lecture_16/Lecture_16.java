package Lecture_16;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.awaitility.Awaitility;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Lecture_16 {

    @BeforeTest
    public void precondition() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void single_user() {
        String endpoint = "/api/users/2";
        given().when().get(endpoint).then().statusCode(200);
    }

    @Test
    public void single_user_not_found() {
        String endpoint = "/api/users/23";
        given().when().get(endpoint).then().statusCode(404);
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {1},
                {2},
                {3},
                {4},
                {5}
        };
    }

    @Test(dataProvider = "data")
    public void users(int idInt) {
        String endpoint = "/api/users?id=" + idInt;
        Gson gson = new Gson();
        Root root = gson.fromJson(given().when().get(endpoint).getBody().asPrettyString(), Root.class);
        Assert.assertEquals(root.data.id, idInt);
    }

    @Test
    public void post() {
        String endpoint = "/api/users";
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
        response.prettyPrint();
    }
    @Test
    public void put() {
        String endpoint = "/api/users";
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(requestBody).and().put(endpoint).then().extract().response();
        Assert.assertEquals(response.jsonPath().get("job"), "zion resident");
        response.prettyPrint();
    }
    @Test
    public void patch() {
        String endpoint = "/api/users/2";
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(requestBody).and().patch(endpoint).then().extract().response();
        Assert.assertEquals(response.jsonPath().get("job"), "zion resident");
        response.prettyPrint();
    }
    @Test
    public void delete() {
        String endpoint = "/api/users/2";
        Response response = given().delete(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 204);
    }
    @Test
    public void register() {
        String endpoint = "/api/register";
        String requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X4");
        response.prettyPrint();
    }
    @Test
    public void registerFailed() {
        String endpoint = "/api/register";
        String requestBody = "{\n" +
                "    \"email\": \"sydney@fife\"\n" +
                "}";
        given().header("Content-Type", "application/json").body(requestBody).and().post(endpoint).then().statusCode(400);
    }
    @Test
    public void login() {
        String endpoint = "/api/login";
        String requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X4");
        response.prettyPrint();
    }
    @Test
    public void loginFailed() {
        String endpoint = "/api/register";
        String requestBody = "{\n" +
                "    \"email\": \"peter@klaven\"\n" +
                "}";
        given().header("Content-Type", "application/json").body(requestBody).and().post(endpoint).then().statusCode(400);
    }
    @Test
    public void waitTest() {
        Awaitility.await().atMost(8, TimeUnit.SECONDS).until(() -> this.getStatus("/api/users?delay=3") == 200);
    }

    public int getStatus(String endpoint) {
        return given()
                .accept(ContentType.JSON)
                .get(endpoint)
                .then()
                .extract()
                .statusCode();
    }
}