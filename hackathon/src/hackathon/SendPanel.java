package hackathon;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SendPanel extends JPanel{
	public static JTextField txtName;
	public static JButton btnSubmit, btnSend;
	private JLabel lblName;
	public SerialListener serialListener;
	public static JPanel coinPanel, panelPop;
	private JLabel lblInsertCoin;
	public static JLabel lblAmount, lblTransNum;
	public void sendPanel()
	{
		lblTransNum = new JLabel();
		panelPop = new JPanel();
		btnSend = new JButton("Send");
		lblAmount = new JLabel();
		lblInsertCoin = new JLabel("Received Money:     ");
		coinPanel = new JPanel();
		txtName = new JTextField();
		btnSubmit = new JButton("Submit");
		lblName = new JLabel("Name:");
		serialListener = new SerialListener("SendPanel");
		add(panelPop);
		add(txtName);
		add(btnSubmit);
		add(lblName);
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);
		
		lblName.setBounds(200, 200, 100, 50);
		lblName.setFont(lblName.getFont().deriveFont(30.0f));
		btnSubmit.setFont(btnSubmit.getFont().deriveFont(20.0f));
		btnSubmit.setForeground(Color.WHITE);
		txtName.setBounds(350, 200, 400, 50);
		btnSubmit.setBounds(770, 200, 150, 50);
		btnSubmit.setBackground(Color.GRAY);
		setLayout(null);
		setSize(1200,800);
		btnSubmit.addActionListener(new Listener());
		serialListener.initialize();
		serialListener.portConnect();
		add(coinPanel);
		coinPanel.setVisible(false);
		coinPanel.add(lblInsertCoin);
		coinPanel.add(lblAmount);
		lblInsertCoin.setFont(lblInsertCoin.getFont().deriveFont(30.0f));
		lblAmount.setFont(lblAmount.getFont().deriveFont(30.0f));
		lblInsertCoin.setBounds(0, 0, 300, 50);
		lblAmount.setBounds(300, 0, 100, 50);
		coinPanel.setLayout(null);
		coinPanel.setBackground(new Color(255,255,255,255));
		coinPanel.setBounds(200, 400, 500, 50);
		add(btnSend);
		btnSend.setFont(btnSend.getFont().deriveFont(20.0f));
		btnSend.setBackground(Color.GRAY);
		btnSend.setForeground(Color.WHITE);
		btnSend.setBounds(200, 500, 150, 50);
		btnSend.setVisible(false);
		btnSend.addActionListener(new Listener());
		panelPop.setBounds(350, 250, 500, 300);
		panelPop.setBackground(new Color(200,200,200, 255));
		panelPop.add(lblTransNum);
		lblTransNum.setBounds(50, 100, 450, 100);
		lblTransNum.setFont(lblTransNum.getFont().deriveFont(30.0f));
		lblTransNum.setForeground(Color.WHITE);
		panelPop.setLayout(null);
		panelPop.setVisible(false);
		
	}

}
