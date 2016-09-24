package pl.com.sages.hr.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class OrganizationBuilder implements Organization {

    private Set<Department> departments = new HashSet<Department>();

    public void addDepatrment(String name) {
        departments.add(new Department(name));
    }

    public void addDirector(String name, String departmentName) {

    }

    public void addTeam(String name, String directorName) {

    }
}
