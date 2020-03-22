package atm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtmMethod {
		public static List<User> getData() {
			List<User> users = new ArrayList<User>();
			User user1 = new User("12", "hoa1", "12", 5000000);
			User user2 = new User("23", "hoa2", "23", 600000);
			User user3 = new User("34", "hoa3", "34", 900000);
			User user4 = new User("45", "hoa4", "45", 1000000);
			User user5 = new User("56", "hoa5", "56", 1200000);
			
			users.add(user1);
			users.add(user2);
			users.add(user3);
			users.add(user4);
			users.add(user5);
			
			return users;
		}
	public	static void showList(List<User> users) {
		for (User user : users) {
			System.out.println("stk:"+user.getStk()+"-name:"+user.getName()+"-PIN:"+user.getPin()+"-Money:"+ user.getMoney());
		}
	}
	 public static User checkPin(String pin,List<User> users) {
		  for (User user : users) {
			if(pin.equals(user.getPin())) {
				return user;
			}
		}
		  return null;
		
	}
	 
	 public static void menuUser( User user,List<User> users) {
		 Scanner input = new Scanner( System.in);
		 StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("Choose one function !").append("\n")
			.append("1.Kiem tra so du").append("\n")
			.append("2.Rut tien").append("\n")
			.append("3.Chuyen tien").append("\n")
			.append("4.show list( chuc nang phu )").append("\n");
			System.out.println(stringBuffer);
			System.out.println("Nhap chuc nang:");	
			Integer inputString =null;
			try {
				  inputString = Integer.parseInt(input.next()+"");
			} catch (Exception e) {
				if(continuteOrNo(input)) {
		  			menuUser(user,users);
		  		} 
			}
		 switch (inputString) {
		      case 1:
		  		StringBuffer infor = new StringBuffer();
		  		infor.append("name:"+user.getName()).append("\n").append("money:"+user.getMoney()).append("\n").append("stk:"+user.getStk());
		  		System.out.println(infor);
		  		
		  		if(continuteOrNo(input)) {
		  			menuUser(user,users);
		  		}else {
		  			break;
		  		}
		      case 2:
		        System.out.println("Nhap so tien ban muon rut\n");
		    	String integer = input.next();
		    	try {
		    		Integer inputMoneyInteger = Integer.parseInt(integer+"");
		    		if(inputMoneyInteger>user.getMoney()) {
		    			
		    			System.out.println("Ban nhap qua so tien hien co!"); 
			    		if(continuteOrNo(input)) {
				  			menuUser(user,users);
				  		}else {
				  			break;
				  		}
		    		}else{
		    			user.setMoney(user.getMoney()-inputMoneyInteger);
		    			 
		    			if(continuteOrNo(input)) {
				  			menuUser(user,users);
				  		}else {
				  			break;
				  		}
		    		}
		    		
		    	}catch (Exception e) {
		    		System.out.println("Ban nhap sai du lieu!"); 
		    		if(continuteOrNo(input)) {
			  			menuUser(user,users);
			  		}else {
			  			break;
			  		}
				}
		    		
		      case 3:
		    	  System.out.println("Nhap so tien ban muon chuyen\n");
		    	  Integer moneyPassInteger =null;
		    	  try {
		    	    moneyPassInteger = Integer.parseInt(input.next()+"");
		    	    System.out.println("Nhap so tk:\n");
		    	    String stk =  input.next();
			    	  if (checkStkAndPass(moneyPassInteger,stk, users,user)) {
						System.out.println("Chuyen tien thanh cong");
						  if(continuteOrNo(input)) {
					  			menuUser(user,users);
					  	 }else {
					  			break;
					  	 }
			    	  }else {
			    		  System.out.println("Chuyen tien that bai");
			    		 if(continuteOrNo(input)) {
					  			menuUser(user,users);
					  	 }else {
					  			break;
					  	 }
			    	  }	
		    	  }catch (Exception e) {
		    		  System.out.println("Ban nhap sai du lieu!"); 
			    	  if(continuteOrNo(input)) {
				  			menuUser(user,users);
				  	 }else {
				  			break;
				  			 
				  	 }
		    	  }
		      case 4:  
		    	  showList(users);
		    	  if(continuteOrNo(input)) {
			  			menuUser(user,users);
			  	 }else {
			  			break;
			  	 }
		      default: 
		    	 break;
		    }
	}
	
	 public static  boolean  continuteOrNo(Scanner input) {
		 System.out.println("Ban co muon tiep tuc chuc nang khac:(y/n)");
		 if("y".equals(input.next())) {
			 return true;
		} else /* if("n".equals(input.next())) */ {
			 System.out.println("GoodBye!");
			 return false;
		}
		/* return false; */
	}
	 
	 public static boolean checkStkAndPass(Integer moneyPassInteger,String stk,List<User> users,User userNow) {
		 for (User user : users) {
			if(stk.equals(user.getStk())) {
				 user.setMoney(user.getMoney() + moneyPassInteger );
				 userNow.setMoney(userNow.getMoney() -moneyPassInteger );
				 return true;
			}
		}
		 return false;  
	}
}
