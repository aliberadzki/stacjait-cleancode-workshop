package pl.com.sages.hr;

import pl.com.sages.hr.exceptions.WrongOrganizationStructureException;
import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;

public class DepartmentBuilder {
	
	private Department department;
	
	public void createDepartment(String name)
	{
		Department department = new Department();
		department.setName(name);
		this.department = department;
	}
	
	public void addDirector(String name) throws WrongOrganizationStructureException {
		if(department == null) throw new WrongOrganizationStructureException("There is no department");
		Director director = new Director();
		director.setName(name);
		department.addDirector(director);
	}
	
	public void addTeam(String directorName, String teamName) throws WrongOrganizationStructureException {
		if(noDirectorCreated()) throw new WrongOrganizationStructureException("There are no teams in organization");
		for(Director director : department.getDirectors())
		{
			if(directorName.equals(director.getName()))
			{
				Team team = new Team();
				team.setName(teamName);
				director.addTeam(team);
			}
		}
	}

	private boolean noDirectorCreated() {
		if(department == null || department.getDirectors().size() < 1) return true;
		return false;
	}

	public Department getDepartment()
	{
		return department;
	}
}
