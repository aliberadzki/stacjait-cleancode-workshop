package pl.com.sages.hr.model;

import java.util.Set;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class OrganizationVisitor implements Visitor{

    private int departments = 0;
    private int directors = 0;

    private int qaTeams = 0;
    private int devTeams = 0;
    private int uxTeams = 0;
    private int opsTeams = 0;

    private int qaEngineers = 0;
    private int devEngineers = 0;
    private int uxEngineers = 0;
    private int opsEngineers = 0;


    @Override
    public void visit(Department dept) {
        this.departments++;
    }

    @Override
    public void visit(Director director) {
        this.directors++;
    }

    @Override
    public void visit(Team team) {
        TeamType type = team.getTeamType();

        switch (type) {
            case DEV:
                devTeams++;
                devEngineers += team.getMemberCount();
                break;
            case OPS:
                opsTeams++;
                opsEngineers += team.getMemberCount();
                break;
            case QA:
                qaTeams++;
                qaEngineers += team.getMemberCount();
                break;
            case UX:
                uxTeams++;
                uxEngineers += team.getMemberCount();
                break;
        }
    }

    @Override
    public String generatePrintout() {
        StringBuilder builder = new StringBuilder();
        builder
                .append("Number of departments : ").append(departments).append('\n')
                .append("Number of directors : ").append(directors).append('\n')
                .append("Number of QA teams : ").append(qaTeams)
                .append(" | Number of QA engineers : ").append(qaEngineers).append('\n')
                .append("blablabla");

        return builder.toString();
    }


}
