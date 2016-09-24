package pl.com.sages.hr;

import java.util.HashSet;
import java.util.Set;

import pl.com.sages.hr.model.Department;

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
}
