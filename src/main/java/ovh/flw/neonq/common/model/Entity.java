package ovh.flw.neonq.common.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

public abstract class Entity {

    @Id
    @GeneratedValue
    public Long id;

}
