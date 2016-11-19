package hackathon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Listener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DBcon db = new DBcon();
		if(e.getSource().equals(FirstPage.btnSend))
		{
			FirstPage.holder.setVisible(false);
			FirstPage.sendPanel.setVisible(true);
		}
		if(e.getSource().equals(SendPanel.btnSubmit))
		{
			String name = SendPanel.txtName.getText();
			if(db.selectName(name))
			{
				SendPanel.coinPanel.setVisible(true);
				SendPanel.btnSend.setVisible(true);
				SendPanel.txtName.setEnabled(false);
			}
		}
		if(e.getSource().equals(SendPanel.btnSend))
		{
			db.updateData(SendPanel.txtName.getText(),SerialListener.coins);
		}
	}

}
