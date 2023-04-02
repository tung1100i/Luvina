/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pattern.creationalPattern.objectPool.connectionPool;

import java.sql.Connection;

public class Main {

    public static void main(String args[]) {
        // Do something...
     

    // Create the ConnectionPool:
    JdbcConnectionPool pool = new JdbcConnectionPool(
                "org.hsqldb.jdbcDriver", "jdbc:hsqldb://localhost/mydb",
                "sa", "secret");

        // Get a connection:
        Connection con = pool.checkOut();
        // Use the connection
       

    // Return the connection:
    pool.checkIn(con);

    }
}
