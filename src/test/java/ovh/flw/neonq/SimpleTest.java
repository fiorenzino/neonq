package ovh.flw.neonq;

import org.junit.jupiter.api.Test;
import ovh.flw.neonq.model.Department;

public class SimpleTest {

    @Test
    public void test() {
        Department department = new Department();
        System.out.println(department.getClass());
    }
}
