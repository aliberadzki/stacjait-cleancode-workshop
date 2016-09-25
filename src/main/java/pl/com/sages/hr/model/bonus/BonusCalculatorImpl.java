package pl.com.sages.hr.model.bonus;

import pl.com.sages.hr.model.Team;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by aliberadzki on 25.09.16.
 */
public abstract class BonusCalculatorImpl implements BonusCalculator{

    private static final BigDecimal MULTIPLICATION_BASE = BigDecimal.valueOf(1000.0);

    public BigDecimal calculateBonus(Team team) {
        BigDecimal years = BigDecimal.valueOf(LocalDate.now().getYear() - team.getYearFounded());
        BigDecimal count = BigDecimal.valueOf(team.getMemberCount());
        BigDecimal kpi = BigDecimal.valueOf(team.getKpi());
        BigDecimal factor = calculateTeamFactor(team);
        BigDecimal coefficient = BigDecimal.valueOf(team.getCoefficient());

        return years
                .multiply(count)
                .multiply(kpi)
                .divide(factor)
                .multiply(MULTIPLICATION_BASE)
                .add(coefficient);
    }


    protected abstract BigDecimal calculateTeamFactor(Team team);
}
