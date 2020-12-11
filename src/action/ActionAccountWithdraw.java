package action;

import java.util.Locale;
import java.util.Scanner;

import bank.Account;
import bank.BankAgency;
import bank.exception.AccountException;
import main.BankAgencyAppV2;

public class ActionAccountWithdraw implements Action{
	private String msg;
	private String code;
	
	public ActionAccountWithdraw(String code) {
		this.code = code;
		this.msg  = "Withdraw money from an account";
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
		System.out.print("Withdraw amount -> ");
		amount = lect.nextDouble();
		ActionAccountWithdraw.withdrawFromAccount(ag, number, amount);
	}
	
	public static void withdrawFromAccount(BankAgency ag, String accountNumber, double amount) {
		Account c;

		c = ag.getAccount(accountNumber);
		if (c==null) {
			System.out.println("Account not existing ...");
		} else {
			System.out.println("Balance before withdrawal: " + c.balance());
			try {
				c.withdraw(amount);
				System.out.println("Balance after withdrawal: "+c.balance());
			} catch (AccountException e) {
				System.out.println("Withdraw error, Balance unchanged: " + c.balance());
				System.out.println(e.getMessage());
			}
		}

	}
}
