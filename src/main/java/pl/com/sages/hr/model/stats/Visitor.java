package pl.com.sages.hr.model.stats;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;

/**
 * Created by aliberadzki on 25.09.16.
 */
public interface Visitor {
    void visit(Department department);
    void visit(Director director);
    void visit(Team team);
}
