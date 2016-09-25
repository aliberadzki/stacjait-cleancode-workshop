package pl.com.sages.hr.model.bonus;

import pl.com.sages.hr.model.Team;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by aliberadzki on 25.09.16.
 */
public class OpsBonusCalculator extends BonusCalculatorImpl implements BonusCalculator {

    private static final int YEARS_TRESHOLD = 2;

    private static final BigDecimal HIGHER_FACTOR_VALUE = BigDecimal.valueOf(1.2);
    private static final BigDecimal LOWER_FACTOR_VALUE = BigDecimal.ONE;

    @Override
    protected BigDecimal calculateTeamFactor(Team team) {
        int age = LocalDate.now().getYear() - team.getYearFounded();

        if(age > YEARS_TRESHOLD) {
            return LOWER_FACTOR_VALUE;
        }

        return HIGHER_FACTOR_VALUE;
    }
}
