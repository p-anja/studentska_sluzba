package view;

import javax.swing.JToolBar;




import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentController;
import model.ProfesorBase;
import model.StudentBase;
import model.PredmetBase;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Toolbar extends JToolBar {

	public Toolbar() {
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		setLayout(new BorderLayout());
		
		JPanel buttonsPanel = new JPanel();
		JPanel searchPanel = new JPanel();
		
		
		JButton add = new JButton();
		add.setToolTipText("Dodaj");
		add.setIcon(new ImageIcon("images/new.png"));
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				switch(MainFrame.getInstance().getSelectedTab()) {
					
				case STUDENT:
				{
					DialogAddStudent dialog = new DialogAddStudent(MainFrame.getInstance(),
					"Dodavanje novog studenta", true);
					dialog.setVisible(true);
					add.setSelected(false);
					break;
				}
				case PREDMET:
				{
					DialogAddPredmet dialog = new DialogAddPredmet(MainFrame.getInstance(),
					"Dodavanje novog predmeta", true);
					dialog.setVisible(true);
					add.setSelected(false);
					break;
				}
				case PROFESOR:
				{	DialogAddProfesor dialog = new DialogAddProfesor(MainFrame.getInstance(),
					"Dodavanje novog profesora", true);
					dialog.setVisible(true);
					add.setSelected(false);
					break;
				}
				default:
				{
					return;
				}
				
			}
		}
		});
		
		JButton edit = new JButton();
		edit.setToolTipText("Izmeni");
		edit.setIcon(new ImageIcon("images/edit.png"));
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(MainFrame.getInstance().getSelectedTab()) {
				
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
						break;
					}
					
				default:
				{
					return;
				}
				
			}
			}
		});
		
		
		JButton delete = new JButton();
		delete.setToolTipText("Obriši");
		delete.setIcon(new ImageIcon("images/delete.png"));
		delete.addActionListener(new ActionListener() {
			
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
					delete.setSelected(false);
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
					delete.setSelected(false);
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
					delete.setSelected(false);
					break;
					
				default:
				{
					return;
				}
			
				}
			}
		});
		
		
		JTextField txtSearch = new JTextField();
		Dimension dimTxt = new Dimension(200, 20);
		txtSearch.setPreferredSize(dimTxt);
		txtSearch.setToolTipText("Upis za pretragu");
		txtSearch.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				if (txt.getText().trim().length() == 0) {
					switch(MainFrame.getInstance().getSelectedTab()) {
					case STUDENT:
					{
						break;
					}
					case PREDMET:
					{
						PredmetController.getInstance().searchPredmet("");
						MainFrame.getInstance().refresh();
					}
					case PROFESOR:
					{
						ProfesorController.getInstance().searchProfesor("");
						MainFrame.getInstance().refresh();
					}
						
					default:
					{
						return;
					}
				}

			}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		JButton search = new JButton();
		search.setToolTipText("Pretraži");
		search.setIcon(new ImageIcon("images/search.png"));
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(MainFrame.getInstance().getSelectedTab()) {
				
				case STUDENT:
				{
					break;
				}
				case PREDMET:
				{
					String s = txtSearch.getText();
					PredmetController.getInstance().searchPredmet(s);
					search.setSelected(false);
				}
				case PROFESOR:
				{	
					String s = txtSearch.getText();
					ProfesorController.getInstance().searchProfesor(s);
					search.setSelected(false);
	
				}
					default:
				{
					return;
				}
			
				}
			}
		});


		
		buttonsPanel.add(add);
		buttonsPanel.add(edit);
		buttonsPanel.add(delete);
		add(buttonsPanel, BorderLayout.WEST);
		
		
		searchPanel.add(txtSearch);
		searchPanel.add(search);
		add(searchPanel, BorderLayout.EAST);
		
		
	}
		}
	
	

