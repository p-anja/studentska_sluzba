package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	
	
	private static final long serialVersionUID = -6978611277443373768L;
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String email;
	private String brojIndeksa;
	private String godinaUpisa;
	private int trenutnaGodStudija;
	private StatusStudent status;
	private double prosecnaOcena;
	private ArrayList<Ocena> polozeniIspiti;
	private ArrayList<Predmet> nepolozeniIspiti;
	
	public Student(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brojIndeksa, String godinaUpisa, int trenutnaGodStudija, StatusStudent status) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodStudija = trenutnaGodStudija;
		this.status = status;
		polozeniIspiti = new ArrayList<Ocena>();
		nepolozeniIspiti = new ArrayList<Predmet>();

	}
	
	

	public Student(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brojIndeksa, String godinaUpisa, int trenutnaGodStudija, StatusStudent status,
			 ArrayList<Ocena> polozeniIspiti, ArrayList<Predmet> nepolozeniIspiti) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodStudija = trenutnaGodStudija;
		this.status = status;
		this.polozeniIspiti = polozeniIspiti;
		this.nepolozeniIspiti = nepolozeniIspiti;
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

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public String getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(String godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public int getTrenutnaGodStudija() {
		return trenutnaGodStudija;
	}

	public void setTrenutnaGodStudija(int trenutnaGodStudija) {
		this.trenutnaGodStudija = trenutnaGodStudija;
	}

	public StatusStudent getStatus() {
		return status;
	}

	public void setStatus(StatusStudent status) {
		this.status = status;
	}

	public double getProsecnaOcena() {
		double suma = 0;
		for(Ocena o : this.polozeniIspiti) {
			suma += o.getVrednostOcene();
		}
		prosecnaOcena = suma / polozeniIspiti.size();
		
		if(polozeniIspiti.size() == 0) {
			return 0;
		}
		return prosecnaOcena;
	}
	public int getBodove() {
		int suma = 0;
		for(Ocena o : this.polozeniIspiti) {
			suma += o.getPredmet().getBrEspb();
		}
		return suma;
	}

	public ArrayList<Ocena> getPolozeniIspiti() {
		return polozeniIspiti;
	}

	public void setPolozeniIspiti(ArrayList<Ocena> polozeniIspiti) {
		this.polozeniIspiti = polozeniIspiti;
	}

	public ArrayList<Predmet> getNepolozeniIspiti() {
		return nepolozeniIspiti;
	}

	public void setNepolozeniIspiti(ArrayList<Predmet> nepolozeniIspiti) {
		this.nepolozeniIspiti = nepolozeniIspiti;
	}

	@Override
	public String toString() {
		return ime + "-" + prezime + "-" + datumRodjenja + "-" + adresaStanovanja + "-" + kontaktTelefon +
				"-" + email + " - " + brojIndeksa + " - " + godinaUpisa + " - " + trenutnaGodStudija + " - "
				+ status + " - " + polozeniIspiti + nepolozeniIspiti + "\n";
	}
	
	
	
	
	
	
	
	

}
