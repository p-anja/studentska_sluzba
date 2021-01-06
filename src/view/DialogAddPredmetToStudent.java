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
import model.Predmet;
import model.PredmetBase;
import model.Profesor;
import model.ProfesorBase;
import model.Student;
import model.StudentBase;

	
	public class DialogAddPredmetToStudent extends JDialog implements ActionListener{
		private JButton btnOk;
		private JButton btnCancel;
		private String selectedPredmet;
		private JList listPredmet;
		
		public DialogAddPredmetToStudent(MainFrame instance, String title, boolean b) {
			super(instance, title, b);
			
			setTitle("Dodavanje predmeta");
			setSize(400, 400);
			setLocationRelativeTo(null);
			setModal(true);
			setResizable(false);
			
			JPanel panCommands = new JPanel(new FlowLayout(FlowLayout.CENTER));
			btnOk = new JButton("Dodaj");
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
			Student s = StudentJTable.getInstance().selected();
			
			for(Predmet p : PredmetBase.getInstance().getListPredmet()) {
					
				
				if(!s.getNepolozeniIspiti().contains(p) && !s.getPolozeniIspiti().contains(p)
						&& s.getTrenutnaGodStudija() >= p.getGodina() ) {
						
						listModel.addElement(p.getSifra() + " " + p.getNaziv());
					}
					
			}
			listPredmet = new JList(listModel);
			listPredmet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    JScrollPane scrollPane = new JScrollPane(listPredmet);
		    
			JLabel lblPredmeti = new JLabel("Predmeti");
			
			add(lblPredmeti, BorderLayout.NORTH);
			add(scrollPane, BorderLayout.CENTER);
			add(panCommands, BorderLayout.SOUTH);
			
		}
		
		public void actionPerformed(ActionEvent arg0) {
			selectedPredmet = (String) listPredmet.getSelectedValue();
			if (selectedPredmet == null) {
				JOptionPane.showMessageDialog(null, "Predmet nije selektovan.", "Upozorenje!",
						JOptionPane.ERROR_MESSAGE);
			}
			else {
				String[] parts = selectedPredmet.split(" ");
				String sifra = parts[0];
				String naziv = parts[1];
				for(Predmet p : PredmetBase.getInstance().getListPredmet()) {
					
					if(sifra.equals(p.getSifra())) {
					
						StudentBase.getInstance().getRow(MainFrame.getInstance().getSelectedRow()).getNepolozeniIspiti().add(p);
					}
				}
				
				JOptionPane.showMessageDialog(null, "Predmet uspešno izabran!");
				
				dispose();
			}
			
		}
		
	}

