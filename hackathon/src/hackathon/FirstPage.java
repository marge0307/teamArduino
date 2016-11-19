package hackathon;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FirstPage extends JFrame{
	public static JButton btnWithraw, btnReceive, btnSend, btnDeposit;
	private JPanel panelButtons;
	public static JPanel holder;
	public static SendPanel sendPanel;
	public void gui()
	{
		sendPanel = new SendPanel();
		holder = new JPanel();
		btnWithraw = new JButton("Withdraw");
		btnSend = new JButton("Send");
		btnReceive = new JButton("Receive");
		btnDeposit = new JButton("Deposit");
		panelButtons = new JPanel();
		panelButtons.add(btnWithraw);
		panelButtons.add(btnReceive);
		panelButtons.add(btnSend);
		panelButtons.add(btnDeposit);
		btnWithraw.setBounds(0, 0, 400, 100);
		btnDeposit.setBounds(0, 190, 400, 100);
		btnSend.setBounds(500, 0, 400, 100);
		btnReceive.setBounds(500, 190, 400, 100);
		btnWithraw.setBackground(Color.GRAY);
		btnDeposit.setBackground(Color.GRAY);
		btnSend.setBackground(Color.GRAY);
		btnReceive.setBackground(Color.GRAY);
		btnReceive.setFont(btnReceive.getFont().deriveFont(30.0f));
		btnSend.setFont(btnSend.getFont().deriveFont(30.0f));
		btnDeposit.setFont(btnDeposit.getFont().deriveFont(30.0f));
		btnWithraw.setFont(btnWithraw.getFont().deriveFont(30.0f));
		btnSend.setForeground(Color.WHITE);
		btnWithraw.setForeground(Color.WHITE);
		btnReceive.setForeground(Color.WHITE);
		btnDeposit.setForeground(Color.WHITE);
		
		panelButtons.setLayout(null);
		panelButtons.setBackground(Color.WHITE);
		holder.add(panelButtons);
		setVisible(true);
		panelButtons.setBounds(150, 200, 900, 800);
		holder.setLayout(null);
		holder.setSize(1200,800);
		setSize(1200,800);
		holder.setBackground(Color.WHITE);
		btnSend.addActionListener(new Listener());
		add(holder);
		add(sendPanel);
		sendPanel.sendPanel();
		sendPanel.setVisible(false);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstPage firstPage = new FirstPage();
		firstPage.gui();
	}

}
