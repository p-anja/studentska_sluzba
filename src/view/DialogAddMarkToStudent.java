package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
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

import model.Ocena;
import model.Predmet;
import model.StudentBase;

public class DialogAddMarkToStudent extends JDialog implements ActionListener {

	private static final long serialVersionUID = -986281284875651792L;
	private JButton btnOk;
	private JButton btnCancel;
	private JTextField txtSifra;
	private JTextField txtNaziv;
	private JTextField txtDatum;
	private JComboBox<Integer> ocenaComboBox;
	private Predmet p;
	
	public DialogAddMarkToStudent (MainFrame instance, String title, boolean b, Predmet predmet) {
		super();
		p = predmet;
		
		setTitle("Unos ocene");
		setSize(350, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		
		JPanel panCommands = new JPanel();
		btnOk = new JButton("Potvrdi");
		btnOk.setEnabled(false);
		btnOk.addActionListener(this); 
		
		btnCancel = new JButton("Odustani");
        btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		panCommands.add(btnCancel);
		panCommands.add(btnOk);
		
		Dimension dim = new Dimension(150, 30);
		JPanel panAddMark = new JPanel();

		JLabel labelSifra = new JLabel("Šifra*");
		labelSifra.setPreferredSize(dim);
		txtSifra = new JTextField();
		txtSifra.setPreferredSize(dim);
		
		JLabel labelNaziv = new JLabel("Naziv*");
		labelNaziv.setPreferredSize(dim);
		txtNaziv = new JTextField();
		txtNaziv.setPreferredSize(dim);
		
		JLabel labelOcena = new JLabel("Ocena*");
		labelOcena.setPreferredSize(dim);
	    Integer marks[] = { 6, 7, 8, 9, 10 };
		ocenaComboBox = new JComboBox<Integer>(marks);
		ocenaComboBox.setPreferredSize(dim);
		
		JLabel labelDatum = new JLabel("Datum*");
		labelDatum.setPreferredSize(dim);
		txtDatum = new JTextField();
		txtDatum.setPreferredSize(dim);
		txtDatum.addKeyListener(new KeyListener() {

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
		panAddMark.add(labelNaziv, gbcIme);
		
		GridBagConstraints gbcTxtIme = new GridBagConstraints();
		gbcTxtIme.gridx = 1;
		gbcTxtIme.gridy = 0;
		gbcTxtIme.weightx = 200;
		gbcTxtIme.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtIme.insets = new Insets(20, 20, 0, 20);
		panAddMark.add(txtNaziv, gbcTxtIme);

		GridBagConstraints gbcPrezime = new GridBagConstraints();
		gbcPrezime.gridx = 0;
		gbcPrezime.gridy = 1;
		gbcPrezime.insets = new Insets(20, 20, 0, 0);
		gbcPrezime.anchor = GridBagConstraints.LINE_START;
		panAddMark.add(labelSifra, gbcPrezime);
		
		GridBagConstraints gbcTxtPrezime = new GridBagConstraints();
		gbcTxtPrezime.gridx = 1;
		gbcTxtPrezime.gridy = 1;
		gbcTxtPrezime.weightx = 200;
		gbcTxtPrezime.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtPrezime.insets = new Insets(20, 20, 0, 20);
		panAddMark.add(txtSifra, gbcTxtPrezime);

		GridBagConstraints gbcDatumRodjenja = new GridBagConstraints();
		gbcDatumRodjenja.gridx = 0;
		gbcDatumRodjenja.gridy = 2;
		gbcDatumRodjenja.insets = new Insets(20, 20, 0, 0);
		panAddMark.add(labelOcena, gbcDatumRodjenja);
		
		GridBagConstraints gbcTxtDatumRodjenja = new GridBagConstraints();
		gbcTxtDatumRodjenja.gridx = 1;
		gbcTxtDatumRodjenja.gridy = 2;
		gbcTxtDatumRodjenja.weightx = 200;
		gbcTxtDatumRodjenja.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtDatumRodjenja.insets = new Insets(20, 20, 0, 20);
		panAddMark.add(ocenaComboBox, gbcTxtDatumRodjenja);

		GridBagConstraints gbcAdresaStanovanja = new GridBagConstraints();
		gbcAdresaStanovanja.gridx = 0;
		gbcAdresaStanovanja.gridy = 3;
		gbcAdresaStanovanja.insets = new Insets(20, 20, 0, 0);
		panAddMark.add(labelDatum, gbcAdresaStanovanja);
		
		GridBagConstraints gbcTxtAdresaStanovanja = new GridBagConstraints();
		gbcTxtAdresaStanovanja.gridx = 1;
		gbcTxtAdresaStanovanja.gridy = 3;
		gbcTxtAdresaStanovanja.weightx = 200;
		gbcTxtAdresaStanovanja.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdresaStanovanja.insets = new Insets(20, 20, 0, 20);
		panAddMark.add(txtDatum, gbcTxtAdresaStanovanja);

		
		add(panAddMark, BorderLayout.CENTER);
		add(panCommands, BorderLayout.SOUTH);
		
		set(predmet);
		txtNaziv.setEditable(false);
		txtSifra.setEditable(false);
		
		
	}
	
	public void set(Predmet p) {
		txtNaziv.setText(p.getNaziv());
		txtSifra.setText(p.getSifra());
	}
	
	public String getDatum() {
		return txtDatum.getText().toString();
    }
	
	public boolean check() {
		String text = getDatum();
		if (text.length() != 0) {
		    if (!Pattern.matches("^(3[01]|[12][0-9]|0[1-9]).(1[0-2]|0[1-9]).[0-9]{4}.", text)) {
				txtDatum.setBackground(Color.RED);
				return false;
			}
		}
		if ((text = text.trim()).length() == 0) {
			txtDatum.setBackground(Color.WHITE);
			return false;
		}
		
		txtDatum.setBackground(Color.WHITE);
		return true;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String datum = getDatum();
		int value = (int) ocenaComboBox.getSelectedItem();
		StudentJTable.getInstance().selected().getNepolozeniIspiti().remove(p);
		Ocena o = new Ocena(StudentJTable.getInstance().selected(),p,value,datum);
		
		StudentJTable.getInstance().selected().getPolozeniIspiti().add(o);
		//p.getStudentiKojiNisuPolozili().remove(StudentBase.getInstance().getRow(MainFrame.getInstance().getSelectedRow()));
		//p.getStudentiKojiSuPolozili().add(StudentBase.getInstance().getRow(MainFrame.getInstance().getSelectedRow()));
		JOptionPane.showMessageDialog(null, "Upisana ocena");
		setVisible(false);
	}
}
