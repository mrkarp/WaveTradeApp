package GetSymbolData;

//STEP 1. Import required packages
import java.io.IOException;
import java.sql.*;

import GetSymbolData.RunParse;

public class SQLQuery {
	
	String symbol = RunParse.symbol;
	String askPrice = RunParse.askPrice;
	String bidPrice = RunParse.bidPrice;
	String realPrice = RunParse.realPrice;
	String volume = RunParse.volume;
	String divYield = RunParse.dividendYield;

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://karpcode.servebeer.com:3306/RealTime";

	// Database credentials
	static final String USER = "karp";
	static final String PASS = "";

	
	public void GetData() throws IOException {

		
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			//System.out.println("[SQL]: Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			//System.out.println("[SQL]: Creating statement...");
			stmt = conn.createStatement();
			String sql;
			
			sql = "INSERT INTO ase_data(Symbol, Ask, Bid, Price, Volume, Dividend) VALUES "
			+ "('"+symbol+"', '"+askPrice+"', '"+bidPrice+"', '"+realPrice+"', '"+volume+"', '"+divYield+"')";
			
			stmt.executeUpdate(sql);
		
	
			// STEP 6: Clean-up environment
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out.println("[SQL]: Statement Inserted");
		}// end main
	}
//}