package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PredmetProfesorTablePanel extends JPanel{
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
		panCommands.add(btnRemove);
		add(panCommands, BorderLayout.NORTH);
	}
	
	public AbstractTableModelPredmet getModel()
	{
		return (AbstractTableModelPredmet)this.predmetTable.getModel();
	}

	public PredmetProfesorJTable getPredmetTable() {
		return predmetTable;
	}

	public void setPredmetProfesorTable(PredmetProfesorJTable predmetTable) {
		this.predmetTable = predmetTable;
	}
}
