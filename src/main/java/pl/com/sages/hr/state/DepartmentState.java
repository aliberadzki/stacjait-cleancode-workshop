package pl.com.sages.hr.state;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Team;

public interface DepartmentState {
	
	public void createDepartment(String name, Department department);
	public void addDirector(String name, Department department);
	public Team addTeam(String directorName, String teamName, Department department);
	public Department getDepartment(Department department);
}
