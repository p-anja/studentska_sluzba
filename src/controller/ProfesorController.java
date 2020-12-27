package controller;

import model.Profesor;

import model.ProfesorBase;
import view.MainFrame;
import view.ProfesorJTable;

public class ProfesorController {
private static ProfesorController instance = null;
	
	public static ProfesorController getInstance() {
		if (instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}
	
	private ProfesorController() {}
	
	public void addProfesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brLicneKarte, String titula, String zvanje) {
		ProfesorBase.getInstance().addProfesor(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, 
				email, adresaKancelarije, brLicneKarte, titula, zvanje);
		MainFrame.getInstance().refresh();
	}
	
	public void editProfesor(int selectedIndex, String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String titula, String zvanje ) {
		if (selectedIndex < 0) {
			return;
		}

		Profesor p = ProfesorBase.getInstance().getRow(selectedIndex);
		ProfesorBase.getInstance().editProfesor(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, 
				email, adresaKancelarije, p.getBrLicneKarte(), titula, zvanje);
		MainFrame.getInstance().refresh();
	}
			
	
}
