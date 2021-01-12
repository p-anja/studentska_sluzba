package model;

import java.io.Serializable;
import java.util.ArrayList;
import model.Student;

public class Predmet implements Serializable {
	
	private static final long serialVersionUID = -8752326110486694545L;
	private String sifra;
	private String naziv;
	private Semestar semestar;
	private int godina;
	private Profesor profesor;
	private int brEspb;
	private ArrayList<Student> studentiKojiSuPolozili;
	private ArrayList<Student> studentiKojiNisuPolozili;
	
	public Predmet(String sifra, String naziv, Semestar semestar, int godina, Profesor profesor, int brEspb) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina = godina;
		this.profesor = profesor;
		this.brEspb = brEspb;
		this.studentiKojiSuPolozili = new ArrayList<Student>();
		this.studentiKojiNisuPolozili = new ArrayList<Student>();
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public int getBrEspb() {
		return brEspb;
	}

	public void setBrEspb(int brEspb) {
		this.brEspb = brEspb;
	}
	
	public ArrayList<Student> getStudentiKojiSuPolozili() {
		return studentiKojiSuPolozili;
	}

	public void setStudentiKojiSuPolozili(ArrayList<Student> studentiKojiSuPolozili) {
		this.studentiKojiSuPolozili = studentiKojiSuPolozili;
	}

	public ArrayList<Student> getStudentiKojiNisuPolozili() {
		return studentiKojiNisuPolozili;
	}

	public void setStudentiKojiNisuPolozili(ArrayList<Student> studentiKojiNisuPolozili) {
		this.studentiKojiNisuPolozili = studentiKojiNisuPolozili;
	}
	
	@Override
	public String toString() {
		return sifra + ", " + naziv + ", " + semestar + ", " + godina + ", " + profesor + ", " + brEspb;
	}
	
}

