package Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class MainClass {
	  Books BookObj = new Books();
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
				 AddBook();
				 
				break;
				 
			 case 2:
					ViewBook();
				    break;
			
			
			 case 3:
				 SearchBook()	;
				 break;
			
			case 4:
				DeleteBook();
				break;
			case 5:
				UpdateBook();
				break;
		case 6:
			break;
		default:System.out.println("please make a valid selection");
	
	}	
			
		}while(Choice != 0||Choice>5);

        scanner.close();
		
		
	}
	public static void  AddBook() {
		System.out.println("Please enter the books name :");
		Scanner sc=new Scanner(System.in);
		Books newBook = new Books();
		String bookName=sc.next();
		newBook.setBookName(bookName);
		//String bookName=sc.next();
		System.out.println("Please enter the Author  name :");
		Scanner scAuthor=new Scanner(System.in);
		String AuthorName=sc.next();
		newBook.setAuthorName(AuthorName);
		System.out.println("Please enter the Price :");
		Scanner scPrice=new Scanner(System.in);
		int Price=sc.nextInt();
		newBook.setPrice(Price);
		System.out.println("Please enter the Bookid :");
		Scanner scBid=new Scanner(System.in);
		int Bookid=sc.nextInt();
		newBook.setBookid(Bookid);
		JdbcSQLServerConnection Bobj=new JdbcSQLServerConnection();
		Bobj.AddBname(bookName,AuthorName,Price,Bookid);	
		System.out.println("Book added successfully");	

	} 
	  public static void ViewBook(){ 
		  
	  System.out.println(" The available list of all books is  :");
	  List<Books> Booklist=new JdbcSQLServerConnection().ViewBname()	; 
		  for(Books book:Booklist) 
		  {  System.out.println("Book Name: " + book.getBookName());
	        System.out.println("Author Name: " + book.getAuthorName());
	        System.out.println("Price: " + book.getPrice());
	        System.out.println("Book ID: " + book.getBookid());
	        System.out.println("---------------------");
			  
		  }
	  
	}
 public static String SearchBook(){  
	 	Books newBook = new Books();
		  System.out.println(" enter the name to be search  :");
		  Scanner sc=new Scanner(System.in);
		  String bookName=sc.next();
		  newBook.setBookName(bookName);
		  JdbcSQLServerConnection Booklist=new JdbcSQLServerConnection(); 
		  String Bname1 =Booklist.SearchBname(bookName);
		 	  
		  String Avalilability=null;
		  if (Bname1==bookName) {
			  Avalilability="yes";
			  System.out.println(" the book is avaiilable :");
			  
		  }else {
			  Avalilability="no";
			  System.out.println(" the book is avaiilable :");
		  }
		 
		  return Avalilability ;
		}
 public static void DeleteBook() {
	  Books newBook = new Books();
	  System.out.println(" enter the name to be delected :");
	  Scanner sc=new Scanner(System.in);
	  String bookName=sc.next();
	  newBook.setBookName(bookName);
	  JdbcSQLServerConnection Booklist=new JdbcSQLServerConnection(); 
			  Booklist.DeleteBname(bookName);
 }
 public static void UpdateBook() {
	  Books newBook = new Books();
	  System.out.println(" enter the name to be Updated :");
	  Scanner sc1=new Scanner(System.in);
	  String bookName1=sc1.next();
	  newBook.setBookName1(bookName1);
	  System.out.println(" enter the new name :");
	  Scanner sc=new Scanner(System.in);
	  String bookName=sc.next();
	  newBook.setBookName(bookName);
	  JdbcSQLServerConnection Booklist=new JdbcSQLServerConnection(); 
	  Booklist.UpdateBname(bookName1,bookName);
 }
}

	
	

