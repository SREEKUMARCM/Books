package BankAndBranchDetails;

public class BankDetails {
		private int BankID;
		private String BankName;
		private int NoAccount;
		private int NoBranch;
		
		public BankDetails(int BankID,String BankName,int NoAccount,int NoBranch) {
			this.BankID=BankID;
			this.BankName=BankName;
			this.NoAccount=NoAccount;
			this.NoBranch=NoBranch;
			}

		public int getNoAccount() {
			return NoAccount;
		}

		public void setNoAccount(int noAccount) {
			NoAccount = noAccount;
		}

		public int getNoBranch() {
			return NoBranch;
		}

		public void setNoBranch(int noBranch) {
			NoBranch = noBranch;
		}

		public int getBankID() {
			return BankID;
		}

		public void setBankID(int bankID) {
			BankID = bankID;
		}

		public String getBankName() {
			return BankName;
		}

		public void setBankName(String bankName) {
			BankName = bankName;
		}
		
}
