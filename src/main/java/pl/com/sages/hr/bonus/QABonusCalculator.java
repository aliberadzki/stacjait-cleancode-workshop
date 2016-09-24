package pl.com.sages.hr.bonus;

import java.math.BigDecimal;

import pl.com.sages.hr.model.Team;

public class QABonusCalculator extends BonusCalculator{
	
	private static final BigDecimal KPI_THRESHOLD = new BigDecimal(0.80);
	
	protected BigDecimal computeTeamCoefficient(Team team)
	{
		int currentYear = getCurrentYear();
		int sinceYear = team.getSinceYear();
		BigDecimal kpi = team.getKpi();
		
		return (currentYear - sinceYear > 2) && kpi.compareTo(KPI_THRESHOLD) < 0 ? new BigDecimal(1.5) : new BigDecimal(1.2);
	}
}
