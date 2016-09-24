package pl.com.sages.hr.command;

import pl.com.sages.hr.ApplicationCore;
import pl.com.sages.hr.model.Department;

public class PrintCommand implements Command {

	private ApplicationCore core;
	
	public PrintCommand(ApplicationCore core)
	{
		this.core = core;
	}
	
	@Override
	public String getCommandName() {
		return "print";
	}

	@Override
	public void doAction(String[] args) {
		for(Department department : core.getDepartments())
		{
			System.out.println(department.toString());
		}
	}
	
	@Override
	public String getShortHelp() {
		return "print - displays all departments, directors and teams";
	}

	@Override
	public String getLongHelp() {
		return "print - displays all departments, directors and teams LONG DESCRIPTION";
	}

}
