package model;

import java.time.LocalDate;
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
	protected ArrayList<Ocena> polozeni;
	protected ArrayList<Predmet> nepolozeni;
	
	private StudentBase() {
		
		
		this.cols = new ArrayList<String>();
		this.students = new ArrayList<Student>();
		
		initStudents();
		
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
	public int getStudentCount() {
		return students.size();
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getColumnCount() {
		return cols.size();
	}
	public ArrayList<Ocena> getPolozeni(Student s) {
		
		
		return polozeni;
	}

	public void setPolozeni(ArrayList<Ocena> polozeni) {
		this.polozeni = polozeni;
	}

	public ArrayList<Predmet> getNepolozeni() {
		return nepolozeni;
	}

	public void setNepolozeni(ArrayList<Predmet> nepolozeni) {
		this.nepolozeni = nepolozeni;
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
	
	public void editStudent(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon, String email, String brojIndeksa, String godinaUpisa, int trenutnaGodStudija, StatusStudent status) {
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
				//s.setProsecnaOcena(prosecnaOcena);
			}
		}
	}
	
	public void deleteStudent(String indeks) {
		for (Student s : students) {
			if (s.getBrojIndeksa().equals(indeks)) {
				students.remove(s);
				break;
			}
		}
	}
	
	private void initStudents() {
		this.students = new ArrayList<Student>();
		this.polozeni = new ArrayList<Ocena>();
		this.nepolozeni = new ArrayList<Predmet>();
		
		Predmet p1 = new Predmet("E214", "Matematička analiza 1", Semestar.ZIMSKI, 1, ProfesorBase.getInstance().getListProfesor().get(1), 
				9);
		Predmet p2 = new Predmet("E214", "Algebra", Semestar.ZIMSKI, 1, ProfesorBase.getInstance().getListProfesor().get(2), 
				9);
		Ocena o1 = new Ocena(null, p1, 9, "22.1.2019.");
		Ocena o2 = new Ocena(null, p2, 8, "23.1.2019.");
		polozeni.add(o1);
		polozeni.add(o2);
		ArrayList<Predmet> nep = new ArrayList<Predmet>();
		nep.add(p1);
		ArrayList<Ocena> pol = new ArrayList<Ocena>();

		
		students.add(new Student("Mika", "Mikić", "12.3.1999.", "Šumadijska 8, Novi Sad", "063563214", "mika@mail.com", "in-96-2018", "2018", 3, StatusStudent.B, polozeni, nepolozeni));
		students.add(new Student("Pera", "Perić", "11.10.1998.", "Zlatne grede 1, Novi Sad", "065852963", "pera@mail.com", "ra-33-2017", "2017", 4, StatusStudent.S));
		students.add(new Student("Toma", "Tomić", "20.3.2000.", "Alekse Šantića 3, Novi Sad", "063773214", "toma@mail.com", "ar-96-2019", "2019", 2, StatusStudent.B));
		students.add(new Student("Ana", "Vidić", "20.2.2001.", "Ćirpanova 3, Novi Sad", "063721324", "ana@mail.com", "in-96-2020", "2020", 1, StatusStudent.B));
		students.add(new Student("Jelena", "Čavić", "15.3.1999.", "Laze Kostića 2, Novi Sad", "064214564", "jelena@mail.com", "ar-180-2018", "2018", 3, StatusStudent.S));
		students.add(new Student("Nikola", "Nikolić", "10.8.2000.", "Balzakova 13, Novi Sad", "062456987", "nikola@mail.com", "in-3-2019", "2019", 2, StatusStudent.S,pol,nep));
		
		
	}
	

}
