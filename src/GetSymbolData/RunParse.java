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
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunParse {

	//Split the array
	static String splitBy = ",";  
	//@init the Read
	static BufferedReader br = null;
	//@init the blank array
	public static String line = "";
	
	//Parsed Vars
	public static String[] stockInfo;
	//public static String symbol;
	public static String symbol;
	public static String askPrice;
	public static String bidPrice;
	public static String realPrice;
	public static String volume;
	public static String dividendYield;
	public static List<String> sl = new ArrayList<String>();
	public static boolean parseDone = false;
	public static boolean symbolDone = false;



	public void GetRealTime() throws IOException {

		boolean symbolDone = false;
		
		String yahooFinEnd = "&f=sb2b3l1vy";
		//ASE Exchange
		String aseTwoHundred = "AAMC+AAU+ACU+ADGE+ADK+AE+AIRI+AKG+ALN+AMCO+AMPE+AMS+ANO+ANV+ANX+API+APP+APT+AQQ+ASM+ATL+AUMN+AVL+AWX+AXN+AXU+AXX+AZC+BAA+BCV+BDL+BFY+BHB+BHV+BKJ+BKR+BLE+BLJ+BONE+BPS+BQI-RWI+BQY+BRD+BTI+BTN+BTX+BVX+BXE+BZC+CAK+CCA+CDY+CEF+CEP+CEV+CFD+CFP+CH+CHGS+CIK+CLM+CMFO+CMT+CNAM+CNR+COVR+CPHI+CQP+CRF+CRV+CRVP+CTF+CTO+CTP+CUO+CUR+CVM+CVR+CVU+CXM+DEJ+DGSE+DHY+DIT+DLA+DMC+DMF+DNN+DPW+DSS+DXR+EAD+ECBE+ECF+EGAS+EIA+EIM+EIO+EIP+EIV+ELLO+ELMD+EMAN+EMI+EMJ+EMXX+ENX+EOX+EPM+ERB+ERC+ERH+ESA+ESP+ETAK+ETF+ETUA+ETUB+EVBN+EVI+EVJ+EVK+EVM+EVO+EVP+EVV+EVY+EXE+FAX+FCO+FCSC+FEN+FFI+FPP+FRD+FRS+FSI+FSP+FTF+FU+FWV+GBR+GGN+GHM+GIG+GIW+GLO+GLQ+GLU+GLU-PA+GMO+GORO+GPL+GRC+GRF+GRH+GSB+GSS+GST+GSV+GTE+GTT+GTU+GV+GVP+HEB+HH+HMG+HNW+HRT+HTM+HUSA+HWG+IAF+ICH+IDI+IDN+IEC+IFMI+IG+IGC+IGC-WT+IHT+IMH+IMO+IMUC+INFU+INO+IOT+IPB+IRT+ISL+IVD+JOB+JRS+KBX+KGN+LAQ+LBY+LCI";

		String firstTwoHundred = "http://finance.yahoo.com/d/quotes.csv?s=" + aseTwoHundred + yahooFinEnd;

		String makeTempFolder = (System.getProperty("user.home") + "\\TempExcel");
		String tempFile = makeTempFolder + "\\ase.csv";

		File file = new File(makeTempFolder);
		if(file.exists()) {
			//System.out.println("Folder Exists");
		} else {
		file.mkdirs();
		}
			try {
				URL url = new URL(firstTwoHundred);
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

			} catch (IOException e) {
				e.printStackTrace();
			}
		
		symbolDone = true;
	}
		
	public static void ParseNextLine() {
		if(symbolDone == true) {
		try {
			Scanner s = new Scanner(new File(tempFile));
			br = new BufferedReader(new FileReader(tempFile));
			while ((line = br.readLine()) != null) {
				stockInfo = line.split(splitBy);
				int length = line.length();
				System.out.println(line);
				sl.add(line);


			}
			//Close the scanner and buffer
			br.close();
			s.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		symbol = stockInfo[0];
		askPrice = stockInfo[1];
		bidPrice = stockInfo[2];
		realPrice = stockInfo[3];
		volume = stockInfo[4];
		dividendYield = stockInfo[5];
		
		System.out.println(symbol);
		System.out.println(askPrice);
		System.out.println(bidPrice);
		System.out.println(realPrice);
		System.out.println(volume);
		System.out.println(dividendYield);
		System.out.println(sl);

		
		parseDone = true;
		System.out.println("[Parse]: ParseDone: " + parseDone);

			}
		}
	
}
