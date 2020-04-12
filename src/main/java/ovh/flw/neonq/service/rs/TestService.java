package ovh.flw.neonq.service.rs;

import org.neo4j.ogm.session.Session;
import ovh.flw.neonq.model.Actor;
import ovh.flw.neonq.model.Department;
import ovh.flw.neonq.model.Movie;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static ovh.flw.neonq.management.Constant.DEPTH_ENTITY;

@Path("/neonq")
public class TestService {

    @Inject
    Session session;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test")
    public Response test() {
        Department department = new Department();
        session.save(department, DEPTH_ENTITY);
        return Response.ok(department).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/films")
    public Response films() {
        Movie movie = new Movie("The Matrix", 1999);

        Actor keanu = new Actor("Keanu Reeves");
        keanu.actsIn(movie);

        Actor carrie = new Actor("Carrie-Ann Moss");
        carrie.actsIn(movie);

        //Persist the movie. This persists the actors as well.
        session.save(movie);

        //Load a movie
        Movie matrix = session.load(Movie.class, movie.id);
        StringBuffer stringBuffer = new StringBuffer();
        for (Actor actor : matrix.actors) {
            stringBuffer.append("Actor: " + actor.name);
        }
        return Response.ok(stringBuffer.toString()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/actors")
    public Response actors() {
        Collection<Actor> list = session.loadAll(Actor.class);
        return Response.ok(list).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/movies")
    public Response movies() {
        Collection<Movie> list = session.loadAll(Movie.class);
        return Response.ok(list).build();
    }
}