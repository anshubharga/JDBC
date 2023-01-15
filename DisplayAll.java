import java.sql.*;
import java.util.Scanner;
class DisplayAll{
	public static void main(String ar[]){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost/employee?user=root&password=");
			PreparedStatement ps=con.prepareStatement("select * from its");
			
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int eno=rs.getInt(1);
				String en=rs.getString(2);
				int sl=rs.getInt(3);
				String dn=rs.getString(4);
				System.out.println("Enrollmentn no is"+eno);
				System.out.println("nane is"+en);
				System.out.println("sal is"+sl);
				System.out.println("Department name is "+dn);
				System.out.println("=============================================");
				
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
		