package actionList;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import action.Action;
import action.ActionList;
import bank.BankAgency;
import main.BankAgencyApp;
import main.BankAgencyAppV2;

public class ActionListBankAgency implements ActionList{
	private String msg;
	private String code;
	private String title;
	private ArrayList<Action> actionList;
	
	public ActionListBankAgency(String msg, String code, String title) {
		this.msg =  msg;
		this.code=  code;
		this.title= title;
		actionList = new ArrayList<Action>();
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
		String choice;
		Scanner lect;
		Action act;
		
		lect = new Scanner( System.in );
		lect.useLocale(Locale.US);
		
		boolean proceed = true;
		
		while (proceed) {
			System.out.println(title);	
			
			for (int i=0; i<actionList.size();i++) {
				System.out.println("" + actionList.get(i).actionCode() + " - " + actionList.get(i).actionMessage());
			}
			System.out.println("0 - Quit");
			
			choice = lect.next();
			choice = choice.toLowerCase();
			if ( choice.equals("0") ) {
				System.out.println("ByeBye");
				proceed = false;
			} 
			
			act=getAction(choice);
			
			if (act==null && !choice.equals("0")){
				System.out.println("problem...");
				ActionListBankAgency.tempo();
			}
			else if(act!=null){
				act.execute(ag);
				ActionListBankAgency.tempo();
			}
		}
	}
	
	@Override
	public String listTitle() {
		// TODO Auto-generated method stub
		return title;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return actionList.size();
	}
	@Override
	public boolean addAction(Action ac) {
		actionList.add(ac);
		if(actionList.contains(ac)) {
			return true;
		}
		else {
		return false;
		}
	}
	
	public Action getAction(String code) {
		for(int i=0; i<actionList.size(); i++) {
			Action act = actionList.get(i);
			if (act.actionCode().contentEquals(code)) {
				return act;
			}
		}
		return null;
	}
	
	public static void tempo() {
		Scanner lect ;

		lect = new Scanner (System.in );

		System.out.print("Type any car + return to continue ... ");
		lect.next(); 
	}

}
