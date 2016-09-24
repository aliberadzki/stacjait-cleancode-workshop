package pl.com.sages.hr.model;

import java.time.LocalDate;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class RegularPremiumCalculator implements PremiumCalculator {

    private TeamFactorCalculator teamFactorCalculator;

    public RegularPremiumCalculator(TeamFactorCalculator teamFactorCalculator) {
        this.teamFactorCalculator = teamFactorCalculator;
    }

    @Override
    public double calculatePremiumForTeam(Team team) {
        int howManyYearsTeamExists = LocalDate.now().getYear() - team.getYearFounded();
        int howManyMembers = team.getHeadCount();
        double teamKPI = team.getKPI();
        double directorCoefficient = team.getDirectorCoefficient();
        double teamFactor = getTeamFactor(team);
        return 0;
    }

    private double getTeamFactor(Team team) {
        return teamFactorCalculator.calculateFactor(team);
    }
}
