package pl.com.sages.hr.command;

import java.math.BigDecimal;
import java.util.Scanner;

import pl.com.sages.hr.ApplicationCore;
import pl.com.sages.hr.DepartmentBuilder;
import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.TeamType;

public class AddDepartmentCommand implements Command {

	private ApplicationCore core;
	
	public AddDepartmentCommand(ApplicationCore core) {
		this.core = core;
	}
	
	@Override
	public String getCommandName() {
		return "add_department";
	}

	@Override
	public void doAction(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
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

	@Override
	public String getShortHelp() {
		return "add_department - adds a new department with directors and teams";
	}

	@Override
	public String getLongHelp() {
		return "add_department - adds a new department with directors and teams LONG DESCRIPTION";
	}
}
