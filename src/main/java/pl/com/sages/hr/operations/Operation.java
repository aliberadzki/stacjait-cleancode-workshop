package pl.com.sages.hr.operations;

/**
 * Created by aliberadzki on 24.09.16.
 */
public interface Operation {
    void execute(String[] args);

    String getCommand();
    String getHelp();
    String getLongHelp();
}
