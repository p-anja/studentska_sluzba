package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static MenuBar instance = null;
	private JMenu file;
	private JMenu edit;
	private JMenu help;
	private JMenuItem miClose;
	private JMenuItem miNew;
	private JMenuItem miEdit;
	private JMenuItem miDelete;
	private JMenuItem miHelp;
	private JMenuItem miAbout;
	
	public static MenuBar getInstance() {
		if(instance == null) {
			instance = new MenuBar();
		}
		return instance;
	}

	public MenuBar() {
		
		file= new JMenu("File");
		edit= new JMenu("Edit");
		help= new JMenu("Help");
		
		file.setMnemonic(KeyEvent.VK_F);
		edit.setMnemonic(KeyEvent.VK_E);
		help.setMnemonic(KeyEvent.VK_H);
		
		miNew = new JMenuItem("New");
		miNew.setIcon(new ImageIcon("images/new.png"));
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miNew.setMnemonic(KeyEvent.VK_N);
		miNew.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(MainFrame.getInstance().getSelectedTab()) {
				
				case STUDENT:
				{
					DialogAddStudent dialog = new DialogAddStudent(MainFrame.getInstance(),
					"Dodavanje novog studenta", true);
					dialog.setVisible(true);
					miNew.setSelected(false);
					break;
				}
				case PREDMET:
				{
					break;
				}
				case PROFESOR:
				{	DialogAddProfesor dialog = new DialogAddProfesor(MainFrame.getInstance(),
					"Dodavanje novog profesora", true);
					dialog.setVisible(true);
					miNew.setSelected(false);
					break;
				}
				default:
				{
					return;
				}
				
			}
				
			}
			
		});
		file.add(miNew);
		file.addSeparator();
		
		miClose = new JMenuItem("Close");
		miClose.setIcon(new ImageIcon("images/close.png"));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miClose.setMnemonic(KeyEvent.VK_C);
		file.add(miClose);

		miEdit = new JMenuItem("Edit");
		miEdit.setIcon(new ImageIcon("images/edit.png"));
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miEdit.setMnemonic(KeyEvent.VK_E);
		edit.add(miEdit);
		edit.addSeparator();
		
		miDelete = new JMenuItem("Delete");
		miDelete.setIcon(new ImageIcon("images/delete.png"));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		miDelete.setMnemonic(KeyEvent.VK_D);
		edit.add(miDelete);

		miHelp = new JMenuItem("Help");
		miHelp.setIcon(new ImageIcon("images/help.png"));
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miHelp.setMnemonic(KeyEvent.VK_H);
		help.add(miHelp);
		help.addSeparator();
		
		miAbout = new JMenuItem("About");
		miAbout.setIcon(new ImageIcon("images/about.png"));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		miAbout.setMnemonic(KeyEvent.VK_A);
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
		
	}

}