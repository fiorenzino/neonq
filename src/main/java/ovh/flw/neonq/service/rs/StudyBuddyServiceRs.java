package ovh.flw.neonq.service.rs;

import ovh.flw.neonq.common.service.rs.GenericServiceRs;
import ovh.flw.neonq.model.Student;
import ovh.flw.neonq.model.StudyBuddy;
import ovh.flw.neonq.service.StudentService;
import ovh.flw.neonq.service.StudyBuddyService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/studybuddies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudyBuddyServiceRs extends GenericServiceRs<StudyBuddy> {

    public StudyBuddyServiceRs() {
    }

    @Inject
    public StudyBuddyServiceRs(StudyBuddyService studyBuddyService) {
        super(studyBuddyService);
    }
}
