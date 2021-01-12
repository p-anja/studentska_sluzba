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

import model.DataBase;



public class MainFrame extends JFrame implements ChangeListener{
	
	private static final long serialVersionUID = -966061532856661365L;
	private JTabbedPane tabbedPane;
	private SelectedTab selectedTab;
	private StudentTablePanel panelStudent;
	private ProfesorTablePanel panelProfesor;
	private PredmetTablePanel panelPredmet;
	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MainFrame() {
		DataBase db = new DataBase();

		db.input();

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
		
		panelStudent = new StudentTablePanel();
		panelProfesor = new ProfesorTablePanel();
		panelPredmet = new PredmetTablePanel();
		
		tabbedPane.addTab("Studenti", panelStudent);
		tabbedPane.addTab("Predmeti", panelPredmet);
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

						db.save();
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
		switch(MainFrame.getInstance().getSelectedTab()) {
		
		case STUDENT:
		{
			AbstractTableModelStudent modelS = panelStudent.getModel();
			modelS.fireTableDataChanged();
			validate();
			break;
		}
		case PREDMET:
		{
			AbstractTableModelPredmet modelPredmet = panelPredmet.getModel();
			modelPredmet.fireTableDataChanged();
			validate();
			break;
		}
		case PROFESOR:
		{	
			AbstractTableModelProfesor modelProfesor = panelProfesor.getModel();
			modelProfesor.fireTableDataChanged();
			validate();
			break;
		}
		default:
		{
			return;
		}
	}
	}
	public int getSelectedRow() {
		switch(MainFrame.getInstance().getSelectedTab()) {
		
		case STUDENT:
		{
			return panelStudent.getStudentTable().getSelectedRow();
		}
		case PREDMET:
		{
			return panelPredmet.getPredmetTable().getSelectedRow();
		}
		case PROFESOR:
		{	
			return panelProfesor.getProfesorTable().getSelectedRow();
		}
	}
		return -1;
	}

	public ProfesorTablePanel getPanelProfesor() {
		return panelProfesor;
	}

	public void setPanelProfesor(ProfesorTablePanel panelProfesor) {
		this.panelProfesor = panelProfesor;
	}

	public PredmetTablePanel getPanelPredmet() {
		return panelPredmet;
	}

	public void setPanelPredmet(PredmetTablePanel panelPredmet) {
		this.panelPredmet = panelPredmet;
	}
	
	public StudentTablePanel getPanelStudent() {
		return panelStudent;
	}
	
	public void setPanelStudent(StudentTablePanel panelStudent) {
		this.panelStudent = panelStudent;
	}

	
}

