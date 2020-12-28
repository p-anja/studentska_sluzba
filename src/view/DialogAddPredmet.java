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

import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentController;
import model.Profesor;
import model.ProfesorBase;
import model.Semestar;
import model.StatusStudent;


public class DialogAddPredmet extends JDialog implements ActionListener{

	JTextField txtSifra = new JTextField();
	JTextField txtNaziv = new JTextField();
	JComboBox<String> semestarComboBox;
	JComboBox<String> godinaComboBox;
	JComboBox<Profesor> profComboBox;
	JTextField txtESPB = new JTextField();
	
	
	public DialogAddPredmet(MainFrame instance, String title, boolean b) {
		super(instance, title, b);
		
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Dodavanje predmeta");
		
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
		
		JLabel labelSifra = new JLabel("Šifra*:");
		labelSifra.setPreferredSize(dim);

		txtSifra.setPreferredSize(dim);
		txtSifra.setName("txtSifra");
		txtSifra.addKeyListener(new KeyListener() {

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
		
		JLabel labelNaziv = new JLabel("Naziv*:");
		labelNaziv.setPreferredSize(dim);

		txtNaziv.setPreferredSize(dim);
		txtNaziv.setName("txtNaziv");
		txtNaziv.addKeyListener(new KeyListener() {

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
		
		JLabel lblSemestar = new JLabel("Semestar*:");
		lblSemestar.setPreferredSize(dim);
		String semestar[] = { "     ", "Zimski", "Letnji" };
		semestarComboBox = new JComboBox<String>(semestar);
		semestarComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (check()) {
					ok.setEnabled(true);
				} else {
					ok.setEnabled(false);
				}
				
			}
			
		});
		
		JLabel lblGodina = new JLabel("Godina*:");
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
		
		
		
		JLabel labelProfesor = new JLabel("Profesor*:");
		labelProfesor.setPreferredSize(dim);

		
		profComboBox = new JComboBox<Profesor>();
		profComboBox.addItem(null);
		
		for (Profesor p : ProfesorBase.getInstance().getListProfesor())
		{
			profComboBox.addItem(p);
		}
		profComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (check()) {
					ok.setEnabled(true);
				} else {
					ok.setEnabled(false);
				}
				
			}
			
		});
		

		JLabel labelESPB = new JLabel("ESPB bodovi*:");
		labelESPB.setPreferredSize(dim);

		txtESPB.setPreferredSize(dim);
		txtESPB.setName("txtESPB");
		txtESPB.addKeyListener(new KeyListener() {

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
		
		
		GridBagConstraints gbcSifra = new GridBagConstraints();
		gbcSifra.gridx = 0;
		gbcSifra.gridy = 0;
		gbcSifra.insets = new Insets(20, 20, 0, 0);
		panCentar.add(labelSifra, gbcSifra);

		GridBagConstraints gbcNaziv = new GridBagConstraints();
		gbcNaziv.gridx = 0;
		gbcNaziv.gridy = 1;
		gbcNaziv.insets = new Insets(20, 20, 0, 0);
		gbcNaziv.anchor = GridBagConstraints.LINE_START;
		panCentar.add(labelNaziv, gbcNaziv);

		GridBagConstraints gbcSemestar = new GridBagConstraints();
		gbcSemestar.gridx = 0;
		gbcSemestar.gridy = 2;
		gbcSemestar.insets = new Insets(20, 20, 0, 0);
		panCentar.add(lblSemestar, gbcSemestar);

		GridBagConstraints gbcGodina = new GridBagConstraints();
		gbcGodina.gridx = 0;
		gbcGodina.gridy = 3;
		gbcGodina.insets = new Insets(20, 20, 0, 0);
		panCentar.add(lblGodina, gbcGodina);

		GridBagConstraints gbcProfesor = new GridBagConstraints();
		gbcProfesor.gridx = 0;
		gbcProfesor.gridy = 4;
		gbcProfesor.insets = new Insets(20, 20, 0, 0);
		panCentar.add(labelProfesor, gbcProfesor);

		GridBagConstraints gbcESPB = new GridBagConstraints();
		gbcESPB.gridx = 0;
		gbcESPB.gridy = 5;
		gbcESPB.insets = new Insets(20, 20, 0, 0);
		panCentar.add(labelESPB, gbcESPB);

		

		GridBagConstraints gbcTekstSifra = new GridBagConstraints();
		gbcTekstSifra.gridx = 1;
		gbcTekstSifra.gridy = 0;
		gbcTekstSifra.weightx = 200;
		gbcTekstSifra.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstSifra.insets = new Insets(20, 20, 0, 20);
		panCentar.add(txtSifra, gbcTekstSifra);

		GridBagConstraints gbcTekstNaziv = new GridBagConstraints();
		gbcTekstNaziv.gridx = 1;
		gbcTekstNaziv.gridy = 1;
		gbcTekstNaziv.weightx = 200;
		gbcTekstNaziv.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstNaziv.insets = new Insets(20, 20, 0, 20);
		panCentar.add(txtNaziv, gbcTekstNaziv);

		GridBagConstraints gbcTekstSemestar = new GridBagConstraints();
		gbcTekstSemestar.gridx = 1;
		gbcTekstSemestar.gridy = 2;
		gbcTekstSemestar.weightx = 200;
		gbcTekstSemestar.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstSemestar.insets = new Insets(20, 20, 0, 20);
		panCentar.add(semestarComboBox, gbcTekstSemestar);

		GridBagConstraints gbcTekstGodina = new GridBagConstraints();
		gbcTekstGodina.gridx = 1;
		gbcTekstGodina.gridy = 3;
		gbcTekstGodina.weightx = 200;
		gbcTekstGodina.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstGodina.insets = new Insets(20, 20, 0, 20);
		panCentar.add(godinaComboBox, gbcTekstGodina);

		GridBagConstraints gbcTekstProfesor = new GridBagConstraints();
		gbcTekstProfesor.gridx = 1;
		gbcTekstProfesor.gridy = 4;
		gbcTekstProfesor.weightx = 200;
		gbcTekstProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstProfesor.insets = new Insets(20, 20, 0, 20);
		panCentar.add(profComboBox, gbcTekstProfesor);

		GridBagConstraints gbcTekstESPB = new GridBagConstraints();
		gbcTekstESPB.gridx = 1;
		gbcTekstESPB.gridy = 5;
		gbcTekstESPB.weightx = 200;
		gbcTekstESPB.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstESPB.insets = new Insets(20, 20, 0, 20);
		panCentar.add(txtESPB, gbcTekstESPB);
		
		add(panCentar, BorderLayout.CENTER);
		add(answer, BorderLayout.SOUTH);

		setResizable(false);
		
		
	}
	
	public String[] saveEnteredText() {
		String text[] = new String[6];
		for (int i = 0; i < text.length; i++) {
			text[i] = new String();
		}
		text[0] = txtSifra.getText().toString();
		text[1] = txtNaziv.getText().toString();
		text[2] = txtESPB.getText().toString();

		return text;
	}
	
	protected boolean check() {
		String text[] = saveEnteredText();
		boolean out = true;

		if (!Pattern.matches("[a-zA-Z0-9 ]*", text[0])) {
			txtSifra.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ čČćĆžŽšŠđĐ]*", text[1])) {
			txtNaziv.setBackground(Color.RED);
			return false;
		}
		
		if (!Pattern.matches("^[0-9]*", text[5])) {
			txtESPB.setBackground(Color.RED);
			return false;
		}

		for (String t : text) {
			if ((t = t.trim()).length() == 0) {
				txtSifra.setBackground(Color.WHITE);
				txtNaziv.setBackground(Color.WHITE);
				profComboBox.setBackground(Color.WHITE);
				txtESPB.setBackground(Color.WHITE);
				out = false;
			}
		}

		return out;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String text[] = saveEnteredText();
		setVisible(true);
	
		String semestar;
		int god = 0;
		
		if(text[2].equals("Zimski")) {
			semestar = "ZIMSKI";
		}
		else {
			semestar = "LETNJI";
		}
		
		if(text[3].equals("1 (prva)")) {
			god = 1;
		}
		else if(text[3].equals("2 (druga)")) {
			god = 2;
		}
		else if(text[3].equals("3 (treća)")) {
			god = 3;
		}
		else if(text[3].equals("4 (četvrta)")) {
			god = 4;
		}
		
		PredmetController.getInstance().addPredmet(text[0], text[1], Semestar.valueOf(semestar), god, (Profesor)profComboBox.getSelectedItem(),
			Integer.parseInt(text[2]));
	    setVisible(false);
		
	}
	
	
}
