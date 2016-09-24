package pl.com.sages.hr.bonus;

import pl.com.sages.hr.model.Team;

public class BonusCalculatorResolver {
	
	public static BonusCalculator resolve(Team team)
	{
		switch(team.getTeamType())
		{
		case QA:
			return new QABonusCalculator();
		case DEV:
			return new DEVBonusCalculator();
		case UX:
			return new UXBonusCalculator();
		case OPS:
			return new OPSBonusCalculator();
		default:
			return new BonusCalculator();
		}
	}
}
