package pl.com.sages.hr.operations;

import pl.com.sages.hr.ApplicationCore;
import pl.com.sages.hr.bonus.BonusCalculator;
import pl.com.sages.hr.bonus.BonusCalculatorResolver;
import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class DisplayBonusesOperation implements Operation {

    private ApplicationCore core;

    public DisplayBonusesOperation(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public void execute() {
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
}
