package main;

/*
 * Parse Excel Documents
 * Author: Mr.Karp
 * Project: WaveTrade
 * Date: April
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Parse {

	//User inputed symbol
	static String symbolInput = RunParse.symbolInput;
	//Preset dir of file
	static String fileDir = GetFile.tempFolder;
	//Split the array
	static String splitBy = ",";  
	//@init the Read
	static BufferedReader br = null;
	//@init the blank array
	String line = "";
	
	//Var's to be replaced
	static String symbol;
	static String askPrice;
	static String bidPrice;
	static String realPrice;
	static String dividend;
	static String dayVolume;
	static String dividendYield;
	static String dividendPerShare;
	static String exDividend;
	static String dividendPayDate;
	static String daysRange;
	static String fiftyTwoWeek;
	static String exchange;

	
	static String[] stockInfo;
		
	public static void doParse() {

		String csvFile = fileDir;
		String line = "";
		try {
			Scanner s = new Scanner(new File(fileDir));
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
		dividend = stockInfo[4];
		dayVolume = stockInfo[5];
		dividendYield = stockInfo[6];
		dividendPerShare = stockInfo[7];
		exDividend = stockInfo[8];
		dividendPayDate = stockInfo[9];
		daysRange = stockInfo[10];
		fiftyTwoWeek = stockInfo[11];
		exchange = stockInfo[12];
//		System.out.println(symbol);
//		System.out.println(askPrice);
//		System.out.println(bidPrice);
//		System.out.println(realPrice);
//		System.out.println(dividend);
//		System.out.println(dayVolume);		
//		System.out.println(dividendYield);
//		System.out.println(dividendPerShare);
//		System.out.println(exDividend);
//		System.out.println(dividendPayDate);
//		System.out.println(daysRange);
//		System.out.println(fiftyTwoWeek);
//		System.out.println(exchange);

		System.out.println("Done Parsing");
	}

	//Delete temp file
	public static void delTempFile() {
		File f = new File(fileDir);
		String makeTempFolder = (System.getProperty("user.home") + "\\TempExcel");
		File d = new File(makeTempFolder);
		if (f.exists()) {
			//System.out.println(f + " exsists");
			f.deleteOnExit();
			//System.out.println(f + " was deleted");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			d.deleteOnExit();
		//	System.out.println(d + " was deleted");

		}
	}
}