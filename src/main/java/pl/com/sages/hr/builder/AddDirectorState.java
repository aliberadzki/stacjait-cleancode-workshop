package pl.com.sages.hr.builder;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;

import java.util.Set;

/**
 * Created by aliberadzki on 25.09.16.
 */
public class AddDirectorState implements OrganizationBuilderState {
    private Set<Department> departments;

    public AddDirectorState(Set<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(String name) {
        this.departments.add(new Department(name));
    }

    public void addDirector(String name, String departmentName) {
        for(Department dept : this.departments) {
            if(dept.getName().equals(departmentName)) {
                dept.addDirector(new Director(name));
                return;
            }
        }

        throw new IllegalArgumentException("No department with name " + departmentName);
    }

    public void addTeam(Team team, String directorName) {
        throw new IllegalStateException("Cannot create Team now");
    }

    public Set<Department> getDepartments() {
        throw new IllegalStateException("Not completed structure");
    }
}
