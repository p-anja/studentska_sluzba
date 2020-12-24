package view;

import java.awt.BorderLayout;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class MainFrame extends JFrame implements ChangeListener{
	
	private JTabbedPane tabbedPane;
	private SelectedTab selectedTab;
	private StudentTablePanel panelStudent;
	private ProfesorTablePanel panelProfesor;
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
		setTitle("Studentska služba");
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
		JPanel predmeti = new JPanel();
		JPanel profesori = new JPanel();
		
		panelStudent = new StudentTablePanel();
		panelProfesor = new ProfesorTablePanel();
		
		tabbedPane.addTab("Studenti", panelStudent);
		tabbedPane.addTab("Predmeti", predmeti);
		tabbedPane.addTab("Profesori", panelProfesor);
		add(tabbedPane, BorderLayout.CENTER);
		
		selectedTab = SelectedTab.STUDENT;
		
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				JFrame frame = (JFrame) e.getComponent();
				int choice = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da zatvorite aplikaciju?",
						"Close", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {

					try {

						//bp.cuvanje();
					} catch (Exception t) {
						// TODO: handle exception
					}
					frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				} else {
					frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				}
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
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
	
	public void refresh() {
		AbstractTableModelStudent modelS = panelStudent.getModel();
		modelS.fireTableDataChanged();
		validate();
	}

	
}
