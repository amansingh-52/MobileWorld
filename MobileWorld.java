import java.util.*;
import java.io.*;

class Menu{
	Scanner sc = new Scanner(System.in);
	static Password pw = new Password();
	static AddMobile am = new AddMobile();
	static EditMobile em = new EditMobile();
	static DisplayMobile dm = new DisplayMobile();
	static Menu menu = new Menu();
	public void open() throws IOException{
		int choice = 0;
		boolean reLaunch = false;
		try{
		System.out.println("\n******************************************");
		System.out.println("\t\tMENU");
		System.out.println("******************************************");
		System.out.println("\t1. Display Mobile");
		System.out.println("\t2. Add Mobile");
		System.out.println("\t3. Edit Mobile");
		System.out.println("\t4. Change Password");
		System.out.println("\t5. Exit");
		System.out.println("\tEnter your choice");
		System.out.print("\t");
		choice = sc.nextInt();
		}catch(InputMismatchException e)
		{
			System.out.println("\tPlease Enter Valid Integral Value :( ");
			System.out.println("\tPlease Re-Enter.........");
			reLaunch = true; 
		}
		switch(choice)
		{
		case 1 : dm.dispalyMenu();
			 break;
		case 2 : am.generateName();
			 break;
		case 3 : em.editMenu();
			 break;
		case 4 : pw.editPassword();
			 break;
		case 5 : System.out.println("\tThank You :)");
			 break;
		
		default : System.out.println("\tWrong Choice :( ");
			  reLaunch=true;
			  break;
		}
		OpenAgain(reLaunch);
	}
		void OpenAgain(boolean condition) throws IOException{
		if(condition==true)
		menu.open();
	}
}

class Password{
		Scanner sc = new Scanner(System.in);
		static Menu menu = new Menu();
		public void checkPassword() throws IOException{
					FileReader fr = new FileReader("D:\\output\\MobileWorld\\Password.txt");
					BufferedReader br = new BufferedReader(fr);
					String actualPassword = br.readLine();
					boolean check = false;
					int chance = 3;
					do{
					System.out.println("\tEnter password :");
					System.out.print("\t");
					String userInput = sc.nextLine();
					if(actualPassword.equals(userInput))
						{
							System.out.println("\tPassword is correct\n");
							menu.open();
							check = true;
							
						}
					else 
						{
							chance--;
							System.out.println("\tOOPS!!!!!!.....Password INCORRECT");
							if(chance!=0)
							System.out.println("\t"+chance+" chances remaining.....!!!!");
							else
							System.out.println("\tSorry.....Try again after sometime :(");
						}
					}while(check==false&&chance!=0);
					fr.close();
					}

		public void editPassword() throws IOException{
					System.out.println("\tEnter new Password");
					System.out.print("\t");
					String userInput1 = sc.nextLine();
					System.out.println("\tRe-Enter New Password");
					System.out.print("\t");
					String userInput2 = sc.nextLine();
					if(userInput1.equals(userInput2))
					{
					FileWriter fw = new FileWriter("D:\\output\\MobileWorld\\Password.txt");
					fw.write(userInput2);
					System.out.println("\tPassword changed ;) \n\tRelogin.....");
					fw.close();
					}
					else
					{
					System.out.println("\tPassword DONOT match :(");
					System.out.println("\tReturning to Menu..............");
					menu.open();
					}
				}
}

class AddMobile extends Path{
		Scanner sc = new Scanner(System.in);
		static Path path = new Path();
		public void generateName() throws IOException{
					System.out.println("\tEnter name of new mobile phone");
					System.out.print("\t");
					String name = sc.nextLine();
					LastAdded(name);
					addDescription(name);
					}
			void LastAdded(String name) throws IOException{
					try{
					FileWriter fw = new FileWriter("D:\\output\\MobileWorld\\LastAdded.txt");
					fw.write(name);
					fw.close();
					}catch(FileNotFoundException e)
					{System.out.println("\t\tFile not found :(");}
					}
			
			public void createDescriptionFile(String path) throws IOException{
				try{
				FileWriter fw = new FileWriter(path);
				System.out.print("\t");
				String userInput = sc.nextLine();
				fw.write(userInput);
				fw.close();
				}catch(FileNotFoundException e)
				{System.out.println("\tFile not created!! :( ");}
				}
		public void addDescription(String name) throws IOException{
					
				String location = null;
						location=company(name);
						System.out.println("\tEnter company name of "+name);
						createDescriptionFile(location);
						location=model(name);
						System.out.println("\tEnter model number "+name);
						createDescriptionFile(location);
						location=screenSize(name);
						System.out.println("\tEnter "+name+"'s Screen Size");
						createDescriptionFile(location);
						location=resolution(name);
						System.out.println("\tEnter "+name+"'s Resolution");
						createDescriptionFile(location);
						location=screenType(name);
						System.out.println("\tEnter "+name+"'s Screen Type");
						createDescriptionFile(location);
						location=ram(name);
						System.out.println("\tEnter "+name+"'s RAM");
						createDescriptionFile(location);
						location=rom(name);
						System.out.println("\tEnter "+name+"'s Internal Storage");
						createDescriptionFile(location);
						location=batteryCapacity(name);
						System.out.println("\tEnter "+name+"'s Battery Capacity");
						createDescriptionFile(location);
						location=rearCamera(name);
						System.out.println("\tEnter "+name+"'s Rear Camera");
						createDescriptionFile(location);
						location=frontCamera(name);
						System.out.println("\tEnter "+name+"'s Front Camera");
						createDescriptionFile(location);
						location=processor(name);
						System.out.println("\tEnter "+name+"'s Processor");
						createDescriptionFile(location);
						location=chargingPortType(name);
						System.out.println("\tEnter "+name+"'s Charging Port Type");
						createDescriptionFile(location);
						location=notchType(name);
						System.out.println("\tEnter "+name+"'s Notch Type");
						createDescriptionFile(location);
						location=simSlot(name);
						System.out.println("\tEnter "+name+"'s Sim slot Type");
						createDescriptionFile(location);
						location=os(name);
						System.out.println("\tEnter "+name+"'s Operating System");
						createDescriptionFile(location);
						location=ui(name);
						System.out.println("\tEnter "+name+"'s User Interface Type");
						createDescriptionFile(location);
						location=price(name);
						System.out.println("\tEnter "+name+"'s Price");
						createDescriptionFile(location);					
			}
}

class Path{

			String company(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_company.txt";
				return path;
			}
			
			String model(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_model.txt";
				return path;
			}

			String screenSize(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_screenSize.txt";
				return path;
			}

			String resolution(String name) throws IOException{
				String path ="D://output//MobileWorld//"+name+"_resolution.txt";
				return path;
			}
			
			String screenType(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_screenType.txt";
				return path;
			}

			String ram(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_ram.txt";
				return path;
			}
			
			String rom(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_rom.txt";
				return path;
			}
			
			String batteryCapacity(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_batteryCapacity.txt";
				return path;
			}
			
			String rearCamera(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_rearCamera.txt";
				return path;
			}
			
			String frontCamera(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_frontCamera.txt";
				return path;
			}
			
			String processor(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_processor.txt";
				return path;
			}
			
			String chargingPortType(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_chargingPortType.txt";
				return path;
			}

			String notchType(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_notchType.txt";
				return path;
			}

			
			String simSlot(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_simSlot.txt";
				return path;
			}

			String os(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_os.txt";
				return path;
			}
			String ui(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_ui.txt";
				return path;
			}

			String price(String name) throws IOException{
				String path="D://output//MobileWorld//"+name+"_price.txt";
				return path;
			}			
}

class EditMobile{
		static EditMobile em = new EditMobile();
		static Scanner sc = new Scanner(System.in);
		static Path path = new Path();
		static Option o = new Option();
		static Menu menu = new Menu();
		void editMenu() throws IOException{
			System.out.println("\tEnter name of the mobile to be edited");
			String name = o.descriptionList();
			edit(name);
				}
			
	void edit(String name) throws IOException{
			String location = null;
			try{
			location = o.getChoice(name);
			if(location != null){
			System.out.println("\tEnter new details");
			String input=sc.next();
			try{
			FileWriter fw = new FileWriter(location);
			fw.write(input); 
			fw.close();
			System.out.println("\tNew Details Added :)");
			reLaunch();
			}catch(FileNotFoundException e)
			{System.out.println("\tFile Not Found :(");}}
			else
			{System.out.println("\tINVALID INPUT :( \n \tReturning to Main Menu");
			 menu.open();}
			}catch(NullPointerException n)
			{System.out.println("\t\tNULL");}
	}
		void reLaunch() throws IOException{
			int answer = 0;
			try{
			System.out.println("\n******************************************");
			System.out.println("\t\tWant to edit more");
			System.out.println("\t\t1. Yes\n"+"\t\t2. No");
			System.out.println("\n******************************************");
			answer=sc.nextInt();
			if(answer==1)
			em.editMenu();
			else if(answer!=2){
			System.out.println("\t\tWrong Input");
			menu.open();}
			}catch(InputMismatchException i)
			{
			 System.out.println("\t\tPlease Enter either 1 or 2");
			 em.editMenu();
			}
		}		
}
class Option{
		Scanner sc = new Scanner(System.in);
		static Path path = new Path();
		String descriptionList(){
			System.out.print("\t");
			String name = sc.nextLine();
			System.out.println("\tEnter choice.........");
			System.out.println("\t1.  Company");
			System.out.println("\t2.  Model");
			System.out.println("\t3.  Screen Size");
			System.out.println("\t4.  Resolution");
			System.out.println("\t5.  Screen Type");
			System.out.println("\t6.  RAM");
			System.out.println("\t7.  Internal Storage");
			System.out.println("\t8.  Battery Capacity");
			System.out.println("\t9.  Rear Camera");
			System.out.println("\t10. Front Camera");
			System.out.println("\t11. Processor");
			System.out.println("\t12. Charging Port Type");
			System.out.println("\t13. Notch Type");
			System.out.println("\t14. Sim Slot Type");
			System.out.println("\t15. Operating Software");
			System.out.println("\t16. User Interface");
			System.out.println("\t17. Price");
//         		System.out.println("\t18. Every Details");
			return name;
	}
	 String getChoice(String name) throws IOException{
			int choice = 0;
			String location=null;
			try{
			System.out.print("\t");
			choice = sc.nextInt();
	//		do{
			switch(choice)
			{
				case 1 : location = path.company(name);
					 break;
				case 2 : location = path.model(name);
					 break;
				case 3 : location = path.screenSize(name);
					 break;
				case 4 : location = path.resolution(name);
					 break;
				case 5 : location = path.screenType(name);
					 break;
				case 6 : location = path.ram(name);
					 break;
				case 7 : location = path.rom(name);
					 break;
				case 8 : location = path.batteryCapacity(name);
					 break;
				case 9 : location = path.rearCamera(name);
					 break;
				case 10 : location = path.frontCamera(name);
					 break;
				case 11 : location = path.processor(name);
					 break;
				case 12 : location = path.chargingPortType(name);
					 break;
				case 13 : location = path.notchType(name);
					 break;
				case 14 : location = path.simSlot(name);
					 break;
				case 15 : location = path.os(name);
					 break;
				case 16 : location = path.ui(name);
					 break;
				case 17 : location = path.price(name);
	//				  option18 = false;
					 break;
	//			case 18 : option18 = true;
	//				  break;
				default : break;
			}
	//		}while(option18==true);
			}catch(InputMismatchException i)
			{
			System.out.println("\tPlease enter a valid integral value");
			}
			return location;			
	}

}

class DisplayMobile{
			Scanner sc = new Scanner(System.in);
			static Path path = new Path();
			static Option o = new Option();
			static Menu menu = new Menu();
			void dispalyMenu() throws IOException{
			System.out.println("\tEnter name of the mobile to be Displayed");
			String name = o.descriptionList();
			display(name);
	}
	void display(String name) throws IOException{
			String location = null;
			try{
			location = o.getChoice(name);
			if(location != null){
				FileReader fr = new FileReader(location);
				BufferedReader br = new BufferedReader(fr);
				String data = br.readLine();
				System.out.println("\t"+data);
				br.close();
				reLaunch(name);
					    }
				else{
					System.out.println("\tInvalid Name :( ");
				}
			   }catch(FileNotFoundException e)
			{System.out.println("\tFile Not Found :(");}
	}
		void reLaunch(String name) throws IOException
			{
				char choice = 'a';
				System.out.println("\tDo you want to Know more Y/N");	
				System.out.print("\t");
				choice = sc.next().charAt(0);
				if (choice == 'y' || choice == 'Y')
				{
				o.descriptionList();
				display(name);
				}
				else if (choice == 'n' || choice == 'N' )
				System.out.println("\tThnak You :)");
				else{
				System.out.println("\tInvalid input :(");
				System.out.println("\tReturning to Main Menu");
				menu.open();
				}
			}
}

public class MobileWorld{
		public static void main(String[] args)
		throws IOException{
			Scanner sc = new Scanner(System.in);
			Password pw = new Password();
			System.out.println("\n********************************************************");
			System.out.println("\tWelcome to the Mobile World....!!!!");
			System.out.println("********************************************************");
			pw.checkPassword();
			sc.close();
			}
}