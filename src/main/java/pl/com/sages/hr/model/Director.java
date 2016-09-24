package pl.com.sages.hr.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Director {
	private String name;
	private Set<Team> teams = new HashSet<Team>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Team> getTeams() {
		return teams;
	}
	
	public void addTeam(Team team) {
		teams.add(team);
	}
	
	public String toString()
	{
		StringBuilder teamNames = new StringBuilder();
		for(Team team : teams)
		{
			teamNames.append(team.toString());
		}
		return "[Director | name=" + name + ", teams=" + teamNames.toString() + "]";
	}
}
