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
			Thread pop = new Thread()
					{
						public void run()
						{
							String name = SendPanel.txtName.getText();
							int coinz = SerialListener.coins;
							int trans = DBcon.randomWithRange(1000000, 9999999);
							
							String accnum = db.selectforacc(name);
							db.insertData(trans, coinz, accnum);
							
							SendPanel.lblTransNum.setText("Your transaction no. "+trans);
							SendPanel.panelPop.setVisible(true);
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							SendPanel.panelPop.setVisible(false);
						}
					};
			pop.start();
		}
	}

}
