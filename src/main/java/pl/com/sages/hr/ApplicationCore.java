package pl.com.sages.hr;

import java.util.HashSet;
import java.util.Set;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;

public class ApplicationCore {
	
	private Set<Department> departments = new HashSet<Department>();

	public Set<Department> getDepartments() 
	{
		return departments;
	}

	public void addDepartment(Department department) 
	{
		departments.add(department);
	}

	public Set<Team> getAllTeams() {
		Set<Team> teams = new HashSet<Team>();

		for(Department dept : departments) {
			for(Director director : dept.getDirectors()) {
				teams.addAll(director.getTeams());
			}
		}
		return teams;
	}
}
