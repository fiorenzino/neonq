package ovh.flw.neonq.service.rs;

import ovh.flw.neonq.commons.service.rs.GenericServiceRs;
import ovh.flw.neonq.model.Actor;
import ovh.flw.neonq.service.ActorService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/actors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ActorServiceRs extends GenericServiceRs<Actor> {

    public ActorServiceRs() {
    }

    @Inject
    public ActorServiceRs(ActorService actorService) {
        super(actorService);
    }
}
