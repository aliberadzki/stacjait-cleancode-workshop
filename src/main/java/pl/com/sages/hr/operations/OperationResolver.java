package pl.com.sages.hr.operations;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class OperationResolver {

    private Map<String, Operation> registeredOperations = new HashMap<String, Operation>();

    public void registerOperation(Operation operation) {
        this.registeredOperations.put(operation.getCommand(), operation);
    }

    public Operation resolve(String cmdName) {
        return registeredOperations.get(cmdName);
    }

    public boolean operationExists(String cmdName) {
        return this.registeredOperations.containsKey(cmdName);
    }

    public Collection<Operation> getOperations() {
        return this.registeredOperations.values();
    }
}
