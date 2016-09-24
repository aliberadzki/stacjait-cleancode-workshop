package pl.com.sages.hr.state;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;

public class AddDirectorState implements DepartmentState {

	@Override
	public void createDepartment(String name, Department department) {
		throw new IllegalStateException("Illegal method called");
	}

	@Override
	public void addDirector(String name, Department department) {
		throw new IllegalStateException("Illegal method called");
	}

	@Override
	public Team addTeam(String directorName, String teamName,
						Department department) {
		Team team = new Team();
		for (Director director : department.getDirectors()) {
			if (directorName.equals(director.getName())) {
				team.setName(teamName);
				director.addTeam(team);
			}
		}
		return team;
	}

	@Override
	public Department getDepartment(Department department) {
		throw new IllegalStateException("Illegal method called");
	}
}
