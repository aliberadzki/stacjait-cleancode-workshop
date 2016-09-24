package pl.com.sages.hr.operations;

import pl.com.sages.hr.ApplicationCore;
import pl.com.sages.hr.DepartmentBuilder;
import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.TeamType;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class AddDepartmentOperation implements Operation {

    private Scanner scanner;
    private ApplicationCore core;

    public AddDepartmentOperation(Scanner scanner, ApplicationCore core) {
        this.scanner = scanner;
        this.core = core;
    }

    @Override
    public void execute() {
        DepartmentBuilder builder = new DepartmentBuilder();
        System.out.println("Department name: ");
        String departmentName = scanner.nextLine();
        builder.createDepartment(departmentName);
        System.out.println("Name of directors (comma-separated): ");
        String[] directorNames = parseNames(scanner.nextLine(), ",");
        for(String directorName : directorNames)
        {
            builder.addDirector(directorName);
            System.out.println("Team names for director " + directorName + " (comma-separated)");
            String[] teamNames = parseNames(scanner.nextLine(), ",");
            for(String teamName : teamNames)
            {
                System.out.println("Team " + teamName + " is of type (QA, DEV, UX or OPS): ");
                TeamType teamType = TeamType.valueOf(scanner.nextLine());
                System.out.println("Team " + teamName + " exists since year: ");
                int sinceYear = Integer.valueOf(scanner.nextLine());
                System.out.println("Team " + teamName + " number of members: ");
                int memberCount = Integer.valueOf(scanner.nextLine());
                System.out.println("Team " + teamName + " KPI: ");
                String kpiString = scanner.nextLine();
                BigDecimal kpi = new BigDecimal(kpiString);
                System.out.println("Team " + teamName + " director coefficient: ");
                BigDecimal directorCoefficient = new BigDecimal(scanner.nextLine());
                builder.addTeam(directorName, teamName, teamType, sinceYear, memberCount, kpi, directorCoefficient);
            }
        }

        Department department = builder.getDepartment();
        core.addDepartment(department);
    }



    private static String[] parseNames(String line, String separator)
    {
        return line.split(separator);
    }
}
