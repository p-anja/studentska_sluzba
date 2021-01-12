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
		students.add(new Student("Marko", "Milošević", "12.03.2001.", "Karađorđeva 83, Novi Sad", "021/333-555", "marko.milosevic@mailinator.com", "RA 2/2020", "2020", 1, StatusStudent.B));
		students.add(new Student( "Marija", "Milić", "12.01.2000.", "Stražilovska 12, Novi Sad", "021/555-2222", "marija.milic@mailinator.com","RA 3/2019", "2019", 2, StatusStudent.S));
		students.add(new Student("Nikola", "Nikolić", "30.08.2001.", "Knez Mihajlova 16, Beograd", "021/135-463", "nikola.nikolic@mailinator.com", "RA 3/2017", "2017", 1, StatusStudent.B));
		students.add(new Student("Pera", "Perić", "07.06.1995.", "Gogoljeva 3, Novi Sad", "021/903-463", "pera.peric@mailinator.com", "RA 134/2015", "2015", 3, StatusStudent.S));
		students.add(new Student("Sofija", "Ilić", "06.05.1999.", "Miše Dimitrijevića 44, Novi Sad", "021/731-067", "sofija.ilic@mailinator.com", "RA 5/2019", "2019", 3, StatusStudent.B));
		students.add(new Student("Martina", "Lukić", "16.05.1999.", "Vojvode Stepe 180, Beograd", "011/4333-800", "martina.lukic@mailinator.com", "RA 8/2018", "2018", 3, StatusStudent.S));
		students.add(new Student("Stojan", "Stojaković", "19.10.2001.", "1300 Kaplara, Šabac", "011/3130-007", "stojan.stojakovic@mailinator.com", "RA 10/2017", "2017", 1, StatusStudent.B));
		students.add(new Student("Milan", "Milanović", "02.11.2000.", "Surepova 12, Šabac", "015/313-061", "milan.milanovic@mailinator.com", "RA 12/2017", "2017", 2, StatusStudent.S));
		students.add(new Student("Miroslav", "Milić", "11.10.2000.", "Milovana Glišića, Valjevo", "021/351-091", "miroslav.milic@mailinator.com", "RA 16/2019", "2019", 2, StatusStudent.B));
		students.add(new Student("Stefan", "Gojić", "01.05.1999.", "Bulevar Mihajla Pupina, Novi Sad", "015/324-500", "stefan.gojic@mailinator.com", "RA 21/2015", "2015", 3, StatusStudent.S));
		students.add(new Student("Anastasija", "Jokić", "11.07.1999.", "Braće Ribnikar 12, Novi Sad", "011/2333-900", "anastasija.jokic@mailinator.com", "RA 9/2020", "2020", 3, StatusStudent.B));
		students.add(new Student("Bogdan", "Bogdanović", "23.07.1999.", "Cara Dušana 42, Subotica", "021/231-114", "bogdan.bogdanovic@mailinator.com", "RA 4/2017", "2017", 3, StatusStudent.S));
		students.add(new Student("Ana", "Dabović", "12.12.2001.", "Marka Kraljevića 1, Kikinda", "014/303-007", "ana.dabovic@mailinator.com", "RA 30/2019", "2019", 1, StatusStudent.S));
		students.add(new Student("Mika", "Mikić", "05.11.2001.", "Nikole Stojanovića 2, Kraljevo", "015/101-909", "mika.mikic@mailinator.com", "RA 1/2020", "2020", 1, StatusStudent.S));
		students.add(new Student("Jovan", "Deretić", "10.09.1998.", "Marka Bratića 99, Niš", "002/200-300", "jovan.deretic@mailinator.com", "RA 11/2018", "2018", 4, StatusStudent.B));
		students.add(new Student("Nikola", "Misković", "03.08.1998.", "Cara Dušana 12, Banja Luka", "022/123-456", "nikola.miskovic@mailinator.com", "RA 12/2018", "2018", 4, StatusStudent.S));
		students.add(new Student("Martin", "Stojanović", "01.05.1998.", "Borisa Bačkog 1, Bijeljina", "024/321-775", "martin.stojanovic@mailinator.com", "RA 13/2018", "2018", 4, StatusStudent.S));
		students.add(new Student("Tomislav", "Novaković", "25.02.1996.", "Mirka Maksića 10, Kruševac", "011/1188-379", "tomislav.novakovic@mailinator.com", "RA 14/2018", "2018", 3, StatusStudent.B));
		students.add(new Student("Lena", "Ivić", "11.05.1998.", "Stari Most 6, Sremska Mitrovica", "024/333-555", "lena.ivic@mailinator.com", "RA 154/2016", "2016", 4, StatusStudent.B));
		students.add(new Student("Jovan", "Lazić", "22.01.2001.", "Nevesinjskih ustanika 10", "025/1189-479", "jovan.lazic@mailinator.com", "RA 23/2020", "2020", 1, StatusStudent.B));
		students.add(new Student("Isidora", "Mikić", "31.12.2000.", "Radničка 11, Novi Sad", "011/1122-366", "isidora.mikic@mailinator.com", "RA 1/2019", "2019", 2, StatusStudent.B));
		students.add(new Student("Vladimir", "Ilić", "31.08.1998.", "Miloša Obilića 1, Beograd", "021/1122-367", "vladimir.ilic@mailinator.com", "SW 4/2014", "2014", 4, StatusStudent.B));
		students.add(new Student("Mirko", "Aličić", "21.07.1999.", "Heroja Pinkija 112, Novi Sad", "012/1122-368", "mirko.alicic@mailinator.com", "SW 17/2015", "2015", 3, StatusStudent.S));
		students.add(new Student("Milisav", "Perković", "28.09.1998.", "Pavla Bakića 26, Novi Sad", "012/1122-369", "milisav.pejkovic@mailinator.com", "SW 17/2016", "2016", 4, StatusStudent.S));
		students.add(new Student("Purisa", "Djordjević", "29.02.2000.", "Pavla Papa 1, Novi Sad", "011/1543-370", "purisa.djordjevic@mailinator.com", "SW 27/2018", "2018", 2, StatusStudent.B));
		students.add(new Student("Mikica", "Kovacević", "23.03.1999.", "Valentina Vodnika 112, Novi Sad", "011/1992-371", "mikica.kovacevic@mailinator.com", "RA 226/2017", "2017", 3, StatusStudent.S));
		students.add(new Student("Miloš", "Milić", "21.10.2001.", "Neznanog junaka 12, Beograd", "011/8172-372", "milos.milic@mailinator.com", "SW 12/2020", "2020", 1, StatusStudent.S));
		
		
	}
	

}
