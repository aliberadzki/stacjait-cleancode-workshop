package pl.com.sages.hr.model;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private String name;
	private Set<Director> directors = new HashSet<Director>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Director> getDirectors() {
		return directors;
	}
	
	public void addDirector(Director director) {
		directors.add(director);
	}
	
	public String toString()
	{
		StringBuilder directorNames = new StringBuilder();
		for(Director director : directors)
		{
			directorNames.append(director.toString());
		}
		return "[Department | name=" + name + ", directors=" + directorNames.toString() + "]";
	}
}
