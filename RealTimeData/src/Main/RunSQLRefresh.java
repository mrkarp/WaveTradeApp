package Main;

import java.io.IOException;
import GetSymbolData.RunParse;
import GetSymbolData.SQLQuery;
import GetSymbolData.SymbolConstants;

public class RunSQLRefresh {

	public static void main(String[] args) throws IOException {
		
		SymbolConstants rfta = new SymbolConstants();
		SQLQuery qu = new SQLQuery();
		RunParse parse = new RunParse();
		rfta.read();		
		String[] data = SymbolConstants.data;
		for (int i = 0; i < data.length; i++){
	    String symbol = data[i];
		parse.GetRealTime(symbol);
		qu.GetData(symbol);
		}
	}
}