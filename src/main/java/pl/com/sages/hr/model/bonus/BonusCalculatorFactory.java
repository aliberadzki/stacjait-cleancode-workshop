package pl.com.sages.hr.model.bonus;

import pl.com.sages.hr.model.TeamType;

/**
 * Created by aliberadzki on 25.09.16.
 */
public class BonusCalculatorFactory {

    public static BonusCalculator forTeamType(TeamType type) {
        switch(type) {
            case DEV:
                return new DevBonusCalculator();
            case OPS:
                return new OpsBonusCalculator();
            case QA:
                return new QaBonusCalculator();
            case UX:
                return new UxBonusCalculator();
            default:
                throw new IllegalArgumentException("No bonus calculator implemented for type " + type.toString());
        }
    }
}
