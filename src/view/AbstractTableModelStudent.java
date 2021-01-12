package view;

import javax.swing.table.AbstractTableModel;

import model.StudentBase;

public class AbstractTableModelStudent extends AbstractTableModel{

	private static final long serialVersionUID = -5712265068405275698L;

	@Override
	public int getColumnCount() {
		return StudentBase.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return StudentBase.getInstance().getStudents().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return StudentBase.getInstance().getValueAt(row, column);
	}

	@Override
	public String getColumnName(int column) {
		return StudentBase.getInstance().getColumnName(column);
	}
	
	
	
	

}
