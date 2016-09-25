package pl.com.sages.hr.model;

import pl.com.sages.hr.model.stats.Visitable;
import pl.com.sages.hr.model.stats.Visitor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Director implements Visitable {
	private String name;
	private Set<Team> teams = new HashSet<Team>();

	public Director(String name) {
		this.name = name;
	}

	public void addTeam(Team teamToBeAdded) {
		this.teams.add(teamToBeAdded);
	}


	public String toString() {
		Iterator i = teams.iterator();

		StringBuilder builder = new StringBuilder("[Director | name=")
				.append(this.name)
				.append(", teams =");

		while(i.hasNext()) {
			builder.append(i.next());
		}

		return builder.append("]").toString();

	}

	public String getName() {
		return name;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
		for(Team team : teams) {
			team.accept(visitor);
		}
	}
}
