package main;

import bank.BankAgency;
import action.ActionAccountNumber;
import action.ActionPrintAgencyAccount;
import actionList.ActionListAccountManagement;
import actionList.ActionListAccountOperation;
import actionList.ActionListBankAgency;
import application.AccesBankAgency;


public class BankAgencyAppV3 {
	public static void main(String argv[]) throws Exception {
		BankAgency ag;
		ag = AccesBankAgency.getBankAgency();
		ActionListBankAgency menu = new ActionListBankAgency("Bank agency","5","Menu of " + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")");
		menu.addAction(new ActionPrintAgencyAccount("1"));
		menu.addAction(new ActionAccountNumber("2"));
		menu.addAction(new ActionListAccountOperation("Accout Operation","3","Account operation menu" ));
		menu.addAction(new ActionListAccountManagement("Account Management","4","Account Management menu"));
		menu.execute(ag);
	}
}
