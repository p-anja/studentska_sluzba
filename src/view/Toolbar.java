package view;

import javax.swing.JToolBar;


import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Toolbar extends JToolBar {

	public Toolbar() {
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		setLayout(new BorderLayout());
		
		JPanel buttonsPanel = new JPanel();
		JPanel searchPanel = new JPanel();
		
		
		JButton dodaj = new JButton();
		dodaj.setToolTipText("Dodaj");
		dodaj.setIcon(new ImageIcon("images/new.png"));
		
		JButton izmeni = new JButton();
		izmeni.setToolTipText("Izmeni");
		izmeni.setIcon(new ImageIcon("images/edit.png"));
		
		JButton obrisi = new JButton();
		obrisi.setToolTipText("Obriši");
		obrisi.setIcon(new ImageIcon("images/delete.png"));
		
		JButton pretrazi = new JButton();
		pretrazi.setToolTipText("Pretraži");
		pretrazi.setIcon(new ImageIcon("images/search.png"));
		
		JTextField txtPretraga = new JTextField();
		Dimension dimTxt = new Dimension(200, 20);
		txtPretraga.setPreferredSize(dimTxt);
		
		
		buttonsPanel.add(dodaj);
		buttonsPanel.add(izmeni);
		buttonsPanel.add(obrisi);
		add(buttonsPanel, BorderLayout.WEST);
		
		
		searchPanel.add(txtPretraga);
		searchPanel.add(pretrazi);
		add(searchPanel, BorderLayout.EAST);
		
		
	}
}

