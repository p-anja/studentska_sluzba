package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Ocena;
import model.Predmet;
import model.Semestar;
import model.Student;
import model.StudentBase;

public class AbstractTableModelPolozeniIspiti extends AbstractTableModel{

	Student s = StudentJTable.getInstance().selected();
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
	
		return s.getPolozeniIspiti().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
	
		ArrayList<Ocena> list= s.getPolozeniIspiti();
		Ocena o = list.get(rowIndex);
		switch(columnIndex)
		{
			case 0:
			{
				return o.getPredmet().getSifra();
			}
			case 1:
			{
				return o.getPredmet().getNaziv();
			}
			case 2:
			{
				return Integer.toString(o.getPredmet().getBrEspb());
			}
			case 3:
			{
				return o.getVrednostOcene();
			}
			case 4:
			{
				return o.getDatumPolaganja();
			}
			default:
				return null;
		
		}
	}
	
	@Override
	public String getColumnName(int column) {
		switch(column)
		{
			case 0:
			{
				return "ŠIFRA PREDMETA";
			}
			case 1:
			{
				return "NAZIV PREDMETA";
			}
			case 2:
			{
				return "ESPB";
			}
			case 3:
			{
				return "OCENA";
			}
			case 4:
			{
				return "DATUM";
			}
			default:
				return null;
		
		}
	}
	
	

	
}
