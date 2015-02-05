package GetSymbolData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SymbolConstants {

	static String symbolFile = "D:\\Eclipse Projects\\RealTimeData\\src\\res\\symbolList.txt";

	public static String[] data = new String[9000];

	public void read() throws IOException {
		FileReader fr = new FileReader(symbolFile);
		BufferedReader br = new BufferedReader(fr);
		String line;

		int i = 0;
		while ((line = br.readLine()) != null) {
			data[i] = line;
			System.out.println(data[i]);
			i++;
		}
		br.close();
		System.out.println(line);
		// This is for resize the data array (and data.length reflect new size)
		String[] dataNew = new String[i];
		System.arraycopy(data, 0, dataNew, 0, i);
		data = dataNew;
		System.out.println("Data length: " + data.length);
		//System.out.println(data[1]);

	}
}
