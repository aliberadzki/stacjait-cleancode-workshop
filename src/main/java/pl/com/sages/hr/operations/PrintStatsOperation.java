package pl.com.sages.hr.operations;

import pl.com.sages.hr.builder.OrganizationBuilder;
import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.stats.EntityCountingVisitor;
import pl.com.sages.hr.model.stats.Visitor;

import java.util.Set;

/**
 * Created by aliberadzki on 25.09.16.
 */
public class PrintStatsOperation implements Operation {
    private OrganizationBuilder organization;

    public PrintStatsOperation(OrganizationBuilder organization) {
        this.organization = organization;
    }

    public void execute(String[] args) {
        Visitor counterVisitor = new EntityCountingVisitor();
        Set<Department> depts = organization.getDepartments();

        for(Department dept : depts) {
            dept.accept(counterVisitor);
        }

        ((EntityCountingVisitor) counterVisitor).displayStats();

    }

    public String getCommand() {
        return "stats";
    }

    public String getHelp() {
        return "stats - display stats about organization";
    }

    public String getLongHelp() {
        return "stats - display stats about organization - headcount, teamcount, directors and departments";
    }
}
