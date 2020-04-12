package ovh.flw.neonq.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import ovh.flw.neonq.commons.model.Entity;

import java.util.ArrayList;
import java.util.List;

@NodeEntity(label = "StudyBuddy")
class StudyBuddy extends Entity {

    @Relationship(type = "BUDDY")
    public List<Student> buddies;

    @JsonProperty("course")
    public Course course;

    StudyBuddy() {
        buddies = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "StudyBuddy{" +
                "buddies=" + buddies +
                ", course=" + course +
                '}';
    }
}