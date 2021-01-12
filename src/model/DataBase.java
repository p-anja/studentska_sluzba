package model;

import model.StudentBase;



import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.PredmetBase;
import model.ProfesorBase;
import model.StudentBase;

public class DataBase {
	private StudentBase studentBase;
	private PredmetBase predmetBase;
	private ProfesorBase profesorBase;
	
	
	public DataBase() {
		studentBase = StudentBase.getInstance();
		profesorBase = ProfesorBase.getInstance();
		predmetBase  = PredmetBase.getInstance();
	}
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public void input() {
		ObjectInputStream o = null;
		try {
			o = new ObjectInputStream(new BufferedInputStream(new FileInputStream("objekti.txt")));
			
			studentBase.students = (ArrayList<Student>) o.readObject();
			System.out.println("t");
			profesorBase.listProfesor = (ArrayList<Profesor>) o.readObject();
			predmetBase.listPredmet  =(ArrayList<Predmet>) o.readObject();
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				o.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
}
