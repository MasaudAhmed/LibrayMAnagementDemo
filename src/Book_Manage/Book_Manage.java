/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Book_Manage;

import Manage_Category.Manage_Category;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author masoo
 */
public class Book_Manage {
    static int row =0 ;
    static char choice;
    static Connection con = Connection_db.JBDConnection.makeConnection();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void bookMenu()
    {
        System.out.println("1 -> Add    Book --->");
        System.out.println("2 -> Delete Book --->");
        System.out.println("3 -> Update Book --->");
        System.out.println("4 -> View Book   --->");
        System.out.println("5 -> Go Back     --->");
    }
    public static void bookOperation() throws IOException, SQLException
    {
        reader = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            bookMenu();
            reader = new BufferedReader(new InputStreamReader(System.in));
            char ch = (char)reader.read();
            switch(ch)
            {
                case '1':
                    int add  = addBook();
                    if(add==1)
                    {
                        System.out.println("Added successfully");
                    }
                    else
                    System.out.println("Some thing went wrong");
                    break;
                case '2':
                    int del  = deleteBook();
                    if(del==1)
                    {
                        System.out.println("Deleted successfully");
                    }
                    else
                    System.out.println("Some thing went wrong");
                    break;
                case '3':
                    updateBook();
                    break;
                case '4':
                    showBook();
                    break;
                case '5':
                    librarymanagemet.LibraryManagemet.menu();
                default:
                    System.out.print("invalid choice ");
            }
            System.out.println("Do You want to continue IN Book Depart ");
            reader=new BufferedReader(new InputStreamReader(System.in));
            choice = (char)reader.read();
        }while(choice =='Y' || choice =='y');
    }
    
    // Add Book in Book Table
    
    public static int addBook() throws IOException, SQLException
    {  
        System.out.println("Enter Book Name --->");
        String name = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        Manage_Category.showCategory();
        System.out.println("Enter Book Category --->");
        String id =reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter ISBN number");
        String sNo = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Price --->" );
        String price = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Author Name ---> ");
        String Auth_name = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Edition");
        String edition = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        Statement stm = con.createStatement();
        row  = stm.executeUpdate("insert into Book_Record(Bname,Author,serial,edition,price,cate_id)values( '"+name+"','"+Auth_name+"','"+sNo+"','"+edition+"','"+price+"','"+id+"')");        
        return row;    
    }
    
    // delete book
    
    public static int deleteBook() throws IOException, SQLException
    {
        showBook();
        System.out.println("Enter Book ID  --->");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String Id = reader.readLine();
        Statement stm = con.createStatement();
        row = stm.executeUpdate("delete from Book_Record where Bookno= "+ Id);  
        return row;
    }
    
    // Update Book
    
    public static void updateBook() throws IOException, SQLException
    {
        System.out.println("1 : Update by Name ");
        System.out.println("2 : Update by Author Name");
        System.out.println("3 : Update by price");
        System.out.println("4 : Update by Edition");
        System.out.println("5 : Update All Fields");
        char choice  = (char)reader.read();
        reader = new BufferedReader(new InputStreamReader(System.in));
        switch(choice)
        {
            case '1':
                int update =  updateName();
                if(update ==1)
                {
                    System.out.println("Updated Successfully");
                }
                else
                    System.out.println("Some Thing Went To  wrong");
                break;
            case'2':
                int updateAuthor =  updateAuthor();
                if(updateAuthor ==1)
                {
                    System.out.println("Updated Successfully");
                }
                else
                    System.out.println("Some Thing Went To  wrong");
                break;
            case'3':
                int updatePrice =  updatePrice();
                if(updatePrice ==1)
                {
                    System.out.println("Updated Successfully");
                }
                else
                    System.out.println("Some Thing Went To  wrong");
                break;
            case'4':
                int updateCategory =  updateEdition();
                if(updateCategory ==1)
                {
                    System.out.println("Updated Successfully");
                }
                else
                    System.out.println("Some Thing Went To  wrong");
                break;
            case'5':
                int updateAll =  updateAll();
                if(updateAll==1)
                {
                    System.out.println("Updated Successfully");
                }
                else
                    System.out.println("Some Thing Went To  wrong");
                break;
                   
        }
    }
    
    // Update by Book Name
    
    public static int updateName() throws IOException, SQLException
    {
        showBook();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Book Id");
        String id = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Book Name");
        String name   =reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        Statement stm = con.createStatement();   
        row=  stm.executeUpdate("update Book_Record set Bname='"+name+"' where Bookno="+id);   
        return  row;
    }
    
    // update by Author Name
    
    public static int updateAuthor() throws IOException, SQLException
    {
        showBook();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Book Id");
        String id = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Author Name");
        String name   =reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        Statement stm = con.createStatement();   
        row=  stm.executeUpdate("update Book_Record set Author='"+name+"' where Bookno="+id);   
        return  row;
    }
    
    // update by price
    
    public static int updatePrice() throws IOException, SQLException
    {
        showBook();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Book Id");
        String id = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Price");
        String price   =reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        Statement stm = con.createStatement();   
        row=  stm.executeUpdate("update Book_Record set price='"+price+"' where Bookno="+id);   
        return  row;
    }
    // update by Edition
    public static int updateEdition() throws IOException, SQLException
    {
        showBook();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Book Id");
        String id = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Book Edition");
        String edition   =reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        Statement stm = con.createStatement();   
        row=  stm.executeUpdate("update Book_Record set edition='"+edition+"' where Bookno="+id);   
        return  row;
    }
    
    //  Update All
     public static int updateAll() throws IOException, SQLException
    {
        showBook();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Book Id");
        String id = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Book Name");
        String name   =reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Author Name");
        String A_name   =reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Book Serial number");
        String serial = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Edition");
        String Edition   =reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Price");
        String Price   =reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Book Category");
        String c_id   =reader.readLine();
        reader = new BufferedReader(new InputStreamReader(System.in));
        Statement stm = con.createStatement();   
        row=  stm.executeUpdate("update Book_Record set Bname='"+name+"', Author='"+A_name+"',serial='"+serial+"'"
                + ", edition='"+Edition+"' , price='"+Price+"',cate_id='"+c_id+"' where Bookno="+id);   
        return  row;
    }
    
   // View Book
    public static void showBook() throws SQLException
    {
        {
            System.out.println("Book_ID\t  BName\t  Author\t  serial_num\t  Edition\t  price\t   Cate_Id\t");
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("Select *from Book_Record");
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" \t  "+rs.getString(2)+"\t  "+rs.getString(3)+"\t\t"+rs.getInt(4)+"\t     "+rs.getInt(5)+"\t\t   "+rs.getInt(6)+"\t     "+rs.getInt(7));
            }
        }
     }
}
