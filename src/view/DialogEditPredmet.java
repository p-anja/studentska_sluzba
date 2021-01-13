package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import controller.StudentController;
import model.Predmet;
import model.PredmetBase;
import model.Profesor;
import model.ProfesorBase;
import model.Semestar;
import model.StatusStudent;
import model.StudentBase;

public class DialogEditPredmet extends JDialog implements ActionListener{

	private static final long serialVersionUID = 2490306076386700002L;
	JTextField txtSifra = new JTextField();
	JTextField txtNaziv = new JTextField();
	JComboBox<String> semestarComboBox;
	JComboBox<String> godinaComboBox;
	JTextField txtProf = new JTextField();
	JTextField txtESPB = new JTextField();
	JButton plus;
	JButton minus;
	
	private Predmet predmet;
	
	
	public DialogEditPredmet(MainFrame instance, String title, boolean b) {
		super(instance, title, b);
		
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Izmena predmeta");
		
		Dimension dim = new Dimension(100, 30);

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

		JPanel panEdit = new JPanel();
		panEdit.setBackground(Color.white);
		panEdit.setLayout(new GridBagLayout());
		panEdit.setBackground(new Color(204, 227, 249));
		
		plus = new JButton("+");
		plus.setPreferredSize(new Dimension(30, 30));
		plus.setMargin(new Insets(0, 0, 0, 0));
		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				plus.setSelected(true);
				DialogAddProfesorToPredmet dialog = new DialogAddProfesorToPredmet(MainFrame.getInstance(), "Odaberi profesora", true);
				dialog.setVisible(true);
				Profesor p = dialog.getProf();
					
				if(p != null) {
					
					if(p.toStringWithoutSpaces().equals("")) {
						txtProf.setText("");
						plus.setEnabled(true);
						minus.setEnabled(false);
						
					}
					else {
						
						txtProf.setText(p.getIme() + " " + p.getPrezime());
						plus.setEnabled(false);
						minus.setEnabled(true);
					}
				}
				
				
				if (check()) {
					ok.setEnabled(true);
				} else {
					ok.setEnabled(false);
				}
				
			}
		});
		minus = new JButton("-");
		minus.setPreferredSize(new Dimension(30, 30));
		minus.setMargin(new Insets(0, 0, 0, 0));
        minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da uklonite profesora?",
						"Brisanje profesora", JOptionPane.YES_NO_OPTION);
				if ( option == JOptionPane.YES_OPTION) {
					txtProf.setText("");
					Profesor p = predmet.getProfesor();
					p.getSpisakPredmeta().remove(predmet);
					predmet.setProfesor(new Profesor("", "", "", "", "", "", "", "", "", ""));
					minus.setEnabled(false);
					plus.setEnabled(true);
					JOptionPane.showMessageDialog(null, "Profesor je obrisan!");
				} else {
					JOptionPane.showMessageDialog(null, "Profesor nije obrisan.");
				}
			}
		});
		
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
		
	
		txtProf.setPreferredSize(dim);
		txtProf.setName("txtProf");
		txtProf.addKeyListener(new KeyListener() {

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
		panEdit.add(labelSifra, gbcSifra);

		GridBagConstraints gbcNaziv = new GridBagConstraints();
		gbcNaziv.gridx = 0;
		gbcNaziv.gridy = 1;
		gbcNaziv.insets = new Insets(20, 20, 0, 0);
		panEdit.add(labelNaziv, gbcNaziv);

		GridBagConstraints gbcSemestar = new GridBagConstraints();
		gbcSemestar.gridx = 0;
		gbcSemestar.gridy = 2;
		gbcSemestar.insets = new Insets(20, 20, 0, 0);
		panEdit.add(lblSemestar, gbcSemestar);

		GridBagConstraints gbcGodina = new GridBagConstraints();
		gbcGodina.gridx = 0;
		gbcGodina.gridy = 3;
		gbcGodina.insets = new Insets(20, 20, 0, 0);
		panEdit.add(lblGodina, gbcGodina);

		GridBagConstraints gbcESPB = new GridBagConstraints();
		gbcESPB.gridx = 0;
		gbcESPB.gridy = 4;
		gbcESPB.insets = new Insets(20, 20, 0, 0);
		panEdit.add(labelESPB, gbcESPB);
		
		GridBagConstraints gbcProfesor = new GridBagConstraints();
		gbcProfesor.gridx = 0;
		gbcProfesor.gridy = 5;
		gbcProfesor.insets = new Insets(20, 20, 20, 0);
		panEdit.add(labelProfesor, gbcProfesor);


		GridBagConstraints gbcTekstSifra = new GridBagConstraints();
		gbcTekstSifra.gridx = 1;
		gbcTekstSifra.gridy = 0;
		gbcTekstSifra.weightx = 200;
		gbcTekstSifra.gridwidth = 200;
		gbcTekstSifra.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstSifra.insets = new Insets(20, 20, 0, 20);
		panEdit.add(txtSifra, gbcTekstSifra);

		GridBagConstraints gbcTekstNaziv = new GridBagConstraints();
		gbcTekstNaziv.gridx = 1;
		gbcTekstNaziv.gridy = 1;
		gbcTekstNaziv.weightx = 200;
		gbcTekstNaziv.gridwidth = 200;
		gbcTekstNaziv.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstNaziv.insets = new Insets(20, 20, 0, 20);
		panEdit.add(txtNaziv, gbcTekstNaziv);

		GridBagConstraints gbcTekstSemestar = new GridBagConstraints();
		gbcTekstSemestar.gridx = 1;
		gbcTekstSemestar.gridy = 2;
		gbcTekstSemestar.weightx = 200;
		gbcTekstSemestar.gridwidth = 200;
		gbcTekstSemestar.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstSemestar.insets = new Insets(20, 20, 0, 20);
		panEdit.add(semestarComboBox, gbcTekstSemestar);

		GridBagConstraints gbcTekstGodina = new GridBagConstraints();
		gbcTekstGodina.gridx = 1;
		gbcTekstGodina.gridy = 3;
		gbcTekstGodina.weightx = 200;
		gbcTekstGodina.gridwidth = 200;
		gbcTekstGodina.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstGodina.insets = new Insets(20, 20, 0, 20);
		panEdit.add(godinaComboBox, gbcTekstGodina);

		GridBagConstraints gbcTekstESPB = new GridBagConstraints();
		gbcTekstESPB.gridx = 1;
		gbcTekstESPB.gridy = 4;
		gbcTekstESPB.weightx = 200;
		gbcTekstESPB.gridwidth = 200;
		gbcTekstESPB.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstESPB.insets = new Insets(20, 20, 0, 20);
		panEdit.add(txtESPB, gbcTekstESPB);
		
		GridBagConstraints gbcTekstProfesor = new GridBagConstraints();
		gbcTekstProfesor.gridx = 1;
		gbcTekstProfesor.gridy = 5;
		gbcTekstProfesor.weightx = 200;
		gbcTekstProfesor.gridwidth = 30;
		gbcTekstProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstProfesor.insets = new Insets(20, 20, 20, 130);
		panEdit.add(txtProf, gbcTekstProfesor);
		
		GridBagConstraints gbcPlus = new GridBagConstraints();
		gbcPlus.gridx = 2;
		gbcPlus.gridy = 5;
		gbcPlus.fill = GridBagConstraints.CENTER;
		gbcPlus.insets = new Insets(0, 160, 0, 0);
		panEdit.add(plus, gbcPlus);
		
		GridBagConstraints gbcMinus = new GridBagConstraints();
		gbcMinus.gridx = 3;
		gbcMinus.gridy = 5;
		gbcMinus.fill = GridBagConstraints.CENTER;
		gbcMinus.insets = new Insets(0, 25, 0, 0);
		panEdit.add(minus, gbcMinus);
		

		add(panEdit, BorderLayout.CENTER);
		add(answer, BorderLayout.SOUTH);

		setResizable(false);
		setPredmet();
		txtSifra.setEditable(false);
		
		
		
	}
	
	public void setPredmet() {
		predmet = PredmetBase.getInstance().getListPredmet().get(PredmetJTable.getInstance().convertRowIndexToModel(PredmetJTable.getInstance().getSelectedRow()));
		txtSifra.setText(predmet.getSifra());
		txtNaziv.setText(predmet.getNaziv());
		txtESPB.setText(Integer.toString(predmet.getBrEspb()));
		txtProf.setText(predmet.getProfesor().getIme() + " " + predmet.getProfesor().getPrezime());
		
		if(predmet.getProfesor().toStringWithoutSpaces().length() == 0) {
	
			plus.setEnabled(true);
			minus.setEnabled(false);
		}
		else {
			plus.setEnabled(false);
			minus.setEnabled(true);
			
		}
		
		String semestar = predmet.getSemestar().toString();
		
		if(semestar.equals("ZIMSKI")) {
			semestarComboBox.setSelectedIndex(1);
		}
		else {

			semestarComboBox.setSelectedIndex(2);
		}
		

		int godina = predmet.getGodina();
		
		switch (godina) {
		case 1:
			godinaComboBox.setSelectedIndex(godina);
			break;
		case 2:
			godinaComboBox.setSelectedIndex(godina);
			break;
		case 3:
			godinaComboBox.setSelectedIndex(godina);
			break;
		case 4:
			godinaComboBox.setSelectedIndex(godina);
		}

	}
	
	public String[] saveEnteredText() {
		String text[] = new String[6];
		for (int i = 0; i < text.length; i++) {
			text[i] = new String();
		}
		text[0] = txtSifra.getText().toString();
		text[1] = txtNaziv.getText().toString();
		text[2] = semestarComboBox.getSelectedItem().toString();
		text[3] = godinaComboBox.getSelectedItem().toString();
		text[4] = txtESPB.getText().toString();
		text[5] = txtProf.getText().toString();
		
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
		
		if (!Pattern.matches("^[0-9]*", text[4])) {
			txtESPB.setBackground(Color.RED);
			return false;
		}

		for(int i = 0; i < 5; i++) {
			if ((text[i] = text[i].trim()).length() == 0) {
				txtSifra.setBackground(Color.WHITE);
				txtNaziv.setBackground(Color.WHITE);
				txtProf.setBackground(Color.WHITE);
				txtESPB.setBackground(Color.WHITE);
				out = false;
			}
		}

		return out;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
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
		
		Profesor prof = new Profesor("","","","","","","","","","");
		
		for(Profesor p : ProfesorBase.getInstance().getListProfesor()) {
			String s = p.getIme() + " " + p.getPrezime();
			if(s.equals(text[5])) {
				prof = p;
			}
		}
		
		PredmetController.getInstance().editPredmet(PredmetJTable.getInstance().convertRowIndexToModel(PredmetJTable.getInstance().getSelectedRow()), text[0], text[1], Semestar.valueOf(semestar), god, prof,
			Integer.parseInt(text[4]));
	    setVisible(false);
		
	}
	
}
