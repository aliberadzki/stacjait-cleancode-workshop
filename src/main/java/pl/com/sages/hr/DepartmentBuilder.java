package pl.com.sages.hr;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;
import pl.com.sages.hr.model.TeamType;
import pl.com.sages.hr.state.AddDepartmentState;
import pl.com.sages.hr.state.AddDirectorState;
import pl.com.sages.hr.state.AddTeamState;
import pl.com.sages.hr.state.DepartmentState;
import pl.com.sages.hr.state.EndState;
import pl.com.sages.hr.state.InitState;

public class DepartmentBuilder {
	
	private Department department = new Department();
	private DepartmentState state = new InitState();
	
	public void createDepartment(String name)
	{
		state.createDepartment(name, department);
		state = new AddDepartmentState();
	}
	
	public void addDirector(String name)
	{
		if(state instanceof AddDirectorState)
		{
			state = new AddDepartmentState();
		}
		
		state.addDirector(name, department);
		state = new AddDirectorState();
	}
	
	public Team addTeam(String directorName, String teamName)
	{
		if(state instanceof AddTeamState)
		{
			state = new AddDirectorState();
		}
		
		Team team = state.addTeam(directorName, teamName, department);
		state = new AddTeamState();
		return team;
	}
	
	public Department getDepartment()
	{
		department = state.getDepartment(department);
		state = new EndState();
		return department;
	}

	public Team addTeam(String directorName, String teamName, TeamType type, int yearFounded, int headCount, double kpi, double coefficient) {
		Team team = this.addTeam(directorName, teamName);
		team.setType(type);
		team.setYearFounded(yearFounded);
		team.setHeadCount(headCount);
		team.setKPI(kpi);
		team.setDirectorCoefficient(coefficient);
		return team;
	}
}
