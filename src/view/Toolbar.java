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
		
		
		JButton add = new JButton();
		add.setToolTipText("Dodaj");
		add.setIcon(new ImageIcon("images/new.png"));
		
		JButton edit = new JButton();
		edit.setToolTipText("Izmeni");
		edit.setIcon(new ImageIcon("images/edit.png"));
		
		JButton delete = new JButton();
		delete.setToolTipText("Obriši");
		delete.setIcon(new ImageIcon("images/delete.png"));
		
		JButton search = new JButton();
		search.setToolTipText("Pretraži");
		search.setIcon(new ImageIcon("images/search.png"));
		
		JTextField txtSearch = new JTextField();
		Dimension dimTxt = new Dimension(200, 20);
		txtSearch.setPreferredSize(dimTxt);
		
		
		buttonsPanel.add(add);
		buttonsPanel.add(edit);
		buttonsPanel.add(delete);
		add(buttonsPanel, BorderLayout.WEST);
		
		
		searchPanel.add(txtSearch);
		searchPanel.add(search);
		add(searchPanel, BorderLayout.EAST);
		
		
	}
}

