package com.wipro.bank.bean;
import java.util.Date;
class TransferBean{
	private int transctionID;
	public void setTransctionID(int transctionID){
		this.transctionID=transctionID;
	}
	public int getTransactionID(){
		return transctionID;
	}
	private String fromAccountNumber;
	public void setAccountNumberFrom(String fromAccountNumber){
		this.fromAccountNumber=fromAccountNumber;
		
	}
	public String getAccountNumberFrom(){
		return fromAccountNumber;
	}
	private String toAccountNumber;
	public void setAccountNumberTo(String toAccountNumber){
		this.toAccountNumber=toAccountNumber;
		
	}
	public String getAccountNumberTo(){
		return toAccountNumber;
	}
	private Date dateOfTransaction;
	public void setdateOfTransaction(Date dateOfTransaction){
		this.dateOfTransaction=dateOfTransaction;
	}
	public Date getdateOfTransaction(){
		return dateOfTransaction;
	}
	private float amount;
	public void setamount(float amount){
		this.amount=amount;
	}
	public float getamount(){
		return amount;
	}
}