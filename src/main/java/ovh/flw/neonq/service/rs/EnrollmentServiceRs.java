package ovh.flw.neonq.service.rs;

import ovh.flw.neonq.common.service.rs.GenericServiceRs;
import ovh.flw.neonq.model.Enrollment;
import ovh.flw.neonq.service.EnrollmentService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/enrollments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnrollmentServiceRs extends GenericServiceRs<Enrollment> {

    public EnrollmentServiceRs() {
    }

    @Inject
    public EnrollmentServiceRs(EnrollmentService enrollmentService) {
        super(enrollmentService);
    }
}
