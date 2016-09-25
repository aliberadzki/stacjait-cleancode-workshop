package pl.com.sages.hr.model.bonus;

import pl.com.sages.hr.model.Team;

import java.math.BigDecimal;

/**
 * Created by aliberadzki on 25.09.16.
 */
public class UxBonusCalculator extends BonusCalculatorImpl implements BonusCalculator {
    @Override
    protected BigDecimal calculateTeamFactor(Team team) {
        return BigDecimal.valueOf(1.1);
    }
}
