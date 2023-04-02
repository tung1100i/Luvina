/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.transact;

import jdbc.callable.*;
import java.sql.*;

/**
 *
 * @author Hung
 */
public class TransactDemo {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");// nap driver
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
        }
    }
    ;
    private String dbURL = "jdbc:mysql://localhost:3306/sampleDB";
    private String user = "root";
    private String password = "root";
    private Connection conn;

    public void connect() {
        try {
            conn = DriverManager.getConnection(dbURL, user, password);
            System.out.println("Connected.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            conn.close();
            System.out.println("Closed.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void saveOrder(int productId, Date orderDate, float amount, int reportMonth) {
        PreparedStatement orderStatement = null;
        PreparedStatement saleStatement = null;

        try {

            conn.setAutoCommit(false);

            String sqlSaveOrder = "insert into orders (product_id, order_date, amount)";
            sqlSaveOrder += " values (?, ?, ?)";

            String sqlUpdateTotal = "update monthly_sales set total_amount = total_amount + ?";
            sqlUpdateTotal += " where product_id = ? and report_month = ?";

            orderStatement = conn.prepareStatement(sqlSaveOrder);
            saleStatement = conn.prepareStatement(sqlUpdateTotal);

            orderStatement.setInt(1, productId);
            orderStatement.setDate(2, orderDate);
            orderStatement.setFloat(3, amount);

            saleStatement.setFloat(1, amount);
            saleStatement.setInt(2, productId);
            saleStatement.setInt(3, reportMonth);

            orderStatement.executeUpdate();
            saleStatement.executeUpdate();

            conn.commit();

        } catch (SQLException ex) {
            if (conn != null) {
                try {

                    conn.rollback();

                    System.out.println("Rolled back.");
                } catch (SQLException exrb) {
                    exrb.printStackTrace();
                }
            }
        } finally {
            try {
                if (orderStatement != null) {
                    orderStatement.close();
                }

                if (saleStatement != null) {
                    saleStatement.close();
                }

                conn.setAutoCommit(true);
            } catch (SQLException excs) {
                excs.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TransactDemo demo = new TransactDemo();

        int productId = 1;
        int reportMonth = 7;
        Date date = new Date(System.currentTimeMillis());
        float amount = 580;

        demo.connect();

        demo.saveOrder(productId, date, amount, reportMonth);

        demo.disconnect();
    }
}
