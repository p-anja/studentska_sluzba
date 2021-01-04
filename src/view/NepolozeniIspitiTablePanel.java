package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class NepolozeniIspitiTablePanel extends JPanel {
	private NepolozeniIspitiJTable table;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnExam;
	private JScrollPane scrollPane;
	
	public NepolozeniIspitiTablePanel() {
		super();
		setLayout(new BorderLayout());
		setOpaque(false);
		table = new NepolozeniIspitiJTable();
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		JPanel panCommands = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnAdd = new JButton("Dodaj");
		btnDelete = new JButton("Obriši");
		btnExam = new JButton("Polaganje");
		panCommands.add(btnAdd);
		panCommands.add(btnDelete);
		panCommands.add(btnExam);
		add(panCommands, BorderLayout.NORTH);
		
	}

	public NepolozeniIspitiJTable getTable() {
		return table;
	}

	public void setTable(NepolozeniIspitiJTable table) {
		this.table = table;
	}
	
	public void refresh() {
		AbstractTableModelNepolozeniIspiti apt = (AbstractTableModelNepolozeniIspiti)table.getModel();
		apt.fireTableDataChanged();
		validate();
	}
	
	
	
}
