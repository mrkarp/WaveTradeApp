package Main;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class RefreshExchanges {

	static String symbol;
	static String askPrice;
	static String bidPrice;
	static String realPrice;
	static String volume;
	static String dividendYield;
	static boolean isDone;
	
	public static void SQLUpdate (String database, String fileName) throws IOException {
		// @init the query
		SQLQuery query = new SQLQuery();
		// String array to hold the information of the stocks
		String[] sqlString;
		// Splite the elements to be able to read
		String splitBy = ",";

		// Get the URI CSV file
		//GetFile.GetFileMakeFolder(URL, fileName);
		// Parse through the CSV file to populate the List<String>
		ParseAndIterate.IterateCSV();

		List<String> sl = ParseAndIterate.stockInfo;
		while (!sl.isEmpty()) {
			isDone = false;
			String element = sl.get(0);
			sl = sl.subList(1, sl.size());
			System.out.println("Stock Info: " + element);
			sqlString = element.split(splitBy);
			String sql = Arrays.toString(sqlString);

			symbol = sqlString[0];
			askPrice = sqlString[1];
			bidPrice = sqlString[2];
			realPrice = sqlString[3];
			volume = sqlString[4];
			dividendYield = sqlString[5];

			System.out.println("Split String: " + sql);
			System.out.println("Stock: " + symbol + askPrice + bidPrice + realPrice + volume + dividendYield);
			System.out.println("");

			query.SendQuery(database);
		} 
		isDone = true;
	}
}
