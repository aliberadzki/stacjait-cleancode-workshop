package pl.com.sages.hr.model;

import java.util.Iterator;

public class Team {
	private String name;

    public Team(String teamName) {
        this.name = teamName;
    }

    public String toString() {
        return new StringBuilder("[Team | name=")
                .append(this.name)
                .append("]")
                .toString();

    }
}
