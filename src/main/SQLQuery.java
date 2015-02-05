package Main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * SQL Query
 * Author: Mr.Karp
 * Project: WaveTrade
 * Date: April
*/

public class SQLQuery {
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://karpcode.servehttp.com:3306/RealTime";

	// Database credentials
	static final String USER = "karp";
	static final String PASS = "";
	
	public void SendQuery(String database) throws IOException {
		
		String symbol = Main.RefreshExchanges.symbol;
		String askPrice = Main.RefreshExchanges.askPrice;
		String bidPrice = Main.RefreshExchanges.bidPrice;
		String realPrice = Main.RefreshExchanges.realPrice;
		String volume = Main.RefreshExchanges.volume;
		String divYield = Main.RefreshExchanges.dividendYield;

		Connection conn = null;
		Statement stmt = null;
		
		try {
			//Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			//Execute a query
			stmt = conn.createStatement();
			String sql;
			
			sql = "INSERT INTO "+database+"(Symbol, Ask, Bid, Price, Volume, Dividend) VALUES "
			+ "('"+symbol+"', '"+askPrice+"', '"+bidPrice+"', '"+realPrice+"', '"+volume+"', '"+divYield+"')";
			
			stmt.executeUpdate(sql);
		
	
			//Clean-up environment
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			//Block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("[SQL]: Statement Inserted");
		}
	}