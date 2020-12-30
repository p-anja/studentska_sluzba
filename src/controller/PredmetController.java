package controller;

import javax.swing.JOptionPane;

import model.Predmet;
import model.PredmetBase;
import model.Profesor;
import model.Semestar;
import model.StatusStudent;
import model.Student;
import model.StudentBase;
import view.MainFrame;

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

		Predmet p = PredmetBase.getInstance().getRow(selectedIndex);
		PredmetBase.getInstance().editPredmet(sifra, naziv, semestar, godina, profesor, brEspb);
		MainFrame.getInstance().refresh();
	}
	
	public void deletePredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		
		Predmet predmet = PredmetBase.getInstance().getRow(rowSelectedIndex);
		PredmetBase.getInstance().deletePredmet(predmet.getSifra());
		MainFrame.getInstance().refresh();
	}
	
	public void searchPredmet(String text) {
		if(text.equals(""))
		{
			MainFrame.getInstance().getPanelPredmet().getPredmetTable().clearFilter();
			MainFrame.getInstance().refresh();	
		}
		else {
		MainFrame.getInstance().getPanelPredmet().getPredmetTable().setFilter(text.trim(), 1);
		MainFrame.getInstance().refresh();
	}
}
}