package ovh.flw.neonq.service.rs;

import ovh.flw.neonq.commons.service.rs.GenericServiceRs;
import ovh.flw.neonq.model.Department;
import ovh.flw.neonq.service.DepartmentService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/departments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentServiceRs extends GenericServiceRs<Department> {

    public DepartmentServiceRs() {
    }

    @Inject
    public DepartmentServiceRs(DepartmentService departmentService) {
        super(departmentService);
    }
}
