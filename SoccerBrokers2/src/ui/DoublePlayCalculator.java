package ui;

/**
 * @Author Tony Cotta
 */
import javax.swing.JPanel;
import javax.swing.JTextField;

import system.DoublePlaySolver;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;

import java.text.NumberFormat;
import java.text.DecimalFormat;

public class DoublePlayCalculator extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private   JPanel mainPanel = new JPanel();
	private  JLabel EMPTY_LINE = new JLabel(" ");
	
	private  final JLabel TWO_ML_SOLVER = new JLabel(" Two Money Line Solver ");
	private  final JLabel FAV_WEIGHTED = new JLabel(" Favorite Weighted ");
	private  final JLabel ODDS_PAYOFF_CALC = new JLabel(" Odds and Payoff Calculator ");
	private  final JLabel ODDS_PAYOFF_CALC2 = new JLabel(" Odds and Payoff Calculator ");
	private  final JLabel AMOUNT = new JLabel(" Amount ");
	private  final JLabel AMOUNT2 = new JLabel(" Amount ");
	private  final JLabel ODDS = new JLabel(" Odds ");
	private  final JLabel PAYOFF = new JLabel(" Payoff ");
	private  final JLabel PAYOFF2 = new JLabel(" Payoff ");
	
	private  final JLabel TEAM1 = new JLabel(" Team 1 / Bet 1 / Draw: ");
	private  final JLabel TEAM1_2 = new JLabel(" Team 1 / Bet 1 / Draw: ");
	private  final JLabel TEAM2 = new JLabel(" Team 2 / Bet 2 / Favorite: ");
	private  final JLabel TEAM2_2 = new JLabel(" Team 2 / Bet 2 / Favorite: ");
	

	//***************************************************************************************
	private  JLabel AMT1 = new JLabel();
	private  JLabel AMT1_2 = new JLabel();
	private  JLabel AMT2 = new JLabel();
	private  JLabel AMT2_2 = new JLabel();
	
	private  JLabel PAY1 = new JLabel();
	private  JLabel PAY1_2 = new JLabel();
	private  JLabel PAY2 = new JLabel();
	private  JLabel PAY2_2 = new JLabel();
	
	private  JLabel PERCENT = new JLabel();
	private  JLabel PERCENT2 = new JLabel();
	
	private  JLabel TO_WIN_10_TOTAL = new JLabel();
	private  JLabel TO_WIN_10_TOTAL_2 = new JLabel();
	private  JLabel TO_WIN_100_TOTAL = new JLabel();
	private  JLabel TO_WIN_100_TOTAL_2 = new JLabel();
	private  JLabel TO_WIN_1000_TOTAL = new JLabel();
	private  JLabel TO_WIN_1000_TOTAL_2 = new JLabel();
	private  JLabel TO_WIN_10000_TOTAL = new JLabel();
	private  JLabel TO_WIN_10000_TOTAL_2 = new JLabel();
	
		// $10
		private  JLabel BET1_TOTAL = new JLabel();
		private  JLabel BET1_TOTAL_2 = new JLabel();
		private  JLabel BET2_TOTAL = new JLabel();
		private  JLabel BET2_TOTAL_2 = new JLabel();
		
		// $100
		private JLabel BET1_TOTAL_100 = new JLabel();
		private JLabel BET1_TOTAL_100_2 = new JLabel();
		private JLabel BET2_TOTAL_100 = new JLabel();
		private JLabel BET2_TOTAL_100_2 = new JLabel();
		
		// $1,000
		private JLabel BET1_TOTAL_1000 = new JLabel();
		private JLabel BET1_TOTAL_1000_2 = new JLabel();
		private JLabel BET2_TOTAL_1000 = new JLabel();
		private JLabel BET2_TOTAL_1000_2 = new JLabel();
		
		// $10,000
		private JLabel BET1_TOTAL_10000 = new JLabel();
		private JLabel BET1_TOTAL_10000_2 = new JLabel();
		private JLabel BET2_TOTAL_10000 = new JLabel();
		private JLabel BET2_TOTAL_10000_2 = new JLabel();
		
	//***************************************************************************************
	
	private  final JLabel NET1 = new JLabel(" 10 ");
	private  final JLabel NET2 = new JLabel(" 10 ");
	private  final JLabel NET3 = new JLabel(" 0 ");
	private  final JLabel NET4 = new JLabel(" 10 ");
		
	private  JTextField teamOdds = new JTextField("Enter Odds");
	private  JTextField drawOdds = new JTextField("Enter Odds");
	
	private  final JLabel BET1NET = new JLabel(" Bet 1 Win Net: ");
	private  final JLabel BET1NET_2 = new JLabel(" Bet 1 Win Net: ");
	private  final JLabel BET2NET = new JLabel(" Bet 2 Win Net: ");
	private  final JLabel BET2NET_2 = new JLabel(" Bet 2 Win Net: ");
	
	private  final JLabel PERCENT_ON_MONEY = new JLabel(" % On Your Money: ");
	private  final JLabel PERCENT_ON_MONEY2 = new JLabel(" % On Your Money or Break Even: ");
	
	private  final JLabel TO_WIN_10 = new JLabel(" Money Needed to win $10: ");
	private  final JLabel TO_WIN_10_2 = new JLabel(" $10: ");
	private  final JLabel TO_WIN_100 = new JLabel(" Money Needed to win $100: ");
	private  final JLabel TO_WIN_100_2 = new JLabel(" $100: ");
	private  final JLabel TO_WIN_1000 = new JLabel(" Money Needed to win $1k: ");
	private  final JLabel TO_WIN_1000_2 = new JLabel(" $1k: ");
	private  final JLabel TO_WIN_10000 = new JLabel(" Money Needed to win $10k: ");
	private  final JLabel TO_WIN_10000_2 = new JLabel(" $10k: ");
	
	private  final JLabel BET1AMT100 = new JLabel(" Bet 1 Amount: ");
	private  final JLabel BET1AMT100_2 = new JLabel(" Bet 1 Amount: ");
	private  final JLabel BET2AMT100 = new JLabel(" Bet 2 Amount: ");
	private  final JLabel BET2AMT100_2 = new JLabel(" Bet 2 Amount: ");
	
	private  final JLabel BET1AMT1k = new JLabel(" Bet 1 Amount: ");
	private  final JLabel BET1AMT1k_2 = new JLabel(" Bet 1 Amount: ");
	private  final JLabel BET2AMT1k = new JLabel(" Bet 2 Amount: ");
	private  final JLabel BET2AMT1k_2 = new JLabel(" Bet 2 Amount: ");
	
	private  final JLabel BET1AMT10k = new JLabel(" Bet 1 Amount: ");
	private  final JLabel BET1AMT10k_2 = new JLabel(" Bet 1 Amount: ");
	private  final JLabel BET2AMT10k = new JLabel(" Bet 2 Amount: ");
	private  final JLabel BET2AMT10k_2 = new JLabel(" Bet 2 Amount: ");
	
	public void DoublePlayCalculator(Container pane){

		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		// Add the header (Row 0, Column 0)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		mainPanel.add(TWO_ML_SOLVER, c);
		// (Row 0, Column 6)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 0;
		mainPanel.add(FAV_WEIGHTED, c);
		
		// Create a separation (Row 1, Column 0-INF)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		mainPanel.add(EMPTY_LINE, c);
		
		// Add the column titles (Row 2, Column 0)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		mainPanel.add(ODDS_PAYOFF_CALC, c);
		// (Row 2, Column 1)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		mainPanel.add(AMOUNT, c);
		// (Row 2, Column 2)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		mainPanel.add(ODDS, c);
		//(Row 2, Column 3)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 2;
		mainPanel.add(PAYOFF, c);
		// Row 2, Column 6)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 2;
		mainPanel.add(ODDS_PAYOFF_CALC2, c);
		// (Row 2, Column 7)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 7;
		c.gridy = 2;
		mainPanel.add(AMOUNT2, c);
		// (Row 2, Column 8)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8;
		c.gridy = 2;
		mainPanel.add(PAYOFF2, c);
		
		// Create a separation (Row 3, Column 0-INF)
		EMPTY_LINE = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		mainPanel.add(EMPTY_LINE, c);
		
		// Team 1 / Bet 1 / Draw (Row 4, Column 0)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		mainPanel.add(TEAM1, c);
		// (Row 4, Column 1)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		mainPanel.add(AMT1, c);
		// (Row 4, Column 2)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		mainPanel.add(drawOdds, c);
		// (Row 4, Column 3)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 4;
		mainPanel.add(PAY1, c);
		// (Row 4, Column 6)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 4;
		mainPanel.add(TEAM1_2, c);
		// (Row 4, Column 7)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 7;
		c.gridy = 4;
		mainPanel.add(AMT1_2, c);
		// (Row 4, Column 8)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8;
		c.gridy = 4;
		mainPanel.add(PAY1_2, c);
		
		
		
		// Create a separation (Row 5, Column 0-INF)
		EMPTY_LINE = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		mainPanel.add(EMPTY_LINE, c);
		
		// Team 2 / Bet 2 / Favorite (Row 6, Column 0)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		mainPanel.add(TEAM2, c);
		// (Row 6, Column 1)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 6;
		mainPanel.add(AMT2, c);
		// (Row 6, Column 2)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 6;
		mainPanel.add(teamOdds, c);
		// (Row 6, Column 3)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 6;
		mainPanel.add(PAY2, c);
		// Team 2 / Bet 2 / Favorite (Row 6, Column 6)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 6;
		mainPanel.add(TEAM2_2, c);
		// (Row 6, Column 7)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 7;
		c.gridy = 6;
		mainPanel.add(AMT2_2, c);
		// (Row 6, Column 8)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8;
		c.gridy = 6;
		mainPanel.add(PAY2_2, c);
		
	
		// Create a separation (Row 7, Column 0-INF)
		EMPTY_LINE = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 7;
		mainPanel.add(EMPTY_LINE, c);
		
		// Bet 1 Win Net (Row 8, Column 1)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 8;
		mainPanel.add(BET1NET, c);
		// (Row 8, Column 2)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 8;
		mainPanel.add(NET1, c);
		// Bet 1 Win Net (Row 8, Column 6)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 8;
		mainPanel.add(BET1NET_2, c);
		// (Row 8, Column 7)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 7;
		c.gridy = 8;
		mainPanel.add(NET3, c);		
		
		// Create a separation (Row 9, Column 0-INF)
		EMPTY_LINE = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 9;
		mainPanel.add(EMPTY_LINE, c);
			
		// Bet 2 Win Net (Row 10, Column 1)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 10;
		mainPanel.add(BET2NET, c);
		// (Row 10, Column 2)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 10;
		mainPanel.add(NET2, c);
		// Bet 2 Win Net (Row 10, Column 6)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 10;
		mainPanel.add(BET2NET_2, c);
		// (Row 10, Column 7)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 7;
		c.gridy = 10;
		mainPanel.add(NET4, c);
		
		// Create a separation (Row 11, Column 0-INF)
		EMPTY_LINE = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 11;
		mainPanel.add(EMPTY_LINE, c);
		
		// Percent on your money (Row 12, Column 3)
		PERCENT_ON_MONEY.setForeground(new Color(0,102,51));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 12;
		mainPanel.add(PERCENT_ON_MONEY, c);
		// (Row 12, Column 4)
		PERCENT.setForeground(new Color(0,102,51));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 12;
		mainPanel.add(PERCENT, c);
		// Percent on your money (Row 12, Column 7)
		PERCENT_ON_MONEY2.setForeground(new Color(0,102,51));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 7;
		c.gridy = 12;
		mainPanel.add(PERCENT_ON_MONEY2, c);
		// (Row 12, Column 8)
		PERCENT2.setForeground(new Color(0,102,51));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8;
		c.gridy = 12;
		mainPanel.add(PERCENT2, c);
		// END CALCULATION PANEL
		
		
		
		// BET AMOUNTS PANEL BELOW
		
		// WIN 10
		// Bet 1 Win Net (Row 13, Column 0)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 13;
		mainPanel.add(TO_WIN_10, c);
		// (Row 13, Column 1)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 13;
		mainPanel.add(TO_WIN_10_TOTAL, c);
		// (Row 13, Column 5)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 13;
		mainPanel.add(TO_WIN_10_2, c);
		// (Row 13, Column 6)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 13;
		mainPanel.add(TO_WIN_10_TOTAL_2, c);
		
		// Create a separation (Row 14, Column 0-INF)
		EMPTY_LINE = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 14;
		mainPanel.add(EMPTY_LINE, c);
	
		// WIN 100
		// Bet 1 Win Net (Row 15, Column 0)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 15;
		mainPanel.add(TO_WIN_100, c);
		// (Row 15, Column 1)
		TO_WIN_100_TOTAL.setForeground(Color.red);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 15;
		mainPanel.add(TO_WIN_100_TOTAL, c);
		// Bet 1 Win Net (Row 15, Column 5)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 15;
		mainPanel.add(TO_WIN_100_2, c);
		// (Row 15, Column 6)
		TO_WIN_100_TOTAL_2.setForeground(Color.red);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 15;
		mainPanel.add(TO_WIN_100_TOTAL_2, c);
			
		// (Row 16, Column 2)
		BET1AMT100.setForeground(Color.red);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 16;
		mainPanel.add(BET1AMT100, c);
		// (Row 16, Column 3)
		BET1_TOTAL_100.setForeground(Color.red);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 16;
		mainPanel.add(BET1_TOTAL_100, c);
		// (Row 16, Column 7)
		BET1AMT100_2.setForeground(Color.red);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 7;
		c.gridy = 16;
		mainPanel.add(BET1AMT100_2, c);
		// (Row 16, Column 8)
		BET1_TOTAL_100_2.setForeground(Color.red);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8;
		c.gridy = 16;
		mainPanel.add(BET1_TOTAL_100_2, c);		
		// (Row 17, Column 2)
		BET2AMT100.setForeground(Color.red);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 17;
		mainPanel.add(BET2AMT100, c);
		// (Row 17, Column 3)
		BET2_TOTAL_100.setForeground(Color.red);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 17;
		mainPanel.add(BET2_TOTAL_100, c);
		// (Row 17, Column 7)
		BET2AMT100_2.setForeground(Color.red);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 7;
		c.gridy = 17;
		mainPanel.add(BET2AMT100_2, c);
		// (Row 17, Column 8)
		BET2_TOTAL_100_2.setForeground(Color.red);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8;
		c.gridy = 17;
		mainPanel.add(BET2_TOTAL_100_2, c);
	
		// WIN 1,000
		// (Row 18, Column 0)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 18;
		mainPanel.add(TO_WIN_1000, c);
		// (Row 18, Column 1)
		TO_WIN_1000_TOTAL.setForeground(Color.blue);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 18;
		mainPanel.add(TO_WIN_1000_TOTAL, c);
		// (Row 18, Column 5)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 18;
		mainPanel.add(TO_WIN_1000_2, c);
		// (Row 18, Column 6)
		TO_WIN_1000_TOTAL_2.setForeground(Color.blue);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 18;
		mainPanel.add(TO_WIN_1000_TOTAL_2, c);
		// (Row 19, Column 2)
		BET1AMT1k.setForeground(Color.blue);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 19;
		mainPanel.add(BET1AMT1k, c);
		// (Row 19, Column 3)
		BET1_TOTAL_1000.setForeground(Color.blue);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 19;
		mainPanel.add(BET1_TOTAL_1000, c);
		// (Row 19, Column 7)
		BET1AMT1k_2.setForeground(Color.blue);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 7;
		c.gridy = 19;
		mainPanel.add(BET1AMT1k_2, c);
		// (Row 19, Column 8)
		BET1_TOTAL_1000_2.setForeground(Color.blue);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8;
		c.gridy = 19;
		mainPanel.add(BET1_TOTAL_1000_2, c);
		// (Row 20, Column 2)
		BET2AMT1k.setForeground(Color.blue);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 20;
		mainPanel.add(BET2AMT1k, c);
		// (Row 20, Column 3)
		BET2_TOTAL_1000.setForeground(Color.blue);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 20;
		mainPanel.add(BET2_TOTAL_1000, c);
		// (Row 20, Column 7)
		BET2AMT1k_2.setForeground(Color.blue);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 7;
		c.gridy = 20;
		mainPanel.add(BET2AMT1k_2, c);
		// (Row 20, Column 8)
		BET2_TOTAL_1000_2.setForeground(Color.blue);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8;
		c.gridy = 20;
		mainPanel.add(BET2_TOTAL_1000_2, c);
		
		// WIN 10,000
		// (Row 21, Column 0)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 21;
		mainPanel.add(TO_WIN_10000, c);
		// (Row 21, Column 1)
		TO_WIN_10000_TOTAL.setForeground(Color.MAGENTA);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 21;
		mainPanel.add(TO_WIN_10000_TOTAL, c);
		// (Row 21, Column 5)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 21;
		mainPanel.add(TO_WIN_10000_2, c);
		// (Row 21, Column 6)
		TO_WIN_10000_TOTAL_2.setForeground(Color.MAGENTA);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 21;
		mainPanel.add(TO_WIN_10000_TOTAL_2, c);
		// (Row 22, Column 2)
		BET1AMT10k.setForeground(Color.MAGENTA);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 22;
		mainPanel.add(BET1AMT10k, c);
		// (Row 22, Column 3)
		BET1_TOTAL_10000.setForeground(Color.MAGENTA);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 22;
		mainPanel.add(BET1_TOTAL_10000, c);
		// (Row 22, Column 7)
		BET1AMT10k_2.setForeground(Color.MAGENTA);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 7;
		c.gridy = 22;
		mainPanel.add(BET1AMT10k_2, c);
		// (Row 22, Column 8)
		BET1_TOTAL_10000_2.setForeground(Color.MAGENTA);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8;
		c.gridy = 22;
		mainPanel.add(BET1_TOTAL_10000_2, c);
		// (Row 23, Column 2)
		BET2AMT10k.setForeground(Color.MAGENTA);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 23;
		mainPanel.add(BET2AMT10k, c);
		// (Row 23, Column 3)
		BET2_TOTAL_10000.setForeground(Color.MAGENTA);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 23;
		mainPanel.add(BET2_TOTAL_10000, c);
		// (Row 23, Column 7)
		BET2AMT10k_2.setForeground(Color.MAGENTA);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 7;
		c.gridy = 23;
		mainPanel.add(BET2AMT10k_2, c);
		// (Row 23, Column 8)
		BET2_TOTAL_10000_2.setForeground(Color.MAGENTA);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8;
		c.gridy = 23;
		mainPanel.add(BET2_TOTAL_10000_2, c);
		
		
		
		pane.add(mainPanel);
	}
	
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame();
        frame.setTitle("Soccer Brokers: Double Play Solver");
        
        teamOdds.addActionListener(this);
        drawOdds.addActionListener(this);
        //Set up the content pane.
        DoublePlayCalculator(frame.getContentPane());

        //Display the window.
        frame.setSize(1200, 475);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
    	// Setup a solver
    	DoublePlaySolver ds = new DoublePlaySolver();
    	NumberFormat f = NumberFormat.getCurrencyInstance();
    	DecimalFormat p = new DecimalFormat("#.##");
    	// Get the user input for odds
    	String s = teamOdds.getText();
    	String t = drawOdds.getText();
    	// Parse the input to doubles
    	Double x = Double.parseDouble(s);
    	Double y = Double.parseDouble(t);
    	// Calculate bet sizes
    	Double fav = ds.DPFavSolver(x, y);
    	Double draw = ds.DPDrawSolver(x, y);
    	Double fav_weighted = ds.DSFavSolver(x, y);
    	Double draw_weighted = ds.DSDrawSolver(x, y);
    	// Create strings from returned doubles
    	
    	String amount1 = f.format(draw);
    	String amount2 = f.format(fav);
    	String amount3 = f.format(draw_weighted);
    	String amount4 = f.format(fav_weighted);
    	// Update the displayed values 
    	AMT1.setText(amount1);
    	AMT2.setText(amount2);
    	AMT1_2.setText(amount3);
    	AMT2_2.setText(amount4);
    	// Calculate payoffs
    	
    	// If Euro Odds given, convert to American and calculate payoff
    	Double draw2;
    	if (y<100 && y>0){
    		draw2 = draw*(ds.convertOdds(y))/100;
    	}
    	else{
    		draw2 = draw*y/100;
    	}
    	// If Euro Odds given, convert to American and calculate payoff
    	Double fav2;
    	if (x<100 && x>0){
    		fav2 = fav*(ds.convertOdds(x))/100;
    	}
    	else{
    		fav2 = fav*x/100;
    	}
    	// If Euro Odds given, convert to American and calculate payoff
    	Double draw_weighted2;
    	if (y<100 && y>0){
    		draw_weighted2 = draw_weighted*(ds.convertOdds(y))/100;
    	}
    	else{
    		draw_weighted2 = draw_weighted*y/100;
    	}
    	// If Euro Odds given, convert to American and calculate payoff
    	Double fav_weighted2;
    	if (x<100 && x>0){
    		fav_weighted2 = fav_weighted*(ds.convertOdds(x))/100;
    	}
    	else{
    		fav_weighted2 = fav_weighted*x/100;
    	}
    	
    	// Convert payoffs to string
    	String payoff1 = f.format(draw2);
    	String payoff2 = f.format(fav2);
    	String payoff3 = f.format(draw_weighted2);
    	String payoff4 = f.format(fav_weighted2);
    	// Update the payoff values
    	PAY1.setText(payoff1);
    	PAY2.setText(payoff2);
    	PAY1_2.setText(payoff3);
    	PAY2_2.setText(payoff4);
    	
    	
    	// Money needed to win $10
    	Double toWin10 = fav+draw;
    	String toWin10_2 = f.format(toWin10);
    	TO_WIN_10_TOTAL.setText(toWin10_2);
    	// Money needed to draw-save win $10
    	Double toWin10_weighted = fav_weighted+draw_weighted;
    	String toWin10_2_weighted = f.format(toWin10_weighted);
    	TO_WIN_10_TOTAL_2.setText(toWin10_2_weighted);
    	// Calculate % on money
    	Double pcnt = (10/toWin10)*100;
    	Double pcnt2 = (10/toWin10_weighted)*100;
    	// Update the percent displayed
    	String pct = p.format(pcnt);
    	String pct2 = p.format(pcnt2);
    	PERCENT.setText(pct);
    	PERCENT2.setText(pct2);
    	
    	
    	
    	// Money needed to win $100
    	Double toWin100 = toWin10*10;
    	String toWin100_2 = f.format(toWin100);
    	TO_WIN_100_TOTAL.setText(toWin100_2);
    	// Double Play Bet 1 and Bet 2
    	Double bet1_100 = draw*10;
    	Double bet2_100 = fav*10;
    	String bet1_100_s = f.format(bet1_100);
    	String bet2_100_s = f.format(bet2_100);
    	BET1_TOTAL_100.setText(bet1_100_s);
    	BET2_TOTAL_100.setText(bet2_100_s);

    	// Money needed to win $100 weighted
    	Double toWin100_weighted = toWin10_weighted*10;
    	String toWin100_2_weighted = f.format(toWin100_weighted);
    	TO_WIN_100_TOTAL_2.setText(toWin100_2_weighted);
    	// Draw-Saver Bet 1 and Bet 2
    	Double bet1_100_2 = draw_weighted*10;
    	Double bet2_100_2 = fav_weighted*10;
    	String bet1_100_2_s = f.format(bet1_100_2);
    	String bet2_100_2_s = f.format(bet2_100_2);
    	BET1_TOTAL_100_2.setText(bet1_100_2_s);
    	BET2_TOTAL_100_2.setText(bet2_100_2_s);
    	
    	
    	
    	// Money needed to win $1000
    	Double toWin1000 = toWin10*100;
    	String toWin1000_2 = f.format(toWin1000);
    	TO_WIN_1000_TOTAL.setText(toWin1000_2);
    	// Double Play Bet 1 and Bet 2
    	Double bet1_1000 = draw*100;
    	Double bet2_1000 = fav*100;
    	String bet1_1000_s = f.format(bet1_1000);
    	String bet2_1000_s = f.format(bet2_1000);
    	BET1_TOTAL_1000.setText(bet1_1000_s);
    	BET2_TOTAL_1000.setText(bet2_1000_s);
    	
    	// Money needed to win $1000 weighted
    	Double toWin1000_weighted = toWin10_weighted*100;
    	String toWin1000_2_weighted = f.format(toWin1000_weighted);
    	TO_WIN_1000_TOTAL_2.setText(toWin1000_2_weighted);
    	// Draw-Saver Bet 1 and Bet 2
    	Double bet1_1000_2 = draw_weighted*100;
    	Double bet2_1000_2 = fav_weighted*100;
    	String bet1_1000_2_s = f.format(bet1_1000_2);
    	String bet2_1000_2_s = f.format(bet2_1000_2);
    	BET1_TOTAL_1000_2.setText(bet1_1000_2_s);
    	BET2_TOTAL_1000_2.setText(bet2_1000_2_s);  	
    	
    	
    	
    	// Money needed to win $10000
    	Double toWin10000 = toWin10*1000;
    	String toWin10000_2 = f.format(toWin10000);
    	TO_WIN_10000_TOTAL.setText(toWin10000_2);
    	// Double Play Bet 1 and Bet 2
    	Double bet1_10000 = draw*1000;
    	Double bet2_10000 = fav*1000;
    	String bet1_10000_s = f.format(bet1_10000);
    	String bet2_10000_s = f.format(bet2_10000);
    	BET1_TOTAL_10000.setText(bet1_10000_s);
    	BET2_TOTAL_10000.setText(bet2_10000_s);
    	
    	// Money needed to win $1000 weighted
    	Double toWin10000_weighted = toWin10_weighted*1000;
    	String toWin10000_2_weighted = f.format(toWin10000_weighted);
    	TO_WIN_10000_TOTAL_2.setText(toWin10000_2_weighted);
    	// Draw-Saver Bet 1 and Bet 2
    	Double bet1_10000_2 = draw_weighted*1000;
    	Double bet2_10000_2 = fav_weighted*1000;
    	String bet1_10000_2_s = f.format(bet1_10000_2);
    	String bet2_10000_2_s = f.format(bet2_10000_2);
    	BET1_TOTAL_10000_2.setText(bet1_10000_2_s);
    	BET2_TOTAL_10000_2.setText(bet2_10000_2_s);    	
    	
    	
    }
	
}
