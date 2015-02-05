package main;

/*
 * GetFile
 * Author: Mr.Karp
 * Project: WaveTrade
 * Date: April
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class GetFile {
	
	static String symbolInput = RunParse.symbolInput;
	//s - Symbol
	//b2 - Ask
	//b3 - Bid
	//l1 - Realtime Stock Price
	//v - Volume
	//a2 - Daily volume 
	//y - Dividend yield 
	//d - Dividend per share
	//q - Ex-Dividend date 
	//r1 - Dividend pay date
	//m - Days range
	//w - 52 week
	//x - Exchange
	
	static String yahooFin2 = ("http://finance.yahoo.com/d/quotes.csv?s=" + symbolInput + "&f=sb2b3l1yqr1va2mwx");	
	static String yahooFin = ("http://finance.yahoo.com/d/quotes.csv?s=" + symbolInput + "&f=sb2b3l1va2ydqr1mwx");	

	//Create dir to temp folder
	static String makeTempFolder = (System.getProperty("user.home") + "\\TempExcel");
	//File extension
	static String tempFolder = makeTempFolder + "\\" + symbolInput + ".csv";
	

	public static void getFile() {
		
		File file = new File(makeTempFolder);
		//Check if directory or folder exists
		if(file.exists()) {
			//System.out.println("Folder Exists");
		} else {
		file.mkdirs();
		}
			try {
				URL url = new URL(yahooFin);
				URLConnection conn = url.openConnection();
				InputStream in = conn.getInputStream();
				FileOutputStream out = new FileOutputStream(tempFolder);
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
				//		+ "\nFile Downloaded to: " + tempFolder);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}