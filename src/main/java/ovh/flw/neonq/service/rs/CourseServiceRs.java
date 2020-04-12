package ovh.flw.neonq.service.rs;

import ovh.flw.neonq.common.service.rs.GenericServiceRs;
import ovh.flw.neonq.model.Course;
import ovh.flw.neonq.service.CourseService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseServiceRs extends GenericServiceRs<Course> {

    public CourseServiceRs() {
    }

    @Inject
    public CourseServiceRs(CourseService courseService) {
        super(courseService);
    }
}
