package model;

import java.util.ArrayList;

public class PredmetBase {
	private static PredmetBase instance = null;
	
	public static PredmetBase getInstance() {
		if (instance == null) {
			instance = new PredmetBase();
		}
		return instance;
	}
	
	private ArrayList<String> columns;
	private ArrayList<Predmet> listPredmet;
	
	private PredmetBase() {
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
		listPredmet.add(new Predmet("E214", "Matematička analiza 1", Semestar.ZIMSKI, 1, ProfesorBase.getInstance().getListProfesor().get(1), 
				9));
	}

	public ArrayList<Predmet> getListPredmet() {
		return listPredmet;
	}

	public void setListPredmet(ArrayList<Predmet> listPredmet) {
		this.listPredmet = listPredmet;
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
	
	public void addPredmet(String sifra, String naziv, Semestar semestar, int godina, Profesor profesor, int brEspb){
		this.listPredmet.add(new Predmet(sifra, naziv, semestar, godina, profesor, brEspb));
	}
	
	public void deletePredmet(String sifra) {
		for (Predmet p : listPredmet) {
			if (p.getSifra().equals(sifra)) {
				listPredmet.remove(p);
				break;
			}
		}
	}
	
	public void editPredmet(String sifra, String naziv, Semestar semestar, int godina, Profesor profesor, int brEspb) {
		for (Predmet p : listPredmet) {
			if (p.getSifra().equals(sifra)) {
				p.setNaziv(naziv);
				p.setSemestar(semestar);
				p.setGodina(godina);
				p.setProfesor(profesor);
				p.setBrEspb(brEspb);
			}
		}
	}
	
}
