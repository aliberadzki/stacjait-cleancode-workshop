package pl.com.sages.hr;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Set;

import pl.com.sages.hr.bonus.BonusCalculator;
import pl.com.sages.hr.bonus.BonusCalculatorResolver;
import pl.com.sages.hr.command.AddDepartmentCommand;
import pl.com.sages.hr.command.BonusCommand;
import pl.com.sages.hr.command.Command;
import pl.com.sages.hr.command.CommandResolver;
import pl.com.sages.hr.command.HelpCommand;
import pl.com.sages.hr.command.InfoCommand;
import pl.com.sages.hr.command.PrintCommand;
import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;
import pl.com.sages.hr.model.TeamType;

public class HRSystem {
	
	private ApplicationCore core;
	private CommandResolver commandResolver;
	
	public static void main(String[] args)
	{
		HRSystem hrSystem = new HRSystem(new ApplicationCore(), new CommandResolver());
		hrSystem.start(args);
	}
	
	public HRSystem(ApplicationCore core, CommandResolver commandResolver)
	{
		this.core = core;
		this.commandResolver = commandResolver;
	}
	
	private void init()
	{
		commandResolver.registerCommand(new AddDepartmentCommand(core));
		commandResolver.registerCommand(new BonusCommand(core));
		commandResolver.registerCommand(new InfoCommand());
		commandResolver.registerCommand(new PrintCommand(core));
		commandResolver.registerCommand(new HelpCommand());
	}
	
	public void start(String[] args)
	{
		init();
		
		System.out.println("--- Human Resources System ---");
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("hrs# ");
			String line = scanner.nextLine();
			String[] arguments = line.split(" ");
			String cmd = arguments[0];
			
			if("exit".equals(cmd))
			{
				break;
			}
			
			Command command = commandResolver.resolve(cmd);
			command.doAction(arguments);
		}
	}
}
