package pl.com.sages.hr.bonus;

import java.math.BigDecimal;

import pl.com.sages.hr.model.Team;

public class UXBonusCalculator extends BonusCalculator 
{
	protected BigDecimal computeTeamCoefficient(Team team)
	{
		return new BigDecimal(1.1);
	}
}
