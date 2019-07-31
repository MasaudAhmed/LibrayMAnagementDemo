/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage_Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Manage_Category {
     static int row =0 ;
     static char choice  = '0';
     static Connection con = Connection_db.JBDConnection.makeConnection();
     static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     public static void mainMenu() throws SQLException, IOException
     {
         
        do
        {
            if(choice=='n' || choice=='N')
                System.exit(1);
                
            menu();
            reader=new BufferedReader(new InputStreamReader(System.in));
            char a = (char)reader.read();
            switch (a)
            {
                case '1':
                    showCategory();
                    break;
                case '2':
                    int add = addCategor();
                    if(add==1)
                    {
                        System.out.println("Data inserted Successfuly");
                    }
                    else
                        System.out.println("Some thing went wrong");
                    break;
                case '3':
                {
                    showCategory();
                    
                    int del = deleteCategor();
                    if(del==1)
                    {
                        System.out.println("Data Deleted Successfuly");
                    }
                    else
                        System.out.println("Some thing went wrong");
                    break;
                }
                case '4':
                {
                    
                    int update = updateRecord();
                    if(update==1)
                    {
                        System.out.println("Record Updated Successfuly");
                    }
                    else
                        System.out.println("Some thing went wrong");
                    break;
                }
                case '5':
                    librarymanagemet.LibraryManagemet.menu();
                    break;
                default:
                    System.out.println("Invalid choice");
                
            }
            System.out.println("Do You want to continue IN Category Depart ");
            reader=new BufferedReader(new InputStreamReader(System.in));
            choice = (char)reader.read();
             
        }while(choice =='Y' || choice =='y');
     }
     public static void menu() 
     {
        
        System.out.println("Enetr 1 for show    Categor    ----- >");
        System.out.println("Enetr 2 for Add     Categor    ----- >");
        System.out.println("Enetr 3 for Delete  Categor    ----- >");
        System.out.println("Enetr 4 for Update  Categor    ----- >");
        System.out.println("Enetr 5 for Back To Main Menu  ----- >");
    }
    public static int addCategor() throws SQLException, IOException
    {
        System.out.println("Enter Category Name");
        reader=new BufferedReader(new InputStreamReader(System.in));
        String Name = reader.readLine();
        Statement stm = con.createStatement();
        row  = stm.executeUpdate("insert into category(cate_name)"+   " values( '"+Name+"')");
        return row;
        
    }
    public static int deleteCategor() throws SQLException, IOException
    {
        System.out.println("Enter ID To delete category ");
        reader=new BufferedReader(new InputStreamReader(System.in));
        int id = reader.read();
        Statement stm = con.createStatement();
        row  = stm.executeUpdate("delete from category where cate_id= "+ id);
        return row;
       
    }
    public static int updateRecord() throws SQLException, IOException
    {
        showCategory();
        reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enteer Id To update ");
        String id = reader.readLine();
        reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Name to update ");
        String name = reader.readLine();
        Statement stmt=con.createStatement();
        row=  stmt.executeUpdate("update category set cate_name='"+name+"' where categ_id="+id);
        return row;
    }
    public static void showCategory() throws SQLException
    {
        System.out.println("Id \t\t\t Name");
        Statement stmt=con.createStatement();
        ResultSet rs = stmt.executeQuery("Select *from category");
        while(rs.next())
        {
            System.out.println(rs.getInt(1)+"\t\t\t"+rs.getString(2));
            
            
        }
    }
}
