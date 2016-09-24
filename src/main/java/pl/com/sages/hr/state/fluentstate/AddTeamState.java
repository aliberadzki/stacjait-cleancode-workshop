package pl.com.sages.hr.state.fluentstate;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class AddTeamState {

    private Department dept;
    private Director currentDirector;


    public AddTeamState(Department dept, Director director) {
        this.dept = dept;
        this.currentDirector = director;
    }

    public AddTeamState newTeam(String name) {
        Team team = new Team();
        team.setName(name);
        currentDirector.addTeam(team);
        return this;
    }

    public AddTeamState newDirector(String name) {
        Director director = new Director();
        director.setName(name);
        this.dept.addDirector(director);
        this.currentDirector = director;
        return this;
    }

    public Department department() {
        return dept;
    }
}
