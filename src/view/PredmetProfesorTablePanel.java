package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.PredmetController;
import controller.StudentController;
import model.Predmet;
import model.PredmetBase;
import model.Profesor;
import model.ProfesorBase;
import model.StudentBase;

public class PredmetProfesorTablePanel extends JPanel{
	
	private static final long serialVersionUID = 2786111403910559115L;
	private PredmetProfesorJTable predmetTable;
	private JButton btnAdd;
	private JButton btnRemove;
	private JScrollPane scrollPane;
	
	public PredmetProfesorTablePanel() {
		super();
		setLayout(new BorderLayout());
		setOpaque(false);
		predmetTable = new PredmetProfesorJTable();
		scrollPane = new JScrollPane(predmetTable);
		add(scrollPane, BorderLayout.CENTER);
		JPanel panCommands = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnAdd = new JButton("Dodaj predmet");
		btnRemove = new JButton("Ukloni predmet");
		panCommands.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogAddPredmetToProfesor dialog = new DialogAddPredmetToProfesor(MainFrame.getInstance(), "Dodaj predmet", true);
				dialog.setVisible(true);
				refresh();
				dialog.setVisible(false);
				btnAdd.setSelected(false);
			}
		});
		panCommands.add(btnRemove);
		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = predmetTable.getSelectedRow();
				Profesor p = ProfesorJTable.getInstance().selected();
				
				if (row >= 0 && row <= predmetTable.getRowCount()) {
					int option = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete predmet sa profesora?",
							"Brisanje predmeta", JOptionPane.YES_NO_OPTION);
					if ( option == JOptionPane.YES_OPTION) {
						
						for(Predmet pr : PredmetBase.getInstance().getListPredmet()) {
							if(p.getSpisakPredmeta().get(row).equals(pr)) {
								PredmetBase.getInstance().editPredmet(pr.getSifra(), pr.getNaziv(), pr.getSemestar(),
										pr.getGodina(), new Profesor("","","","","","","","","",""), pr.getBrEspb());
							}
						}
						
						p.getSpisakPredmeta().remove(row);
						refresh();
			
			
						
						JOptionPane.showMessageDialog(null, "Predmet je obrisan!");
					} else {
						JOptionPane.showMessageDialog(null, "Predmet nije obrisan.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Predmet nije selektovan.", "Upozorenje!",
							JOptionPane.ERROR_MESSAGE);
				}
				btnRemove.setSelected(false);
				
			}
			
		});
		add(panCommands, BorderLayout.NORTH);
	}
	
	public PredmetProfesorJTable getPredmetTable() {
		return predmetTable;
	}

	public void setPredmetProfesorTable(PredmetProfesorJTable predmetTable) {
		this.predmetTable = predmetTable;
	}
	
	
	public void refresh() {
		AbstractTableModelPredmetProfesor apt = (AbstractTableModelPredmetProfesor)predmetTable.getModel();
		apt.fireTableDataChanged();
		validate();
	}

}
