package view;

import javax.swing.JToolBar;


import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.ProfesorBase;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
					break;
				}
				case PREDMET:
				{
					break;
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
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton search = new JButton();
		search.setToolTipText("Pretraži");
		search.setIcon(new ImageIcon("images/search.png"));
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JTextField txtSearch = new JTextField();
		Dimension dimTxt = new Dimension(200, 20);
		txtSearch.setPreferredSize(dimTxt);
		txtSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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

