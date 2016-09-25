package pl.com.sages.hr.model.stats;

/**
 * Created by aliberadzki on 25.09.16.
 */
public interface Visitable {
    void accept(Visitor visitor);
}
