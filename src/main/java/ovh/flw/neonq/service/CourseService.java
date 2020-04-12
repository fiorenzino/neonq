package ovh.flw.neonq.service;

import ovh.flw.neonq.commons.service.GenericService;
import ovh.flw.neonq.model.Course;

import javax.inject.Singleton;

@Singleton
public class CourseService extends GenericService<Course> {
    @Override
    public Class<Course> getEntityType() {
        return Course.class;
    }
}
