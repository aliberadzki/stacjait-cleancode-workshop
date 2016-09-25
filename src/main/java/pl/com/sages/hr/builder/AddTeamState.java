package pl.com.sages.hr.builder;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;

import java.util.Set;

/**
 * Created by aliberadzki on 25.09.16.
 */
public class AddTeamState implements OrganizationBuilderState {

    private Set<Department> departments;

    public AddTeamState(Set<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(String name) {
        throw new IllegalStateException("Cannot add departments now");
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
        for(Department dept : this.departments) {
            for(Director director : dept.getDirectors()) {
                if (director.getName().equals(directorName)) {
                    director.addTeam(team);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("No director with name " + directorName);
    }

    public Set<Department> getDepartments() {
        return departments;
    }
}
