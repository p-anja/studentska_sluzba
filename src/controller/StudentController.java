package controller;


import model.StatusStudent;
import model.StudentBase;
import view.MainFrame;

public class StudentController {
	
	private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	public void addStudent(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brojIndeksa, String godinaUpisa, int trenutnaGodStudija, StatusStudent status) {
		
		StudentBase.getInstance().addStudent(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, 
				email, brojIndeksa, godinaUpisa, trenutnaGodStudija, status);
		MainFrame.getInstance().refresh();
	}

}
