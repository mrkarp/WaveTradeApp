package Math;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Forward Volatility Calculator
 * Author: Mr.Karp & Q The Brain
 * Project: WaveTrade
 * Date: 4/3/2014
*/

public class ForwardVolatility {
	
	//Output formatter
	static DecimalFormat df = new DecimalFormat("#.####");	
	
	//Variables
	
	//@init Inputs
	static double fVolOne;
	static double fVolTwo;
	static double fVolThree;
	static double fVolFour;
	static double fVolFive;
	//@init getMinMax variables
	static double minVal;
	static double maxVal;
	//@init output
	static double forwardVolOutput;
	
	//Testing values
	static double dayStart = 10;
	static double dayEnd = 5;
	

	//Calc Forward Volatility One
	public static void forwardVolOne(double dayStart, double dayEnd, double volOfStart1, double volOfEnd1) {
		
		fVolOne = Math.sqrt((dayEnd * volOfEnd1 * volOfEnd1 - dayStart * volOfStart1 * volOfStart1) / (dayEnd - dayStart));
		
	}
	//Calc Forward Volatility Two
	public static void forwardVolTwo(double dayStart, double dayEnd, double volOfStart2, double volOfEnd2) {
		
		fVolTwo = Math.sqrt((dayEnd * volOfEnd2 * volOfEnd2 - dayStart * volOfStart2 * volOfStart2) / (dayEnd - dayStart));
		
	}
	//Calc Forward Volatility Three
	public static void forwardVolThree(double dayStart, double dayEnd, double volOfStart3, double volOfEnd3) {
		
		fVolThree = Math.sqrt((dayEnd * volOfEnd3 * volOfEnd3 - dayStart * volOfStart3 * volOfStart3) / (dayEnd - dayStart));
		
	}
	//Calc Forward Volatility Four
	public static void forwardVolFour(double dayStart, double dayEnd, double volOfStart4, double volOfEnd4) {
		
		fVolFour = Math.sqrt((dayEnd * volOfEnd4 * volOfEnd4 - dayStart * volOfStart4 * volOfStart4) / (dayEnd - dayStart));
		
	}
	//Calc Forward Volatility Five
	public static void forwardVolFive(double dayStart, double dayEnd, double volOfStart5, double volOfEnd5) {
		
		fVolFive = Math.sqrt((dayEnd * volOfEnd5 * volOfEnd5 - dayStart * volOfStart5 * volOfStart5) / (dayEnd - dayStart));
		
	}
	//Calc Min and Max from fVol(s)
	public static void getMinMax() {
		
		//Insert input into the double[]
		double[] getMinMax = {fVolOne, fVolTwo, fVolThree, fVolFour, fVolFive};
		
		//Sort double[]
		Arrays.sort(getMinMax);

		//Get position of the min value and max value
		minVal = getMinMax[0];
		maxVal = getMinMax[4];
	}
	

	//Calculate the ForwardVolatility through the user/inputs
	public static void forwardVolOutput(double fVolOne, double fVolTwo, double fVolThree, double fVolFour, double fVolFive) {
		
		forwardVolOutput = (((fVolOne + fVolTwo + fVolThree + fVolFour + fVolFive) - (minVal + maxVal)) / 3);
		
	}
	
	//Test main
	public static void main(String [] args) {
			
	//Open Scanner
	Scanner s = new Scanner(System.in);
	
	//User Inputs
	System.out.println("1st Vol. Start & End: ");
		double fVolThreeInput = s.nextDouble();
		double fVolFourInput = s.nextDouble();
		
	System.out.println("2nd Vol. Start & End: ");
		double fVolThreeInput2 = s.nextDouble();
		double fVolFourInput2 = s.nextDouble();
		
	System.out.println("3rd Vol. Start & End: ");
		double fVolThreeInput3 = s.nextDouble();
		double fVolFourInput3 = s.nextDouble();
		
	System.out.println("4th Vol. Start & End: ");
		double fVolThreeInput4 = s.nextDouble();
		double fVolFourInput4 = s.nextDouble();
		
	System.out.println("5th Vol. Start & End: ");
		double fVolThreeInput5 = s.nextDouble();
		double fVolFourInput5 = s.nextDouble();
	
	//Close Scanner
	s.close();

	//Run 5 fVol Math
	ForwardVolatility.forwardVolOne(dayStart, dayEnd, fVolThreeInput, fVolFourInput);
	ForwardVolatility.forwardVolTwo(dayStart, dayEnd, fVolThreeInput2, fVolFourInput2);
	ForwardVolatility.forwardVolThree(dayStart, dayEnd, fVolThreeInput3, fVolFourInput3);
	ForwardVolatility.forwardVolFour(dayStart, dayEnd, fVolThreeInput4, fVolFourInput4);
	ForwardVolatility.forwardVolFive(dayStart, dayEnd, fVolThreeInput5, fVolFourInput5);
	
	//getMinMax Math
	ForwardVolatility.getMinMax();
	
	//forwardVol Math
	ForwardVolatility.forwardVolOutput(fVolOne, fVolTwo, fVolThree, fVolFour, fVolFive);
	
		System.out.println("-----------");
	System.out.println("Forward1: " + fVolOne);
		System.out.println("-----------");
	System.out.println("Forward2: " + fVolTwo);
		System.out.println("-----------");
	System.out.println("Forward3: " + fVolThree);
		System.out.println("-----------");
	System.out.println("Forward4: " + fVolFour);
		System.out.println("-----------");
	System.out.println("Forward5: " + fVolFive);
		System.out.println("-----------");
	System.out.println("Min Extracted " + minVal);
		System.out.println("-----------");
	System.out.println("Max Extracted " + maxVal);
		System.out.println("-----------");
	System.out.println("Expected Forward Volatility: " + forwardVolOutput);
		System.out.println("-----------");
	String fVolOutput = df.format(forwardVolOutput);
	System.out.println("Formated Forward Volatility: " + fVolOutput);

	
	}
}
