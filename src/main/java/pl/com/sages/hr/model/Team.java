package pl.com.sages.hr.model;

public class Team {
	private String name;

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
}
