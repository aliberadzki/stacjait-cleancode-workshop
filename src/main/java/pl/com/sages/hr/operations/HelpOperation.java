package pl.com.sages.hr.operations;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class HelpOperation implements Operation {
    private OperationResolver operations;

    public HelpOperation(OperationResolver operations) {
        this.operations = operations;
    }

    public void execute(String[] args) {

        if(args == null || args.length < 1) {
            displayAllCommandsHelp();
            return;
        }

        if(operations.operationExists(args[0])) {
            displaySingleCommandHelp(args[0]);
        }
        else {
            displayNonExistentCmdInfo(args[0]);
            displayAllCommandsHelp();
        }

    }

    public String getCommand() {
        return "help";
    }

    public String getHelp() {
        return "help - help short desc";
    }

    public String getLongHelp() {
        return "help - long long lomng help";
    }

    private void displayAllCommandsHelp() {
        Collection<Operation> allOperations = operations.getOperations();
        Iterator<Operation> i = allOperations.iterator();
        StringBuilder builder = new StringBuilder("Available operations are:\n");

        while (i.hasNext()) {
            Operation op = i.next();
            builder.append(op.getHelp()).append("\n");
        }
        System.out.println(builder.toString());
    }

    private void displaySingleCommandHelp(String cmd) {
        System.out.println(operations.resolve(cmd).getLongHelp());
    }

    private void displayNonExistentCmdInfo(String cmd) {
        System.out.println("Command '" + cmd + "' does not exists.");
    }
}
