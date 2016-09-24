package pl.com.sages.hr;

import java.util.Scanner;
import java.util.Set;

import pl.com.sages.hr.model.Department;

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
						builder.addTeam(directorName, teamName);
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
