package pl.com.sages.hr.operations;

import pl.com.sages.hr.builder.OrganizationBuilder;

import java.util.Iterator;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class PrintOrganizationOperation implements Operation {
    private OrganizationBuilder organization;

    public PrintOrganizationOperation(OrganizationBuilder organization) {
        this.organization = organization;
    }

    public void execute(String[] args) {
        Iterator i = organization.getDepartments().iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }
    }

    public String getCommand() {
        return "print";
    }

    public String getHelp() {
        return "print - short help";
    }

    public String getLongHelp() {
        return "print - long help text";
    }
}
