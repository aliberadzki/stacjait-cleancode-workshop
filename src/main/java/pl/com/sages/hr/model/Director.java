package pl.com.sages.hr.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Director {
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
}
