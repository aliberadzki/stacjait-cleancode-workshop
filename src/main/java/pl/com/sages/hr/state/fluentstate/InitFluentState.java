package pl.com.sages.hr.state.fluentstate;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class InitFluentState {

    private Department dept;

    public InitFluentState(String deptName) {
        this.dept = new Department();
        this.dept.setName(deptName);
    }

    public AddTeamState newDirector(String name) {
        Director director = new Director();
        director.setName(name);
        this.dept.addDirector(director);
        return new AddTeamState(dept, director);
    }
}
