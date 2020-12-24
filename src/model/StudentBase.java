package model;

import java.util.ArrayList;
import java.util.List;


public class StudentBase {
	
	private static StudentBase instance = null;
	
	public static StudentBase getInstance() {
		if(instance == null) {
			instance = new StudentBase();
		}
		return instance;
	}
	
	private List<String> cols;
	protected List<Student> students;
	
	private StudentBase() {
		
		this.cols = new ArrayList<String>();
		this.students = new ArrayList<Student>();
		
		this.cols.add("INDEX");
		this.cols.add("IME");
		this.cols.add("PREZIME");
		this.cols.add("GODINA STUDIJA");
		this.cols.add("STATUS");
		this.cols.add("PROSEK");
	}

	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getColumnCount() {
		return cols.size();
	}
	
	public String getColumnName(int index) {
		return this.cols.get(index);
	}
	public Student getRow(int index) {
		return this.students.get(index);
	}
	public String getValueAt(int row, int column) {
		Student student = this.students.get(row);
		switch (column) {
		case 0:
		{
			return student.getBrojIndeksa();
		}
		case 1:
		{
			return student.getIme();
		}
		case 2:
		{
			return student.getPrezime();
		}
		case 3:
		{
			return Integer.toString(student.getTrenutnaGodStudija());
		}
		case 4:
		{
			if (student.getStatus()==StatusStudent.B)
				return "B";
			else
				return "S";
		}
		case 5:
		{
			return Double.toString(student.getProsecnaOcena());
		}
		case 6:
		{
			return student.getGodinaUpisa();
		}
		case 7:
		{
			return student.getKontaktTelefon();
		}
		case 8:
		{
			return student.getEmail();
		}
		case 9:
		{
			return student.getAdresaStanovanja();
		}
		case 10:
		{
			return student.getDatumRodjenja();
		}
		default:
			return null;
		}
	}
	
	public boolean addStudent(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brojIndeksa, String godinaUpisa, int trenutnaGodStudija, StatusStudent status)
	{
		for(Student student : students) {
			if (student.getBrojIndeksa().equals(brojIndeksa)) {
				return false;
			}
		}
		this.students.add(new Student(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon,
				email, brojIndeksa, godinaUpisa, trenutnaGodStudija, status));
		return true;
	}
	
	public void removeStudent(int row)
	{
		this.students.remove(row);
	}
	
	public void editStudent(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon, String email, String brojIndeksa, String godinaUpisa, int trenutnaGodStudija, StatusStudent status, double prosecnaOcena) {
		for (Student s : students) {
			if (s.getBrojIndeksa().equals(brojIndeksa)) {
				s.setIme(ime);
				s.setPrezime(prezime);
				s.setDatumRodjenja(datumRodjenja);
				s.setAdresaStanovanja(adresaStanovanja);
				s.setKontaktTelefon(kontaktTelefon);
				s.setEmail(email);
				s.setBrojIndeksa(brojIndeksa);
				s.setGodinaUpisa(godinaUpisa);
				s.setTrenutnaGodStudija(trenutnaGodStudija);
				s.setStatus(status);
				s.setProsecnaOcena(prosecnaOcena);
			}
		}
	}
	

}
