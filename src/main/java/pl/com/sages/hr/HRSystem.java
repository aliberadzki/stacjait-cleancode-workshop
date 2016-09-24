package pl.com.sages.hr;

import pl.com.sages.hr.model.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HRSystem {

	
	public static void main(String[] args)
	{

		Set<Department> departments = new HashSet<Department>();
		Organization organization = new OrganizationBuilder();
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
			else if(cmd.equals("add_department")) {
				addDepartmentOperation(scanner, organization);
			}
			else if(cmd.equals("print")) {
				printDepartmentsOperation(departments);
			}
			else if(cmd.equals("exit"))
			{
				break;
			}
		}
	}

	private static void printDepartmentsOperation(Set<Department> departments) {
		Iterator i = departments.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}

	private static void addDepartmentOperation(Scanner scanner, Organization organization) {
		System.out.println("Department name:");
		String deptName = scanner.nextLine();
		organization.addDepatrment(deptName);

		System.out.println("Name of directors (comma separated):");
		String[] directorNames = getCommaSeparatedNames(scanner);

		for(int i=0; i<directorNames.length; i++) {
			organization.addDirector(directorNames[i], deptName);
			System.out.println("Team names for director " + directorNames[i] + " (comma separated):");
			String[] teamNames = getCommaSeparatedNames(scanner);

				for(int j=0; j<teamNames.length; j++) {
				organization.addTeam(teamNames[j], directorNames[i]);
			}
		}

	}

	private static String[] getCommaSeparatedNames(Scanner scanner) {
		String line = scanner.nextLine();
		return line.split(",");
	}
}
