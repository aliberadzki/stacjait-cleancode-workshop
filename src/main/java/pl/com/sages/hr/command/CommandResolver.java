package pl.com.sages.hr.command;

import java.util.HashMap;
import java.util.Map;

public class CommandResolver {
	
	private Map<String, Command> commandMap = new HashMap<String, Command>();
	
	public void registerCommand(Command command)
	{
		String commandName = command.getCommandName();
		commandMap.put(commandName, command);
		// hack
		if(command instanceof HelpCommand)
		{
			HelpCommand helpCommand = (HelpCommand) command;
			helpCommand.setCommandsMap(commandMap);
		}
	}
	
	public Command resolve(String commandName)
	{
		return commandMap.containsKey(commandName) ? commandMap.get(commandName) : commandMap.get("help");
	}
}
