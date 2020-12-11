package action;

import java.util.Locale;
import java.util.Scanner;

import bank.Account;
import bank.BankAgency;

public class ActionAccountNumber implements Action{
	private String msg;
	private String code;
	
	public ActionAccountNumber(String code) {
		this.code = code;
		this.msg  = "See an account (by its number)";
	}
	@Override
	public String actionMessage() {
		// TODO Auto-generated method stub
		return msg;
	}

	@Override
	public String actionCode() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public void execute(BankAgency ag) throws Exception {
		// TODO Auto-generated method stub
		Scanner lect;
		Account c;
		lect = new Scanner( System.in );
		lect.useLocale(Locale.US);
		
		System.out.print("Account Number -> ");
		String number = lect.next();
		c = ag.getAccount(number);
		if (c==null) {
			System.out.println("Account non existing ...");
		} else {
			c.print();
		}
	}

}
