import io.restassured.RestAssured;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Basic_Post_API_Test {

    Properties prop = new Properties();
    @BeforeTest
    public void loadVariable() throws IOException {
        String localDir = System.getProperty("user.dir");
        File fileRelative = new File(localDir + "\\src\\test\\files\\env.properties");
        String absPath = fileRelative.getPath();
        InputStream path = new FileInputStream(absPath);
        prop.load(path);
    }

    @Test
    public void test() {
        RestAssured.baseURI = prop.getProperty("BaseUrl");
        given().body("{"+ "\"name\": \"morpheus\","+ "\"job\": \"leader\""+ "}").
                when().post(prop.getProperty("Base1")).
                then().assertThat().statusCode(201);
    }
}
