package pl.com.sages.hr.state;

import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;

public class AddDepartmentState implements DepartmentState {

	@Override
	public void createDepartment(String name, Department department) {
		throw new IllegalStateException("Illegal method called");
	}

	@Override
	public void addDirector(String name, Department department) {
		Director director = new Director();
		director.setName(name);
		department.addDirector(director);
	}

	@Override
	public void addTeam(String directorName, String teamName,
			Department department) {
		throw new IllegalStateException("Illegal method called");
	}

	@Override
	public Department getDepartment(Department department) {
		throw new IllegalStateException("Illegal method called");
	}

}
