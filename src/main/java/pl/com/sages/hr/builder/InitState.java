package pl.com.sages.hr.builder;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Team;

import java.util.Set;

/**
 * Created by aliberadzki on 25.09.16.
 */
public class InitState implements OrganizationBuilderState{
    private Set<Department> departments;

    public InitState(Set<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(String name) {
        this.departments.add(new Department(name));
    }

    public void addDirector(String name, String departmentName) {
        throw new IllegalStateException("Cannot add directors yet");
    }

    public void addTeam(Team team, String directorName) {
        throw new IllegalStateException("Cannot add teams yet");
    }

    public Set<Department> getDepartments() {
        throw new IllegalStateException("Cannot retrieve departments yet");
    }
}
