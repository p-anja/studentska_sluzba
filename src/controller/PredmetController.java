package controller;

import javax.swing.JOptionPane;

import model.Ocena;
import model.Predmet;
import model.PredmetBase;
import model.Profesor;
import model.ProfesorBase;
import model.Semestar;
import model.StatusStudent;
import model.Student;
import model.StudentBase;
import view.MainFrame;
import view.PredmetJTable;

public class PredmetController {
private static PredmetController instance = null;
	
	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	public void addPredmet(String sifra, String naziv, Semestar semestar, int godina, Profesor profesor, int brEspb) {
		
		PredmetBase.getInstance().addPredmet(sifra, naziv, semestar, godina, profesor, brEspb);
		MainFrame.getInstance().refresh();
	}
	
	public void editPredmet(int selectedIndex, String sifra, String naziv, Semestar semestar, int godina, Profesor profesor, int brEspb) {
		if (selectedIndex < 0) {
			return;
		}

		Predmet predmet = PredmetBase.getInstance().getRow(selectedIndex);
		PredmetBase.getInstance().editPredmet(sifra, naziv, semestar, godina, profesor, brEspb);
		MainFrame.getInstance().refresh();
		
		for(Profesor p: ProfesorBase.getInstance().getListProfesor()) {
			if(p.getBrLicneKarte().equals(predmet.getProfesor().getBrLicneKarte())) {
				if(!p.getSpisakPredmeta().contains(predmet)) {
					p.getSpisakPredmeta().add(predmet);
				}
			}
		}
	}
	
	public void deletePredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		
		Predmet predmet = PredmetBase.getInstance().getRow(rowSelectedIndex);
		PredmetBase.getInstance().deletePredmet(predmet.getSifra());
		MainFrame.getInstance().refresh();
		
		for(Student s : StudentBase.getInstance().getStudents()) {
			
			for(Predmet p : s.getNepolozeniIspiti()) {
				if(p.getSifra().equals(predmet.getSifra())) {
					s.getNepolozeniIspiti().remove(p);
					break;
				}
			}
			for(Ocena o : s.getPolozeniIspiti()) {
				if(o.getPredmet().getSifra().equals(predmet.getSifra())) {
					s.getPolozeniIspiti().remove(o);
					break;
				}
			}
		}
		Profesor p = predmet.getProfesor();
		p.getSpisakPredmeta().remove(predmet);
	}
	
	public void searchPredmet(String text) {
		if(text.equals(""))
		{
			PredmetJTable.getInstance().clearFilter();
			MainFrame.getInstance().refresh();	
		}
		else {
		PredmetJTable.getInstance().setFilter(text.trim(), 1);
		MainFrame.getInstance().refresh();
	}
}
}