package pl.com.sages.hr.model;

/**
 * Created by aliberadzki on 24.09.16.
 */
public interface Organization {
    void addDepatrment(String name);
    void addDirector(String name, String departmentName);
    void addTeam(String name, String directorName);
}
