package ovh.flw.neonq;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@QuarkusTest
@QuarkusTestResource(DatabaseResource.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HeroResourceTest {


    @Test
    public void testGETHelloEndpoint() {
        given()
                .when().get("/neonq")
                .then()
                .statusCode(200)
                .body(is("hello"));
    }

    @Test
    public void tesSecond() {
        given()
                .when().get("/neonq/test")
                .then()
                .statusCode(200)
                .body(containsString("Department"));
    }

    @Test
    public void tesArtistCreate() {
        given()
                .when().get("/neonq/test")
                .then()
                .statusCode(200)
                .body(containsString("Department"));
    }
}
