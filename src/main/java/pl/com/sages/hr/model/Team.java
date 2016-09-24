package pl.com.sages.hr.model;

import java.math.BigDecimal;

public class Team {
	private String name;
	
	private int sinceYear;
	
	private int memberCount;
	
	private BigDecimal kpi;
	
	private BigDecimal directorsCoefficient;
	
	private TeamType teamType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getSinceYear() {
		return sinceYear;
	}

	public void setSinceYear(int sinceYear) {
		this.sinceYear = sinceYear;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public BigDecimal getKpi() {
		return kpi;
	}

	public void setKpi(BigDecimal kpi) {
		this.kpi = kpi;
	}

	public BigDecimal getDirectorsCoefficient() {
		return directorsCoefficient;
	}

	public void setDirectorsCoefficient(BigDecimal directorsCoefficient) {
		this.directorsCoefficient = directorsCoefficient;
	}

	public TeamType getTeamType() {
		return teamType;
	}

	public void setTeamType(TeamType teamType) {
		this.teamType = teamType;
	}

	public String toString()
	{
		return "[Team | name: " + name + ", type: " + teamType + ", since year: " + sinceYear + ", member count: " + memberCount + 
				", kpi: " + kpi + ", directors coefficient: " + directorsCoefficient + "]";
	}
}
