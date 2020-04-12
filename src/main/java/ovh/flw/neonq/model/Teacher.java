package ovh.flw.neonq.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import ovh.flw.neonq.common.model.Entity;

import java.util.Set;

@NodeEntity
public class Teacher extends Entity {
    String name;

    @Relationship(type = "TEACHES_CLASS")
    Set<Course> courses;

    @Relationship(type = "TAUGHT_BY", direction = Relationship.INCOMING)
    Set<Subject> subjects;

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                ", subjects=" + subjects +
                '}';
    }
}
