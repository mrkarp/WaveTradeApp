package RealTime;

/*
 * Run Parser
 * Author: Mr.Karp
 * Project: WaveTrade
 * Date: April
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class RunParse {

	//static String symbolInput = Main.wtcGUI.getSymbol;
	//Split the array
	static String splitBy = ",";  
	//@init the Read
	static BufferedReader br = null;
	//@init the blank array
	static String line = "";
	
	//Parsed Vars
	static String[] stockInfo;
	public static String symbol;
	public static String askPrice;
	public static String bidPrice;
	public static String realPrice;
	public static String volume;
	public static String dayVolume;
	public static String dividendYield;
	public static String dividendPerShare;
	public static String exDividend;
	public static String dividendPayDate;
	public static String daysRange;
	public static String fiftyTwoWeek;
	public static String exchange;
	public static boolean parseDone = false;


	public static void GetRealTime(String symbol) throws IOException {

		boolean symbolDone = false;
		
		System.out.println("Symbol To Parse: " + symbol);
		//Bool's for fools
		boolean euroTrade = symbol.startsWith("eur") || symbol.endsWith("eur");
		boolean pundTrade = symbol.startsWith("gbp") || symbol.endsWith("gbp");
		boolean usdTrade = symbol.startsWith("usd") || symbol.endsWith("usd");
		boolean aussieTrade = symbol.startsWith("aud") || symbol.endsWith("aud");
		boolean yenTrade = symbol.startsWith("jpy") || symbol.endsWith("jpy");
		boolean canadianTrade = symbol.startsWith("cad") || symbol.endsWith("cad");
		boolean swissTrade = symbol.startsWith("chf") || symbol.endsWith("chf");

		//Check user input for non-USD currency
		if(euroTrade || pundTrade || usdTrade || aussieTrade || yenTrade || canadianTrade || swissTrade) {
			symbol = symbol + "=x";
			System.out.println("Not USD");
			}
		System.out.println(symbol);
				
		String yahooFin = ("http://finance.yahoo.com/d/quotes.csv?s=" + symbol + "&f=sb2b3l1va2ydqr1mwx");	
		String makeTempFolder = (System.getProperty("user.home") + "\\TempExcel");
		String tempFile = makeTempFolder + "\\" + symbol + ".csv";

		File file = new File(makeTempFolder);
		if(file.exists()) {
			//System.out.println("Folder Exists");
		} else {
		file.mkdirs();
		}
			try {
				URL url = new URL(yahooFin);
				URLConnection conn = url.openConnection();
				InputStream in = conn.getInputStream();
				FileOutputStream out = new FileOutputStream(tempFile);
				byte[] b = new byte[1024];
				int sizeFile = conn.getContentLength();
				int count;

				while ((count = in.read(b)) >= 0) {
					out.write(b, 0, count);
				}
				out.flush();
				out.close();
				in.close();
				System.out.println("File Size: " + sizeFile
						+ "\nFile Downloaded to: " + tempFile);

			} catch (IOException e) {
				e.printStackTrace();
			}
		
		symbolDone = true;

		if(symbolDone == true) {
		String csvFile = tempFile;
		try {
			Scanner s = new Scanner(new File(tempFile));
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				stockInfo = line.split(splitBy);
				int length = line.length();
				System.out.println("Excel Includes: " + line);
				System.out.println("String length: " + length);
				System.out.println("Symbol: " + stockInfo[0]);
				System.out.println("Ask(R): " + stockInfo[1]);
				System.out.println("Bid(R): " + stockInfo[2]);
				System.out.println("Price(R): " + stockInfo[3]);
				System.out.println("Volume: " + stockInfo[4]);
				System.out.println("Daily Volume: " + stockInfo[5]);
				System.out.println("Dividend Yield: " + stockInfo[6]);
				System.out.println("Dividend per Share: " + stockInfo[7]);
				System.out.println("Ex-Dividend Date: " + stockInfo[8]);
				System.out.println("Dividend Pay Date: " + stockInfo[9]);
				System.out.println("Days Range: " + stockInfo[10]);
				System.out.println("52 Week: " + stockInfo[11]);
				System.out.println("Exchange: " + stockInfo[12]);


			}
			//Close the scanner and buffer
			br.close();
			s.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Save Vars
		System.out.println("Saving Variables");

		symbol = stockInfo[0];
		askPrice = stockInfo[1];
		bidPrice = stockInfo[2];
		realPrice = stockInfo[3];
		volume = stockInfo[4];
		dayVolume = stockInfo[5];
		dividendYield = stockInfo[6];
		dividendPerShare = stockInfo[7];
		exDividend = stockInfo[8];
		dividendPayDate = stockInfo[9];
		daysRange = stockInfo[10];
		fiftyTwoWeek = stockInfo[11];
		exchange = stockInfo[12];

		System.out.println("Done Parsing");
		
		System.out.println(parseDone);
		parseDone = true;
		System.out.println(parseDone);

		File f = new File(tempFile);
		if (parseDone == true && f.exists()) {
			//System.out.println(f + " exsists");
			f.deleteOnExit();
			System.out.println(f + " was deleted");

			PrintWriter writer = new PrintWriter(tempFile + ".txt", "UTF-8");

			
			}
		}
	}
}
