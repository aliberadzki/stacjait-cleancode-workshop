package pl.com.sages.hr.operations;

/**
 * Created by aliberadzki on 24.09.16.
 */
public interface OperationFactory {

    boolean exists(String operationName);
    Operation get(String operationName);
}
