import java.sql.*;
import java.util.Scanner;
class DelRecordDemo{
	public static void main(String ar[]){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost/studentgui?user=root&password=");
			Scanner s1=new Scanner(System.in);
			System.out.println("Enter Employee Number:");
			int eno=s1.nextInt();
			PreparedStatement ps=con.prepareStatement("delete from stugui where empno=? ");
			
			ps.setInt(1,eno);

			int a=ps.executeUpdate();
			if(a==1)
				System.out.println("Record deleted");
			else
				System.out.println("Record not deleted");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
		