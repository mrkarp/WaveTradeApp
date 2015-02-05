//package Main;
//
////STEP 1. Import required packages
//import java.io.IOException;
//import java.sql.*;
//import java.util.Scanner;
//
//import GetSymbolData.RunParse;
//
//public class SQLConnect {
//
//	// JDBC driver name and database URL
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://karpcode.servebeer.com:3306/RealTime";
//
//	// Database credentials
//	static final String USER = "karp";
//	static final String PASS = "";
//	static String symbolInput;
//
//	public static void main(String[] args) throws IOException {
//		Scanner scanner = new Scanner (System.in);
//		
//		//Ask user for symbol
//		System.out.println("Enter Symbol: ");  
//		//Get what the user types
//		symbolInput = scanner.next();
//		
//		RunParse.GetRealTime(symbolInput);
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			// STEP 2: Register JDBC driver
//			Class.forName("com.mysql.jdbc.Driver");
//
//			// STEP 3: Open a connection
//			System.out.println("Connecting to database...");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//			// STEP 4: Execute a query
//			System.out.println("Creating statement...");
//			stmt = conn.createStatement();
//			String sql;
//			sql = "SELECT * FROM symbol_data limit 1 offset 2";
//			ResultSet rs = stmt.executeQuery(sql);
//
//			// STEP 5: Extract data from result set
//			while (rs.next()) {
//				// Retrieve by column name
//				int id = rs.getInt("number");
//				String symbol = rs.getString("symbol");
//				String askPrice = rs.getString("ask");
//				String bidPrice = rs.getString("bid");
//				String realPrice = rs.getString("price");
//				String volume = rs.getString("volume");
//				String dayVolume = rs.getString("daily volume");
//				String dividendYield = rs.getString("dividend");
//				String dividendPerShare = rs.getString("dividend per share");
//				String exDividend = rs.getString("exp. dividend date");
//				String dividendPayDate = rs.getString("dividend pay date");
//				String daysRange = rs.getString("days range");
//				String fiftyTwoWeek = rs.getString("52 week");
//				String exchange = rs.getString("exchange");
//
//
//				// Display values
//				System.out.println("Symbol: " + symbol);
//				System.out.println("Ask(R): " + askPrice);
//				System.out.println("Bid(R): " + bidPrice);
//				System.out.println("Price(R): " + realPrice);
//				System.out.println("Volume: " + volume);
//				System.out.println("Daily Volume: " + dayVolume);
//				System.out.println("Dividend Yield: " + dividendYield);
//				System.out.println("Dividend per Share: " + dividendPerShare);
//				System.out.println("Ex-Dividend Date: " + exDividend);
//				System.out.println("Dividend Pay Date: " + dividendPayDate);
//				System.out.println("Days Range: " + daysRange);
//				System.out.println("52 Week: " + fiftyTwoWeek);
//				System.out.println("Exchange: " + exchange);
//
//
//			}
//			// STEP 6: Clean-up environment
//			rs.close();
//			stmt.close();
//			conn.close();
//		} catch (SQLException se) {
//			// Handle errors for JDBC
//			se.printStackTrace();
//		} catch (Exception e) {
//			// Handle errors for Class.forName
//			e.printStackTrace();
//		} finally {
//			// finally block used to close resources
//			try {
//				if (stmt != null)
//					stmt.close();
//			} catch (SQLException se2) {
//			}// nothing we can do
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}// end finally try
//		}// end try
//		System.out.println("Goodbye!");
//	}// end main
//}// end FirstExample