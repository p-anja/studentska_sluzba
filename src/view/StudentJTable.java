package view;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class StudentJTable extends JTable{
	
	private TableRowSorter<TableModel> sorter;
	
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
		sorter = new TableRowSorter<TableModel>((AbstractTableModelStudent)this.getModel());
		this.setRowSorter(sorter);
	}
	
	public void clearFilter()
	{
		sorter.setRowFilter(RowFilter.regexFilter("", 0, 1, 2));
	}
	
	public void setFilter(String s, int i)
	{
		sorter.setRowFilter(RowFilter.regexFilter("(?i)"+ s, i));
	}

	public void set2Filter(String s1, int col1, String s2, int col2) {
		List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
		filters.add(RowFilter.regexFilter("(?i)"+ s1, col1));
		filters.add(RowFilter.regexFilter("(?i)"+ s2, col2));
		RowFilter<Object,Object> rf = RowFilter.andFilter(filters);
		sorter.setRowFilter(rf);
		
	}
	
	public void set3Filter(String s1, int col1, String s2, int col2, String s3, int col3) {
		List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
		filters.add(RowFilter.regexFilter("(?i)"+s1, col1));
		filters.add(RowFilter.regexFilter("(?i)"+s2, col2));
		filters.add(RowFilter.regexFilter("(?i)"+s3, col3));
		RowFilter<Object,Object> rf = RowFilter.andFilter(filters);
		sorter.setRowFilter(rf);
		
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
	
	
	
	
	
}
