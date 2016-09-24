package pl.com.sages.hr.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Department {
	private String name;
	private Set<Director> directors = new HashSet<Director>();

	public Department(String name) {
		this.name = name;
	}

	public void addDirector(Director directorToBeAdded) {
		this.directors.add(directorToBeAdded);
	}

	public String toString() {
		Iterator i = directors.iterator();

		StringBuilder builder = new StringBuilder("[Department | name=")
				.append(this.name)
				.append(", directors =");

		while(i.hasNext()) {
			builder.append(i.next());
		}

		return builder.append("]").toString();
	}
}
