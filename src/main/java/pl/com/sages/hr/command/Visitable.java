package pl.com.sages.hr.command;

import pl.com.sages.hr.model.Visitor;

/**
 * Created by aliberadzki on 24.09.16.
 */
public interface Visitable {
    void accept(Visitor visitor);
}
