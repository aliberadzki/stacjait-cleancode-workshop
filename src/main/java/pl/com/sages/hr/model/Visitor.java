package pl.com.sages.hr.model;

/**
 * Created by aliberadzki on 24.09.16.
 */
public interface Visitor {

    void visit(Department dept);
    void visit(Director director);
    void visit(Team team);

    String generatePrintout();
}
