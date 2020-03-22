package atm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int count=0;
		Scanner input = new Scanner( System.in);
		
		List<User> users = AtmMethod.getData();
		boolean  checkPin=true;
		User user = null;
		 
		while (checkPin) {
			if(count<=5) {
				System.out.println("Thank you for use service of us");
				System.out.println("Input your PIN");
				 
				String pinString = input.next();
				 
				if(AtmMethod.checkPin(pinString, users)!=null) {
						user = AtmMethod.checkPin(pinString, users);
						checkPin=false;
				}else {
					count++;
					System.out.println("Your PIN Wrong!");
					checkPin=true;
				}
			}else {
				System.out.println("Your pass to 6 time input PIN");
				checkPin=false;
			}
			
		}
		
		
		AtmMethod.menuUser(user,users); 
		

	}
}
