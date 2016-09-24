package pl.com.sages.hr.command;

public interface Command {
	
	public String getCommandName();
	
	public String getShortHelp();
	
	public String getLongHelp();
	
	public void doAction(String[] args);
}
