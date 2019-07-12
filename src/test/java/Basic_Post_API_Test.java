import io.restassured.RestAssured;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Basic_Post_API_Test {

    Properties pro = new Properties();
    @BeforeTest
    public void loadVariable() throws IOException {
        FileInputStream path = new FileInputStream("..\\.\\files\\env.properties");
        pro.load(path);
    }

    @Test
    public void test() {
        RestAssured.baseURI = pro.getProperty("BaseUrl");
        given().body("{"+ "\"name\": \"morpheus\","+ "\"job\": \"leader\""+ "}").
                when().post(pro.getProperty("Base1")).
                then().assertThat().statusCode(201);
    }
}
