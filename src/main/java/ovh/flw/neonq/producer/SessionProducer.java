package ovh.flw.neonq.producer;

import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Singleton
public class SessionProducer {

    Logger logger = Logger.getLogger(getClass());
    Configuration configuration;

    Session session;

    @ConfigProperty(name = "neo4j.packages")
    String packages;

    @ConfigProperty(name = "neo4j.uri")
    String uri;

    @ConfigProperty(name = "neo4j.password")
    String password;

    @ConfigProperty(name = "neo4j.username")
    String username;

    public void init(@Observes StartupEvent startupEvent) {
        logger.info("packages: " + packages);
        logger.info("uri: " + uri);
        logger.info("password: " + password);
        logger.info("username: " + username);
        configuration = new Configuration.Builder()
                .uri(uri)
                .credentials(username, password)
                .build();
    }

    @Produces
    public Session produce() {
        logger.info("produce");
        if (session == null) {
            SessionFactory sessionFactory = new SessionFactory(
                    configuration,
                    packages);
            session = sessionFactory.openSession();
        }
        return session;
    }
}
