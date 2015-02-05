package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import GetSymbolData.RunParse;
import GetSymbolData.SQLQuery;

public class RunSQLRefresh {

	public static void main(String[] args) throws IOException {
		
		SQLQuery qu = new SQLQuery();
		RunParse parse = new RunParse();
		
		parse.GetRealTime();
		List<String> arrayList = RunParse.sl;
		Iterator<String> it = arrayList.iterator();
		
		while(it.hasNext())
		{
		    String obj = it.next();
		    System.out.println("One: " + obj);
		    qu.GetData();
		}
		
	   //String symbol = stockInfo;
		//qu.GetData();
		}
	}
