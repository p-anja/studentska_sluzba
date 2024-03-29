package controller;

import javax.swing.JOptionPane;

import model.Predmet;
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
	public void deleteProfesor(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		
		Profesor profesor = ProfesorBase.getInstance().getRow(rowSelectedIndex);
		ProfesorBase.getInstance().deleteProfesor(profesor.getBrLicneKarte());
		MainFrame.getInstance().refresh();
		
		for(Predmet p : profesor.getSpisakPredmeta()) {
			p.setProfesor(new Profesor("","","","","","","","","",""));
		}
	}
			
	public void searchProfesor(String text) {
		if(text.equals(""))
		{
			ProfesorJTable.getInstance().clearFilter();
			MainFrame.getInstance().refresh();	
		}
		
		String words[] = text.trim().split("\\s+");
		
		if(words.length == 1) {
		String prezime = words[0];
				ProfesorJTable.getInstance().setFilter(prezime, 1);
				MainFrame.getInstance().refresh();
		}
		
		
		else if(words.length == 2) {
		String prezime = words[0];
		String ime = words[1];
			ProfesorJTable.getInstance().setFilters(prezime, 1, ime, 0);
			MainFrame.getInstance().refresh();
		}
		
		else {
			JOptionPane.showMessageDialog(null,
					"Unete vrednosti nisu dobre! Moguće opcije su: <prezime>, <prezime ime>.",
					"Upozorenje!", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
		
}
	

