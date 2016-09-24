package pl.com.sages.hr.bonus;

import java.math.BigDecimal;
import java.util.Calendar;

import pl.com.sages.hr.model.Team;

public abstract class BonusCalculator 
{
	private static final BigDecimal BONUS_BASE = new BigDecimal(1000);
	
	public final BigDecimal calculateBonus(Team team)
	{
		BigDecimal yearsCount = new BigDecimal(getCurrentYear() - team.getSinceYear());
		BigDecimal memberCount = new BigDecimal(team.getMemberCount());
		BigDecimal kpi = team.getKpi();
		BigDecimal directorsCoefficient = team.getDirectorsCoefficient();
		
		return (yearsCount.multiply(memberCount).multiply(kpi).divide(computeTeamCoefficient(team)).multiply(BONUS_BASE)
				).add(directorsCoefficient);
	}
	
	protected abstract BigDecimal computeTeamCoefficient(Team team);
//	{
//		return BigDecimal.ONE;
//	}
	
	protected int getCurrentYear()
	{
		return Calendar.getInstance().get(Calendar.YEAR);
	}
}
