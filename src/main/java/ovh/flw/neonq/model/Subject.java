package ovh.flw.neonq.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import ovh.flw.neonq.common.model.Entity;

import java.util.Set;

@NodeEntity
public class Subject extends Entity {
    String name;

    @Relationship(type = "CURRICULUM", direction = Relationship.INCOMING)
    Department department;

    @Relationship(type = "TAUGHT_BY")
    Set<Teacher> teachers;

    @Relationship(type = "SUBJECT_TAUGHT", direction = Relationship.INCOMING)
    Set<Course> courses;

    public Subject() {
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", department=" + department +
                ", teachers=" + teachers +
                ", courses=" + courses +
                '}';
    }
}
