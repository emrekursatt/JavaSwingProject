package tr.com.StokKart.controller;

import tr.com.StokKart.controllerButton.GeneralAction;
import tr.com.StokKart.controllerButton.StokTipKartDeleteCommand;
import tr.com.StokKart.controllerButton.StokTipKartSaveCommand;
import tr.com.StokKart.controllerButton.StokTipKartUpdateCommand;
import tr.com.StokKart.view.MainFrame;
import tr.com.StokKart.view.StokTipKart;

public class StokTipKartFrameController {

	private MainFrame mainFrame;
	private StokTipKart stokTipKart;
	
	
	
	



	public StokTipKartFrameController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}



	public void execute() {
		stokTipKart = new StokTipKart();
		setListeners();
		stokTipKart.setVisible(true);
		mainFrame.getDesktopPane().add(stokTipKart);
		
		
	}



	private void setListeners() {
		
		stokTipKart.getBtnKaydet().addActionListener(new GeneralAction(new StokTipKartSaveCommand(stokTipKart)));
		stokTipKart.getBtnSil().addActionListener(new GeneralAction(new StokTipKartDeleteCommand(stokTipKart)));
		stokTipKart.getBtnDegistir().addActionListener(new GeneralAction(new StokTipKartUpdateCommand(stokTipKart)));
		
		
		
	}


}





