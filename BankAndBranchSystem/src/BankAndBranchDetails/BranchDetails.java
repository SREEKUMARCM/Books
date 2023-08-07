package BankAndBranchDetails;

public class BranchDetails {
	
	private int Branchid;
	private String BranchName;
	private int NoAccount;
	private int BankID;
	private String IFSCE;
	public BranchDetails(int Branchid,String BranchName,int NoAccount,int BankID,String IFSCE) {
		this.Branchid=Branchid;
		this.BranchName=BranchName;
		this.NoAccount=NoAccount;
		this.BankID=BankID;
		this.IFSCE=IFSCE;
	}
	public int getBranchid() {
		return Branchid;
	}
	public void setBranchid(int branchid) {
		Branchid = branchid;
	}
	public String getBranchName() {
		return BranchName;
	}
	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
	public int getNoAccount() {
		return NoAccount;
	}
	public int setNoAccount(int noAccount) {
		return NoAccount = noAccount;
	}
	public int getBankID() {
		return BankID;
	}
	public void setBankID(int bankID) {
		BankID = bankID;
	}
	public String getIFSCE() {
		return IFSCE;
	}
	public void setIFSCE(String iFSCE) {
		IFSCE = iFSCE;
	}
}
