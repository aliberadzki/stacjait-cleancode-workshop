package pl.com.sages.hr.bonus;

import pl.com.sages.hr.model.Team;
import pl.com.sages.hr.model.TeamType;

public class BonusCalculatorResolver {
	
	public static BonusCalculator resolve(Team team)
	{
		TeamType teamType = team.getTeamType();
		switch(teamType)
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
			throw new IllegalArgumentException("Unsupported team type: " + typeType);
		}
	}
}
