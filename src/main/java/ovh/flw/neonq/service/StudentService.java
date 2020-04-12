package ovh.flw.neonq.service;

import ovh.flw.neonq.common.service.GenericService;
import ovh.flw.neonq.model.Student;

import javax.inject.Singleton;

@Singleton
public class StudentService extends GenericService<Student> {
    @Override
    public Class<Student> getEntityType() {
        return Student.class;
    }
}
