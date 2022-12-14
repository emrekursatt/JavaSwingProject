package tr.com.StokKart.controller;

import tr.com.StokKart.controllerButton.GeneralAction;
import tr.com.StokKart.controllerButton.StokListMenuExcelCommand;
import tr.com.StokKart.controllerButton.StokListMenuGosterCommand;
import tr.com.StokKart.controllerButton.StokListMenuMailCommand;
import tr.com.StokKart.controllerButton.StokListMenuPdfCommand;
import tr.com.StokKart.view.MainFrame;
import tr.com.StokKart.view.StokList;

public class StokListController {

	private StokList stokList;
	
	private MainFrame mainFrame;
	public StokListController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}


	public void execute() {
		
		stokList = new StokList();
		setListeners();
		stokList.setVisible(true);
		mainFrame.getDesktopPane().add(stokList);
	
		
	}
	
	
	
	
	
	
	private void setListeners() { 
		
		stokList.getMenuMail().addActionListener(new GeneralAction(new StokListMenuMailCommand(stokList)));
		stokList.getMenuPdf().addActionListener(new GeneralAction(new StokListMenuPdfCommand(stokList)));
		stokList.getMenuGoster().addActionListener(new GeneralAction(new StokListMenuGosterCommand(stokList,mainFrame)));
		stokList.getMenuExcel().addActionListener(new GeneralAction(new StokListMenuExcelCommand(stokList)));;
		

	}
	
}
