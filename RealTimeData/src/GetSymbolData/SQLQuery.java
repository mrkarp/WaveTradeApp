package GetSymbolData;

//STEP 1. Import required packages
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import GetSymbolData.RunParse;

public class SQLQuery {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:oracle:thin://karpcode.com:3306/test_ftf";

	// Database credentials
	static final String USER = "androidUser";
	static final String PASS = "";
	ArrayList<String> truckNames = new ArrayList<String>();
	
	public ArrayList<String> getTruckNames() {
		return truckNames;
	}

	public void setTruckNames(ArrayList<String> truckNames) {
		this.truckNames = truckNames;
	}

	public void GetData() throws IOException {
		
		String askPrice = RunParse.askPrice;
		String bidPrice = RunParse.bidPrice;
		String realPrice = RunParse.realPrice;						
		String volume = RunParse.volume;
		//String avgVolume = RunParse.dayVolume;//End of day
		String divYield = RunParse.dividendYield;
		//String divPerShare = RunParse.dividendPerShare;
		//String exDividend = RunParse.exDividend;
		//String paymentDate = RunParse.dividendPayDate;
		String daysRange = RunParse.daysRange;
		//String fiftyTwo = RunParse.fiftyTwoWeek;//End of day
		//String exchange = RunParse.exchange;	
		String symName = RunParse.symName;

		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		
		try {
			//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			// STEP 2: Register JDBC driver
			Class.forName("oracle.jdbc.OracleDriver");

			// STEP 3: Open a connection
			//System.out.println("[SQL]: Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			//System.out.println("[SQL]: Creating statement...");
			stmt = conn.createStatement();
			String sql;
//			sql = "INSERT INTO symbol_data(Symbol, Ask, Bid, Price, Volume, Daily_Volume, Dividend, Dividend_Per_Share, "
//					+ "Exp_Dividend_Date, Dividend_Pay_Date, Days_Range, 52_Week, Exchange) VALUES "
//					+ "('"+symbol+"', '"+askPrice+"', '"+bidPrice+"', '"+realPrice+"', '"+volume+"'"
//							+ ", '"+avgVolume+"', '"+divYield+"', '"+divPerShare+"', '"+exDividend+"'"
//									+ ", '"+paymentDate+"', '"+daysRange+"'"
//											+ ", '"+fiftyTwo+"', '"+exchange+"')";
			
			//sql = "INSERT INTO symbol_directory(Symbol, Name) "
					//+ "VALUES ('"+symbol+"', '"+symName+"')";
			//stmt.executeUpdate(sql);
			
			sql = "select truckname from truck_names";
		
					rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						String name = rs.getString(1);
						System.out.println(name);
						truckNames.add(name);
					}
	
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