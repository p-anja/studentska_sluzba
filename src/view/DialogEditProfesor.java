package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.ProfesorController;
import model.Profesor;
import model.ProfesorBase;

public class DialogEditProfesor extends JDialog {
	private JTabbedPane tabbedPane;
	private JPanel panelInfo;
	private PredmetProfesorTablePanel panelPredmeti;
	private JTextField txtPrezime;
	private JTextField txtIme;
	private JTextField txtDatumRodjenja;
	private JTextField txtAdresaStanovanja;
	private JTextField txtKontaktTelefon;
	private JTextField txtEmail;
	private JTextField txtAdresaKancelarije;
	private JTextField txtBrLicneKarte;
	private JTextField txtTitula;
	private JTextField txtZvanje;
	private JButton btnOk;
	private JButton btnCancel;
	private Profesor profesor;
	
	public DialogEditProfesor(MainFrame instance, String title, boolean b) {
		super(instance, title, b);
		
		setTitle("Izmena profesora");
		setSize(500, 550);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		Dimension dim = new Dimension(120, 20);
		
		
		tabbedPane = new JTabbedPane();
		

		
		JPanel panCommands = new JPanel((LayoutManager) new FlowLayout(FlowLayout.RIGHT));
		JButton btnOk = new JButton("POTVRDA");
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text[] = getTxt();
				setVisible(true);
				ProfesorController.getInstance().editProfesor(MainFrame.getInstance().getSelectedRow(), text[0], text[1], text[2], text[3], text[4],
						text[5], text[6], text[8], text[9]);
				dispose();
				JOptionPane.showMessageDialog((Component) e.getSource(), "UspeĹˇna izmena!");
				setVisible(false);
				
			}
		});
		btnOk.setBackground(new Color(255, 205, 193));
		JButton btnCancel = new JButton("ODUSTANI");
		btnCancel.setBackground(new Color(255, 205 ,193));
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
		
		panCommands.add(btnCancel);
		panCommands.add(btnOk);
		
		JPanel panEditProfesor = new JPanel();
		panEditProfesor.setLayout(new GridBagLayout());
		panEditProfesor.setBackground(new Color(204, 227, 249));
		
		JLabel labelIme = new JLabel("Ime*");
		labelIme.setPreferredSize(dim);
		
		txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.addKeyListener(new KeyListener() {
		
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (check()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}

			}
		});
		
		JLabel labelPrezime = new JLabel("Prezime*");
		labelPrezime.setPreferredSize(dim);
		txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		txtPrezime.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (check()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}
		});
	
		
		JLabel labelDatumRodjenja = new JLabel("Datum rodjenja*");
		labelDatumRodjenja.setPreferredSize(dim);
		txtDatumRodjenja = new JTextField();
		txtDatumRodjenja.setPreferredSize(dim);
		txtDatumRodjenja.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (check()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}
		});
		
		JLabel labelAdresaStanovanja = new JLabel("Adresa stanovanja*");
		labelAdresaStanovanja.setPreferredSize(dim);
		txtAdresaStanovanja = new JTextField();
		txtAdresaStanovanja.setPreferredSize(dim);
		txtAdresaStanovanja.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (check()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}
		});
		
		JLabel labelKontaktTelefon = new JLabel("Kontakt telefon*");
		labelKontaktTelefon.setPreferredSize(dim);
		txtKontaktTelefon = new JTextField();
		txtKontaktTelefon.setPreferredSize(dim);
		txtKontaktTelefon.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (check()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}
		});
		
		JLabel labelEmail = new JLabel("Email*");
		labelEmail.setPreferredSize(dim);
		txtEmail = new JTextField();
		txtEmail.setPreferredSize(dim);
		txtEmail.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (check()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}
		});
		
		JLabel labelAdresaKancelarije = new JLabel("Adresa kancelarije*");
		labelAdresaKancelarije.setPreferredSize(dim);
		txtAdresaKancelarije = new JTextField();
		txtAdresaKancelarije.setPreferredSize(dim);
		txtAdresaKancelarije.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (check()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}
		});
		
		JLabel labelBrLicneKarte = new JLabel("Broj liÄŤne karte*");
		labelBrLicneKarte.setPreferredSize(dim);
		txtBrLicneKarte = new JTextField();
		txtBrLicneKarte.setPreferredSize(dim);
		txtBrLicneKarte.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (check()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}
		});
		
		JLabel labelTitula = new JLabel("Titula*");
		labelTitula.setPreferredSize(dim);
		txtTitula = new JTextField();
		txtTitula.setPreferredSize(dim);
		txtTitula.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (check()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}
		});
		
		JLabel labelZvanje = new JLabel("Zvanje*");
		labelZvanje.setPreferredSize(dim);
		txtZvanje = new JTextField();
		txtZvanje.setPreferredSize(dim);
		txtZvanje.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (check()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}
		});
		
		GridBagConstraints gbcIme = new GridBagConstraints();
		gbcIme.gridx = 0;
		gbcIme.gridy = 0;
		gbcIme.insets = new Insets(20, 20, 0, 0);
		panEditProfesor.add(labelIme, gbcIme);
		
		GridBagConstraints gbcTxtIme = new GridBagConstraints();
		gbcTxtIme.gridx = 1;
		gbcTxtIme.gridy = 0;
		gbcTxtIme.weightx = 200;
		gbcTxtIme.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtIme.insets = new Insets(20, 20, 0, 20);
		panEditProfesor.add(txtIme, gbcTxtIme);

		GridBagConstraints gbcPrezime = new GridBagConstraints();
		gbcPrezime.gridx = 0;
		gbcPrezime.gridy = 1;
		gbcPrezime.insets = new Insets(20, 20, 0, 0);
		gbcPrezime.anchor = GridBagConstraints.LINE_START;
		panEditProfesor.add(labelPrezime, gbcPrezime);
		
		GridBagConstraints gbcTxtPrezime = new GridBagConstraints();
		gbcTxtPrezime.gridx = 1;
		gbcTxtPrezime.gridy = 1;
		gbcTxtPrezime.weightx = 200;
		gbcTxtPrezime.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtPrezime.insets = new Insets(20, 20, 0, 20);
		panEditProfesor.add(txtPrezime, gbcTxtPrezime);

		GridBagConstraints gbcDatumRodjenja = new GridBagConstraints();
		gbcDatumRodjenja.gridx = 0;
		gbcDatumRodjenja.gridy = 2;
		gbcDatumRodjenja.insets = new Insets(20, 20, 0, 0);
		panEditProfesor.add(labelDatumRodjenja, gbcDatumRodjenja);
		
		GridBagConstraints gbcTxtDatumRodjenja = new GridBagConstraints();
		gbcTxtDatumRodjenja.gridx = 1;
		gbcTxtDatumRodjenja.gridy = 2;
		gbcTxtDatumRodjenja.weightx = 200;
		gbcTxtDatumRodjenja.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtDatumRodjenja.insets = new Insets(20, 20, 0, 20);
		panEditProfesor.add(txtDatumRodjenja, gbcTxtDatumRodjenja);

		GridBagConstraints gbcAdresaStanovanja = new GridBagConstraints();
		gbcAdresaStanovanja.gridx = 0;
		gbcAdresaStanovanja.gridy = 3;
		gbcAdresaStanovanja.insets = new Insets(20, 20, 0, 0);
		panEditProfesor.add(labelAdresaStanovanja, gbcAdresaStanovanja);
		
		GridBagConstraints gbcTxtAdresaStanovanja = new GridBagConstraints();
		gbcTxtAdresaStanovanja.gridx = 1;
		gbcTxtAdresaStanovanja.gridy = 3;
		gbcTxtAdresaStanovanja.weightx = 200;
		gbcTxtAdresaStanovanja.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdresaStanovanja.insets = new Insets(20, 20, 0, 20);
		panEditProfesor.add(txtAdresaStanovanja, gbcTxtAdresaStanovanja);

		GridBagConstraints gbcKontaktTelefon = new GridBagConstraints();
		gbcKontaktTelefon.gridx = 0;
		gbcKontaktTelefon.gridy = 4;
		gbcKontaktTelefon.insets = new Insets(20, 20, 0, 0);
		panEditProfesor.add(labelKontaktTelefon, gbcKontaktTelefon);
		
		GridBagConstraints gbcTxtKontaktTelefon = new GridBagConstraints();
		gbcTxtKontaktTelefon.gridx = 1;
		gbcTxtKontaktTelefon.gridy = 4;
		gbcTxtKontaktTelefon.weightx = 200;
		gbcTxtKontaktTelefon.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtKontaktTelefon.insets = new Insets(20, 20, 0, 20);
		panEditProfesor.add(txtKontaktTelefon, gbcTxtKontaktTelefon);

		GridBagConstraints gbcEmail = new GridBagConstraints();
		gbcEmail.gridx = 0;
		gbcEmail.gridy = 5;
		gbcEmail.insets = new Insets(20, 20, 0, 0);
		panEditProfesor.add(labelEmail, gbcEmail);
		
		GridBagConstraints gbcTxtEmail = new GridBagConstraints();
		gbcTxtEmail.gridx = 1;
		gbcTxtEmail.gridy = 5;
		gbcTxtEmail.weightx = 200;
		gbcTxtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtEmail.insets = new Insets(20, 20, 0, 20);
		panEditProfesor.add(txtEmail, gbcTxtEmail);

		GridBagConstraints gbcAdresaKancelarije = new GridBagConstraints();
		gbcAdresaKancelarije.gridx = 0;
		gbcAdresaKancelarije.gridy = 6;
		gbcAdresaKancelarije.insets = new Insets(20, 20, 0, 0);
		panEditProfesor.add(labelAdresaKancelarije, gbcAdresaKancelarije);
		
		GridBagConstraints gbcTxtAdresaKancelarije = new GridBagConstraints();
		gbcTxtAdresaKancelarije.gridx = 1;
		gbcTxtAdresaKancelarije.gridy = 6;
		gbcTxtAdresaKancelarije.weightx = 200;
		gbcTxtAdresaKancelarije.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdresaKancelarije.insets = new Insets(20, 20, 0, 20);
		panEditProfesor.add(txtAdresaKancelarije, gbcTxtAdresaKancelarije);

		GridBagConstraints gbcBrLicneKarte = new GridBagConstraints();
		gbcBrLicneKarte.gridx = 0;
		gbcBrLicneKarte.gridy = 7;
		gbcBrLicneKarte.insets = new Insets(20, 20, 0, 0);
		panEditProfesor.add(labelBrLicneKarte, gbcBrLicneKarte);
		
		GridBagConstraints gbcTxtBrLicneKarte = new GridBagConstraints();
		gbcTxtBrLicneKarte.gridx = 1;
		gbcTxtBrLicneKarte.gridy = 7;
		gbcTxtBrLicneKarte.weightx = 200;
		gbcTxtBrLicneKarte.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtBrLicneKarte.insets = new Insets(20, 20, 0, 20);
		panEditProfesor.add(txtBrLicneKarte, gbcTxtBrLicneKarte);

		GridBagConstraints gbcTitula = new GridBagConstraints();
		gbcTitula.gridx = 0;
		gbcTitula.gridy = 8;
		gbcTitula.insets = new Insets(20, 20, 0, 0);
		gbcTitula.anchor = GridBagConstraints.LINE_START;
		panEditProfesor.add(labelTitula, gbcTitula);
		
		GridBagConstraints gbcTxtTitula = new GridBagConstraints();
		gbcTxtTitula.gridx = 1;
		gbcTxtTitula.gridy = 8;
		gbcTxtTitula.weightx = 200;
		gbcTxtTitula.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtTitula.insets = new Insets(20, 20, 0, 20);
		panEditProfesor.add(txtTitula, gbcTxtTitula);

		GridBagConstraints gbcZvanje = new GridBagConstraints();
		gbcZvanje.gridx = 0;
		gbcZvanje.gridy = 9;
		gbcZvanje.insets = new Insets(20, 20, 0, 0);
		gbcZvanje.anchor = GridBagConstraints.LINE_START;
		panEditProfesor.add(labelZvanje, gbcZvanje);

		GridBagConstraints gbcTxtZvanje = new GridBagConstraints();
		gbcTxtZvanje.gridx = 1;
		gbcTxtZvanje.gridy = 9;
		gbcTxtZvanje.weightx = 200;
		gbcTxtZvanje.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtZvanje.insets = new Insets(20, 20, 0, 20);
		panEditProfesor.add(txtZvanje, gbcTxtZvanje);
		
		
		panelInfo = new JPanel();
		//panEditProfesor.setSize(400,500);
		//panelInfo.setSize(400, 500);
		panelInfo.add(panEditProfesor, BorderLayout.CENTER);
		panelInfo.add(panCommands, BorderLayout.SOUTH);
		setProfesor();
		txtBrLicneKarte.setEditable(false);
		
		panelPredmeti = new PredmetProfesorTablePanel();
		panelPredmeti.setVisible(true);
		
		tabbedPane.add("Info", panelInfo);
		tabbedPane.addTab("Predmeti", panelPredmeti);
		add(tabbedPane, BorderLayout.CENTER);
	}
	
	public String[] getTxt() {
		String text[] = new String[10];
		for (int i = 0; i < text.length; i++) {
			text[i] = new String();
		}
		text[0] = txtIme.getText().toString();
		text[1] = txtPrezime.getText().toString();
		text[2] = txtDatumRodjenja.getText().toString();
		text[3] = txtAdresaStanovanja.getText().toString();
		text[4] = txtKontaktTelefon.getText().toString();
		text[5] = txtEmail.getText().toString();
		text[6] = txtAdresaKancelarije.getText().toString();
		text[7] = txtBrLicneKarte.getText().toString();
		text[8] = txtTitula.getText().toString();
		text[9] = txtZvanje.getText().toString();
		return text;
	}
	
	public boolean check() {
		String text[] = getTxt();
		
		if (!Pattern.matches("[a-zA-Z0-9_ ÄŤÄŚÄ‡Ä†ĹľĹ˝ĹˇĹ Ä‘Ä]*", text[0])) {
			txtIme.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ÄŤÄŚÄ‡Ä†ĹľĹ˝ĹˇĹ Ä‘Ä]*", text[1])) {
			txtPrezime.setBackground(Color.RED);
			return false;
		}
		if (text[2].length() != 0) {
		    if (!Pattern.matches("^(3[01]|[12][0-9]|[1-9]).(1[0-2]|[1-9]).[0-9]{4}.", text[2])) {
				txtDatumRodjenja.setBackground(Color.RED);
				return false;
			}
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ÄŤÄŚÄ‡Ä†ĹľĹ˝ĹˇĹ Ä‘Ä,]*", text[3])) {
			txtAdresaStanovanja.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("^[0-9-/]*", text[4])) {
			txtKontaktTelefon.setBackground(Color.RED);
			return false;
		}
		if (text[5].length() != 0) {
			if (!Pattern.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", text[5])) {
				txtEmail.setBackground(Color.RED);
				return false;
			}
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ÄŤÄŚÄ‡Ä†ĹľĹ˝ĹˇĹ Ä‘Ä,]*", text[6])) {
			txtAdresaKancelarije.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("^[0-9-/]*", text[7])) {
			txtBrLicneKarte.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ .]*", text[8])) {
			txtTitula.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", text[9])) {
			txtZvanje.setBackground(Color.RED);
			return false;
		}
		
		for (String t : text) {
			if ((t = t.trim()).length() == 0) {
				txtIme.setBackground(Color.WHITE);
				txtPrezime.setBackground(Color.WHITE);
				txtDatumRodjenja.setBackground(Color.WHITE);
				txtAdresaStanovanja.setBackground(Color.WHITE);
				txtKontaktTelefon.setBackground(Color.WHITE);
				txtEmail.setBackground(Color.WHITE);
				txtAdresaKancelarije.setBackground(Color.WHITE);
				txtBrLicneKarte.setBackground(Color.WHITE);
				txtTitula.setBackground(Color.WHITE);
				txtZvanje.setBackground(Color.WHITE);
				return false;
			}
		}
		
		txtIme.setBackground(Color.WHITE);
		txtPrezime.setBackground(Color.WHITE);
		txtDatumRodjenja.setBackground(Color.WHITE);
		txtAdresaStanovanja.setBackground(Color.WHITE);
		txtKontaktTelefon.setBackground(Color.WHITE);
		txtEmail.setBackground(Color.WHITE);
		txtAdresaKancelarije.setBackground(Color.WHITE);
		txtBrLicneKarte.setBackground(Color.WHITE);
		txtTitula.setBackground(Color.WHITE);
		txtZvanje.setBackground(Color.WHITE);
		return true;
	}
	
	public void setProfesor() {
		profesor = ProfesorBase.getInstance().getListProfesor().get(MainFrame.getInstance().getSelectedRow());
		txtIme.setText(profesor.getIme());
		txtPrezime.setText(profesor.getPrezime());
		txtDatumRodjenja.setText(profesor.getDatumRodjenja());
		txtAdresaStanovanja.setText(profesor.getAdresaStanovanja());
		txtKontaktTelefon.setText(profesor.getKontaktTelefon());
		txtEmail.setText(profesor.getEmail());
		txtAdresaKancelarije.setText(profesor.getAdresaKancelarije());
		txtBrLicneKarte.setText(profesor.getBrLicneKarte());
		txtTitula.setText(profesor.getTitula());
		txtZvanje.setText(profesor.getZvanje());
	}
	
	
}
