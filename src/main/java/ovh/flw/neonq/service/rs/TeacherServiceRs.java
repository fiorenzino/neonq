package ovh.flw.neonq.service.rs;

import ovh.flw.neonq.common.service.rs.GenericServiceRs;
import ovh.flw.neonq.model.Teacher;
import ovh.flw.neonq.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/teachers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeacherServiceRs extends GenericServiceRs<Teacher> {

    public TeacherServiceRs() {
    }

    @Inject
    public TeacherServiceRs(TeacherService teacherService) {
        super(teacherService);
    }
}
