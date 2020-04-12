package ovh.flw.neonq.service;

import ovh.flw.neonq.common.service.GenericService;
import ovh.flw.neonq.model.Department;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.Map;

@Singleton
public class DepartmentService extends GenericService<Department> {
    @Override
    public Class<Department> getEntityType() {
        return Department.class;
    }

    Iterable<Map<String, Object>> getTeachers() {
        String query = "MATCH (d:Department)<-[:CURRICULUM]-(s:Subject) return d, count(s) as subjects ORDER BY subjects DESC";
        return session.query(query, Collections.EMPTY_MAP);
    }
}
