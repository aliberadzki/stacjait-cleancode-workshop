package pl.com.sages.hr.model;

import java.util.Iterator;

public class Team {
	private String name;
    private TeamType type;
    private int yearFounded;
    private int memberCount;
    private double kpi;
    private double coefficient;

    public Team(String teamName) {
        this.name = teamName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamType getType() {
        return type;
    }

    public void setType(TeamType type) {
        this.type = type;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public double getKpi() {
        return kpi;
    }

    public void setKpi(double kpi) {
        this.kpi = kpi;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public String toString() {
        return new StringBuilder("[Team | name=")
                .append(this.name)
                .append("]")
                .toString();

    }
}
