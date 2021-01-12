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
	protected ArrayList<Profesor> listProfesor;
	
	private ProfesorBase() {
		columns = new ArrayList<String>();
		columns.add("IME");
		columns.add("PREZIME");
		columns.add("TITULA");
		columns.add("ZVANJE");
		
		listProfesor = new ArrayList<Profesor>();
		init();
	}

	
	private void init() {
		addProfesor( "Miloš", "Nikolić","12.12.1965","Temerinska 15, Novi Sad", "021356785", "milos.nikolic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 600", "123123123", "Profesor Doktor", "Redovni Profesor");
	
		addProfesor( "Nikola", "Mirković", "01.01.1978","Jovana Cvijića 25, Subotica", "021368456", "nikola.mirkovic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 601", "321321321", "Profesor Doktor", "Redovni Profesor");
		addProfesor( "Ilija", "Petković", "03.09.1988","Gogoljeva 1, Novi Sad", "021215314", "bojan@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 602", "456456456", "Doktor", "Vanredni Profesor");
		addProfesor( "Mitar", "Petrović", "25.07.1976","Marka Kraljevića 102, Beograd", "021884640", "mitar.petrovic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 603", "789789789", "Doktor", "Vanredni Profesor");
		addProfesor( "Vasa", "Micić", "14.02.1970","Marka Kraljevića 102, Beograd", "021212114", "vasa.micic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 604", "001001001", "Doktor", "Docent");
		addProfesor( "Srđan", "Miletić", "20.04.1966","Šekspirova 12, Novi Sad", "021978225", "srdjan.miletic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 605", "002002002", "Doktor", "Docent");
		addProfesor( "Branislav", "Mihajlović", "28.06.1980","Jovana Subotića 99, Novi Sad", "021778323", "branislav.mihajlovic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 606", "559585632", "Profesor Doktor", "Redovni Profesor");
		addProfesor( "Marko", "Marković", "31.01.1985","Mirka Markovića 101, Kraljevo", "021899659", "marko.markovic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 607", "559585632", "Profesor Doktor", "Redovni Profesor");
		addProfesor( "Miloš", "Milaković", "21.09.1975","Braće Jugović 1, Kragujevac", "021122326", "milos.milakovic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 608", "073070365", "Doktor", "Vanredni Profesor");
	    addProfesor( "Lazar", "Bratić", "13.11.1973","Jovanke Orleanke 3, Niš", "021156326", "lazar.bratic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 609", "006003786", "Doktor", "Vanredni Profesor");
		addProfesor( "Ljeposava", "Dražić", "11.08.1964","Vojvode Stepe 1100, Beograd", "021888156", "ljeposava.drazic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 610", "158496152", "Doktor", "Docent");
		addProfesor( "Miroljub", "Dragić", "02.03.1959","Miše Ljubibratića 123, Aleksandrovac", "021456125", "miroljub.dragic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 611", "777348395", "Doktor", "Docent");
		addProfesor( "Bogdan", "Rekavić", "23.07.1977","Resavska 12, Beograd", "021456125", "bogdan.rekavic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 612", "721254363", "Doktor", "Vanredni Profesor");
		addProfesor( "Stanka", "Milić", "03.03.1990","Vidakovićeva 90, Novi Sad", "021945255", "stanka.milic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 613", "225533488", "Doktor", "Docent");
		addProfesor( "Milica", "Vuković", "18.10.1967","Nikolićeva 12, Novi Sad", "021746659", "milica.vukovic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 614", "111555888", "Doktor", "Vanredni Profesor");
		addProfesor( "Miša", "Mišić", "20.10.1969","Šojićeva 10, Subotica", "021489326", "misa.misic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 615", "003003003", "Doktor", "Docent");
		addProfesor( "Branko", "Maričić", "18.01.1973","Nikole Tesle 25, Sombor", "021487265", "misa.misic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 616", "004004004", "Profesor Doktor", "Docent");
	    addProfesor( "Branislav", "Luković", "08.04.1982","Živojina Mišića 7, Apatin", "021159478", "branislav.lukovic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 617", "005005005", "Doktor", "Redovni Profesor");
		addProfesor( "Branimir", "Obradović", "07.01.1979","Stari šor 18, Sremska Mitrovica", "021922333", "branimir.obradovic@mailinator.com",
				"Dositeja Obradovića 6, Novi Sad, NTP 618", "006006006", "Profesor Doktor", "Docent");
		
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
