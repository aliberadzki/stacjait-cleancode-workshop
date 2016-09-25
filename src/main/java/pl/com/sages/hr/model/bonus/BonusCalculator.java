package pl.com.sages.hr.model.bonus;

import pl.com.sages.hr.model.Team;

import java.math.BigDecimal;

/**
 * Created by aliberadzki on 25.09.16.
 */
public interface BonusCalculator {

    BigDecimal calculateBonus(Team team);
}
