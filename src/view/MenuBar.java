package view;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	public MenuBar() {
		
		JMenu file= new JMenu("File");
		JMenu edit= new JMenu("Edit");
		JMenu help= new JMenu("Help");
		
		JMenuItem miNew = new JMenuItem("New");
		JMenuItem miClose = new JMenuItem("Close");
		miNew.setIcon(new ImageIcon("images/buttonplus.png"));
		file.add(miNew);
		file.addSeparator();
		miClose.setIcon(new ImageIcon("images/close.png"));
		file.add(miClose);

		JMenuItem miEdit = new JMenuItem("Edit");
		JMenuItem miDelete = new JMenuItem("Delete");
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);

		JMenuItem miHelp = new JMenuItem("Help");
		JMenuItem miAbout = new JMenuItem("About");
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
		
	}

}