package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Run Parser
 * Author: Mr.Karp
 * Project: WaveTrade
 * Date: April
*/

public class ParseAndIterate {	
	
	//@init the Read
	static BufferedReader br = null;
	//@init the blank array
	public static String line = "";
	
	static boolean downloadFile = GetFile.downloadFile;
	
	static String csvFile = GetFile.tempFile;
	public static List<String> stockInfo = new ArrayList<String>();
	
	static boolean parseDone = false;

	public static void IterateCSV() {
		
		if(downloadFile == true) {
			try {
				Scanner s = new Scanner(new File(csvFile));
				br = new BufferedReader(new FileReader(csvFile));
				while ((line = br.readLine()) != null) {
					@SuppressWarnings("unused")
					int length = line.length();
					//System.out.println(line);
					stockInfo.add(line);
				}
				//Close the scanner and buffer
				br.close();
				s.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			parseDone = true;
			System.out.println("[Parse]: ParseDone: " + parseDone);

				}
			}
}
