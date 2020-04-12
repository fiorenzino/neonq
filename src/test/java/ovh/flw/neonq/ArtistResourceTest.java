package ovh.flw.neonq;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ovh.flw.neonq.model.Actor;
import ovh.flw.neonq.model.Movie;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;
import static org.jboss.resteasy.util.HttpHeaderNames.ACCEPT;
import static org.jboss.resteasy.util.HttpHeaderNames.CONTENT_TYPE;

@QuarkusTest
@QuarkusTestResource(DatabaseResource.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArtistResourceTest {

    @Test
    void shouldGetUnknownActor() {
        Long randomId = new Random().nextLong();
        given()
                .pathParam("id", randomId)
                .when().get("/actors/{id}")
                .then()
                .statusCode(NOT_FOUND.getStatusCode());
    }


    @Test
    void shouldAddValidItem() {
        Actor actor = new Actor("fiorenzo");
        Movie movie = new Movie("The Quarkus Movie", 2020);
        actor.actsIn(movie);
        given()
                .body(actor)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .header(ACCEPT, APPLICATION_JSON)
                .when()
                .post("/actors")
                .then()
                .statusCode(OK.getStatusCode());
    }

//    @Test
//    @Order(1)
//    void shouldGetInitialItems() {
//        List<Actor> heroes = get("/actors").then()
//                .statusCode(OK.getStatusCode())
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
//                .extract().body().as(getActorTypeRef());
//        assertEquals(0, heroes.size());
//    }
//
//    @Test
//    @Order(2)
//    void shouldAddAnItem() {
//        Actor hero = new Actor();
//        hero.name = DEFAULT_NAME;
//
//        String location = given()
//                .body(hero)
//                .header(CONTENT_TYPE, APPLICATION_JSON)
//                .header(ACCEPT, APPLICATION_JSON)
//                .when()
//                .post("/actors")
//                .then()
//                .statusCode(OK.getStatusCode())
//                .extract().header("Location");
//        assertTrue(location.contains("/actors"));
//
//        // Stores the id
//        String[] segments = location.split("/");
//        heroId = Long.valueOf(segments[segments.length - 1]);
//        assertNotNull(heroId);
//
//        given()
//                .pathParam("id", heroId)
//                .when().get("/actors/{id}")
//                .then()
//                .statusCode(OK.getStatusCode())
//                .header(CONTENT_TYPE, APPLICATION_JSON)
//                .body("name", Is.is(DEFAULT_NAME));
//
//        List<Actor> heroes = get("/actors").then()
//                .statusCode(OK.getStatusCode())
//                .header(CONTENT_TYPE, APPLICATION_JSON)
//                .extract().body().as(getActorTypeRef());
//        assertEquals(0 + 1, heroes.size());
//    }

    private TypeRef<List<Actor>> getActorTypeRef() {
        return new TypeRef<List<Actor>>() {
            // Kept empty on purpose
        };
    }
}
