package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentController;
import model.StatusStudent;
import model.Student;
import model.StudentBase;


public class DialogAddStudent extends JDialog implements ActionListener{

	private static final long serialVersionUID = 5174356442727363481L;
	private JTextField txtIme = new JTextField();
	private JTextField txtPrezime = new JTextField();
	private JTextField txtDatumRodjenja = new JTextField();
	private JTextField txtAdresa = new JTextField();
	private JTextField txtTelefon = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtIndeks = new JTextField();
	private JTextField txtGodinaUpisa = new JTextField();
	private JComboBox<String> godinaComboBox;
	private JComboBox<String> finansiranjeComboBox;

	

	
	
	public DialogAddStudent(MainFrame instance, String title, boolean b) {
		super(instance, title, b);
		
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Dodavanje studenta");
		
		Dimension dim = new Dimension(120, 20);

		JPanel answer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton cancel = new JButton("ODUSTANI");
		cancel.setBackground(new Color(255, 205 ,193));
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
		JButton ok = new JButton("POTVRDA");
		ok.setEnabled(false);
		ok.setBackground(new Color(255, 205 ,193));
		ok.addActionListener(this);
		
		answer.add(cancel);
		answer.add(ok);

		JPanel panCentar = new JPanel();
		panCentar.setBackground(Color.white);
		panCentar.setLayout(new GridBagLayout());
		panCentar.setBackground(new Color(204, 227, 249));
		
		JLabel labelIme = new JLabel("Ime*:");
		labelIme.setPreferredSize(dim);

		txtIme.setPreferredSize(dim);
		txtIme.setName("txtIme");
		txtIme.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (check()) {
					ok.setEnabled(true);
				} else {
					ok.setEnabled(false);
				}
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel labelPrezime = new JLabel("Prezime*:");
		labelIme.setPreferredSize(dim);

		txtPrezime.setPreferredSize(dim);
		txtPrezime.setName("txtPrezime");
		txtPrezime.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (check()) {
					ok.setEnabled(true);
				} else {
					ok.setEnabled(false);
				}
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel labelDatum = new JLabel("Datum rodjenja*:");
		labelDatum.setPreferredSize(dim);

		txtDatumRodjenja.setPreferredSize(dim);
		txtDatumRodjenja.setName("txtDatumRodjenja");
		txtDatumRodjenja.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (check()) {
					ok.setEnabled(true);
				} else {
					ok.setEnabled(false);
				}
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel labelAdresa = new JLabel("Adresa*:");
		labelAdresa.setPreferredSize(dim);

		txtAdresa.setPreferredSize(dim);
		txtAdresa.setName("txtAdresa");
		txtAdresa.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (check()) {
					ok.setEnabled(true);
				} else {
					ok.setEnabled(false);
				}
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel labelTelefon = new JLabel("Broj telefona*:");
		labelTelefon.setPreferredSize(dim);

		txtTelefon.setPreferredSize(dim);
		txtTelefon.setName("txtTelefon");
		txtTelefon.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (check()) {
					ok.setEnabled(true);
				} else {
					ok.setEnabled(false);
				}
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel labelEmail = new JLabel("Email*:");
		labelEmail.setPreferredSize(dim);

		txtEmail.setPreferredSize(dim);
		txtEmail.setName("txtEmail");
		txtEmail.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (check()) {
					ok.setEnabled(true);
				} else {
					ok.setEnabled(false);
				}
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		

		JLabel labelIndeks = new JLabel("Indeks*:");
		labelIndeks.setPreferredSize(dim);

		txtIndeks.setPreferredSize(dim);
		txtIndeks.setName("txtIndeks");
		txtIndeks.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (check()) {
					ok.setEnabled(true);
				} else {
					ok.setEnabled(false);
				}
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel labelGodinaUpisa = new JLabel("Godina upisa*:");
		labelGodinaUpisa.setPreferredSize(dim);

		txtGodinaUpisa.setPreferredSize(dim);
		txtGodinaUpisa.setName("txtGodinaUpisa");
		txtGodinaUpisa.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (check()) {
					ok.setEnabled(true);
				} else {
					ok.setEnabled(false);
				}
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel lblGodina = new JLabel("Trenutna godina*:");
		lblGodina.setPreferredSize(dim);
		String godina[] = { "     ", "1 (prva)", "2 (druga)", "3 (treća)", "4 (četvrta)" };
		godinaComboBox = new JComboBox<String>(godina);
		godinaComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (check()) {
					ok.setEnabled(true);
				} else {
					ok.setEnabled(false);
				}
				
			}
			
		});
		
		JLabel lblFinansiranje = new JLabel("Nacin finansiranja*:");
		lblFinansiranje.setPreferredSize(dim);
		String fin[] = { "     ", "Budžet", "Samofinansiranje"};
		finansiranjeComboBox = new JComboBox<String>(fin);
		finansiranjeComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (check()) {
					ok.setEnabled(true);
				} else {
					ok.setEnabled(false);
				}
				
			}
			
		});
		
		GridBagConstraints gbcIme = new GridBagConstraints();
		gbcIme.gridx = 0;
		gbcIme.gridy = 0;
		gbcIme.insets = new Insets(20, 20, 0, 0);
		panCentar.add(labelIme, gbcIme);

		GridBagConstraints gbcPrezime = new GridBagConstraints();
		gbcPrezime.gridx = 0;
		gbcPrezime.gridy = 1;
		gbcPrezime.insets = new Insets(20, 20, 0, 0);
		gbcPrezime.anchor = GridBagConstraints.LINE_START;
		panCentar.add(labelPrezime, gbcPrezime);

		GridBagConstraints gbcDatumRodjenja = new GridBagConstraints();
		gbcDatumRodjenja.gridx = 0;
		gbcDatumRodjenja.gridy = 2;
		gbcDatumRodjenja.insets = new Insets(20, 20, 0, 0);
		panCentar.add(labelDatum, gbcDatumRodjenja);

		GridBagConstraints gbcAdresa = new GridBagConstraints();
		gbcAdresa.gridx = 0;
		gbcAdresa.gridy = 3;
		gbcAdresa.insets = new Insets(20, 20, 0, 0);
		panCentar.add(labelAdresa, gbcAdresa);

		GridBagConstraints gbcTelefon = new GridBagConstraints();
		gbcTelefon.gridx = 0;
		gbcTelefon.gridy = 4;
		gbcTelefon.insets = new Insets(20, 20, 0, 0);
		panCentar.add(labelTelefon, gbcTelefon);

		GridBagConstraints gbcEmail = new GridBagConstraints();
		gbcEmail.gridx = 0;
		gbcEmail.gridy = 5;
		gbcEmail.insets = new Insets(20, 20, 0, 0);
		panCentar.add(labelEmail, gbcEmail);

		GridBagConstraints gbcBrojIndexa = new GridBagConstraints();
		gbcBrojIndexa.gridx = 0;
		gbcBrojIndexa.gridy = 6;
		gbcBrojIndexa.insets = new Insets(20, 20, 0, 0);
		panCentar.add(labelIndeks, gbcBrojIndexa);

		GridBagConstraints gbcGodinaUpisa = new GridBagConstraints();
		gbcGodinaUpisa.gridx = 0;
		gbcGodinaUpisa.gridy = 7;
		gbcGodinaUpisa.insets = new Insets(20, 20, 0, 0);
		gbcGodinaUpisa.anchor = GridBagConstraints.LINE_START;
		panCentar.add(labelGodinaUpisa, gbcGodinaUpisa);
		
		GridBagConstraints gbcGodina = new GridBagConstraints();
		gbcGodina.gridx = 0;
		gbcGodina.gridy = 8;
		gbcGodina.insets = new Insets(20, 20, 0, 0);
		panCentar.add(lblGodina, gbcGodina);

		
		GridBagConstraints gbcFinansiranje = new GridBagConstraints();
		gbcFinansiranje.gridx = 0;
		gbcFinansiranje.gridy = 9;
		gbcFinansiranje.insets = new Insets(20, 20, 0, 0);
		panCentar.add(lblFinansiranje, gbcFinansiranje);

		GridBagConstraints gbcTekstIme = new GridBagConstraints();
		gbcTekstIme.gridx = 1;
		gbcTekstIme.gridy = 0;
		gbcTekstIme.weightx = 200;
		gbcTekstIme.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstIme.insets = new Insets(20, 20, 0, 20);
		panCentar.add(txtIme, gbcTekstIme);

		GridBagConstraints gbcTekstPrezime = new GridBagConstraints();
		gbcTekstPrezime.gridx = 1;
		gbcTekstPrezime.gridy = 1;
		gbcTekstPrezime.weightx = 200;
		gbcTekstPrezime.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstPrezime.insets = new Insets(20, 20, 0, 20);
		panCentar.add(txtPrezime, gbcTekstPrezime);

		GridBagConstraints gbcTekstDatumRodjenja = new GridBagConstraints();
		gbcTekstDatumRodjenja.gridx = 1;
		gbcTekstDatumRodjenja.gridy = 2;
		gbcTekstDatumRodjenja.weightx = 200;
		gbcTekstDatumRodjenja.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstDatumRodjenja.insets = new Insets(20, 20, 0, 20);
		panCentar.add(txtDatumRodjenja, gbcTekstDatumRodjenja);

		GridBagConstraints gbcTekstAdresa = new GridBagConstraints();
		gbcTekstAdresa.gridx = 1;
		gbcTekstAdresa.gridy = 3;
		gbcTekstAdresa.weightx = 200;
		gbcTekstAdresa.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstAdresa.insets = new Insets(20, 20, 0, 20);
		panCentar.add(txtAdresa, gbcTekstAdresa);

		GridBagConstraints gbcTekstTelefon = new GridBagConstraints();
		gbcTekstTelefon.gridx = 1;
		gbcTekstTelefon.gridy = 4;
		gbcTekstTelefon.weightx = 200;
		gbcTekstTelefon.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstTelefon.insets = new Insets(20, 20, 0, 20);
		panCentar.add(txtTelefon, gbcTekstTelefon);

		GridBagConstraints gbcTekstEmail = new GridBagConstraints();
		gbcTekstEmail.gridx = 1;
		gbcTekstEmail.gridy = 5;
		gbcTekstEmail.weightx = 200;
		gbcTekstEmail.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstEmail.insets = new Insets(20, 20, 0, 20);
		panCentar.add(txtEmail, gbcTekstEmail);

		GridBagConstraints gbcTekstBrojIndeksa = new GridBagConstraints();
		gbcTekstBrojIndeksa.gridx = 1;
		gbcTekstBrojIndeksa.gridy = 6;
		gbcTekstBrojIndeksa.weightx = 200;
		gbcTekstBrojIndeksa.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstBrojIndeksa.insets = new Insets(20, 20, 0, 20);
		panCentar.add(txtIndeks, gbcTekstBrojIndeksa);

		GridBagConstraints gbcTekstGodinaUpisa = new GridBagConstraints();
		gbcTekstGodinaUpisa.gridx = 1;
		gbcTekstGodinaUpisa.gridy = 7;
		gbcTekstGodinaUpisa.weightx = 200;
		gbcTekstGodinaUpisa.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstGodinaUpisa.insets = new Insets(20, 20, 0, 20);
		panCentar.add(txtGodinaUpisa, gbcTekstGodinaUpisa);

		GridBagConstraints gbcComboBoxGodina = new GridBagConstraints();
		gbcComboBoxGodina.gridx = 1;
		gbcComboBoxGodina.gridy = 8;
		gbcComboBoxGodina.weightx = 10;
		gbcComboBoxGodina.insets = new Insets(20, 20, 0, 20);
		panCentar.add(godinaComboBox, gbcComboBoxGodina);
		
		GridBagConstraints gbcComboBoxFinansiranje = new GridBagConstraints();
		gbcComboBoxFinansiranje.gridx = 1;
		gbcComboBoxFinansiranje.gridy = 9;
		gbcComboBoxFinansiranje.weightx = 10;
		gbcComboBoxFinansiranje.insets = new Insets(20, 20, 0, 20);
		panCentar.add(finansiranjeComboBox, gbcComboBoxFinansiranje);
		
		add(panCentar, BorderLayout.CENTER);
		add(answer, BorderLayout.SOUTH);

		setResizable(false);
		
		
	}
	
	public String[] saveEnteredText() {
		String text[] = new String[10];
		for (int i = 0; i < text.length; i++) {
			text[i] = new String();
		}
		text[0] = txtIme.getText().toString();
		text[1] = txtPrezime.getText().toString();
		text[2] = txtDatumRodjenja.getText().toString();
		text[3] = txtAdresa.getText().toString();
		text[4] = txtTelefon.getText().toString();
		text[5] = txtEmail.getText().toString();
		text[6] = txtIndeks.getText().toString();
		text[7] = txtGodinaUpisa.getText().toString();
		text[8] = godinaComboBox.getSelectedItem().toString();
		text[9] = finansiranjeComboBox.getSelectedItem().toString();

		return text;
	}
	
	protected boolean check() {
		String text[] = saveEnteredText();
		boolean out = true;

		if (!Pattern.matches("[a-zA-ZčČćĆžŽšŠĐđ]*", text[0])) {
			txtIme.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-ZčČćĆžŽšŠđĐ]*", text[1])) {
			txtPrezime.setBackground(Color.RED);
			return false;
		}
		if (text[2].length() != 0) {
			if (!Pattern.matches("^(3[01]|[12][0-9]|0[1-9]).(1[0-2]|0[1-9]).[0-9]{4}.", text[2])) {
				txtDatumRodjenja.setBackground(Color.RED);
				return false;
			}
		}
		if (!Pattern.matches("[a-zA-Z0-9,čČćĆžŽšŠđĐ ]*", text[3])) {
			txtAdresa.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("^[0-9/-]*", text[4])) {
			txtTelefon.setBackground(Color.RED);
			return false;
		}
		if (text[5].length() != 0) {
			if (!Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", text[5])) {
				txtEmail.setBackground(Color.RED);
				return false;
			}
		}
		if (text[6].length() != 0) {
			
			for(Student s: StudentBase.getInstance().getStudents()) {
				if(text[6].equals(s.getBrojIndeksa())) {
					txtIndeks.setBackground(Color.RED);
					return false;
				}
			}

			if (!Pattern.matches("[A-Z]{2,3} [0-9]{1,3}/[0-9]{4}", text[6])) {
				txtIndeks.setBackground(Color.RED);
				return false;
			}
		}
		if (text[7].length() != 0) {
			if(!(text[7].equals(text[6].substring(text[6].length() - 4)))) {
				txtGodinaUpisa.setBackground(Color.RED);
				return false;
			}
			if (!Pattern.matches("[0-9]{4}", text[7])) {
				txtGodinaUpisa.setBackground(Color.RED);
				return false;
			}
		}

		for (String t : text) {
			if ((t = t.trim()).length() == 0) {
				txtIme.setBackground(Color.WHITE);
				txtPrezime.setBackground(Color.WHITE);
				txtDatumRodjenja.setBackground(Color.WHITE);
				txtAdresa.setBackground(Color.WHITE);
				txtTelefon.setBackground(Color.WHITE);
				txtEmail.setBackground(Color.WHITE);
				txtIndeks.setBackground(Color.WHITE);
				txtGodinaUpisa.setBackground(Color.WHITE);
				return false;
			}
		}
		txtIme.setBackground(Color.WHITE);
		txtPrezime.setBackground(Color.WHITE);
		txtDatumRodjenja.setBackground(Color.WHITE);
		txtAdresa.setBackground(Color.WHITE);
		txtTelefon.setBackground(Color.WHITE);
		txtEmail.setBackground(Color.WHITE);
		txtIndeks.setBackground(Color.WHITE);
		txtGodinaUpisa.setBackground(Color.WHITE);
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text[] = saveEnteredText();
		setVisible(true);
	
		String status;
		int god = 0;
		
		if(text[9].equals("Budžet")) {
			status = "B";
		}
		else {
			status = "S";
		}
		
		if(text[8].equals("1 (prva)")) {
			god = 1;
		}
		else if(text[8].equals("2 (druga)")) {
			god = 2;
		}
		else if(text[8].equals("3 (treća)")) {
			god = 3;
		}
		else if(text[8].equals("4 (četvrta)")) {
			god = 4;
		}
		
		StudentController.getInstance().addStudent(text[0], text[1], text[2], text[3], text[4],
				text[5], text[6], text[7], god, StatusStudent.valueOf(status));
		setVisible(false);
		
	}
	
	
}
