package pl.com.sages.hr;

import java.util.Scanner;

public class HRSystem {
	
	public static void main(String[] args)
	{
		System.out.println("--- Human Resources System ---");
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			System.out.println("hrs# ");
			String cmd = scanner.nextLine();
			if(cmd.equals("info"))
			{
				System.out.println("Human Resources System v1");
			}
			else if(cmd.equals("exit"))
			{
				break;
			}
		}
	}
}
