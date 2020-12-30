package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import controller.PredmetController;
import model.PredmetBase;
import model.ProfesorBase;
import model.StudentBase;

public class MenuBar extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static MenuBar instance = null;
	private JMenu file;
	private JMenu edit;
	private JMenu help;
	private JMenuItem miClose;
	private JMenuItem miNew;
	private JMenuItem miEdit;
	private JMenuItem miDelete;
	private JMenuItem miHelp;
	private JMenuItem miAbout;
	private JTextArea ta;
	private JTextArea about;
	private JScrollPane scrollPane;
	
	public static MenuBar getInstance() {
		if(instance == null) {
			instance = new MenuBar();
		}
		return instance;
	}

	public MenuBar() {
		
		file= new JMenu("File");
		edit= new JMenu("Edit");
		help= new JMenu("Help");
		
		file.setMnemonic(KeyEvent.VK_F);
		edit.setMnemonic(KeyEvent.VK_E);
		help.setMnemonic(KeyEvent.VK_H);
		
		miNew = new JMenuItem("New");
		miNew.setIcon(new ImageIcon("images/new.png"));
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miNew.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(MainFrame.getInstance().getSelectedTab()) {
				
				case STUDENT:
				{
					DialogAddStudent dialog = new DialogAddStudent(MainFrame.getInstance(),
					"Dodavanje novog studenta", true);
					dialog.setVisible(true);
					miNew.setSelected(false);
					break;
				}
				case PREDMET:
				{
					DialogAddPredmet dialog = new DialogAddPredmet(MainFrame.getInstance(),
					"Dodavanje novog predmeta", true);
					dialog.setVisible(true);
					miNew.setSelected(false);
					break;
				}
				case PROFESOR:
				{	DialogAddProfesor dialog = new DialogAddProfesor(MainFrame.getInstance(),
					"Dodavanje novog profesora", true);
					dialog.setVisible(true);
					miNew.setSelected(false);
					break;
				}
				default:
				{
					return;
				}
				
			}
				
			}
			
		});
		file.add(miNew);
		file.addSeparator();
		
		miClose = new JMenuItem("Close");
		miClose.setIcon(new ImageIcon("images/close.png"));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		file.add(miClose);

		miEdit = new JMenuItem("Edit");
		miEdit.setIcon(new ImageIcon("images/edit.png"));
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(MainFrame.getInstance().getSelectedTab()) {
				
				case PROFESOR:
					if (MainFrame.getInstance().getSelectedRow() >= 0 &&  
					MainFrame.getInstance().getSelectedRow() < ProfesorBase.getInstance().getProfesorCount()) {
						DialogEditProfesor dialog = new DialogEditProfesor(MainFrame.getInstance(),
								"Izmena profesora", true);
								dialog.setVisible(true);
								edit.setSelected(false);
								break;
					} else {
						JOptionPane.showMessageDialog(null, "Profesor nije selektovan.", "Upozorenje!",
								JOptionPane.ERROR_MESSAGE);
					}
				case STUDENT:
				{
					if (MainFrame.getInstance().getSelectedRow() >= 0 &&  
							MainFrame.getInstance().getSelectedRow() < StudentBase.getInstance().getStudentCount()) {
								DialogEditStudent dialog = new DialogEditStudent(MainFrame.getInstance(),
										"Izmena studenta", true);
										dialog.setVisible(true);
										edit.setSelected(false);
										break;
							} else {
								JOptionPane.showMessageDialog(null, "Student nije selektovan.", "Upozorenje!",
										JOptionPane.ERROR_MESSAGE);
								break;
							}
				}
				case PREDMET:
				{
					if (MainFrame.getInstance().getSelectedRow() >= 0 &&  
							MainFrame.getInstance().getSelectedRow() < PredmetBase.getInstance().getPredmetCount()) {
								DialogEditPredmet dialog = new DialogEditPredmet(MainFrame.getInstance(),
										"Izmena predmeta", true);
										dialog.setVisible(true);
										edit.setSelected(false);
										break;
							} else {
								JOptionPane.showMessageDialog(null, "Predmet nije selektovan.", "Upozorenje!",
										JOptionPane.ERROR_MESSAGE);
								break;
							}
				}
					

				
			}
			}
		});
		edit.add(miEdit);
		edit.addSeparator();
		
		miDelete = new JMenuItem("Delete");
		miDelete.setIcon(new ImageIcon("images/delete.png"));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		miDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = MainFrame.getInstance().getSelectedRow();
				switch(MainFrame.getInstance().getSelectedTab()) {
				case PREDMET:
					if (row >= 0 && row < PredmetBase.getInstance().getPredmetCount()) {
						int option = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete predmet?",
								"Brisanje predmeta", JOptionPane.YES_NO_OPTION);
						if ( option == JOptionPane.YES_OPTION) {
							PredmetController.getInstance().deletePredmet(row);
							JOptionPane.showMessageDialog(null, "Predmet je obrisan!");
						} else {
							JOptionPane.showMessageDialog(null, "Predmet nije obrisan.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Predmet nije selektovan.", "Upozorenje!",
								JOptionPane.ERROR_MESSAGE);
					}
					miDelete.setSelected(false);
					break;
				}
			}
		});
		edit.add(miDelete);

		miHelp = new JMenuItem("Help");
		miHelp.setIcon(new ImageIcon("images/help.png"));
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta = new JTextArea("\t\t\t NAČIN KORIŠĆENJA APLIKACIJE \n\n" + "TABELA STUDENATA\n"
						+ "1.Dodavanje studenta je moguće pomoću dugmeta u toolbar-u ili preko File -> New\n"
						+ "Validacija unosa:\n" + "Datum je u formatu - dd.mm.yyyy.\n"
						+ "Broj telefona može sadržati bilo koju cifru i znakove / i -.\n"
						+ "Indeks je u formatu XX(X)00(0)/0000 (minimalno prva dva mala ili velika slova, maksimalno 3).\n"
						+ "Email – bilo_šta@bilo_šta.\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da dodate studenta\n\n\n"
						+ "TABELA PROFESORA\n"
						+ "1.Dodavanja profesora na predmet moguće je pomoću dugmeta u toolbar-u ili preko File-> New\n"
						+ "Validacija unosa:\n"
						+"Broj lične karte - 9 cifara sa navodnicima na pocetku i kraju\n"
						+ "Datum u formatu – dd.mm.yyyy.\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da dodate profesora\n\n\n"
						+ "Prečice:\n" + "ctrl + N – New Student/Profesor u zavisnosti od otvorenog taba\n" 
					 	+ "ctrl + H – Help\n"
						+ "ctrl + A - About App\n\n" 
					 	+"Mnemonici:\n"
						+"alt + F - File\n" 
					 	+"alt + E - Edit\n"
						+"alt + H - Help\n" + "", 20, 70);

				scrollPane = new JScrollPane(ta);
				JOptionPane.showMessageDialog(null, scrollPane);
				
			}
			
		});
		help.add(miHelp);
		help.addSeparator();
		
		miAbout = new JMenuItem("About");
		miAbout.setIcon(new ImageIcon("images/about.png"));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		miAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				about = new JTextArea(	"Java Aplikacija Studentska služba omogućava rad sa studentima, profesorima i predmetima.\n\n"
						+ "Kratak opis korišćenja aplikacije:\n"
						+ "1.Tabela student ima mogućnost dodavanja, brisanja, izmene, prikaza predmeta koje sluša student i pretragu studenata.\n"
						+ "2.Tabela predmet ima mogućnost dodavanja, brisanja, izmene, pretrage predmeta, dodavanja studenta na predmet, brisanja studenta sa predmeta,\n"
						+ " dodavanja profesora na predmet, brisanja profesora sa predmeta, prikaza liste profesora i studenata na predmetu.\n"
						+ "3.Tabela profesor ima mogćnost dodavanja, brisanja, izmene profesora i prikaza predmeta na kojima predaje profesor.\n\n"
						+"Student 1:\n"
						+"Anja Pešić, rođena 17.8.1999. u Novom Sadu, student Računarstva i automatike, indeks RA36-2018.\n"
						+"Student 2:\n"
						+"Tanja Cupać, rođena 24.1.2000. u Somboru, student Računarstva i automatike, indeks RA40-2018.\n");
				
				scrollPane = new JScrollPane(about);
				JOptionPane.showMessageDialog(null,	scrollPane);

			}
			
		});
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
		
	}

}