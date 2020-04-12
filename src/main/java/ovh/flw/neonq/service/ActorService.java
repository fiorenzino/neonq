package ovh.flw.neonq.service;

import ovh.flw.neonq.common.service.GenericService;
import ovh.flw.neonq.model.Actor;

import javax.inject.Singleton;

@Singleton
public class ActorService extends GenericService<Actor> {
    @Override
    public Class<Actor> getEntityType() {
        return Actor.class;
    }
}
