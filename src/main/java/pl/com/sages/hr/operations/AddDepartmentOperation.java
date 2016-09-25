package pl.com.sages.hr.operations;

import pl.com.sages.hr.builder.OrganizationBuilder;
import pl.com.sages.hr.model.Team;
import pl.com.sages.hr.model.TeamType;

import java.util.Scanner;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class AddDepartmentOperation implements Operation {
    private Scanner scanner;
    private OrganizationBuilder organization;

    public AddDepartmentOperation(Scanner scanner, OrganizationBuilder organization) {
        this.scanner = scanner;
        this.organization = organization;
    }

    public void execute(String[] args) {
        System.out.println("Department name:");
        String deptName = scanner.nextLine();
        organization.addDepartment(deptName);

        System.out.println("Name of directors (comma separated):");
        String[] directorNames = getCommaSeparatedNames(scanner);

        for(String directorName : directorNames) {
            organization.addDirector(directorName, deptName);
            System.out.println("Team names for director " + directorName + " (comma separated):");
            String[] teamNames = getCommaSeparatedNames(scanner);

            for(String teamName : teamNames) {
                System.out.println("Team " + teamName + " is of type:");
                String strTeamType = scanner.nextLine();
                System.out.println("Team " + teamName + " was founded on (year):");
                String strYear = scanner.nextLine();
                System.out.println("Team " + teamName + " has how many members:");
                String strMembersCount = scanner.nextLine();
                System.out.println("Team " + teamName + " has KPI of value:");
                String strKPI = scanner.nextLine();
                System.out.println("Team " + teamName + " directors' coefficient:");
                String strCoefficient = scanner.nextLine();

                Team team = new Team(teamName);
                team.setYearFounded(Integer.valueOf(strYear));
                team.setType(TeamType.valueOf(strTeamType));
                team.setMemberCount(Integer.valueOf(strMembersCount));
                team.setKpi(Double.valueOf(strKPI));
                team.setCoefficient(Double.valueOf(strCoefficient));

                organization.addTeam(team, directorName);


            }
        }
    }

    public String getCommand() {
        return "add_department";
    }

    public String getHelp() {
        return "add_department - asks for complete structure of department in steps";
    }

    public String getLongHelp() {
        return "add_department - asks for complete structure of department in steps LOBG DESCRIPTION";
    }

    private static String[] getCommaSeparatedNames(Scanner scanner) {
        String line = scanner.nextLine();
        return line.split(",");
    }
}
