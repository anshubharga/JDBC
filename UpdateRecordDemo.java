import java.sql.*;
import java.util.Scanner;
class UpdateRecordDemo{
	public static void main(String ar[]){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost/employee?user=root&password=");
			Scanner s1=new Scanner(System.in);
			System.out.println("Enter Employee Number:");
			int eno=s1.nextInt();
			System.out.println("Enter Department Number:");
			String dn=s1.next();
			PreparedStatement ps=con.prepareStatement("update its set dn=? where eno=? ");
			
			ps.setString(1,dn);
			ps.setInt(2,eno);

			int a=ps.executeUpdate();
			if(a==1)
				System.out.println("Updated Sucessfully");
			else
				System.out.println("Not updated Sucessfully");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
		