package pl.com.sages.hr.logging;

import pl.com.sages.hr.operations.Operation;

import java.util.Date;

/**
 * Created by aliberadzki on 25.09.16.
 */
public class LoggingDecorator implements Operation {

    private Operation operation;

    public LoggingDecorator(Operation operation) {
        this.operation = operation;
    }

    public void execute(String[] args) {
        System.err.println(new Date().toString() + " " + operation.getCommand());
        operation.execute(args);
    }

    public String getCommand() {
        return operation.getCommand();
    }

    public String getHelp() {
        return operation.getHelp();
    }

    public String getLongHelp() {
        return operation.getLongHelp();
    }
}
