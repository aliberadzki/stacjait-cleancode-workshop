package pl.com.sages.hr;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Set;

import pl.com.sages.hr.bonus.BonusCalculator;
import pl.com.sages.hr.bonus.BonusCalculatorResolver;
import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;
import pl.com.sages.hr.model.TeamType;

public class HRSystem {
	
	private ApplicationCore core = new ApplicationCore();
	
	public static void main(String[] args)
	{
		HRSystem hrSystem = new HRSystem();
		hrSystem.start();
	}
	
	public void start()
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
			else if(cmd.equals("add_department"))
			{
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
			else if(cmd.equals("bonus"))
			{
				Set<Department> departments = core.getDepartments();
				for(Department department : departments)
				{
					Set<Director> directors = department.getDirectors();
					for(Director director : directors)
					{
						Set<Team> teams = director.getTeams();
						for(Team team : teams)
						{
							BonusCalculator calculator = BonusCalculatorResolver.resolve(team);
							BigDecimal bonus = calculator.calculateBonus(team);
							System.out.println("Team " + team.getName() + " was assigned a bonus of: " + bonus);
						}
					}
				}
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
