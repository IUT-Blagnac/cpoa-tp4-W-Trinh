package action;

import bank.BankAgency;

public class ActionPrintAgencyAccount implements Action{
	private String msg;
	private String code;
	
	public ActionPrintAgencyAccount(String code){
		this.code = code;
		this.msg  = "List of the Agency accounts";
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
		ag.print();
	}

}
