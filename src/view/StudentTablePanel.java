package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class StudentTablePanel extends JPanel{
	
	private static final long serialVersionUID = -2639577441761407073L;
	private StudentJTable studentTable;
	private JScrollPane scrollPane;
	
	public StudentTablePanel() {
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
		studentTable = StudentJTable.getInstance();
		scrollPane = new JScrollPane(studentTable);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public AbstractTableModelStudent getModel()
	{
		return (AbstractTableModelStudent)this.studentTable.getModel();
	}
	
	public StudentJTable getStudentTable() {
		return studentTable;
	}

}
