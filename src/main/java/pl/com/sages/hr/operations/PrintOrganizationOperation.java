package pl.com.sages.hr.operations;

import pl.com.sages.hr.ApplicationCore;
import pl.com.sages.hr.model.Department;

import java.util.Set;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class PrintOrganizationOperation implements Operation {

    private ApplicationCore core;

    public PrintOrganizationOperation(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public void execute() {
        Set<Department> departments = core.getDepartments();
        for(Department department : departments)
        {
            System.out.println(department.toString());
        }
    }
}
