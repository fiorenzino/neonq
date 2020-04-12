package ovh.flw.neonq.common.service;

import org.neo4j.ogm.session.Session;
import ovh.flw.neonq.common.model.Entity;

import javax.inject.Inject;

import static ovh.flw.neonq.management.Constant.DEPTH_ENTITY;
import static ovh.flw.neonq.management.Constant.DEPTH_LIST;

public abstract class GenericService<T extends Entity> implements Service<T> {

    @Inject
    protected
    Session session;


    @Override
    public Iterable<T> findAll() {
        return session.loadAll(getEntityType(), DEPTH_LIST);
    }

    @Override
    public T find(Long id) {
        return session.load(getEntityType(), id, DEPTH_ENTITY);
    }

    @Override
    public void delete(Long id) {
        session.delete(session.load(getEntityType(), id));
    }

    @Override
    public T createOrUpdate(T entity) {
        session.save(entity, DEPTH_ENTITY);
        return find(entity.id);
    }

    public abstract Class<T> getEntityType();
}
