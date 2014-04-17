
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * This class is intended for connecting to a MySQL server and executing queries on it.
 * @author Abhijit
 *
 */

public class query {
   // JDBC driver name and database information
	String JDBC_DRIVER;
	String DB_URL;
	String HOST;
	String USER;
	String PASS;
	
	/**
	 * Constructor to initialize an instance with Driver, Host and Credentials
	 */
	public query(){
		JDBC_DRIVER = "com.mysql.jdbc.Driver";
		HOST = "jdbc:mysql://localhost/";
		//  Database credentials
		USER = "root";
		PASS = "";
	}
	/**
	 * This method is for choosing a database to run queries on.
	 * Alternatively user can prefix database name before the name table with a period
	 * @param DB is the name of the database
	 */
	public void selectDB(String DB){
		DB_URL=HOST+DB;
	}
	/**
	 * This method is for querying the DB to obtain data i.e. SELECT statements
	 * @param sql is the SELECT MySQL query to fetch data
	 */
	public List<List<String>> getData(String sql) {
   Connection conn = null;
   Statement stmt = null;
   List <List <String>> Result=new ArrayList<List <String>>();
   try{
      // Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      // Open a connection
      //System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      // Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      /*String sql;
      sql = "SELECT * FROM test_table";*/
      ResultSet rs = stmt.executeQuery(sql);
      
      ResultSetMetaData rsmd = rs.getMetaData();
      int columnsNumber = rsmd.getColumnCount();
      // Extract data from result set
      while(rs.next()){
         //Retrieve by column name
    	  int col=1;
    	  List <String> row=new ArrayList<String>();
    	  while (col<=columnsNumber){
    	  row.add(rs.getString(col));
    	  col++;
    	  }
         //Display values
         Result.add(row);
      }
      //Clean-up environment
      rs.close();
      stmt.close();
      conn.close();      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   //System.out.println("Goodbye!");
   return Result;
}//end getData
	/**
	 * This method is to run an Update Query i.e. UPDATE,DELETE or INSERT
	 * @param sql is the MySQL query to run
	 */
	public void runQuery(String sql){
		
		Connection conn = null;
		   Statement stmt = null;
		   try{
		      // Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      // Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      // Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      
		      int rs = stmt.executeUpdate(sql);
		      System.out.println(rs+" Rows Affected");
		      //Clean-up environment
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try		
	}
	/**
	 * This function takes an SQL SELECT query as input, and write the result into a file
	 * @param sql is the query to be executed
	 * @param File is the file in which this information is to be stored
	 */
	public void writeDataToCSV(String sql, String File) {
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      // Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      // Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      // Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      /*String sql;
		      sql = "SELECT * FROM test_table";*/
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      CSVWriter writer = new CSVWriter(new FileWriter(File));
		      writer.writeAll(rs,true);
		      writer.close();
		      //Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();      
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   //System.out.println("Goodbye!");
		}//end getData
}//end query class