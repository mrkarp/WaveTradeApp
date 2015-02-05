package GetSymbolData;

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

	String symbol = SymbolConstants.data[0];
	//Split the array
	static String splitBy = ",";  
	//@init the Read
	static BufferedReader br = null;
	//@init the blank array
	public static String line = "";
	
	//Parsed Vars
	static String[] stockInfo;
	//public static String symbol;
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
	public static String symName;
	public static boolean parseDone = false;


	public void GetRealTime(String symbol) throws IOException {

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
				
		//String firstTwo = "http://finance.yahoo.com/d/quotes.csv?s=AAMC+ AAU+ ACU+ ADGE+ ADK+ AE+ AIRI+ AKG+ ALN+ AMCO+ AMPE+ AMS+ ANO+ ANV+ ANX+ API+ APP+ APT+ AQQ+ ASM+ ATL+ AUMN+ AVL+ AWX+ AXN+ AXU+ AXX+ AZC+ BAA+ BCV+ BDL+ BFY+ BHB+ BHV+ BKJ+ BKR+ BLE+ BLJ+ BONE+ BPS+ BQI-RWI+ BQY+ BRD+ BTI+ BTN+ BTX+ BVX+ BXE+ BZC+ CAK+ CCA+ CDY+ CEF+ CEP+ CEV+ CFD+ CFP+ CH+ CHGS+ CIK+ CLM+ CMFO+ CMT+ CNAM+ CNR+ COVR+ CPHI+ CQP+ CRF+ CRV+ CRVP+ CTF+ CTO+ CTP+ CUO+ CUR+ CVM+ CVR+ CVU+ CXM+ DEJ+ DGSE+ DHY+ DIT+ DLA+ DMC+ DMF+ DNN+ DPW+ DSS+ DXR+ EAD+ ECBE+ ECF+ EGAS+ EIA+ EIM+ EIO+ EIP+ EIV+ ELLO+ ELMD+ EMAN+ EMI+ EMJ+ EMXX+ ENX+ EOX+ EPM+ ERB+ ERC+ ERH+ ESA+ ESP+ ETAK+ ETF+ ETUA+ ETUB+ EVBN+ EVI+ EVJ+ EVK+ EVM+ EVO+ EVP+ EVV+ EVY+ EXE+ FAX+ FCO+ FCSC+ FEN+ FFI+ FPP+ FRD+ FRS+ FSI+ FSP+ FTF+ FU+ FWV+ GBR+ GGN+ GHM+ GIG+ GIW+ GLO+ GLQ+ GLU+ GLU-PA+ GMO+ GORO+ GPL+ GRC+ GRF+ GRH+ GSB+ GSS+ GST+ GSV+ GTE+ GTT+ GTU+ GV+ GVP+ HEB+ HH+ HMG+ HNW+ HRT+ HTM+ HUSA+ HWG+ IAF+ ICH+ IDI+ IDN+ IEC+ IFMI+ IG+ IGC+ IGC-WT+ IHT+ IMH+ IMO+ IMUC+ INFU+ INO+ IOT+ IPB+ IRT+ ISL+ IVD+ JOB+ JRS+ KBX+ KGN+ LAQ+ LBY+ LCI&f=sn";

		String yahooFin = ("http://finance.yahoo.com/d/quotes.csv?s=" + symbol + "&f=sn");	
		//String yahooFin = ("http://finance.yahoo.com/d/quotes.csv?s=" + symbol + "&f=sb2b3l1vym");	
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
				//System.out.println("File Size: " + sizeFile
				//		+ "\nFile Downloaded to: " + tempFile);

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
				//System.out.println("Excel Includes: " + line);
				//System.out.println("String length: " + length);
				//System.out.println("Symbol: " + stockInfo[0]);
//				System.out.println("Ask(R): " + stockInfo[1]);
//				System.out.println("Bid(R): " + stockInfo[2]);
//				System.out.println("Price(R): " + stockInfo[3]);
//				System.out.println("Volume: " + stockInfo[4]);
//				System.out.println("Daily Volume: " + stockInfo[5]);
//				System.out.println("Dividend Yield: " + stockInfo[6]);
//				System.out.println("Dividend per Share: " + stockInfo[7]);
//				System.out.println("Ex-Dividend Date: " + stockInfo[8]);
//				System.out.println("Dividend Pay Date: " + stockInfo[9]);
//				System.out.println("Days Range: " + stockInfo[10]);
//				System.out.println("52 Week: " + stockInfo[11]);
//				System.out.println("Exchange: " + stockInfo[12]);

				//System.out.println("[Parse]: Applying String");

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
		//System.out.println("[Parse]: Saving Variables");

		symbol = stockInfo[0];
		symName = stockInfo[1];
//		askPrice = stockInfo[1];
//		bidPrice = stockInfo[2];
//		realPrice = stockInfo[3];
//		volume = stockInfo[4];
//		dividendYield = stockInfo[5];
//		daysRange = stockInfo[6];

		//System.out.println("[Parse]: Done Parsing");
		
		parseDone = true;
		System.out.println("[Parse]: ParseDone: " + parseDone);

//		File f = new File(tempFile);
//		if (parseDone == true && f.exists()) {
//			//System.out.println(f + " exsists");
//			f.deleteOnExit();
//			System.out.println(f + " was deleted");
//
//			PrintWriter writer = new PrintWriter(tempFile + ".txt", "UTF-8");
//
//			
//			}
		}
	}
}
