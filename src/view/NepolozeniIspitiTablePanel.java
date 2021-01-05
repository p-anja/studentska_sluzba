package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.StudentBase;

import java.awt.event.ActionListener;

public class NepolozeniIspitiTablePanel extends JPanel {
	private NepolozeniIspitiJTable table;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnExam;
	private JScrollPane scrollPane;
	
	public NepolozeniIspitiTablePanel()  {
		super();
		setLayout(new BorderLayout());
		setOpaque(false);
		table = new NepolozeniIspitiJTable();
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		JPanel panCommands = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnAdd = new JButton("Dodaj");
		btnDelete = new JButton("Obriši");
		
		btnExam = new JButton("Polaganje");
		btnExam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0 &&  table.getSelectedRow() < table.getRowCount())
				{
					DialogAddMarkToStudent dialog = new DialogAddMarkToStudent(MainFrame.getInstance(), "Unos ocene", true, 
							StudentBase.getInstance().getRow(MainFrame.getInstance().getSelectedRow()).getNepolozeniIspiti().get((table.getSelectedRow())));
					dialog.setVisible(true);
					btnExam.setSelected(false);
					refresh();
					
				}
				else {
							JOptionPane.showMessageDialog(null, "Predmet nije selektovan.", "Upozorenje!",
									JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		panCommands.add(btnAdd);
		panCommands.add(btnDelete);
		panCommands.add(btnExam);
		add(panCommands, BorderLayout.NORTH);
		
	}

	public NepolozeniIspitiJTable getTable() {
		return table;
	}

	public void setTable(NepolozeniIspitiJTable table) {
		this.table = table;
	}
	
	public void refresh() {
		AbstractTableModelNepolozeniIspiti apt = (AbstractTableModelNepolozeniIspiti)table.getModel();
		apt.fireTableDataChanged();
		validate();
	}
	
	
	}

