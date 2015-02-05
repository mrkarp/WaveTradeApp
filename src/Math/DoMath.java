package Math;

/*
 * Forward Call and Put Price Calculator
 * Author: Mr.Karp & Q The Brain
 * Project: WaveTrade
 * Date: March
*/

public class DoMath {
	
	//Variables
	static double risk = (.0001);

	//Normal Distribution Doubles
//	static double L;
//	static double K;
//	static double w;
//	static double a1 = 0.31938153;
//	static double a2 = -0.356563782;
//	static double a3 = 1.781477937;
//	static double a4 = -1.821255978;
//	static double a5 = 1.330274429;
		
	// Calculate CallPrice
	public static double CallPrice (double stock, double strike, double days, double vol){
		
		double daysInputForm = days/365.252;
		double volInputForm = vol/100; 
		double d1 = (Math.log(stock / strike) + (risk + volInputForm * volInputForm / 2) * daysInputForm) / (volInputForm * Math.sqrt(daysInputForm));
		double d2 = d1 - volInputForm * Math.sqrt(daysInputForm);
		double callPrice = stock * CND(d1) - strike * Math.exp(-risk * daysInputForm) * CND(d2);
		
		return callPrice;
	}
	
	// Calculate PutPrice
	public static double PutPrice (double stock, double strike, double days, double vol){
		
		double daysInputForm = days/365.252;
		double volInputForm = vol/100;
		double d1 = (Math.log(stock / strike) + (risk + volInputForm * volInputForm / 2) * daysInputForm) / (volInputForm * Math.sqrt(daysInputForm));
		double d2 = d1 - volInputForm * Math.sqrt(daysInputForm);
		double putPrice = strike * Math.exp(-risk * daysInputForm) * CND(-d2) - stock * CND(-d1);
		
		return putPrice;
	}
	
	// The cumulative normal distribution function
	public static double CND(double strikeInput) {
		
		double L;
		double K;
		double w;
		double a1 = 0.31938153;
		double a2 = -0.356563782;
		double a3 = 1.781477937;
		double a4 = -1.821255978;
		double a5 = 1.330274429;
		
		L = Math.abs(strikeInput);
		K = 1.0 / (1.0 + 0.2316419 * L);
		w = 1.0 - 1.0 / Math.sqrt(2.0 * Math.PI) * Math.exp(-L * L / 2) * (a1 * K + a2 * K * K + a3 * Math.pow(K, 3) + a4 * Math.pow(K, 4) + a5 * Math.pow(K, 5));

		if (strikeInput < 0.0) {
			w = 1.0 - w;
		}
		return w;
	}
	
}
