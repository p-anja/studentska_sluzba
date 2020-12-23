package model;

import java.util.ArrayList;

//import model.Predmet;

public class Profesor {
	
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String email;
	private String adresaKancelarije;
	private String brLicneKarte;
	private String titula;
	private String zvanje;
	//private ArrayList<Predmet> spisakPredmeta;
	
	public Profesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon, String email, 
			String adresaKancelarije, String brLicneKarte, String titula, String zvanje) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brLicneKarte = brLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		//spisakPredmeta = new ArrayList<Predmet>();
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getBrLicneKarte() {
		return brLicneKarte;
	}

	public void setBrLicneKarte(String brLicneKarte) {
		this.brLicneKarte = brLicneKarte;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	/*public ArrayList<Predmet> getSpisakPredmeta() {
		return spisakPredmeta;
	}

	public void setSpisakPredmeta(ArrayList<Predmet> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}*/

	@Override
	public String toString() {
		return ime + ", " + prezime + ", " + datumRodjenja + ", " + adresaStanovanja + ", " + kontaktTelefon + ", " + email +
			 ", " + adresaKancelarije + ", " + brLicneKarte + ", " + titula + ", " + zvanje; // + ", " + spisakPredmeta + "\n";
	}

	
	
}

