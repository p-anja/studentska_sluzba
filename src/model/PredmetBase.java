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
	protected ArrayList<Predmet> listPredmet;
	
	private PredmetBase() {
		columns = new ArrayList<String>();
		columns.add("ŠIFRA PREDMETA");
		columns.add("NAZIV PREDMETA");
		columns.add("SEMESTAR");
		columns.add("GODINA STUDIJA");
		columns.add("PROFESOR");
		columns.add("ESPB");
		
		this.listPredmet = new ArrayList<Predmet>();
		//init();
	}
	
	private void init() {
		addPredmet("p1","osnove programiranja", Semestar.ZIMSKI, 1, ProfesorBase.getInstance().getRow(1), 7 );
		addPredmet("p2","statistika", Semestar.LETNJI, 3, ProfesorBase.getInstance().getRow(1), 8 );
		addPredmet("p3","algoritmi i strukture podataka", Semestar.LETNJI, 2, ProfesorBase.getInstance().getRow(1) , 9 );
		addPredmet("p4","LPRS", Semestar.ZIMSKI, 3, ProfesorBase.getInstance().getRow(1) , 7 );
		addPredmet("p5","matematika", Semestar.LETNJI, 1, new Profesor("", "", "", "", "", "", "", "", "", ""), 11 );
		addPredmet("p6","xml i web servisi", Semestar.LETNJI, 4, new Profesor("", "", "", "", "", "", "", "", "", ""), 6);
		addPredmet("p7","Metode optimizacije", Semestar.ZIMSKI, 3, new Profesor("", "", "", "", "", "", "", "", "", ""), 6 );
		addPredmet("p8","osnove elektrotehnike", Semestar.LETNJI, 1, ProfesorBase.getInstance().getRow(4), 11 );
		addPredmet("p9","Sociologija", Semestar.ZIMSKI, 1, ProfesorBase.getInstance().getRow(4) , 10 );
		addPredmet("p10","Filozofija", Semestar.ZIMSKI, 1, ProfesorBase.getInstance().getRow(4), 4 );
		addPredmet("p11","ORT", Semestar.LETNJI, 2,new Profesor("", "", "", "", "", "", "", "", "", "") , 7 );
		addPredmet("p12","NANS", Semestar.LETNJI, 2, ProfesorBase.getInstance().getRow(5), 5 );
		addPredmet("p13","Organizacija podataka", Semestar.ZIMSKI, 2 ,ProfesorBase.getInstance().getRow(5), 7 );
		addPredmet("p14","Baze podataka", Semestar.ZIMSKI, 2, ProfesorBase.getInstance().getRow(5), 6 );
		addPredmet("p15","paralelno programiranje", Semestar.ZIMSKI, 2, ProfesorBase.getInstance().getRow(6), 8 );
		addPredmet("p16","konkurentno programiranje", Semestar.LETNJI, 2, ProfesorBase.getInstance().getRow(6), 9 );
		addPredmet("p17","operativni sistemi", Semestar.LETNJI, 2, new Profesor("", "", "", "", "", "", "", "", "", "") , 8 );
		addPredmet("p18","algebra", Semestar.ZIMSKI, 1, new Profesor("", "", "", "", "", "", "", "", "", "") , 15 );
		addPredmet("p19","verovatnoca", Semestar.LETNJI, 3, new Profesor("", "", "", "", "", "", "", "", "", "") , 14 );
		addPredmet("ps20","Upravljacki sistemi", Semestar.LETNJI, 3, new Profesor("", "", "", "", "", "", "", "", "", "") , 8 );
		addPredmet("ps21","Osnovi elektrotehnike", Semestar.ZIMSKI, 2, new Profesor("", "", "", "", "", "", "", "", "", "") , 7 );
		addPredmet("ps22","slucajni procesi", Semestar.LETNJI, 4, new Profesor("", "", "", "", "", "", "", "", "", "") , 8 );
		addPredmet("ps23","racunarstvo visokih performansi", Semestar.LETNJI, 4, new Profesor("", "", "", "", "", "", "", "", "", "") , 10 );
		addPredmet("p24","Analiza 1", Semestar.ZIMSKI, 1, new Profesor("", "", "", "", "", "", "", "", "", "") , 20 );
		addPredmet("it25","Informaciona bezbednost",Semestar.LETNJI, 4, ProfesorBase.getInstance().getRow(16) , 9 );
		addPredmet("it26","Elektronsko placanje", Semestar.ZIMSKI, 3, ProfesorBase.getInstance().getRow(17), 8 );
		addPredmet("it27","Distribuirani sistemi", Semestar.ZIMSKI, 4, ProfesorBase.getInstance().getRow(18), 6 );
		addPredmet("p28","Projektovanje softvera", Semestar.ZIMSKI, 3, ProfesorBase.getInstance().getRow(17), 5 );
		addPredmet("p29","Informacioni sistemi", Semestar.ZIMSKI, 4,  ProfesorBase.getInstance().getRow(16), 6 );
		addPredmet("p30","Mašinsko učenje", Semestar.LETNJI, 4,new Profesor("", "", "", "", "", "", "", "", "", "") , 7 );
		
	
	}

	public ArrayList<Predmet> getListPredmet() {
		return listPredmet;
	}

	public void setListPredmet(ArrayList<Predmet> listPredmet) {
		this.listPredmet = listPredmet;
	}
	
	public int getColumnCount() {
		return 6;
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
				if(predmet.getSemestar()==Semestar.LETNJI) return "Letnji";
				else return "Zimski";
				
			}
			case 3:
			{
				return Integer.toString(predmet.getGodina());
			}
			case 4:
			{
				return predmet.getProfesor().getIme() + " " + predmet.getProfesor().getPrezime();
			}
			case 5:
			{
				return Integer.toString(predmet.getBrEspb());
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
