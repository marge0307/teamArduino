package hackathon;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SendPanel extends JPanel{
	public static JTextField txtName;
	public static JButton btnSubmit;
	private JLabel lblName;
	public void sendPanel()
	{
		txtName = new JTextField();
		btnSubmit = new JButton("Submit");
		lblName = new JLabel("Name:");
		
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
		
	}

}
