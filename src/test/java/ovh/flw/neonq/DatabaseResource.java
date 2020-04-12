package ovh.flw.neonq;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.Neo4jContainer;

import java.util.Collections;
import java.util.Map;

public class DatabaseResource implements QuarkusTestResourceLifecycleManager {


    Neo4jContainer neo4jContainer = new Neo4jContainer("neo4j:4.0.0")
            .withAdminPassword("secret");

    @Override
    public Map<String, String> start() {
        neo4jContainer.start();
        return Collections.singletonMap("neo4j.uri", neo4jContainer.getBoltUrl());
    }

    @Override
    public void stop() {
        neo4jContainer.stop();
    }
}
