package Main;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

/*
 * RunChunk
 * Author: Mr.Karp
 * Project: WaveTrade
 * Date: April
*/

public class RunChunk {

/*
 * Download the CSV once
 * Parse through to fill a List
 * Iterate through list saving variables each time
 * Run SQL query with saved variables each iteration
*/

	public static void main(String [] args) throws IOException {
		MassGet get = new MassGet();

		get.GetFile();

		
		RefreshExchanges.SQLUpdate("ase_data", "ase");

	}
	
}
