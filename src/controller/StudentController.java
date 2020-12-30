package controller;


import javax.swing.JOptionPane;

import model.Profesor;
import model.ProfesorBase;
import model.StatusStudent;
import model.Student;
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
	
	public void editStudent(int selectedIndex, String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brojIndeksa, String godinaUpisa, int trenutnaGodStudija, StatusStudent status ) {
		if (selectedIndex < 0) {
			return;
		}

		Student s = StudentBase.getInstance().getRow(selectedIndex);
		StudentBase.getInstance().editStudent(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, 
				email, brojIndeksa, godinaUpisa, trenutnaGodStudija, status);
		MainFrame.getInstance().refresh();
	}
	
	public void deleteStudent(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		
		Student student = StudentBase.getInstance().getRow(rowSelectedIndex);
		StudentBase.getInstance().deleteStudent(student.getBrojIndeksa());
		MainFrame.getInstance().refresh();
	}
	
	public void searchStudent(String text) {
		if(text.equals(""))
		{
			MainFrame.getInstance().getPanelStudent().getStudentTable().clearFilter();
			MainFrame.getInstance().refresh();	
		}
		
		String words[] = text.trim().split("\\s+");
		
		if(words.length == 1) {
		String prezime = words[0];
				MainFrame.getInstance().getPanelStudent().getStudentTable().setFilter(prezime, 2);
				MainFrame.getInstance().refresh();
		}
		
		
		else if(words.length == 2) {
		String prezime = words[0];
		String ime = words[1];
			MainFrame.getInstance().getPanelStudent().getStudentTable().set2Filter(prezime, 2, ime, 1);
			MainFrame.getInstance().refresh();
		}
		
		else if(words.length == 3) {
			String prezime = words[0];
			String ime = words[1];
			String indeks = words[2];
				MainFrame.getInstance().getPanelStudent().getStudentTable().set3Filter(prezime, 2, ime, 1, indeks, 0);
				MainFrame.getInstance().refresh();
			}
		
		else {

			JOptionPane.showMessageDialog(null,
					"Unete vrednosti nisu dobre! Moguće opcije su: <prezime>, <prezime ime>, <prezime ime indeks>.",
					"Upozorenje!", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

}
