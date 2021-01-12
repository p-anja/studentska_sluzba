package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import model.Predmet;
import model.PredmetBase;
import model.ProfesorBase;

public class DialogAddPredmetToProfesor extends JDialog implements ActionListener{

	private static final long serialVersionUID = -7981006772785670384L;
	private JButton btnOk;
	private JButton btnCancel;
	private String selectedPredmet;
	private JList listPredmet;
	
	public DialogAddPredmetToProfesor(MainFrame instance, String title, boolean b) {
		super(instance, title, b);
		
		setTitle("Dodaj predmet");
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
		for(Predmet p : PredmetBase.getInstance().getListPredmet()) {
			if(!ProfesorBase.getInstance().getRow(MainFrame.getInstance().getSelectedRow()).getSpisakPredmeta().contains(p)) {
				listModel.addElement(p.getSifra() + " - " + p.getNaziv());
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

	@Override
	public void actionPerformed(ActionEvent e) {
		selectedPredmet = (String) listPredmet.getSelectedValue();
		if (selectedPredmet == null) {
			JOptionPane.showMessageDialog(null, "Predmet nije selektovan.", "Upozorenje!",
					JOptionPane.ERROR_MESSAGE);
		}
		else {
			String[] parts = selectedPredmet.split(" - ");
			String id = parts[0];
			for(Predmet p : PredmetBase.getInstance().getListPredmet()) {
				if(id.equals(p.getSifra())) {
					ProfesorBase.getInstance().getRow(MainFrame.getInstance().getSelectedRow()).getSpisakPredmeta().add(p);
					p.setProfesor(ProfesorBase.getInstance().getRow(MainFrame.getInstance().getSelectedRow()));
				}
			}
			JOptionPane.showMessageDialog(null, "Predmet uspešno dodat!");
			setVisible(false);
		}
	}
}
