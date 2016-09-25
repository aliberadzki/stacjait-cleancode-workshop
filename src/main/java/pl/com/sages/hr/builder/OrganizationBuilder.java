package pl.com.sages.hr.builder;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Team;

import java.util.Set;

/**
 * Created by aliberadzki on 24.09.16.
 */
public interface OrganizationBuilder {

    void addDepartment(String name);
    void addDirector(String name, String departmentName);
    void addTeam(Team team, String directorName);

    Set<Department> getDepartments();
}
