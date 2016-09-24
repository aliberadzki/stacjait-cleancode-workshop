package pl.com.sages.hr.command;

import java.util.Set;

import pl.com.sages.hr.model.Department;

public class InfoCommand implements Command {

	@Override
	public String getCommandName() {
		return "info";
	}

	@Override
	public void doAction(String[] args) {
		System.out.println("Human Resources System v1");
	}
	
	@Override
	public String getShortHelp() {
		return "info - information about the system";
	}

	@Override
	public String getLongHelp() {
		return "info - information about the system LONG DESCRIPTION";
	}

}
