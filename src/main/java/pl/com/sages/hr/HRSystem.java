package pl.com.sages.hr;

import pl.com.sages.hr.logging.LoggingDecorator;
import pl.com.sages.hr.operations.*;
import pl.com.sages.hr.builder.OrganizationBuilder;
import pl.com.sages.hr.builder.OrganizationBuilderImpl;

import java.util.*;

public class HRSystem {

	
	public static void main(String[] args)
	{
		OperationResolver operations = new OperationResolver();
		OrganizationBuilder organization = new OrganizationBuilderImpl();
		Scanner scanner = new Scanner(System.in);

		operations.registerOperation(new LoggingDecorator(new InfoOperation()));
		operations.registerOperation(new LoggingDecorator(new AddDepartmentOperation(scanner, organization)));
		operations.registerOperation(new LoggingDecorator(new PrintOrganizationOperation(organization)));
		operations.registerOperation(new LoggingDecorator(new HelpOperation(operations)));
		operations.registerOperation(new LoggingDecorator(new CalculateBonusOperation(organization)));
		operations.registerOperation(new LoggingDecorator(new PrintStatsOperation(organization)));

		System.out.println("--- Human Resources System ---");
		while(true)
		{
			System.out.println("hrs# ");
			String cmd = scanner.nextLine();

			if(cmd.equals("exit"))
			{
				break;
			}

			String[] commandBroken = cmd.split(" ");
			String commandName = commandBroken[0];
			String[] commandArgs = Arrays.copyOfRange(commandBroken, 1, commandBroken.length);

			if(!operations.operationExists(commandName)) {
				operations.resolve("help").execute(commandBroken);
				continue;
			}

			operations.resolve(commandName).execute(commandArgs);

		}
	}
}
