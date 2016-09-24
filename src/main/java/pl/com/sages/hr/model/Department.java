package pl.com.sages.hr.model;

import pl.com.sages.hr.command.Visitable;

import java.util.HashSet;
import java.util.Set;

public class Department implements Visitable{
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

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		for(Director director : directors) {
			director.accept(visitor);
		}
	}
}
