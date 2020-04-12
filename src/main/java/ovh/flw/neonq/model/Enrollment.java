package ovh.flw.neonq.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import ovh.flw.neonq.commons.model.Entity;

import java.util.Date;

@RelationshipEntity(type = "ENROLLED")
public class Enrollment  extends Entity {

    @StartNode
    Student student;

    @EndNode
    Course course;

    Date enrolledDate;

    public Enrollment() {
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "student=" + student +
                ", course=" + course +
                ", enrolledDate=" + enrolledDate +
                '}';
    }
}