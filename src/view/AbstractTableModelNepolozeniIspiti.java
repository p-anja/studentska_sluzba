package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Predmet;
import model.Profesor;
import model.ProfesorBase;
import model.Semestar;
import model.Student;
import model.StudentBase;

public class AbstractTableModelNepolozeniIspiti extends AbstractTableModel{

	@Override
	public int getRowCount() {
		Student s = StudentBase.getInstance().getRow(MainFrame.getInstance().getSelectedRow());
		return s.getNepolozeniIspiti().size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}
	
	@Override
	public String getColumnName(int column) {
		switch(column)
		{
			case 0:
			{
				return "�IFRA PREDMETA";
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
				return "GODINA STUDIJA";
			}
			case 4:
			{
				return "SEMESTAR";
			}
			default:
				return null;
		
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student s = StudentBase.getInstance().getRow(MainFrame.getInstance().getSelectedRow());
		ArrayList<Predmet> list= s.getNepolozeniIspiti();
		Predmet predmet = list.get(rowIndex);
		switch(columnIndex)
		{
			case 0:
			{
				return predmet.getSifra();
			}
			case 1:
			{
				return predmet.getNaziv();
			}
			case 2:
			{
				return Integer.toString(predmet.getBrEspb());
			}
			case 3:
			{
				return Integer.toString(predmet.getGodina());
			}
			case 4:
			{
				if(predmet.getSemestar()==Semestar.LETNJI) return "Letnji";
				else return "Zimski";
			}
			default:
				return null;
		
		}
	}
}


