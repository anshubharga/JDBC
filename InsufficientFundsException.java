import com.wipro.bank.util.DButil;
public class InsufficientFundsException extends Exception{
		 public String message;
		InsufficientFundsException(){
		message=" Not Sufficient Fund";
	}
		public String toString(){
		return message;
	}
		
}
