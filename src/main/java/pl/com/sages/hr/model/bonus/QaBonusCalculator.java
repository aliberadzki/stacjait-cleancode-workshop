package pl.com.sages.hr.model.bonus;

import pl.com.sages.hr.model.Team;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by aliberadzki on 25.09.16.
 */
public class QaBonusCalculator extends BonusCalculatorImpl implements BonusCalculator {

    private static final int YEARS_TRESHOLD = 2;
    private static final double KPI_TRESHOLD = 0.8;

    private static final BigDecimal HIGHER_FACTOR_VALUE = BigDecimal.valueOf(1.5);
    private static final BigDecimal LOWER_FACTOR_VALUE = BigDecimal.valueOf(1.2);

    @Override
    protected BigDecimal calculateTeamFactor(Team team) {
        int age = LocalDate.now().getYear() - team.getYearFounded();
        if(age > YEARS_TRESHOLD && team.getKpi() < KPI_TRESHOLD) {
            return HIGHER_FACTOR_VALUE;
        }
        return LOWER_FACTOR_VALUE;
    }
}
