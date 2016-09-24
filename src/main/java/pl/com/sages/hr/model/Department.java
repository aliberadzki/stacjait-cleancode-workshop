package pl.com.sages.hr.model;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private String name;
	private Set<Director> directors = new HashSet<Director>();
}
