package pl.com.sages.hr.operations;

import pl.com.sages.hr.ApplicationCore;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class OperationFactoryImpl implements OperationFactory{

    private Map<String, Operation> availableOperations = new HashMap<>();

    public OperationFactoryImpl(Scanner scanner, ApplicationCore core) {
        availableOperations.put("help", new HelpOperation());
        availableOperations.put("print", new PrintOrganizationOperation(core));
        availableOperations.put("bonus", new DisplayBonusesOperation(core));
        availableOperations.put("add_department", new AddDepartmentOperation(scanner, core));
    }

    @Override
    public boolean exists(String operationName) {
        return availableOperations.containsKey(operationName);
    }

    @Override
    public Operation get(String operationName) {
        return availableOperations.get(operationName);
    }
}
