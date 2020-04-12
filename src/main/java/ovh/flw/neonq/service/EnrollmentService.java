package ovh.flw.neonq.service;

import ovh.flw.neonq.common.service.GenericService;
import ovh.flw.neonq.model.Enrollment;

import javax.inject.Singleton;

@Singleton
public class EnrollmentService extends GenericService<Enrollment> {
    @Override
    public Class<Enrollment> getEntityType() {
        return Enrollment.class;
    }
}
