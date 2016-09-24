package pl.com.sages.hr;

import java.util.Scanner;
import java.util.Set;

import pl.com.sages.hr.model.*;

public class HRSystem {
	
	private static ApplicationCore core = new ApplicationCore();
	
	public static void main(String[] args)
	{
		System.out.println("--- Human Resources System ---");
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			System.out.println("hrs# ");
			String cmd = scanner.nextLine();
			if(cmd.equals("info"))
			{
				System.out.println("Human Resources System v1");
			}
			else if(cmd.equals("bonus"))
			{
				Set<Team> teams = core.getAllTeams();
				PremiumCalculator calculator = new RegularPremiumCalculator(new RegularTeamFactorCalculator());
				for(Team team : teams) {
					double calculatedPremium = calculator.calculatePremiumForTeam(team);
					System.out.println("Team " + team.getName() + " was assigned a premium: " + calculatedPremium);
				}
			}
			else if(cmd.equals("add_department"))
			{
				DepartmentBuilder builder = new DepartmentBuilder();
				System.out.println("Department name: ");
				String departmentName = scanner.nextLine();
				// 1. create department
				builder.createDepartment(departmentName);
				System.out.println("Name of directors (comma-separated): ");
				String[] directorNames = parseNames(scanner.nextLine(), ",");
				// 2. create directors
				for(String directorName : directorNames)
				{
					builder.addDirector(directorName);
				}

				// 3. create teams
				for(String directorName : directorNames)
				{
					System.out.println("Team names for director " + directorName + " (comma-separated)");
					String[] teamNames = parseNames(scanner.nextLine(), ",");
					for(String teamName : teamNames)
					{
						System.out.println("Team " + teamName + " is of type: ");
						String teamType = scanner.nextLine();
						TeamType type = TeamType.valueOf(teamType);

						System.out.println("Team " + teamName + " exist since year: ");
						String teamYear = scanner.nextLine();
						int yearFounded = Integer.valueOf(teamYear);

						System.out.println("Team " + teamName + " number of members: ");
						String teamMembersCount = scanner.nextLine();
						int headCount = Integer.valueOf(teamMembersCount);

						System.out.println("Team " + teamName + " KPI: ");
						String teamKPI = scanner.nextLine();
						double kpi = Double.valueOf(teamKPI);

						System.out.println("Team " + teamName + " director coefficient: ");
						String teamCoefficient = scanner.nextLine();
						double coefficient = Double.valueOf(teamCoefficient);


						builder.addTeam(directorName, teamName, type, yearFounded, headCount, kpi, coefficient);
					}
				}

				Department department = builder.getDepartment();
				core.addDepartment(department);
			}
			else if(cmd.equals("print"))
			{
				Set<Department> departments = core.getDepartments();
				for(Department department : departments)
				{
					System.out.println(department.toString());
				}
			}
			else if(cmd.equals("exit"))
			{
				break;
			}
		}
	}
	
	private static String[] parseNames(String line, String separator)
	{
		return line.split(separator);
	}
}
