package pl.com.sages.hr.bonus;

import java.math.BigDecimal;

import pl.com.sages.hr.model.Team;

public class OPSBonusCalculator extends BonusCalculator {
	
	protected BigDecimal computeTeamCoefficient(Team team)
	{
		int sinceYear = team.getSinceYear();
		int currentYear = getCurrentYear();
		return currentYear - sinceYear > 2 ? BigDecimal.ONE : new BigDecimal(1.2);
	}
}
