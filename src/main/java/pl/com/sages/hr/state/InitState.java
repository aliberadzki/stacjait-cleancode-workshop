package pl.com.sages.hr.state;

import pl.com.sages.hr.model.Department;

public class InitState implements DepartmentState{
	
	public void createDepartment(String name, Department department)
	{
		department.setName(name);
	}
	
	public void addDirector(String name, Department department)
	{
		throw new IllegalStateException("Illegal method called");
	}
	
	public void addTeam(String directorName, String teamName, Department department)
	{
		throw new IllegalStateException("Illegal method called");
	}
	
	public Department getDepartment(Department department)
	{
		throw new IllegalStateException("Illegal method called");
	}
}
