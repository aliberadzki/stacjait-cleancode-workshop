package pl.com.sages.hr.bonus;

import java.math.BigDecimal;

import pl.com.sages.hr.model.Team;

public class DEVBonusCalculator extends BonusCalculator {
	
	private static final BigDecimal KPI_THRESHOLD = new BigDecimal(0.90);
	
	protected BigDecimal computeTeamCoefficient(Team team)
	{
		int memberCount = team.getMemberCount();
		BigDecimal kpi = team.getKpi();
		
		return (memberCount > 5 && kpi.compareTo(KPI_THRESHOLD) >= 0) ? BigDecimal.ONE : new BigDecimal(1.3);
	}
}
