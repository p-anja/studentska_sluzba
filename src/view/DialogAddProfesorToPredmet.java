package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controller.PredmetController;
import model.PredmetBase;
import model.Profesor;
import model.ProfesorBase;

	
	public class DialogAddProfesorToPredmet extends JDialog implements ActionListener{
		private JButton btnOk;
		private JButton btnCancel;
		private String selectedProfesor;
		private JList listProfesor;
		private Profesor prof;
		
		public DialogAddProfesorToPredmet(MainFrame instance, String title, boolean b) {
			super(instance, title, b);
			
			setTitle("Odaberi profesora");
			setSize(400, 400);
			setLocationRelativeTo(null);
			setModal(true);
			setResizable(false);
			
			JPanel panCommands = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			btnOk = new JButton("Potvrdi");
			btnOk.addActionListener(this);
			btnOk.setBackground(new Color(255, 205, 193));
			btnCancel = new JButton("Odustani");
			btnCancel.setBackground(new Color(255, 205 ,193));
			btnCancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
			});
			
			panCommands.add(btnCancel);
			panCommands.add(btnOk);
			
			DefaultListModel listModel;
			listModel = new DefaultListModel();
			for(Profesor p : ProfesorBase.getInstance().getListProfesor()) {
				
					listModel.addElement(p.getIme() + " " + p.getPrezime());
			}
			listProfesor = new JList(listModel);
		    listProfesor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    JScrollPane scrollPane = new JScrollPane(listProfesor);
		    
			JLabel lblProfesori = new JLabel("Profesori");
			
			add(lblProfesori, BorderLayout.NORTH);
			add(scrollPane, BorderLayout.CENTER);
			add(panCommands, BorderLayout.SOUTH);
			
		}
		
		public void actionPerformed(ActionEvent arg0) {
			selectedProfesor = (String) listProfesor.getSelectedValue();
			if (selectedProfesor == null) {
				JOptionPane.showMessageDialog(null, "Profesor nije selektovan.", "Upozorenje!",
						JOptionPane.ERROR_MESSAGE);
			}
			else {
				String[] parts = selectedProfesor.split(" ");
				String ime = parts[0];
				String prezime = parts[1];
				for(Profesor p : ProfesorBase.getInstance().getListProfesor()) {
					
					if(ime.equals(p.getIme()) && prezime.equals(p.getPrezime())) {
						
						prof = p;
						
					}
				}
				
				JOptionPane.showMessageDialog(null, "Profesor uspešno izabran!");
				dispose();
			}
			
		}
		
		public Profesor getProf() {
			return this.prof;
		}
	}

