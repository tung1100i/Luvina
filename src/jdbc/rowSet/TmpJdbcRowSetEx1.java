package jdbc.rowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class TmpJdbcRowSetEx1 { 
    public static void main(String[] args) throws Exception {   
        Class.forName("com.mysql.jdbc.Driver");// nap driver          
        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
        rowSet.setUrl("jdbc:mysql://localhost/test");  
        rowSet.setUsername("root"); 
        rowSet.setPassword("root");  
         rowSet.setCommand("Select * from Products");  
        rowSet.execute();   
        rowSet.addRowSetListener(new MyListener()); 
        while (rowSet.next()) {  
               // Generating cursor Moved event  
               System.out.println("Name: " + rowSet.getString(1));  
               System.out.println("ID: " + rowSet.getString(2));  
               System.out.println("Price: " + rowSet.getFloat(3));  
       }       
    }  
}  
  
class MyListener implements RowSetListener {  
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