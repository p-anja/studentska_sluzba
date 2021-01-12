package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PredmetTablePanel extends JPanel{

	private static final long serialVersionUID = 5995316909230759974L;
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
	
	public AbstractTableModelPredmet getModel()
	{
		return (AbstractTableModelPredmet)this.predmetTable.getModel();
	}

	public PredmetJTable getPredmetTable() {
		return predmetTable;
	}

	public void setPredmetTable(PredmetJTable predmetTable) {
		this.predmetTable = predmetTable;
	}

	
	
}
