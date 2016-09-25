package pl.com.sages.hr.operations;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class InfoOperation implements Operation {
    public void execute(String[] args) {
        System.out.println("Human Resources System v1");
    }

    public String getCommand() {
        return "info";
    }

    public String getHelp() {
        return "info - returns information about system";
    }

    public String getLongHelp() {
        return "info - returns brief information about developed system";
    }
}
