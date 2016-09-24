package pl.com.sages.hr;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Set;

import pl.com.sages.hr.bonus.BonusCalculator;
import pl.com.sages.hr.bonus.BonusCalculatorResolver;
import pl.com.sages.hr.model.Department;
import pl.com.sages.hr.model.Director;
import pl.com.sages.hr.model.Team;
import pl.com.sages.hr.model.TeamType;
import pl.com.sages.hr.operations.*;

public class HRSystem {
	
	private ApplicationCore core = new ApplicationCore();
	
	public static void main(String[] args)
	{
		HRSystem hrSystem = new HRSystem();
		hrSystem.start();
	}
	
	public void start()
	{
		System.out.println("--- Human Resources System ---");
		Scanner scanner = new Scanner(System.in);

		OperationFactory operationFactory = new OperationFactoryImpl(scanner, core);
		while(true)
		{
			System.out.println("hrs# ");
			String cmd = scanner.nextLine();

			if(cmd.equals("exit"))
			{
				break;
			}

			if(!operationFactory.exists(cmd)) {
				operationFactory.helpOperation().execute();
			}

			operationFactory.get(cmd).execute();

			if(cmd.equals("info"))
			{
				Operation infoOperation = new InfoOperation();
				infoOperation.execute();
			}
			else if(cmd.equals("add_department"))
			{
				Operation addDeptOperation = new AddDepartmentOperation(scanner, core);
				addDeptOperation.execute();


			}
			else if(cmd.equals("bonus"))
			{
				Operation displayBonusesOperation = new DisplayBonusesOperation(core);
				displayBonusesOperation.execute();

			}
			else if(cmd.equals("print"))
			{
				Operation printOrganization = new PrintOrganizationOperation(core);
				printOrganization.execute();
			}
			else if(cmd.equals("exit"))
			{
				break;
			}
		}
	}
}
