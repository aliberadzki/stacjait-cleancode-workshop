package pl.com.sages.hr;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.state.AddDepartmentState;
import pl.com.sages.hr.state.AddDirectorState;
import pl.com.sages.hr.state.AddTeamState;
import pl.com.sages.hr.state.DepartmentState;
import pl.com.sages.hr.state.EndState;
import pl.com.sages.hr.state.InitState;
import pl.com.sages.hr.state.fluentstate.InitFluentState;

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
	
	public void addTeam(String directorName, String teamName)
	{
		if(state instanceof AddTeamState)
		{
			state = new AddDirectorState();
		}
		
		state.addTeam(directorName, teamName, department);
		state = new AddTeamState();
	}
	
	public Department getDepartment()
	{
		department = state.getDepartment(department);
		state = new EndState();
		return department;
	}

	public static InitFluentState create(String deptName) {
		return new InitFluentState(deptName);
	}
}
