package ovh.flw.neonq.service;

import ovh.flw.neonq.common.service.GenericService;
import ovh.flw.neonq.model.Subject;

import javax.inject.Singleton;

@Singleton
public class SubjectService extends GenericService<Subject> {
    @Override
    public Class<Subject> getEntityType() {
        return Subject.class;
    }
}
