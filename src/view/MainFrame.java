package view;

import java.awt.BorderLayout;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class MainFrame extends JFrame implements ChangeListener{
	private JTabbedPane tabbedPane;
	private SelectedTab selectedTab;
	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MainFrame() {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(3 * screenWidth / 4, 3 * screenHeight / 4);
		setTitle("Studentska slu�ba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		StatusBar statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
		Toolbar toolbar = new Toolbar();
		add(toolbar, BorderLayout.NORTH);

		tabbedPane = new JTabbedPane();
		tabbedPane.addChangeListener(this);
		JPanel studenti = new JPanel();
		JPanel predmeti = new JPanel();
		JPanel profesori = new JPanel();
		
		tabbedPane.addTab("Studenti", studenti);
		tabbedPane.addTab("Predmeti", predmeti);
		tabbedPane.addTab("Profesori", profesori);
		add(tabbedPane, BorderLayout.CENTER);
		
		selectedTab = SelectedTab.STUDENT;
	}
	
	public SelectedTab getSelectedTab()
	{
		return selectedTab;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JTabbedPane tabbedPane = (JTabbedPane)e.getSource();
		int selectedIndex = tabbedPane.getSelectedIndex();
		switch(selectedIndex)
		{
			case 0:
			{
				selectedTab = SelectedTab.STUDENT;
				break;
			}
			case 1:
			{
				selectedTab = SelectedTab.PREDMET;
				break;
			}
			case 2:
			{
				selectedTab = SelectedTab.PROFESOR;
				break;
			}
			default:
			{
				return;
			}
		}
		
	}
	
	
	
	
}
