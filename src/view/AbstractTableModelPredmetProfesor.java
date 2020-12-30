package view;

import javax.swing.table.AbstractTableModel;

import model.PredmetBase;

public class AbstractTableModelPredmetProfesor extends AbstractTableModel{
	private PredmetProfesor pp = new PredmetProfesor();
	
	@Override
	public int getRowCount() {
		return pp.getListPredmet().size();
	}
	
	@Override
	public int getColumnCount() {
		return pp.getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return pp.getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return pp.getValueAt(rowIndex, columnIndex);
	}
} 
