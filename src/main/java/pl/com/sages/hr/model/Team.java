package pl.com.sages.hr.model;

public class Team {
	private String name;
	private TeamType type;
	private double directorCoefficient;
	private double KPI;
	private int headCount;
	private int yearFounded;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString()
	{
		return "[Team | name: " + name + "]";
	}

	public double getDirectorCoefficient() {
		return directorCoefficient;
	}

	public double getKPI() {
		return KPI;
	}

	public int getHeadCount() {
		return headCount;
	}

	public int getYearFounded() {
		return yearFounded;
	}

	public void setType(TeamType type) {
		this.type = type;
	}

	public void setDirectorCoefficient(double directorCoefficient) {
		this.directorCoefficient = directorCoefficient;
	}

	public void setKPI(double KPI) {
		this.KPI = KPI;
	}

	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}

	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}
}
