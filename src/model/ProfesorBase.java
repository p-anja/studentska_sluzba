package model;

import java.util.ArrayList;

public class ProfesorBase {
	private static ProfesorBase instance = null;

	public static ProfesorBase getInstance() {
		if (instance == null) {
			instance = new ProfesorBase();
		}
		return instance;
	}
	
	private ArrayList<String> columns;
	private ArrayList<Profesor> listProfesor;
	
	private ProfesorBase() {
		columns = new ArrayList<String>();
		columns.add("IME");
		columns.add("PREZIME");
		columns.add("TITULA");
		columns.add("ZVANJE");
		
		listProfesor = new ArrayList<Profesor>();
	}

	public ArrayList<Profesor> getListProfesor() {
		return listProfesor;
	}

	public void setListProfesor(ArrayList<Profesor> listProfesor) {
		this.listProfesor = listProfesor;
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public int getProfesorCount() {
		return listProfesor.size();
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public Profesor getRow(int rowIndex) {
		return this.listProfesor.get(rowIndex);
	}
	
	public String getValueAt(int row, int column)
	{
		Profesor profesor = listProfesor.get(row);
		switch(column)
		{
			case 0:
			{
				return profesor.getIme();
			}
			case 1:
			{
				return profesor.getPrezime();
			}
			case 2:
			{
				return profesor.getTitula();
			}
			case 3:
			{
				return profesor.getZvanje();
			}
			default:
				return null;
		
		}
	}
	
	public void addProfesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brLicneKarte, String titula, String zvanje){
		this.listProfesor.add(new Profesor(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, 
				email, adresaKancelarije, brLicneKarte, titula, zvanje));
	}
	
	public void deleteProfesor(String id) {
		for (Profesor p : listProfesor) {
			if (p.getBrLicneKarte().equals(id)) {
				listProfesor.remove(p);
				break;
			}
		}
	}
	
	public void editProfesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brLicneKarte, String titula, String zvanje) {
		for (Profesor p : listProfesor) {
			if (p.getBrLicneKarte().equals(brLicneKarte)) {
				p.setIme(ime);
				p.setPrezime(prezime);
				p.setDatumRodjenja(datumRodjenja);
				p.setAdresaStanovanja(adresaStanovanja);
				p.setKontaktTelefon(kontaktTelefon);
				p.setEmail(email);
				p.setAdresaKancelarije(adresaKancelarije);
				p.setTitula(titula);
				p.setZvanje(zvanje);
			}
		}
	}
}
