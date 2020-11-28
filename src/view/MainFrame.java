package view;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class MainFrame extends JFrame {
	
	public MainFrame() {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(3 * screenWidth / 4, 3 * screenHeight / 4);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		StatusBar statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
		Toolbar toolbar = new Toolbar();
		add(toolbar, BorderLayout.NORTH);

		
		JTabbedPane tabbedPane = new JTabbedPane();
		JPanel studenti = new JPanel();
		JPanel predmeti = new JPanel();
		JPanel profesori = new JPanel();
		
		tabbedPane.addTab("Studenti", studenti);
		tabbedPane.addTab("Predmeti", predmeti);
		tabbedPane.addTab("Profesori", profesori);
		add(tabbedPane, BorderLayout.CENTER);
		
	}
}
