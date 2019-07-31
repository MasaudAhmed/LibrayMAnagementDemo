/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagemet;

import Book_Manage.Book_Manage;
import Connection_db.JBDConnection;
import Manage_Category.Manage_Category;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 *
 * @author masoo
 */
public class LibraryManagemet {
    public LibraryManagemet(){}
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static char choice;
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws SQLException, IOException {
        JBDConnection.makeConnection();
        menu();
    }
    public static void menu() throws IOException, SQLException
    {
        do
        {
            System.out.println("1 => For Category Management");
            System.out.println("2 => For Book Management");
            System.out.println("3 => Exit");
            reader = new BufferedReader(new InputStreamReader(System.in));
            char selection = reader.readLine().charAt(0);
            switch(selection)
            {
                case '1':
                    Manage_Category.mainMenu();
                    break;
                case '2':
                    Book_Manage.bookOperation();
                    break;
                case '3':
                    System.exit(1);
                    break;
                default:
                    System.out.println("Some thing went wrong try again");
            }
            System.out.println("Press Y to coninue ");
           choice = (char)reader.read();
        }while(choice =='Y' || choice=='y');
    }
    
}
