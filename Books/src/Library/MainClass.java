package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainClass {
	public static void Selection() {
		System.out.println("1.AddBook");
		System.out.println("2.ViewBook");
		System.out.println("3.SearchBook");
		System.out.println("4.DeleteBook");
		System.out.println("5.UpdateBook");
		System.out.println("6.Exit");
		System.out.println("Please select your choice");
	}
	
	public static void main(String args[]) {
		 Scanner scanner = new Scanner(System.in);
	        int Choice;

		do {
			Selection();
			Choice= scanner.nextInt();
			
			/*
			 * JdbcSQLServerConnection objdb=new JdbcSQLServerConnection(); objdb.dbclass();
			 */
			String Booklist=null;
			switch(Choice) {
			  case 1:
				 
				 Books obj=new BookActions();
					
				obj.AddBook();			 
				 
				break;
				 
			  case 2:
					Books objview=new BookActions();
						objview.ViewBook();
				    break;
			
			
		case 3:
			Books objsearch=new BookActions();
			objsearch.SearchBook()	;
			break;
			
		case 4:
			Books objdelete=new BookActions();
			objdelete.DeleteBook();
			break;
		case 5:
			Books objupdate=new BookActions();
			objupdate.UpdateBook();
			break;
		case 6:
			break;
		default:System.out.println("please make a valid selection");
	
	}	
			
		}while(Choice != 0||Choice>5);

        scanner.close();
		
		
	}
	
	
}
