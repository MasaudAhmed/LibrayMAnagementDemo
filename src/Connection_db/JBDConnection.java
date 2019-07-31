/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JBDConnection{
    static Connection con=null;
    private JBDConnection(){}
    public static Connection makeConnection()
    {
        if(con == null)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root",""); 
                System.err.println("Connection created");
            
            }
            catch( ClassNotFoundException | SQLException e)
            {
                System.out.println(e);
            }
        }
        return con;
    }
    public static void main(String ags[])
    {
        Connection con = makeConnection();
    }
}
