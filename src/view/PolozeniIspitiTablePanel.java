package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.PredmetBase;
import model.Student;
import model.StudentBase;

public class PolozeniIspitiTablePanel extends JPanel{
	
	private static final long serialVersionUID = 5111850366715706157L;
	private PolozeniIspitiJTable polozeniTable;
	private JButton ponistiOcenu;
	private JScrollPane scrollPane;
	private JLabel prosek;
	private JLabel espb;
	private int bodovi;
	private double avgOcena;
	
	public PolozeniIspitiTablePanel() {
		super();
		setLayout(new BorderLayout());
		setOpaque(false);
		
		polozeniTable = new PolozeniIspitiJTable();
		scrollPane = new JScrollPane(polozeniTable);
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panCommands = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ponistiOcenu = new JButton("Poništi ocenu");
		panCommands.add(ponistiOcenu);
		add(panCommands, BorderLayout.NORTH);
		
		JPanel panLabels = new JPanel(new BorderLayout());
		JPanel panLabel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel panLabel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panLabel1.setBackground(new Color(204, 227, 249));
		panLabel2.setBackground(new Color(204, 227, 249));
		avgOcena = StudentBase.getInstance().getRow(MainFrame.getInstance().getSelectedRow()).getProsecnaOcena();
		prosek = new JLabel("Prosečna ocena: ");
        JTextField prosektxt = new JTextField();
        prosektxt.setEditable(false);
        prosektxt.setText(Double.toString(avgOcena));
        panLabel1.add(prosek);
        panLabel1.add(prosektxt);
        
		bodovi =  StudentBase.getInstance().getRow(MainFrame.getInstance().getSelectedRow()).getBodove();
		espb = new JLabel("Ukupno ESPB: ");
        JTextField espbtxt = new JTextField();
        espbtxt.setEditable(false);
        espbtxt.setText(Integer.toString(bodovi));
        espbtxt.setBackground(new Color(204, 227, 249));
        panLabel2.add(espb);
        panLabel2.add(espbtxt);

		panLabels.add(panLabel1, BorderLayout.NORTH);
		panLabels.add(panLabel2, BorderLayout.SOUTH);
		
		add(panLabels, BorderLayout.SOUTH);
		
	}
	
	public PolozeniIspitiJTable getTable() {
		return polozeniTable;
	}

	public void setTable(PolozeniIspitiJTable table) {
		this.polozeniTable = table;
	}
	
	public void refresh() {
		AbstractTableModelPolozeniIspiti apt = (AbstractTableModelPolozeniIspiti)polozeniTable.getModel();
		apt.fireTableDataChanged();
		validate();
	}
	

}
