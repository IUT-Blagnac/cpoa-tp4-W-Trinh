package action;

import bank.BankAgency;

public class ActionDeleteAccount implements Action{
	private String msg;
	private String code;

	public ActionDeleteAccount(String code) {
		this.code = code;
		this.msg  = "Delete Account";
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
		System.out.println("Deleting account...");
		
	}

}
