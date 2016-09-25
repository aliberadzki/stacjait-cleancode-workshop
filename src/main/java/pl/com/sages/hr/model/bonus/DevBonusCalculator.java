package pl.com.sages.hr.model.bonus;

import pl.com.sages.hr.model.Team;

import java.math.BigDecimal;

/**
 * Created by aliberadzki on 25.09.16.
 */
public class DevBonusCalculator extends BonusCalculatorImpl implements BonusCalculator {

    private static final int COUNT_TRESHOLD = 5;
    private static final double KPI_TRESHOLD = 0.9;

    private static final BigDecimal HIGHER_FACTOR_VALUE = BigDecimal.valueOf(1.3);
    private static final BigDecimal LOWER_FACTOR_VALUE = BigDecimal.ONE;


    @Override
    protected BigDecimal calculateTeamFactor(Team team) {
        if(team.getKpi() > KPI_TRESHOLD && team.getMemberCount() > COUNT_TRESHOLD) {
            return HIGHER_FACTOR_VALUE;
        }
        return LOWER_FACTOR_VALUE;
    }
}
