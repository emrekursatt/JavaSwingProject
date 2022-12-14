package tr.com.StokKart.controller;

import tr.com.StokKart.controllerButton.GeneralAction;
import tr.com.StokKart.controllerButton.StokKartDeleteCommand;
import tr.com.StokKart.controllerButton.StokKartViewsNextCommand;
import tr.com.StokKart.controllerButton.StokKartViewsSaveCommand;
import tr.com.StokKart.controllerButton.StokKartViewsUpdateCommand;
import tr.com.StokKart.view.MainFrame;
import tr.com.StokKart.view.StokKartViews;

public class StokKartViewsController {

	private StokKartViews stokKartViews;
	private MainFrame mainFrame;

	public StokKartViewsController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}

	public void execute() {

		   stokKartViews = new StokKartViews();
		setListeners();
		stokKartViews.setVisible(true);
		mainFrame.getDesktopPane().add(stokKartViews);

	}

	public void setListeners() {

		stokKartViews.getBtnKaydett().addActionListener(new GeneralAction(new StokKartViewsSaveCommand(stokKartViews)));
		stokKartViews.getBtnSil().addActionListener(new GeneralAction(new StokKartDeleteCommand(stokKartViews)));
		stokKartViews.getBtnDuzenle()
				.addActionListener(new GeneralAction(new StokKartViewsUpdateCommand(stokKartViews)));
		stokKartViews.getBtnNext().addActionListener(new GeneralAction(new StokKartViewsNextCommand(stokKartViews)));

}
}