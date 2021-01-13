package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentController;
import model.DataBase;
import model.PredmetBase;
import model.ProfesorBase;
import model.StudentBase;

public class MenuBar extends JMenuBar{



	private static final long serialVersionUID = 1665172609718153640L;
	private static MenuBar instance = null;
	DataBase dp = new DataBase();
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
		miClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int choice = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
						"Da li ste sigurni da zelite da zatvorite aplikaciju?", "Zatvaranje aplikacije",
						JOptionPane.YES_NO_OPTION);

				if (choice == JOptionPane.YES_OPTION) {
					try {
						dp.save();

					} catch (Exception t) {

					}
					System.exit(0);
				}
			}
			
		});
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
										MainFrame.getInstance().refresh();
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
				
				case STUDENT:
					if (row >= 0 && row < StudentBase.getInstance().getStudentCount()) {
						int option = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete studenta?",
								"Brisanje studenta", JOptionPane.YES_NO_OPTION);
						if ( option == JOptionPane.YES_OPTION) {
							StudentController.getInstance().deleteStudent(row);
							JOptionPane.showMessageDialog(null, "Student je obrisan!");
						} else {
							JOptionPane.showMessageDialog(null, "Student nije obrisan.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Student nije selektovan.", "Upozorenje!",
								JOptionPane.ERROR_MESSAGE);
					}
					miDelete.setSelected(false);
					break;
					
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
					
				case PROFESOR:
					if (row >= 0 && row < ProfesorBase.getInstance().getProfesorCount()) {
						int option = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete profesora?",
								"Brisanje profesora", JOptionPane.YES_NO_OPTION);
						if ( option == JOptionPane.YES_OPTION) {
							ProfesorController.getInstance().deleteProfesor(row);
							JOptionPane.showMessageDialog(null, "Profesor je obrisan!");
						} else {
							JOptionPane.showMessageDialog(null, "Profesor nije obrisan.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Profesor nije selektovan.", "Upozorenje!",
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
						+ "1.Dodavanje studenta je moguće pomoću dugmeta u toolbar-u ili preko File -> New ukoliko je otvoren tab Studenti\n"
						+ "Validacija unosa:\n" + "Datum je u formatu - dd.mm.yyyy.\n"
						+ "Broj telefona može sadržati bilo koju cifru i znakove / i -.\n"
						+ "Indeks je u formatu XX(X)00(0)/0000 (prva dva velika slova, maksimalno 3) i mora biti jedinstven.\n"
						+ "Email – bilo_šta@bilo_šta.\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da dodate studenta\n"
						+"2.Izmena studenta je moguća pomoću dugmeta u toolbar-u ili preko File->Edit\n"
						+"Validacija unosa je ista kao pri dodavanju studenta, dok se broj indeksa studenta"
						+ " ne može menjati.\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da izmenite studenta\n"
						+"Takođe, u okviru dijaloga za izmenu studenta postoje tabovi sa položenim i "
						+ "nepoloženim ispitima.\n"
						+"Klikom na prvi otvara se lista položenih ispita sa ocenama za selektovanog studenta,"
						+ "kao i njegov prosek ocena i broj ESPB bodova. Postoji mogućnost \n poništavanja "
						+ "ocene kllikom na dugme i prelaska "
						+ "predmeta u listu nepoloženih. \n Klikom na drugi tab otvara se lista nepoloženih"
						+ " predmeta gde postoji mogućnost dodavanja"
						+ "novih predmeta koje student sluša, brisanje predmeta i upisivanje ocene ukoliko"
						+ " je student položio \ntaj predmet. Tada se otvara"
						+ "manji dijalog i upisuje se ocena i datum kada je položen ispit, a zatim se on "
						+ "prikazuje u listi položenih ispita.\n"
						+"3.Brisanje studenta je moguće pomoću dugmeta u toolbar-u ili preko File->Delete\n"
						+"4.Pretraga studenata je moguća u okviru toolbar-a upisivanjem traženog studenta u"
						+ " obliku <prezime>, "
						+ "<prezime ime> ili <prezime ime indeks> pri čemu se mogu uneti i delovi ovih reči"
						+ " kao i velika i mala slova.\n"
						+"5.Sortiranje studenata je moguće klikom na naziv kolone čiji elementi treba da se "
						+ "sortiraju. Nasumičnim klikovima se menja"
						+ "opadajuće i rastuće sortiranje.\n\n\n"
						
						+ "TABELA PREDMETA\n"
						+ "1.Dodavanje predmeta je moguće pomoću dugmeta u toolbar-u ili preko File -> New "
						+ "ukoliko je otvoren tab Predmeti\n"
						+ "Validacija unosa:\n" + "Šifra se sastoji od malih ili velikih slova i brojeva i "
								+ "mora biti jedinstvena.\n"
						+ "Naziv može sadržati bilo koja slova.\n"
						+ "ESPB bodovi se sastoje isključivo od brojeva.\n"
						+ "Klikom na dugme + moguće je dodati profesora na predmet ukoliko on nema profesora."
						+ " Tada se otvara lista svih predavača"
						+ "i mi možemo da izaberemo jednog profesora koji će konačno biti dodat na \npredmet"
						+ " klikom na dugme 'potvrdi'. Zatim se"
						+ "u listu predmeta koje taj profesor predaje, dodaje i trenutno selektovan predmet. "
						+ "Po istom principu radi uklanjanje profesora"
						+ "sa predmeta ukoliko je on postojao pre toga.\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da dodate predmet.\n"
						+"2.Izmena predmeta je moguća pomoću dugmeta u toolbar-u ili preko File->Edit\n"
						+"Validacija unosa je ista kao pri dodavanju predmeta, dok se šifra predmeta ne može "
						+ "menjati.\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da izmenite predmet\n"
						+"3.Brisanje predmeta je moguće pomoću dugmeta u toolbar-u ili preko File->Delete\n"
						+ "Ukoliko se neki predmet obriše iz baze predmeta, on je takođe uklonjen iz položenih/"
						+ "nepoloženih ispita studenta"
						+ ",kao i iz liste predmeta koje profesor predaje.\n"
						+"4.Pretraga predmeta je moguća u okviru toolbar-a upisivanjem traženog predmeta u "
						+ "obliku <naziv>.\n"
						+"5.Sortiranje predmeta je moguće klikom na naziv kolone čiji elementi treba da se sortiraju."
						+ " Nasumičnim klikovima se menja"
						+ "opadajuće i rastuće sortiranje.\n\n\n"
						
						
						+ "TABELA PROFESORA\n"
						+ "1.Dodavanja profesora na predmet moguće je pomoću dugmeta u toolbar-u ili preko File-> New\n"
						+ " ukoliko je otvoren tab Profesori"
						+ "Validacija unosa:\n"
						+"Broj lične karte ima 9 cifara i mora biti jedinstven.\n"
						+ "Datum u formatu dd.mm.yyyy.\n"
						+"2.Izmena profesora je moguća pomoću dugmeta u toolbar-u ili preko File->Edit\n"
						+"Validacija unosa je ista kao pri dodavanju profesora, dok se broj lične karte ne može"
						+ " menjati.\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da izmenite studenta\n"
						+ "U okviru ovog dijaloga postoji tab Predmeti gde se nalazi spisak svih predmeta koje "
						+ "profesor predaje. Klikom na dugme 'dodaj predmet'"
						+ "moguće je dodati predmet profesoru i tada se i u bazi predmeta dodaje \nselektovani profesor."
						+ " Po istom principu može se ukloniti predmet"
						+ "sa profesora i u bazi predmeta ukloniti selektovani profesor."
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da dodate profesora\n"
						+"3.Brisanje profesora je moguće pomoću dugmeta u toolbar-u ili preko File->Delete\n"
						+ "Na taj način briše se i u bazi predmeta, odnosno predmeti koje je obrisani profesor "
						+ "predavao ostaju bez predavača.\n"
						+"4.Pretraga profesora je moguća u okviru toolbar-a upisivanjem traženog studenta u obliku <prezime>, "
						+ "<prezime ime> pri čemu se mogu uneti i delovi ovih reči kao i velika i mala slova.\n"
						+"5.Sortiranje profesora je moguće klikom na naziv kolone čiji elementi treba da se sortiraju. "
						+ "Nasumičnim klikovima se menja"
						+ "opadajuće i rastuće sortiranje.\n\n\n"
						
						+"MENI BAR\n"
						+ "U okviru meni bara klikom na File otvara se padajući meni koji sadrži New i Close."
						+ "Pomoću New se vrši dodavanje entiteta po principu otvorenog taba koji je gore naveden, "
						+ "dok se klikom na Close"
						+ "zatvara aplikacija što je moguće \nučiniti i klikom na X. Klikom na Edit u okviru meni bara"
						+ " otvara se padajući meni"
						+ "koji sadrži Edit i Delete. Pomoću Edit se otvara dijalog za izmenu entiteta, a klikom na "
						+ "Delete dijalog za brisanje"
						+ "entiteta. Ukoliko kliknete Help moći \nćete da izaberete \nAbout gde se dobijaju informacije o"
						+ " samoj aplikaciji i njenim autorima, dok"
						+ "se klikom na Help dobija detaljan opis korišćenja aplikacije.\n\n\n"
						
						+"STATUS BAR\n"
						+ "U status baru prikazano je trenutno vreme i datum.\n\n\n"
						+ "TOOLBAR\n"
						+ "tToolbar sadrži dugme za dodavanje, izmenu i brisanje entiteta,\n"
						+ " kao i polje za pretragu i dugme za pokretanje pretrage.\n\n\n"
						
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