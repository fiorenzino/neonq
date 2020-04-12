package ovh.flw.neonq.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import ovh.flw.neonq.commons.model.Entity;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Actor extends Entity {
    public String name;

    @Relationship(type = "ACTS_IN", direction = "OUTGOING")
    @JsonIgnore
    public Set<Movie> movies = new HashSet<>();

    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }

    public void actsIn(Movie movie) {
        movies.add(movie);
        movie.actors.add(this);
    }
}
