package pl.com.sages.hr.builder;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class OrganizationBuilderImpl implements OrganizationBuilder {

    private Set<Department> departments = new HashSet<Department>();
    private OrganizationBuilderState state = new InitState(departments);

    public void addDepartment(String name) {
        state.addDepartment(name);
        state = new AddDirectorState(departments);
    }

    public void addDirector(String name, String departmentName) {
        state.addDirector(name, departmentName);
        state = new AddTeamState(departments);
    }

    public void addTeam(Team team, String directorName) {
        state.addTeam(team, directorName);
    }

    public Set<Department> getDepartments() {
        return state.getDepartments();
    }

}
