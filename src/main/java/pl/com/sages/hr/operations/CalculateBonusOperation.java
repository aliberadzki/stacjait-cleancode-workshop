package pl.com.sages.hr.operations;

import pl.com.sages.hr.builder.OrganizationBuilder;
import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;
import pl.com.sages.hr.model.bonus.BonusCalculator;
import pl.com.sages.hr.model.bonus.BonusCalculatorFactory;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by aliberadzki on 25.09.16.
 */
public class CalculateBonusOperation implements Operation{

    private OrganizationBuilder organization;

    public CalculateBonusOperation(OrganizationBuilder organization) {
        this.organization = organization;
    }

    public void execute(String[] args) {
        Set<Department> depts = organization.getDepartments();
        for(Department department : depts) {
            for(Director director : department.getDirectors()) {
                for(Team team : director.getTeams()) {
                    BonusCalculator bonusCalculator = BonusCalculatorFactory.forTeamType(team.getType());
                    BigDecimal bonus = bonusCalculator.calculateBonus(team);
                    System.out.println("Team " + team.getName() + " was assigned bonus of: " + bonus);
                }
            }
        }
    }

    public String getCommand() {
        return "bonus";
    }

    public String getHelp() {
        return "bonus - calculates bonuses for employees";
    }

    public String getLongHelp() {
        return "bonus - calculates bonuses for employees following internal HR policies";
    }
}
