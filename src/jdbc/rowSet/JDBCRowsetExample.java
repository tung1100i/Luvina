package jdbc.rowSet;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class JDBCRowsetExample { 
    private int insertedRowNo; 
    private final static String DB_URL = "jdbc:mysql://localhost:3306/example_db";
    private final static String USR = "root";
    private final static String PWD = "root";
    private final static String BOOKS_TABLE = "books_table"; 
    private final static String TITLE = "title";
    private final static String AUTHOR = "author";
    private final static String INSERT_ROW_TITLE = "Sach mới11";
    private final static String INSERT_ROW_AUTHOR = "Tác giả mới1";
    private final static String UPDATE_ROW_AUTHOR = "Sửa tên tác giả1"; 
    public JDBCRowsetExample() {
   }

public static void main(String [] args)   throws Exception { 
        JDBCRowsetExample pgm = new JDBCRowsetExample(); 
        JdbcRowSet jrs = pgm.getJDBCRowset(); 
        jrs.addRowSetListener(new MyListener1());   
        pgm.loadAllRows(jrs); 
        pgm.printAllRows(jrs);
        pgm.insertRow(jrs);  
        pgm.updateRow(jrs);
        pgm.deleteRow(jrs); 
        jrs.close(); 
        System.out.println("- Close.");
} 
private JdbcRowSet getJDBCRowset() throws SQLException { 
        RowSetFactory rsFactory = RowSetProvider.newFactory();
        JdbcRowSet jRowset = rsFactory.createJdbcRowSet(); 
        jRowset.setUsername(USR);
        jRowset.setPassword(PWD);
        jRowset.setUrl(DB_URL);
      //  jRowset.setReadOnly(false); // make rowset updateable 
        return jRowset;
}

private void loadAllRows(JdbcRowSet jrs)  throws SQLException { 
        String sql = "SELECT * FROM " + BOOKS_TABLE;
        jrs.setCommand(sql);
        jrs.execute();
 System.out.println("Total rows in table: " + getRowCount(jrs));
}

private int getRowCount(JdbcRowSet jrs) throws SQLException {
      jrs.last();
    return jrs.getRow();
}

private void printAllRows(JdbcRowSet jrs)  throws SQLException { 
        System.out.println("- Print all rows:");  
        jrs.beforeFirst(); 
        while (jrs.next()) { 
                int rowNo = jrs.getRow();
                String s1 = jrs.getString(TITLE);
                String s2 = jrs.getString(AUTHOR);
                System.out.println(rowNo + ": " + s1 + ", " + s2);
        }
}

private void insertRow(JdbcRowSet jrs)  throws SQLException { 
        System.out.println("- Insert row: "); 
        jrs.moveToInsertRow();
        jrs.updateString(TITLE, INSERT_ROW_TITLE);
        jrs.updateString(AUTHOR, INSERT_ROW_AUTHOR);
        jrs.insertRow();

        insertedRowNo = jrs.getRow();
        String s1 = jrs.getString(TITLE);
        String s2 = jrs.getString(AUTHOR);
        System.out.println(insertedRowNo + ": " + 
                        jrs.getString(TITLE) + ", " + jrs.getString(AUTHOR));
        System.out.println("Total rows in table: " + getRowCount(jrs));
}

private void updateRow(JdbcRowSet jrs)   throws SQLException { 
        System.out.println("- Update row " + insertedRowNo); 
        jrs.absolute(insertedRowNo);
        String s1 = jrs.getString(TITLE);
        String s2 = jrs.getString(AUTHOR);
        System.out.println("Row (before update): " + s1 + ", " + s2);

         jrs.updateString("AUTHOR", UPDATE_ROW_AUTHOR); 
        jrs.updateRow();

        s1 = jrs.getString(TITLE);
        s2 = jrs.getString(AUTHOR);
        System.out.println("Row (after update): " +  s1 + ", " + s2);
}

private void deleteRow(JdbcRowSet jrs)  throws SQLException {

        jrs.absolute(insertedRowNo);
        String s1 = jrs.getString(TITLE);
        String s2 = jrs.getString(AUTHOR);
 System.out.println("- Delete row " + insertedRowNo + ": " + s1 + ", " + s2);

        jrs.deleteRow();

        System.out.println("Total rows in table: " + getRowCount(jrs));
}
}

class MyListener1 implements RowSetListener {  
      public void cursorMoved(RowSetEvent event) {  
                System.out.println("Cursor Moved...");  
      }  
     public void rowChanged(RowSetEvent event) {  
                System.out.println("Thay đổi ít nhất một trường ");  
     }  
     public void rowSetChanged(RowSetEvent event) {  
                System.out.println("Thay đổi tất cả các trường");  
     }  
}