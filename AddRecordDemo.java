import java.sql.*;
import java.util.Scanner;
class AddRecordDemo{
	public static void main(String ar[]){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost/employee?user=root&password=");
			Scanner s1=new Scanner(System.in);
			System.out.println("Enter Employee Number:");
			int eno=s1.nextInt();
			System.out.println("Enter Employee Name:");
			String en=s1.next();
			System.out.println("Enter Employee Salary :");
			int sal=s1.nextInt();
			System.out.println("Enter Department Number:");
			String dn=s1.next();
			PreparedStatement ps=con.prepareStatement("insert into its values(?,?,?,?)");
			
			ps.setInt(1,eno);
			ps.setString(2,en);
			ps.setInt(3,sal);
			ps.setString(4,dn);
			int a=ps.executeUpdate();
			if(a==1)
				System.out.println("Record added");
			else
				System.out.println("Record not added");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
		