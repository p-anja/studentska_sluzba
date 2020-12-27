package view;

import javax.swing.table.AbstractTableModel;

import model.PredmetBase;

public class AbstractTableModelPredmet extends AbstractTableModel{
	
	@Override
	public int getRowCount() {
		return PredmetBase.getInstance().getListPredmet().size();
	}
	
	@Override
	public int getColumnCount() {
		return PredmetBase.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return PredmetBase.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return PredmetBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
