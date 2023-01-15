package com.wipro.bank.dao;
import java.util.Random;
import java.sql.*;
import com.wipro.bank.util.DButil;

class BankDAO{
	private String accountNumber;
	
	public int generateSequenceNumber(int generateSequenceNumber){
		Random rand=new Random();
		for(int i=1;i<=4;i++){
			int num1=rand.nextInt(4);
			int num2=rand.nextInt(4);
			int num3=rand.nextInt(4);
			int num4=rand.nextInt(4);
			String ano=num1+""+num2+""+ num3+""+num4;
			System.out.println("No generated is"+ano);
		}
	
		return generateSequenceNumber;
	}
	public boolean validateAccount(String accountNumber){
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DButil.getDBConnection();
		try{
			
			ps=con.prepareStatement("select * from account_tbl where accountNumber=?");
			ps.setString(1,accountNumber);
			rs=ps.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
	public float findBalance(String accountNumber){
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DButil.getDBConnection();
		try{
			
			ps=con.prepareStatement("select * from  account_tbl where accountNumber= ? ");
			ps.setString(1,accountNumber);
			rs=ps.executeQuery();
			if(rs.next())
				return rs.getInt(1);
			else
				return -1;
		}
		catch(Exception e){
			System.out.println(e);
			return 0;
		}
	}
	
	
}