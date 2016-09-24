package pl.com.sages.hr.command;

import pl.com.sages.hr.ApplicationCore;
import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.OrganizationVisitor;
import pl.com.sages.hr.model.Visitor;

import java.util.Set;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class StatCommand implements Command {
    private ApplicationCore core;

    public StatCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "stat";
    }

    @Override
    public String getShortHelp() {
        return "stat - display stats of structure";
    }

    @Override
    public String getLongHelp() {
        return "stat - display stats of structure - blah b;la bal";
    }

    @Override
    public void doAction(String[] args) {
        Set<Department> depts = core.getDepartments();
        Visitor visitor = new OrganizationVisitor();

        for(Department dept : depts) {
            visitor.visit(dept);
        }
        System.out.println(visitor.generatePrintout());

    }
}
