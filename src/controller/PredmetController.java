package controller;

import model.Predmet;
import model.PredmetBase;
import view.MainFrame;

public class PredmetController {
private static PredmetController instance = null;
	
	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	public void deletePredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		
		Predmet predmet = PredmetBase.getInstance().getRow(rowSelectedIndex);
		PredmetBase.getInstance().deletePredmet(predmet.getSifra());
		MainFrame.getInstance().refresh();
	}
}
