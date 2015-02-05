package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;

import RealTime.RunParse;

/*
 * Forward Wave Trade Calculator
 * Author: Mr.Karp
 * Project: WaveTrade
 * Date: March
*/

public class wtcGUI {

	//Frame
	private JFrame frmWavetradeCalculator;
	
	public static String getSymbol;
	static String sharesInput;
	static String vidPer;
	//public static String exchange = Parse.exchange;
	
	//Fields
	public static JTextField stockField;
	
	//Fonts and Formats
	Font font1 = new Font("SansSerif", Font.BOLD, 14);
	Font exchange = new Font("SansSerif", Font.BOLD, 10);

	DecimalFormat df = new DecimalFormat("#.####");	
	
	/*
	 * GUI Components
	 */
	
	//Buttons
	private JButton btnReset;
	private JButton btnRun;
	
	//Labels
	private JLabel lblStockPrice;
	private JLabel lblSymbol;
	private JLabel lblAsk;
	private JLabel lblBid;
	private JLabel lblShare;
	static JLabel lblExchange;
	private JLabel lblLogo;
	private JLabel lblVolume;
	private JLabel lblAvgVolume;
	private JLabel lblDivPerShare;
	private JLabel lblDivYield;
	private JLabel lblExDiv;
	private JLabel lblPayDate;
	private JLabel lblDays;
	private JLabel lbl52Week;
	
	//TextFields
	public static JTextField askField;
	public static JTextField bidField;
	public static JTextField shareField;
	public static JTextField daysField;
	public static JTextField fiftyTwoField;
	public static JTextField volField;
	public static JTextField avgVolField;
	public static JTextField divPerField;
	public static JTextField divYieldField;
	public static JTextField exDivField;
	public static JTextField paymentField;
	public static JTextField symField;	
	private JTextPane textPane;
	public static JTextField divPerShareField;
	
	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wtcGUI window = new wtcGUI();
					window.frmWavetradeCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the application.
	 */
	public wtcGUI() {
		initialize();
	}

	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmWavetradeCalculator = new JFrame();
		frmWavetradeCalculator.setTitle("WaveTrade Calculator");
		frmWavetradeCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage(wtcGUI.class.getResource("/res/smallLogo.png")));
		frmWavetradeCalculator.setBounds(100, 100, 900, 900);
		frmWavetradeCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWavetradeCalculator.getContentPane().setLayout(null);
		frmWavetradeCalculator.setResizable(false);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StyledDocument doc = textPane.getStyledDocument();
				symField.setText("");
				askField.setText("");
				bidField.setText("");
				stockField.setText("");					
				volField.setText("");
				avgVolField.setText("");
				divYieldField.setText("");
				divPerField.setText("");
				exDivField.setText("");
				paymentField.setText("");
				daysField.setText("");
				fiftyTwoField.setText("");
				lblExchange.setText("");
				try {
					doc.insertString(0, "\n", null);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
		});
		
		btnRun = new JButton("Fuck Dan");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				StyledDocument doc = textPane.getStyledDocument();
				RunParse.parseDone = false;
				lblExchange.setText("");

		        getSymbol = symField.getText();		     
		        sharesInput = shareField.getText();
		        
		        System.out.println("Enter Pressed: " + getSymbol + " " + sharesInput);
		        try {
					RunParse.GetRealTime(getSymbol);
				} catch (IOException e) {
					e.printStackTrace();
				}

					System.out.println(RunParse.parseDone);
					if(RunParse.parseDone == true) {
						
						if(!shareField.getText().equals("")) {
						double a = Double.parseDouble(RunParse.dividendPerShare);
						double b = Double.parseDouble(sharesInput);
						double sharesOutput = (a* b);							
						vidPer = df.format(sharesOutput);
						} 
						else if(shareField.getText().equals("")) {
							vidPer = "N/A";
						}						
						
						askField.setText(RunParse.askPrice);
						bidField.setText(RunParse.bidPrice);
						stockField.setText(RunParse.realPrice);						
						volField.setText(RunParse.volume);
						avgVolField.setText(RunParse.dayVolume);
						divYieldField.setText(RunParse.dividendYield);
						divPerField.setText(RunParse.dividendPerShare);
						exDivField.setText(RunParse.exDividend);
						paymentField.setText(RunParse.dividendPayDate);
						daysField.setText(RunParse.daysRange);
						fiftyTwoField.setText(RunParse.fiftyTwoWeek);
						lblExchange.setText(RunParse.exchange);
						divPerShareField.setText(vidPer);					
						
						try {
							doc.insertString(0, "Symbol: " + RunParse.dayVolume + "\n", null);
							doc.insertString(0, "Ask(R): " + RunParse.askPrice + "\n", null);
							doc.insertString(0, "Bid(R): " + RunParse.bidPrice + "\n", null);
							doc.insertString(0, "Price(R): " + RunParse.realPrice + "\n", null);
							doc.insertString(0, "Volume: " + RunParse.volume + "\n", null);
							doc.insertString(0, "Daily Volume: " + RunParse.dayVolume + "\n", null);
							doc.insertString(0, "Dividend Yield: " + RunParse.dividendYield + "\n", null);
							doc.insertString(0, "Dividend: " + RunParse.dividendPerShare + "\n", null);
							doc.insertString(0, "Ex-Dividend Date: " + RunParse.exDividend + "\n", null);
							doc.insertString(0, "Dividend Pay Date: " + RunParse.dividendPayDate + "\n", null);
							doc.insertString(0, "Days Range: " + RunParse.daysRange + "\n", null);
							doc.insertString(0, "52 Week: " + RunParse.fiftyTwoWeek + "\n", null);
							doc.insertString(0, "Exchange: " + RunParse.exchange + "\n", null);
							doc.insertString(0, "Dividend Per Share: " + vidPer + "\n", null);


						} catch (BadLocationException e) {
							e.printStackTrace();
						}
					}
				}						
		});
		
		btnRun.setBounds(10, 631, 86, 30);
		frmWavetradeCalculator.getContentPane().add(btnRun);
		
		lblExchange = new JLabel("");
		lblExchange.setBounds(57, 120, 89, 14);
		frmWavetradeCalculator.getContentPane().add(lblExchange);
		btnReset.setBounds(106, 631, 89, 30);
		frmWavetradeCalculator.getContentPane().add(btnReset);
		lblExchange.setFont(exchange);
		
		symField = new JTextField();
		symField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				StyledDocument doc = textPane.getStyledDocument();
				RunParse.parseDone = false;
				lblExchange.setText("");

		        getSymbol = symField.getText();		     
		        sharesInput = shareField.getText();
		        
		        System.out.println("Enter Pressed: " + getSymbol + " " + sharesInput);
		        try {
					RunParse.GetRealTime(getSymbol);
				} catch (IOException e) {
					e.printStackTrace();
				}

					System.out.println(RunParse.parseDone);
					if(RunParse.parseDone == true) {
						
						if(!shareField.getText().equals("")) {
						double a = Double.parseDouble(RunParse.dividendPerShare);
						double b = Double.parseDouble(sharesInput);
						double sharesOutput = (a* b);							
						vidPer = df.format(sharesOutput);
						} 
						else if(shareField.getText().equals("")) {
							vidPer = "N/A";
						}						
						
						askField.setText(RunParse.askPrice);
						bidField.setText(RunParse.bidPrice);
						stockField.setText(RunParse.realPrice);						
						volField.setText(RunParse.volume);
						avgVolField.setText(RunParse.dayVolume);
						divYieldField.setText(RunParse.dividendYield);
						divPerField.setText(RunParse.dividendPerShare);
						exDivField.setText(RunParse.exDividend);
						paymentField.setText(RunParse.dividendPayDate);
						daysField.setText(RunParse.daysRange);
						fiftyTwoField.setText(RunParse.fiftyTwoWeek);
						lblExchange.setText(RunParse.exchange);
						divPerShareField.setText(vidPer);					
						
						try {
							doc.insertString(0, "Symbol: " + RunParse.dayVolume + "\n", null);
							doc.insertString(0, "Ask(R): " + RunParse.askPrice + "\n", null);
							doc.insertString(0, "Bid(R): " + RunParse.bidPrice + "\n", null);
							doc.insertString(0, "Price(R): " + RunParse.realPrice + "\n", null);
							doc.insertString(0, "Volume: " + RunParse.volume + "\n", null);
							doc.insertString(0, "Daily Volume: " + RunParse.dayVolume + "\n", null);
							doc.insertString(0, "Dividend Yield: " + RunParse.dividendYield + "\n", null);
							doc.insertString(0, "Dividend: " + RunParse.dividendPerShare + "\n", null);
							doc.insertString(0, "Ex-Dividend Date: " + RunParse.exDividend + "\n", null);
							doc.insertString(0, "Dividend Pay Date: " + RunParse.dividendPayDate + "\n", null);
							doc.insertString(0, "Days Range: " + RunParse.daysRange + "\n", null);
							doc.insertString(0, "52 Week: " + RunParse.fiftyTwoWeek + "\n", null);
							doc.insertString(0, "Exchange: " + RunParse.exchange + "\n", null);
							doc.insertString(0, "Dividend Per Share: " + vidPer + "\n", null);


						} catch (BadLocationException e) {
							e.printStackTrace();
						}
					}
				}					
		});

		symField.setBounds(10, 115, 136, 20);
		frmWavetradeCalculator.getContentPane().add(symField);
		symField.setColumns(10);
		symField.setFont(font1);
		
		shareField = new JTextField();
		shareField.setBounds(10, 161, 86, 20);
		frmWavetradeCalculator.getContentPane().add(shareField);
		shareField.setColumns(10);
		
		stockField = new JTextField();
		stockField.setBounds(10, 207, 86, 20);
		frmWavetradeCalculator.getContentPane().add(stockField);
		stockField.setColumns(10);
		stockField.setFont(font1);
		
		bidField = new JTextField();
		bidField.setBounds(10, 260, 86, 20);
		frmWavetradeCalculator.getContentPane().add(bidField);
		bidField.setColumns(10);
		bidField.setFont(font1);
		
		askField = new JTextField();
		askField.setBounds(10, 307, 95, 20);
		frmWavetradeCalculator.getContentPane().add(askField);
		askField.setColumns(10);
		askField.setFont(font1);
		
		daysField = new JTextField();
		daysField.setBounds(10, 355, 95, 20);
		frmWavetradeCalculator.getContentPane().add(daysField);
		daysField.setColumns(10);
		
		fiftyTwoField = new JTextField();
		fiftyTwoField.setBounds(10, 405, 95, 20);
		frmWavetradeCalculator.getContentPane().add(fiftyTwoField);
		fiftyTwoField.setColumns(10);
		
		volField = new JTextField();
		volField.setBounds(10, 450, 95, 20);
		frmWavetradeCalculator.getContentPane().add(volField);
		volField.setColumns(10);
		
		avgVolField = new JTextField();
		avgVolField.setBounds(10, 501, 95, 20);
		frmWavetradeCalculator.getContentPane().add(avgVolField);
		avgVolField.setColumns(10);
		
		divPerField = new JTextField();
		divPerField.setBounds(109, 207, 86, 20);
		frmWavetradeCalculator.getContentPane().add(divPerField);
		divPerField.setColumns(10);
		
		divYieldField = new JTextField();
		divYieldField.setBounds(109, 260, 86, 20);
		frmWavetradeCalculator.getContentPane().add(divYieldField);
		divYieldField.setColumns(10);
		
		exDivField = new JTextField();
		exDivField.setBounds(106, 307, 86, 20);
		frmWavetradeCalculator.getContentPane().add(exDivField);
		exDivField.setColumns(10);
		
		paymentField = new JTextField();
		paymentField.setBounds(106, 355, 86, 20);
		frmWavetradeCalculator.getContentPane().add(paymentField);
		paymentField.setColumns(10);
		
		lblAsk = new JLabel("Ask");
		lblAsk.setForeground(Color.BLACK);
		lblAsk.setBounds(10, 291, 46, 14);
		frmWavetradeCalculator.getContentPane().add(lblAsk);
		lblAsk.setFont(font1);
		
		lblStockPrice = new JLabel("Stock Price");
		lblStockPrice.setForeground(Color.BLACK);
		lblStockPrice.setBounds(10, 192, 86, 14);
		frmWavetradeCalculator.getContentPane().add(lblStockPrice);
		lblStockPrice.setFont(font1);
		
		lblBid = new JLabel("Bid");
		lblBid.setForeground(Color.BLACK);
		lblBid.setBounds(11, 245, 46, 14);
		frmWavetradeCalculator.getContentPane().add(lblBid);
		lblBid.setFont(font1);
		
		lblShare = new JLabel("Shares");
		lblShare.setForeground(Color.BLACK);
		lblShare.setBounds(10, 146, 62, 14);
		frmWavetradeCalculator.getContentPane().add(lblShare);
		lblShare.setFont(font1);
		
		lblSymbol = new JLabel("Symbol");
		lblSymbol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSymbol.setForeground(Color.BLACK);
		lblSymbol.setBounds(10, 97, 62, 14);
		frmWavetradeCalculator.getContentPane().add(lblSymbol);
		lblSymbol.setFont(font1);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(wtcGUI.class.getResource("/res/topLogo3.png")));
		lblLogo.setBounds(171, 11, 317, 75);
		frmWavetradeCalculator.getContentPane().add(lblLogo);
		lblLogo.setFont(font1);
		
		lblDays = new JLabel("Days Range");
		lblDays.setForeground(Color.BLACK);
		lblDays.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDays.setBounds(10, 338, 86, 14);
		frmWavetradeCalculator.getContentPane().add(lblDays);
		
		lbl52Week = new JLabel("52 Week Range");
		lbl52Week.setForeground(Color.BLACK);
		lbl52Week.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl52Week.setBounds(10, 386, 116, 14);
		frmWavetradeCalculator.getContentPane().add(lbl52Week);
		
		lblVolume = new JLabel("Volume");
		lblVolume.setForeground(Color.BLACK);
		lblVolume.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblVolume.setBounds(10, 431, 116, 14);
		frmWavetradeCalculator.getContentPane().add(lblVolume);
		
		lblAvgVolume = new JLabel("Avg. Volume");
		lblAvgVolume.setForeground(Color.BLACK);
		lblAvgVolume.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAvgVolume.setBounds(10, 476, 116, 14);
		frmWavetradeCalculator.getContentPane().add(lblAvgVolume);
		
		lblDivPerShare = new JLabel("Dividend");
		lblDivPerShare.setForeground(Color.BLACK);
		lblDivPerShare.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDivPerShare.setBounds(106, 192, 148, 14);
		frmWavetradeCalculator.getContentPane().add(lblDivPerShare);
		
		lblDivYield = new JLabel("Dividend Yield");
		lblDivYield.setForeground(Color.BLACK);
		lblDivYield.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDivYield.setBounds(106, 240, 148, 14);
		frmWavetradeCalculator.getContentPane().add(lblDivYield);
		
		lblExDiv = new JLabel("Ex Dividend");
		lblExDiv.setForeground(Color.BLACK);
		lblExDiv.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblExDiv.setBounds(106, 287, 148, 14);
		frmWavetradeCalculator.getContentPane().add(lblExDiv);
		
		lblPayDate = new JLabel("Payment Date");
		lblPayDate.setForeground(Color.BLACK);
		lblPayDate.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPayDate.setBounds(106, 338, 148, 14);
		frmWavetradeCalculator.getContentPane().add(lblPayDate);
		
		textPane = new JTextPane();
		textPane.setBounds(462, 132, 392, 476);
		frmWavetradeCalculator.getContentPane().add(textPane);
		
		divPerShareField = new JTextField();
		divPerShareField.setBounds(246, 262, 86, 20);
		frmWavetradeCalculator.getContentPane().add(divPerShareField);
		divPerShareField.setColumns(10);
		
		JLabel lblSharesStuff = new JLabel("Dividends Per Share");
		lblSharesStuff.setBounds(246, 242, 136, 14);
		frmWavetradeCalculator.getContentPane().add(lblSharesStuff);
		
	}
}
