package view;

import java.util.ArrayList;

import model.Predmet;
import model.PredmetBase;
import model.Profesor;
import model.ProfesorBase;
import model.Semestar;

public class PredmetProfesor {

	private ArrayList<String> columns;
	private ArrayList<Predmet> listPredmet;
	
	public PredmetProfesor() {
		
		columns = new ArrayList<String>();
		columns.add("ŠIFRA PREDMETA");
		columns.add("NAZIV PREDMETA");
		columns.add("ESPB");
		columns.add("GODINA STUDIJA");
		columns.add("SEMESTAR");
		listPredmet = new ArrayList<Predmet>();
		init();
		
	}
	
	private void init() {
		Profesor p = ProfesorBase.getInstance().getRow(MainFrame.getInstance().getSelectedRow());
		for(Predmet predmet : PredmetBase.getInstance().getListPredmet()) {
			if(predmet.getProfesor() == p) {
				listPredmet.add(predmet);
			}
		}
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public int getPredmetCount() {
		return listPredmet.size();
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public Predmet getRow(int rowIndex) {
		return this.listPredmet.get(rowIndex);
	}

	public ArrayList<Predmet> getListPredmet() {
		return listPredmet;
	}

	public void setListPredmet(ArrayList<Predmet> listPredmet) {
		this.listPredmet = listPredmet;
	}
	
	
	
	public ArrayList<String> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<String> columns) {
		this.columns = columns;
	}

	public String getValueAt(int row, int column)
	{
		Predmet predmet = listPredmet.get(row);
		switch(column)
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
