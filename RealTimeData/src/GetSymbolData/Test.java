package GetSymbolData;

import java.io.IOException;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		SQLQuery sq = new SQLQuery();
		try {
			sq.GetData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<String> names = sq.getTruckNames();
		
		for (String name : names) { 
			System.out.println(name);
			System.out.println("------------------");
		}
		//System.out.println(sq.getTruckNames());
	}
	
	

}
