package ovh.flw.neonq.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import ovh.flw.neonq.common.model.Entity;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "Class")
public class Course extends Entity {
    String name;

    @Relationship(type = "SUBJECT_TAUGHT")
    Subject subject;

    @Relationship(type = "TEACHES_CLASS", direction = Relationship.INCOMING)
    Teacher teacher;

    @Relationship(type = "ENROLLED", direction = Relationship.INCOMING)
    Set<Enrollment> enrollments = new HashSet<>();

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", subject=" + subject +
                ", teacher=" + teacher +
                ", enrollments=" + enrollments +
                '}';
    }
}
