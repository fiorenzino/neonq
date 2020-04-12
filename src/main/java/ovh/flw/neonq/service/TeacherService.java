package ovh.flw.neonq.service;

import ovh.flw.neonq.common.service.GenericService;
import ovh.flw.neonq.model.Teacher;

import javax.inject.Singleton;

@Singleton
public class TeacherService extends GenericService<Teacher> {
    @Override
    public Class<Teacher> getEntityType() {
        return Teacher.class;
    }
}
