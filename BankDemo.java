import java.sql.*;
import java.util.Scanner;
class Bank{
	int accno,bal,balance,Random;
	String cname,actype;
	static Connection con=null;
	
			
	static{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/customer?user=root&password=");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
		
	
	static Scanner S1=new Scanner(System.in);
			
		public static void openAccount(){
		try{
			System.out.println("Enter Acc no :");
			
			int accno=S1.nextInt();
			System.out.println("Enter Account type :");
			String actype=S1.next();
			System.out.println("Enter Customer name :");
			String cname=S1.next();
			int bal=0;
			if(actype.equalsIgnoreCase("saving"))
				bal=5000;
			else
				bal=10000;
			String qry="insert into bank values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(qry);
			ps.setInt(1,accno);
			ps.setString(2,actype);
			ps.setInt(3,bal);
			ps.setString(4,cname);
			int a=ps.executeUpdate();
			if(a==1)
				System.out.println("Account added");
			else
				System.out.println("Account not added");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
		public void Deposit(){
		System.out.println("Enter account number ");
		int accno=S1.nextInt();
		System.out.println("Enter amount to be deposited");
		int Amount=S1.nextInt();
		try{
			PreparedStatement ps=con.prepareStatement("update  Bank set balance=balance+? where accno=? ");
			
			ps.setInt(1,Amount);
			ps.setInt(2,accno);
			int a=ps.executeUpdate();
			
			if(a==1)
				System.out.println("Deposit Successfully");
			else
				System.out.println("Not Deposit Sucessfully");
		}
		catch(Exception e){
			System.out.println(e);
		}
			
	}
		public void withdraw(){
			try{
				System.out.println("Enter account number ");
				int accno=S1.nextInt();
				System.out.println("Enter amount to be Withdrawl");
				int Amount=S1.nextInt();
				PreparedStatement ps1=con.prepareStatement("select * from bank where accno=?");
				ps1.setInt(1,accno);
				ResultSet a=ps1.executeQuery();
				if(a.next()){
					int balance=a.getInt(3);
					if(balance>Amount){
						PreparedStatement ps=con.prepareStatement("update Bank set balance=balance-? where accno=? ");
						ps.setInt(1,Amount);
						ps.setInt(2,accno);
						int b=ps.executeUpdate();
						if(b==1)
							System.out.println("Withdrawal Successfully");
						else
							System.out.println("Record not Found");
					}
					else
						System.out.println("Insufficient balance");
				}
				else
					System.out.println("Record not Found");
			}
			catch(Exception e){
				System.out.println(e);
			}
	    }
	
		public void Close(){
		PreparedStatement ps;
		System.out.println("Enter account number to be closed");
		int accno=S1.nextInt();
		try{
		 ps=con.prepareStatement("delete from bank where accno=? ");
			ps.setInt(1,accno);
			int a=ps.executeUpdate();
			if(a==1)
				System.out.println("Account deleted");
			else
				System.out.println("Account not deleted");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
		public void Search(){
		int a=0;	
		System.out.println("Enter Account number to be Searched");
		int accno=S1.nextInt();
		try{
			PreparedStatement ps=con.prepareStatement("select * from Bank where accno=? ");
			ps.setInt(1,accno);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				System.out.println("Account no is "+rs.getInt(1));
				
				System.out.println("AccountType is "+rs.getString(2));
				System.out.println("Balance is "+rs.getInt(3));
				System.out.println("Customer number is"+rs.getString(4));
				
				
			}
			else{
				System.out.println("No Record Found");
				
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
		public static void Display(){
			
		try{
			PreparedStatement ps=con.prepareStatement("select * from Bank");
			ResultSet rs=ps.executeQuery();
		while(rs.next()){
			int accno=rs.getInt(1);
			String cname=rs.getString(2);
			int bal=rs.getInt(3);
			String actype=rs.getString(4);
			System.out.println("Account number is"+accno);
			System.out.println("AccountType is "+actype);
			System.out.println("Balance is "+bal);
			System.out.println("Customer number is"+cname);
			System.out.println("=============================================");
			
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
class BankDemo{		
    public static void main(String ar[])throws SQLException{
		Bank S1=new Bank();
		Scanner ss=new Scanner(System.in);
		int k=0;
		do{
			System.out.println("Main Menu");
			System.out.println("1. openAccount");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdrawal Money");
			System.out.println("4. Close Account");
			System.out.println("5. Search Account");
			System.out.println("6. Display Details");			
			System.out.println("7. Exit");
			System.out.println("Enter your choice :");
			int choice=ss.nextInt();
					
			switch(choice){
				case 1:						
				S1.openAccount();
				break;
				case 2:
				S1.Deposit();
				break;
				case 3:
				S1.withdraw();
				break;
				case 4:
				S1.Close();
				break;
				case 5:
				S1.Search();
				break;
				case 6:
				S1.Display();
				break;
                case 7:
                System.exit(0);				
			}
				System.out.println("Do u want to cont...press 1 for no");
				k=ss.nextInt();
		}while(k!=1);
	}
}        
