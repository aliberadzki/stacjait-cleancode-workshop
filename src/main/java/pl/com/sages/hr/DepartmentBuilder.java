package pl.com.sages.hr;

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
	
	public void addDirector(String name)
	{
		Director director = new Director();
		director.setName(name);
		department.addDirector(director);
	}
	
	public void addTeam(String directorName, String teamName)
	{
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
	
	public Department getDepartment()
	{
		return department;
	}
}
