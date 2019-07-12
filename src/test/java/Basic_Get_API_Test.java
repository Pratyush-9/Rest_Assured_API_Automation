import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basic_Get_API_Test {

    @Test
    public void test() {
        RestAssured.baseURI="https://reqres.in/";
        given().when().get("api/users/2").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
                and().body("data.first_name",equalTo("Janet")).and().header("Server","cloudflare").and().
                header("Content-Type" ,"application/json; charset=utf-8");
    }
}
