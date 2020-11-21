package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel implements Runnable{
	
	private Thread thread;
	private JLabel time;

	@Override
	public void run() {
		try {
			do {
				DateFormat data = new SimpleDateFormat("hh:mm   dd.MM.yyyy.     ");
				Calendar calendar = Calendar.getInstance();
				time.setText(data.format(calendar.getTime()));
				Thread.sleep(1000);
			} while (thread.isAlive());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public StatusBar() {
		
		setPreferredSize(new Dimension(100, 30));
		setLayout(new BorderLayout());
		
		JLabel title = new JLabel("     Studentska sluzba");
		add(title, BorderLayout.WEST);
		
		time = new JLabel();

		add(time, BorderLayout.EAST);
		thread = new Thread(this);
		thread.start();
	}
}