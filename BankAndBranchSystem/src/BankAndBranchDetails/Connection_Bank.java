package BankAndBranchDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





public class Connection_Bank {
	public static Connection dbclass() {
    	String dbURL = "jdbc:mysql://localhost:3306/BankBreanch";
        String username = "root";
        String password = "passOMKV4545";
    	Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbURL,username,password);
			Statement statement=con.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from Bankdetails");
			while(resultSet.next()) {
				//System.out.println(resultSet.getString(1));
			}
			//con.close();
			
		} catch (Exception e) {

			System.out.println(e);
		}
		return con;
    }
	public static void AddBank(int BankID,String BankName) {
		try(Connection con = dbclass()) {
			String	BName=BankName;
			int BID=BankID;
			 String insertQuery = "INSERT INTO Bankdetails (BankID,BankName) VALUES (?,?)";
			 PreparedStatement statement = con.prepareStatement(insertQuery);
			  statement.setInt(1, BID);
             statement.setString(2, BName);
           
             int rowsInserted = statement.executeUpdate();
             if (rowsInserted > 0) {
                 System.out.println("Data inserted successfully.");
             } else {
                 System.out.println("Data insertion failed.");
             }
			
		}catch(SQLException e) {
            e.printStackTrace();
        }

	}
	public static void AddBranch(int BranchID,String BranchName,int CountAccount,int BankId ,String IFSCE) {
		try(Connection con = dbclass()) {
			String	BName=BranchName;
			int BID=BranchID;
			int countAC=CountAccount;
			int Bankid=BankId;
			String IFSCEcode=IFSCE;
			 String insertQuery = "INSERT INTO Branchdetails (BranchID,BranchName,NoAccount,BankID,IFSCE) VALUES (?,?,?,?,?)";
			 PreparedStatement statement = con.prepareStatement(insertQuery);
			  statement.setInt(1, BID);
              statement.setString(2, BName);
              statement.setInt(3, countAC);
              statement.setInt(4, Bankid);
              statement.setString(5, IFSCEcode);
           
             int rowsInserted = statement.executeUpdate();
             if (rowsInserted > 0) {
                 System.out.println("Data inserted successfully.");
             } else {
                 System.out.println("Data insertion failed.");
             }
			
		}catch(SQLException e) {
            e.printStackTrace();
        }
	}
	public static List<BranchDetails> CountAccount(int BID) {
		List<BranchDetails> Count=new ArrayList<>();
		try(Connection con = dbclass()) {
		int Bankid=BID;
	
		
		 String sqlQuery = "select NoAccount from Branchdetails where BankID=Bankid";
  	   PreparedStatement statement = con.prepareStatement(sqlQuery);
  	   ResultSet resultSet = statement.executeQuery();
         while (resultSet.next()) {
      	  // String[] data = new String[4];
        	 BranchDetails data=new BranchDetails(0, null, 0, 0, null);
        	 data.setNoAccount(resultSet.getInt("NoAccount"));
      	   
        	 Count.add(data);
            
         }
		
		} catch (SQLException e) {
            e.printStackTrace();
        }
	System.out.println("************"+Count);
		
		return  Count;
	}
	public static int CountBranch(int BID) {
	    int Count = 0;
	    try (Connection con = dbclass()) {
	        int Bankid = BID;
	        String sqlQuery = "SELECT COUNT(*) AS TotalCount FROM Branchdetails WHERE BankID = ?";
	        PreparedStatement statement = con.prepareStatement(sqlQuery);
	        statement.setInt(1, Bankid);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            Count = resultSet.getInt("TotalCount");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    System.out.println("************" + Count);
	    return Count;
	}

	 public static List<BranchDetails> ViewBranchdb(){
    	 List<BranchDetails> Branchlist = new ArrayList<>();
    	try(Connection con = dbclass()){
    	  
    	   String sqlQuery = "SELECT * FROM Branchdetails";
    	   PreparedStatement statement = con.prepareStatement(sqlQuery);
    	   ResultSet resultSet = statement.executeQuery();
           while (resultSet.next()) {
        	  // String[] data = new String[4];
        	   BranchDetails data=new BranchDetails(0, null, 0, 0, null);
        	  
		        
        	   data.setBranchid(resultSet.getInt("BranchID"));
        	   data.setBranchName(resultSet.getString("BranchName"));
        	   data.setNoAccount(resultSet.getInt("NoAccount"));
        	   data.setBankID(resultSet.getInt("BankID"));
        	   data.setIFSCE(resultSet.getString("IFSCE"));
        	   Branchlist.add(data);
        	   
              
           }
          
          
    	} catch (SQLException e) {
            e.printStackTrace();
        }

    	 return Branchlist;
    }
	 public static List<BankDetails> ViewBankdb(){
    	 List<BankDetails> Banklist = new ArrayList<>();
    	try(Connection con = dbclass()){
    	  
    	   String sqlQuery = "SELECT * FROM Bankdetails";
    	   PreparedStatement statement = con.prepareStatement(sqlQuery);
    	   ResultSet resultSet = statement.executeQuery();
           while (resultSet.next()) {
        	  // String[] data = new String[4];
        	   BankDetails data=new BankDetails(0, null, 0, 0);
        	  
        	   data.setBankID(resultSet.getInt("BankID"));
        	   data.setBankName(resultSet.getString("BankName"));
        	 
        	  
        	   data.setNoAccount(resultSet.getInt("NoAccount"));
        	   data.setNoBranch(resultSet.getInt("NoBranch"));
        	   
        	   
        	   Banklist.add(data);
        	   
              
           }
          
          
    	} catch (SQLException e) {
            e.printStackTrace();
        }

    	 return Banklist;
    }
	 public static String SearchBranch(String BranchName) {
    	 String Branchlist = null;
    	try(Connection con = dbclass()) {
    		String Bname=BranchName;
    		  String sqlQuery = "SELECT BranchName FROM Branchdetails where BranchName= (?)";
    		  PreparedStatement statement = con.prepareStatement(sqlQuery);
    		  statement.setString(1, Bname);
       	   ResultSet resultSet = statement.executeQuery();
              while (resultSet.next()) {
                  String data = resultSet.getString("BranchName"); // Replace "column_name" with your column name
                  Branchlist=data;
              }
             
             
       	} catch (SQLException e) {
               e.printStackTrace();
           }
		
    	return Branchlist;
    }
	 public static String SearchBank(String BankName) {
    	 String Banklist = null;
    	try(Connection con = dbclass()) {
    		String Bname=BankName;
    		  String sqlQuery = "SELECT BankName FROM Bankdetails where BankName= (?)";
    		  PreparedStatement statement = con.prepareStatement(sqlQuery);
    		  statement.setString(1, Bname);
       	   ResultSet resultSet = statement.executeQuery();
              while (resultSet.next()) {
                  String data = resultSet.getString("BankName"); // Replace "column_name" with your column name
                  Banklist=data;
              }
             
             
       	} catch (SQLException e) {
               e.printStackTrace();
           }
		
    	return Banklist;
    }
	 public static void DeleteBankname(String Banklist) {
	    	try(Connection con = dbclass()) {
	    		String Bname=Banklist;
	    		  String insertQuery = "delete from Bankdetails where (BankName) =(?)";
	              PreparedStatement statement = con.prepareStatement(insertQuery);
	              statement.setString(1, Bname);
	              int rowsInserted = statement.executeUpdate();
	              if (rowsInserted > 0) {
	                  System.out.println("Data Deleted successfully.");
	              } else {
	                  System.out.println("Data Deletion failed failed.");
	              }
	    	}catch(SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 public static void DeleteBranchname(String Branchlist) {
	    	try(Connection con = dbclass()) {
	    		String Bname=Branchlist;
	    		  String insertQuery = "delete from Branchdetails where (BranchName) =(?)";
	              PreparedStatement statement = con.prepareStatement(insertQuery);
	              statement.setString(1, Bname);
	              int rowsInserted = statement.executeUpdate();
	              if (rowsInserted > 0) {
	                  System.out.println("Data Deleted successfully.");
	              } else {
	                  System.out.println("Data Deletion failed failed.");
	              }
	    	}catch(SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 public static void UpdateBranchname(String branchName1,String branchName) {
     	try(Connection con = dbclass()) {
     	String Bname1=branchName1;
     		String Bname=branchName;
     		
     		  String insertQuery = "UPDATE BranchDetails SET BranchName = (?) WHERE BranchName =(?) ;";
               PreparedStatement statement = con.prepareStatement(insertQuery);
               statement.setString(1, Bname);
               statement.setString(2, Bname1);
               int rowsInserted = statement.executeUpdate();
               if (rowsInserted > 0) {
                   System.out.println("Data updated successfully.");
               } else {
                   System.out.println("Data updation failed.");
               }
     	}catch(SQLException e) {
             e.printStackTrace();
         }
	
}
	 public static void UpdateBankname(String bankName1,String bankName) {
	     	try(Connection con = dbclass()) {
	     	String Bname1=bankName1;
	     		String Bname=bankName;
	     		
	     		  String insertQuery = "UPDATE BaDetails SET BankName = (?) WHERE BankName =(?) ;";
	               PreparedStatement statement = con.prepareStatement(insertQuery);
	               statement.setString(1, Bname);
	               statement.setString(2, Bname1);
	               int rowsInserted = statement.executeUpdate();
	               if (rowsInserted > 0) {
	                   System.out.println("Data updated successfully.");
	               } else {
	                   System.out.println("Data updation failed.");
	               }
	     	}catch(SQLException e) {
	             e.printStackTrace();
	         }
		
	}
	 public static void AddBranchCount(int bankid,int Count) {
	     	try(Connection con = dbclass()) {
	     	int BankID=bankid;
	     		int Count1=Count;
	     		
	     		  String insertQuery = "update  Bankdetails set NoBranch=(?)where BankID=(?) ;";
	               PreparedStatement statement = con.prepareStatement(insertQuery);
	               statement.setInt(1, Count1);
	               statement.setInt(2, BankID);
	               int rowsInserted = statement.executeUpdate();
	               if (rowsInserted > 0) {
	                   System.out.println("Data updated successfully.");
	               } else {
	                   System.out.println("Data updation failed.");
	               }
	     	}catch(SQLException e) {
	             e.printStackTrace();
	         }
		
	}
	 public static void AddAccountCountdb(int bankId) {
		  try (Connection con = dbclass()) {
		        String selectQuery = "SELECT SUM(NoAccount) AS total_value FROM Branchdetails WHERE BankID=(?)";
		        PreparedStatement selectStatement = con.prepareStatement(selectQuery);
		        selectStatement.setInt(1, bankId);
		        ResultSet resultSet = selectStatement.executeQuery();
		        
		        int newTotalValue = 0;
		        if (resultSet.next()) {
		            newTotalValue = resultSet.getInt("total_value");
		        }
		        
		        String updateQuery = "UPDATE Bankdetails SET NoAccount = (?) WHERE BankID = (?);";
		        PreparedStatement updateStatement = con.prepareStatement(updateQuery);
		        updateStatement.setInt(1, newTotalValue);
		        updateStatement.setInt(2, bankId);
		        
		        int rowsUpdated = updateStatement.executeUpdate();
		        if (rowsUpdated > 0) {
		            System.out.println("Data updated successfully.");
		        } else {
		            System.out.println("Data updation failed.");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
}
}
