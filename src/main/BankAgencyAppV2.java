package main;


import java.util.Locale;
import java.util.Scanner;

import application.AccesBankAgency;
import bank.BankAgency;
import bank.Account;
import bank.exception.AccountException;

public class BankAgencyAppV2 {

	/**
	 * UI of the App
	 * @param ag	BankAgency to get name and location
	 */
	public static void printMenu(BankAgency ag) {
		System.out.println("Menu of " + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")");
		System.out.println("1 - List of the Agency accounts");
		System.out.println("2 - See an account (by its number)");
		System.out.println("3 - Operation on account");
		System.out.println("4 - Account management");
		System.out.println("0 - Quit");
		System.out.print("Choice -> ");
	}
	
	/**
	 * Temporisation : Affiche un message et attend la frappe de n'importe quel caract�re.
	 */
	public static void tempo() {
		Scanner lect ;

		lect = new Scanner (System.in );

		System.out.print("Type any car + return to continue ... ");
		lect.next(); 
	}

	public static void main(String argv[]) {

		String choice;

		boolean proceed ;
		Scanner lect;
		BankAgency myAgency ;

		String name, number;
		Account c;
		double amount;

		lect = new Scanner( System.in );
		lect.useLocale(Locale.US);

		myAgency = AccesBankAgency.getBankAgency();

		proceed = true;
		while (proceed) {
			BankAgencyAppV2.printMenu(myAgency);
			choice = lect.next();
			choice = choice.toLowerCase();
			switch (choice) {
				case "0" :
					System.out.println("ByeBye");
					BankAgencyAppV2.tempo();
					proceed = false;
					break;
				case "1" :
					myAgency.print();
					BankAgencyAppV2.tempo();
					break;
				case "2" :
					System.out.print("Account Number -> ");
					number = lect.next();
					c = myAgency.getAccount(number);
					if (c==null) {
						System.out.println("Account non existing ...");
					} else {
						c.print();
					}
					BankAgencyApp.tempo();
					break;
				case "3" :
					System.out.println("1 - Deposit money on an account");
					System.out.println("2 - Withdraw money from an account");
					System.out.println("0 - Quit");
					choice = lect.next();
					switch(choice) {
						case "1":
							System.out.print("Account Number -> ");
							number = lect.next();
							System.out.print("Deposit amount -> ");
							amount = lect.nextDouble();
							BankAgencyAppV2.depositOnAccount(myAgency, number, amount);
							break;
						case "2":
							System.out.print("Account Number -> ");
							number = lect.next();
							System.out.print("Withdraw amount -> ");
							amount = lect.nextDouble();
							BankAgencyAppV2.withdrawFromAccount(myAgency, number, amount);
							break;
						case "0":
							break;
						default :
							System.out.println("Problem ...");
							break;
					}
					BankAgencyAppV2.tempo();
					break;
				case "4" :
					System.out.println("1 - Add an account");
					System.out.println("2 - Delete an account");
					System.out.println("0 - Quit");
					choice = lect.next();
					switch(choice) {
					case "1":
						System.out.println("Ajout de compte");
						break;
					case "2":
						System.out.println("Suppression de compte");
						break;
					case "0":
						break;
					default :
						System.out.println("Problem ...");
						break;
					}
					BankAgencyAppV2.tempo();
					break;
				default :
					System.out.println("Problem ...");
					BankAgencyAppV2.tempo();
					break;
			}
		}

	}

	public static void ownerAccounts(BankAgency ag, String ownerName) {
		Account []  t;

		t = ag.getAccountsOf(ownerName);
		if (t.length == 0) {
			System.out.println("no account on this name ...");
		} else {
			System.out.println("  " + t.length + " accounts for " + ownerName);
			for (int i=0; i<t.length; i++)
				t[i].print();
		}
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
