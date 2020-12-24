package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class StudentJTable extends JTable{
	
	private static StudentJTable instance = null;
	
	public static StudentJTable getInstance() {
		if(instance == null) {
			instance = new StudentJTable();
		}
		return instance;
	}
	
	private StudentJTable() {
		
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudent());
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	/*	public void refresh() {
	AbstractTableModelStudent ars = (AbstractTableModelStudent) this.getModel();
	ars.fireTableDataChanged();
	validate();

}*/
	
	
	
}
