/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.rowSet; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider; 
/**
 *
 * @author DELL E7450
 */
public class TmpCachedRowSetEx1 {
public static void main(String args[]) throws Exception{  
    String urlMySQL = "jdbc:mysql://localhost/test"; 
     Class.forName("com.mysql.jdbc.Driver");// nap driver 
    try( Connection con
          =DriverManager.getConnection(urlMySQL,"root","root");
         Statement stmt=con.createStatement();  
         ResultSet rs=stmt.executeQuery("select * from Products");  
       ) {   
        CachedRowSet cRS 
           = RowSetProvider.newFactory().createCachedRowSet();  
        cRS.populate(rs);// Populating ResultSet data into CachedRowSet 
        while(cRS.next()){    
            System.out.println(cRS.getString(1)+"; "
                    +cRS.getString(2)+"; "+cRS.getString(3));    
        }  
    }  
    catch(Exception e){   System.out.println(e);  
    }    
    }  
}  
