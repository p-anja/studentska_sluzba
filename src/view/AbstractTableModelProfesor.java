package view;

import javax.swing.table.AbstractTableModel;
import model.ProfesorBase;

public class AbstractTableModelProfesor extends AbstractTableModel {

	@Override
	public int getRowCount() {
		return ProfesorBase.getInstance().getListProfesor().size();
	}
	
	@Override
	public int getColumnCount() {
		return ProfesorBase.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return ProfesorBase.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ProfesorBase.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
