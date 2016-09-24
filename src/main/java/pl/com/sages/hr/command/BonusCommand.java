package pl.com.sages.hr.command;

import java.math.BigDecimal;
import java.util.Set;

import pl.com.sages.hr.ApplicationCore;
import pl.com.sages.hr.bonus.BonusCalculator;
import pl.com.sages.hr.bonus.BonusCalculatorResolver;
import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;

public class BonusCommand implements Command {

	private ApplicationCore core;
	
	public BonusCommand(ApplicationCore core)
	{
		this.core = core;
	}
	
	@Override
	public String getCommandName() {
		return "bonus";
	}

	@Override
	public void doAction(String[] args) {
		Set<Department> departments = core.getDepartments();
		for(Department department : departments)
		{
			Set<Director> directors = department.getDirectors();
			for(Director director : directors)
			{
				Set<Team> teams = director.getTeams();
				for(Team team : teams)
				{
					BonusCalculator calculator = BonusCalculatorResolver.resolve(team);
					BigDecimal bonus = calculator.calculateBonus(team);
					System.out.println("Team " + team.getName() + " was assigned a bonus of: " + bonus);
				}
			}
		}
	}
	
	@Override
	public String getShortHelp() {
		return "bonus - computes bonuses for all the teams";
	}

	@Override
	public String getLongHelp() {
		return "bonus - computes bonuses for all the teams LONG DESCRIPTION";
	}
}
