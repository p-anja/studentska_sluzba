package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PredmetTablePanel extends JPanel{
	private PredmetJTable predmetTable;
	private JScrollPane scrollPane;
	
	public PredmetTablePanel() {
		super();
		setLayout(new BorderLayout());
		setOpaque(false);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screensize = kit.getScreenSize();
		int width = screensize.width;
		int height = screensize.height;
		JPanel left = new JPanel();
		left.setOpaque(false);
		left.setPreferredSize(new Dimension(width / 10, height));
		JPanel right = new JPanel();
		right.setOpaque(false);
		right.setPreferredSize(new Dimension(width / 10, height));
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		predmetTable = new PredmetJTable();
		scrollPane = new JScrollPane(predmetTable);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public AbstractTableModelProfesor getModel()
	{
		return (AbstractTableModelProfesor)this.predmetTable.getModel();
	}
	
	
}