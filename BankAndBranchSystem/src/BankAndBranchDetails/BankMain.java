package BankAndBranchDetails;

import java.util.List;
import java.util.Scanner;












public class BankMain {
	public static void selection() {
		System.out.println("1.Bankdetails");
		System.out.println("2.Branchdetails");
		System.out.println("Please select your choice");
		
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
		selection();
		choice=sc.nextInt();
		if(choice==1) {
			System.out.println("*********Bankdetails********");
			Bankdata();
			
		}else if(choice==2){
			System.out.println("*********Branchdetails********");
			Branchdata();
		}
		}while(choice<2);{
			sc.close();
		}
	}
	public static void Bankdata() {
		int choiceBank=0;
		Scanner scBank=new Scanner(System.in);
		do {
		System.out.println("1.  Add Bank");
		System.out.println("2.  View Bank list");
		System.out.println("3.  Serach Bank");
		System.out.println("4.  Delete Bank");
		System.out.println("5.  Update Bank");
		System.out.println("6.  calculate Total account and branch count");
		System.out.println("7.  Exit");
		System.out.println("Please select your choice");
		
		choiceBank=scBank.nextInt();
		if(choiceBank==1) {
			AddBank();
		}else if(choiceBank==2){
			ViewBank();
		}else if(choiceBank==3){
			SearchBank();
		}
		else if(choiceBank==4){
			DeleteBank();
		}
		else if(choiceBank==5){
			UpdateBank();
		}
		else if(choiceBank==6) {
			NoAccout();
			NoBranch();
		}else if(choiceBank==7){
			main(null);
		}
		}while(choiceBank<7);{
			scBank.close();
		}
	}
	public static void Branchdata() {
		int choiceBranch=0;
		Scanner scBank=new Scanner(System.in);
		do {
		System.out.println("1.  Add Branch");
		System.out.println("2.  View Branch list");
		System.out.println("3.  Serach Branch");
		System.out.println("4.  Delete Branch");
		System.out.println("5.  Update Branch");
		System.out.println("6.  Exit");
	
		System.out.println("Please select your choice");
		
		choiceBranch=scBank.nextInt();
		if(choiceBranch==1) {
			AddBranch();
		}else if(choiceBranch==2) {
			ViewBranch();
		}else if(choiceBranch==3) {
			SearchBranch();
		}else if(choiceBranch==4) {
			DeleteBranch();
		}else if(choiceBranch==5) {
			UpdateBranch();
		}
		
		else if(choiceBranch==6) {
			main(null);
		}
		}while(choiceBranch<6);{
			scBank.close();
		}
		
	}
	public static void AddBank() {
		System.out.println("Please enter the Bank ID :");
		Scanner scBankId=new Scanner(System.in);
		BankDetails newBank = new BankDetails(0, null, 0, 0);
		int BankID=scBankId.nextInt();
		newBank.setBankID(BankID);
		System.out.println("Please enter the Bank name :");
		Scanner sc=new Scanner(System.in);
		//BankDetails newBank = new BankDetails(0, null, 0, 0);
		String BankName=sc.next();
		newBank.setBankName(BankName);
		
		
		
		
		
		Connection_Bank AddBankobj=new Connection_Bank();
		AddBankobj.AddBank(BankID,BankName);
	}
	public static void AddBranch() {
		System.out.println("Please enter the Branch ID :");
		Scanner scBranchId=new Scanner(System.in);
		BranchDetails newBranch = new BranchDetails(0, null, 0, 0, null);
		int BranchID=scBranchId.nextInt();
		newBranch.setBranchid(BranchID);
		System.out.println("Please enter the Branch name :");
		Scanner sc=new Scanner(System.in);
		//BankDetails newBank = new BankDetails(0, null, 0, 0);
		String BranchName=sc.next();
		newBranch.setBranchName(BranchName);
		System.out.println("Please enter the Number of Active Accounts :");
		Scanner scCountAccount=new Scanner(System.in);
		BankDetails newBank = new BankDetails(0, null, 0, 0);
		int CountAccount=scCountAccount.nextInt();
		newBranch.setNoAccount(CountAccount);
		System.out.println("Please enter the Bank ID :");
		Scanner scBankId=new Scanner(System.in);
		int BankID=scBankId.nextInt();
		newBranch.setBankID(BankID);
		System.out.println("Please enter the IFSCE :");
		Scanner scIFSCE=new Scanner(System.in);
		//BankDetails newBank = new BankDetails(0, null, 0, 0);
		String IFSCE=sc.next();
		newBranch.setIFSCE(IFSCE);
		
		
		Connection_Bank AddBankobj=new Connection_Bank();
		AddBankobj.AddBranch(BranchID,BranchName,CountAccount,BankID,IFSCE);
	}
	public static void NoAccout() {
		BranchDetails newBranch = new BranchDetails(0, null, 0, 0, null);
		System.out.println("Please enter the Bank ID :");
		Scanner scBankId=new Scanner(System.in);
		int BankID=scBankId.nextInt();
		newBranch.setBankID(BankID);
		Connection_Bank AddBranchCountobj=new Connection_Bank();
		int count=AddBranchCountobj.CountBranch(BankID);
		System.out.println("No of Account is "+count);
		AddcountAccount(BankID);
		
	}
	public static void NoBranch() {
		BranchDetails newBranch = new BranchDetails(0, null, 0, 0, null);
		System.out.println("Please enter the Bank ID :");
		Scanner scBankId=new Scanner(System.in);
		int BankID=scBankId.nextInt();
		newBranch.setBankID(BankID);
		Connection_Bank AddBranchCountobj=new Connection_Bank();
		int count=AddBranchCountobj.CountBranch(BankID);
		System.out.println("No of bank is "+count);
		Addcount(BankID,count);
		
		
	}
	
	 public static void ViewBranch(){ 
		  
		  System.out.println(" The available list of all Branch is  :");
		  List<BranchDetails> Branchlist=new Connection_Bank().ViewBranchdb()	; 
			  for(BranchDetails Branch:Branchlist) 
			  {  System.out.println("BranchID : " + Branch.getBranchid());
		        System.out.println("BranchName: " + Branch.getBranchName());
		        System.out.println("Number of Account: " + Branch.getNoAccount());
		        System.out.println("BankID: " + Branch.getBankID());
		        System.out.println("IFSCE CODE: " + Branch.getIFSCE() );
		        System.out.println("---------------------");
				  
			  }
		  
		}
	 public static void ViewBank(){ 
		  
		  System.out.println(" The available list of all Bank is  :");
		  List<BankDetails> Banklist=new Connection_Bank().ViewBankdb()	; 
			  for(BankDetails Bank:Banklist) 
			  {  System.out.println("BankID: " + Bank.getBankID());
		        System.out.println("BankName: " + Bank.getBankName() );
		        System.out.println("Number of Account: " + Bank.getNoAccount());
		        System.out.println("Number of Branch" + Bank.getNoBranch());
		        System.out.println("---------------------");
				  
			  }
		  
		}
	 public static String SearchBranch(){  
			BranchDetails newBranch = new BranchDetails(0, null, 0, 0, null);
			System.out.println("Please enter the Branch name :");
			Scanner sc=new Scanner(System.in);
			//BankDetails newBank = new BankDetails(0, null, 0, 0);
			String BranchName=sc.next();
			newBranch.setBranchName(BranchName);
			  Connection_Bank Branchlist=new Connection_Bank(); 
			  String Bname1 =Branchlist.SearchBranch(BranchName);
			  System.out.println(" -----------"+Bname1); 
			  System.out.println(" ***********"+BranchName);  
			  String Avalilability=null;
			  if (Bname1.equals(BranchName)) {
				  Avalilability="yes";
				  System.out.println(" the branch is avaiilable :");
				  
			  }else {
				  Avalilability="no";
				  System.out.println(" the  is not available :");
			  }
			 
			  return Avalilability ;
			}
	 public static String SearchBank(){  
		 BankDetails newBank = new BankDetails(0, null, 0, 0);
			System.out.println("Please enter the Bank name :");
			Scanner sc=new Scanner(System.in);
			//BankDetails newBank = new BankDetails(0, null, 0, 0);
			String BankName=sc.next();
			newBank.setBankName(BankName);
			  Connection_Bank Banklist=new Connection_Bank(); 
			  String Bname1 =Banklist.SearchBank(BankName);
			  String Avalilability=null;
			  try {
			  if (Bname1.equals(BankName)) {
				  Avalilability="yes";
				  System.out.println(" the bank is avaiilable :");
				  
			  }else {
				  Avalilability="no";
				  System.out.println(" the  is not available :");
			  }
			  }catch(Exception e) {
				  System.out.println(" the  is not available :");
				 // e.printStackTrace();
			  
			  }
			 
			  return Avalilability ;
			}
	 public static void DeleteBank() {
		 BankDetails newBank = new BankDetails(0, null, 0, 0);
		  System.out.println(" enter the name to be delected :");
		  Scanner sc=new Scanner(System.in);
		  String BankName=sc.next();
		  newBank.setBankName(BankName);
		  Connection_Bank Banklist=new Connection_Bank(); 
		  Banklist. DeleteBankname(BankName);
	 }
	 public static void DeleteBranch() {
		 BranchDetails newBranch = new BranchDetails(0, null, 0, 0, null);
		  System.out.println(" enter the name to be delected :");
		  Scanner sc=new Scanner(System.in);
		  String BranchName=sc.next();
		  newBranch.setBranchName(BranchName);
		  Connection_Bank Branchlist=new Connection_Bank(); 
		  Branchlist. DeleteBranchname(BranchName);
	 }
	 public static void UpdateBranch() {
		 BranchDetails newBranch = new BranchDetails(0, null, 0, 0, null);
		  System.out.println(" enter the name to be Updated :");
		  Scanner sc1=new Scanner(System.in);
		  String branchName1=sc1.next();
		  
		  System.out.println(" enter the new name :");
		  Scanner sc=new Scanner(System.in);
		  String branchName=sc.next();
		  newBranch.setBranchName(branchName);
		  Connection_Bank Branchlist=new Connection_Bank(); 
		  Branchlist.UpdateBranchname(branchName1,branchName);
	 }
	 public static void UpdateBank() {
		 BankDetails newBank = new BankDetails(0, null, 0, 0);
		  System.out.println(" enter the name to be Updated :");
		  Scanner sc1=new Scanner(System.in);
		  String bankName1=sc1.next();
		  
		  System.out.println(" enter the new name :");
		  Scanner sc=new Scanner(System.in);
		  String bankName=sc.next();
		  newBank.setBankName(bankName);
		  Connection_Bank Banklist=new Connection_Bank(); 
		  Banklist.UpdateBankname(bankName1,bankName);
	 }
	 public static void Addcount(int BankID,int count) {
		 int bankid=BankID;
		 int Count=count;
		 Connection_Bank Banklist=new Connection_Bank(); 
		  Banklist.AddBranchCount(bankid,Count);
	 }
	 public static void AddcountAccount(int BankID) {
		 int bankid=BankID;
		
		 Connection_Bank Banklist=new Connection_Bank(); 
		  Banklist.AddAccountCountdb(bankid);
	 }
}


