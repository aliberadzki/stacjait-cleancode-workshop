package pl.com.sages.hr.model.stats;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;

/**
 * Created by aliberadzki on 25.09.16.
 */
public class EntityCountingVisitor implements Visitor {

    private int departmentsCount = 0;
    private int directorsCount = 0;

    private int qaTeamsCount = 0;
    private int devTeamsCount = 0;
    private int uxTeamsCount = 0;
    private int opsTeamsCount = 0;

    private int qaEngineersCount = 0;
    private int devEngineersCount = 0;
    private int uxEngineersCount = 0;
    private int opsEngineersCount = 0;

    public void visit(Department department) {
        departmentsCount++;
    }

    public void visit(Director director) {
        directorsCount++;
    }

    public void visit(Team team) {
        switch (team.getType()) {
            case DEV:
                devTeamsCount++;
                devEngineersCount += team.getMemberCount();
                break;
            case QA:
                qaTeamsCount++;
                qaEngineersCount += team.getMemberCount();
                break;
            case UX:
                uxTeamsCount++;
                uxEngineersCount += team.getMemberCount();
                break;
            case OPS:
                opsTeamsCount++;
                opsEngineersCount += team.getMemberCount();
                break;
        }
    }

    public void displayStats() {
        System.out.println("Number of departments: " + departmentsCount);
        System.out.println("Number of directors: " + directorsCount);
        System.out.println("Number of QA teams: " + qaTeamsCount + " | Number of QA engineers: " + qaEngineersCount);
        System.out.println("Number of DEV teams: " + devTeamsCount + " | Number of DEV engineers: " + devEngineersCount);
        System.out.println("Number of UX teams: " + uxTeamsCount + " | Number of UX engineers: " + uxEngineersCount);
        System.out.println("Number of OPS teams: " + opsTeamsCount + " | Number of OPS engineers: " + opsEngineersCount);
    }
}
