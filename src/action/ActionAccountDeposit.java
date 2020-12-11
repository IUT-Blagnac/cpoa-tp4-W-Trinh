package action;

import java.util.Locale;
import java.util.Scanner;

import bank.Account;
import bank.BankAgency;
import bank.exception.AccountException;
import main.BankAgencyAppV2;

public class ActionAccountDeposit implements Action{
	private String msg;
	private String code;
	
	public ActionAccountDeposit(String code) {
		this.code = code;
		this.msg  = "Deposit money on an account";
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
		String number;
		double amount;
		
		System.out.print("Account Number -> ");
		number = lect.next();
		System.out.print("Deposit amount -> ");
		amount = lect.nextDouble();
		ActionAccountDeposit.depositOnAccount(ag, number, amount);
	}
	
	public static void depositOnAccount(BankAgency ag, String accountNumber, double amount) {
		Account c;

		c = ag.getAccount(accountNumber);
		if (c==null) {
			System.out.println("Account not existing ...");
		} else {
			System.out.println("Balance before deposit: "+c.balance());
			try {
				c.deposit(amount);
				System.out.println("Balance after deposit: "+c.balance());
			} catch (AccountException e) {
				System.out.println("Deposit error, Balance unchanged: " + c.balance());
				System.out.println(e.getMessage());
			}
		}
	}
}
