package ovh.flw.neonq.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import ovh.flw.neonq.commons.model.Entity;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Movie extends Entity {

    public String title;
    public int released;

    @Relationship(type = "ACTS_IN", direction = "INCOMING")
    public Set<Actor> actors = new HashSet();


    public Movie() {
    }

    public Movie(String title, int year) {
        this.title = title;
        this.released = year;
    }

}