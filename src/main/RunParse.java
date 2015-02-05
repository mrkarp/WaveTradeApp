package main;

/*
 * Run Parser
 * Author: Mr.Karp
 * Project: WaveTrade
 * Date: April
*/

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RunParse {
	//Users input
	static String symbolInput;
	//Currency Trading Array
	static String[] nonUsd = {"eurusd", "eurjpy"};
	

	public static void main(String [] args) throws IOException {
		Scanner scanner = new Scanner (System.in);
		
		//Ask user for symbol
		System.out.println("Enter Symbol: ");  
		//Get what the user types
		symbolInput = scanner.next();
		//Bool's for fools
		boolean checkArray = Arrays.asList(nonUsd).contains(symbolInput);
		boolean euroTrade = symbolInput.startsWith("eur") || symbolInput.endsWith("eur");
		boolean pundTrade = symbolInput.startsWith("gbp") || symbolInput.endsWith("gbp");
		boolean usdTrade = symbolInput.startsWith("usd") || symbolInput.endsWith("usd");
		boolean aussieTrade = symbolInput.startsWith("aud") || symbolInput.endsWith("aud");
		boolean yenTrade = symbolInput.startsWith("jpy") || symbolInput.endsWith("jpy");
		boolean canadianTrade = symbolInput.startsWith("cad") || symbolInput.endsWith("cad");
		boolean swissTrade = symbolInput.startsWith("chf") || symbolInput.endsWith("chf");
		boolean sAndP = symbolInput.contains("&");

		//Check user input for non-USD currency
		if(checkArray || euroTrade || pundTrade || usdTrade || aussieTrade || yenTrade || canadianTrade || swissTrade) {
			symbolInput = symbolInput + "=x";
			System.out.println("Not USD");
		}
		if (sAndP){
			symbolInput = "^gspc";
			System.out.println("& Found!");
		} 
		else {


		//Download excel
		//for(int i = 10; i > 5; i--) {
		GetFile.getFile();
		
		//Parse Excel
		Parse.doParse();
		//Close the scanner
		scanner.close();
		//}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Parse.delTempFile();
		//Get Strings from parse
		String realPriceRetrieval = Parse.realPrice;
		//System.out.println(realPriceRetrieval);
		}	
	}
}